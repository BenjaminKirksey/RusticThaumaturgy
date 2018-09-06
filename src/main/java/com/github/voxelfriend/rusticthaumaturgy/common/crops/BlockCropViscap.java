package com.github.voxelfriend.rusticthaumaturgy.common.crops;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocks;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItems;
import com.github.voxelfriend.rusticthaumaturgy.configuration.RTConfiguration;
import com.github.voxelfriend.rusticthaumaturgy.reference.Names;

import java.util.Random;

public class BlockCropViscap extends BlockCrops {

    public BlockCropViscap() {
        super();
        this.setUnlocalizedName(Names.Blocks.VISCAP);
        this.setRegistryName(Names.Blocks.VISCAP);

        ModBlocks.BLOCKS.add(this);
    }

    private boolean isOnFarmland(World worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).getBlock() == Blocks.FARMLAND;
    }

    @Override
    @Nonnull
    protected Item getSeed() {
        return ModItems.VISCAP_SPORES;
    }

    @Override
    @Nonnull
    protected Item getCrop() {
        return ModItems.VISCAP;
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.FARMLAND || state.getBlock() == ModBlocks.VISCAP;
}
    
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = playerIn.getHeldItem(hand);
        return !heldItem.isEmpty() || heldItem.getItem().equals(Items.DYE);
}

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, @Nonnull IBlockState state, boolean isClient) {
        return state.getValue(AGE) < 2 && (isOnFarmland(worldIn, pos) || worldIn.getLightFromNeighbors(pos.up()) <= 2);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, @Nullable IBlockState state, @Nullable Random rand) {
        if (state == null || rand == null)
            return;
        
        float baseChance = 25.0F;
        baseChance /= 1.0F;

        if (worldIn.getLightFromNeighbors(pos.up()) <= 7) {
            if (state.getValue(AGE) < 2) {
                if (rand.nextInt((int) (baseChance / getGrowthChance(this, worldIn, pos)) + 1) == 0) {
                    worldIn.setBlockState(pos, state.withProperty(AGE, state.getValue(AGE) + 1), 2);
                }
            }
        }
    }

    @Override
    public void getDrops(@Nonnull NonNullList<ItemStack> drops, @Nullable IBlockAccess world, @Nullable BlockPos pos, @Nonnull IBlockState state, int fortune) {
    	final int age = state.getValue(AGE);
    	final Random rand = world == null ? new Random() : ((World) world).rand;
    	
    	int crop = 0;
    	int seeds = 0;
    	
    	// Seed chance
        if (rand.nextInt(100) < RTConfiguration.seedChance) {
            seeds++;
        }

        if (age == 7) {
            // Second seed chance
            if (rand.nextInt(100) < RTConfiguration.secondSeedChance) {
                seeds++;
            }

            // Crop chance
            if (rand.nextInt(100) < RTConfiguration.cropChance) {
                crop++;
            }

            // Second crop chance
            if (rand.nextInt(100) < RTConfiguration.secondCropChance) {
                crop++;
            }
}
    	
    	drops.add(new ItemStack(this.getSeed(), seeds, 0));
        drops.add(new ItemStack(this.getCrop(), crop, 0));
    }

    @Override
    public void harvestBlock(@Nonnull World worldIn, EntityPlayer player, @Nonnull BlockPos pos, @Nonnull IBlockState state, TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
    }
}