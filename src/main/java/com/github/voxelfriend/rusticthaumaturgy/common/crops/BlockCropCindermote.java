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
import com.github.voxelfriend.rusticthaumaturgy.reference.Names;

import java.util.Random;

public class BlockCropCindermote extends BlockCrops {

    public BlockCropCindermote() {
        super();
        this.setUnlocalizedName(Names.Blocks.CINDERMOTE);
        this.setRegistryName(Names.Blocks.CINDERMOTE);

        ModBlocks.BLOCKS.add(this);
    }

    private boolean isOnFarmland(World worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).getBlock() == Blocks.FARMLAND;
    }

    @Override
    @Nonnull
    protected Item getSeed() {
        return ModItems.CINDERMOTE_SEEDS;
    }

    @Override
    @Nonnull
    protected Item getCrop() {
        return ModItems.CINDERMOTE;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return false;
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, @Nonnull IBlockState state, boolean isClient) {
        return state.getValue(AGE) < 3 && (isOnFarmland(worldIn, pos) || worldIn.getLightFromNeighbors(pos.up()) <= 7);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, @Nullable IBlockState state, @Nullable Random rand) {
        if (state == null || rand == null)
            return;

        if (worldIn.getLightFromNeighbors(pos.up()) <= 7 || isOnFarmland(worldIn, pos)) {
            if (state.getValue(AGE) < 3) {
                if (rand.nextInt((int) (1 / getGrowthChance(this, worldIn, pos)) + 1) == 0) {
                    worldIn.setBlockState(pos, state.withProperty(AGE, state.getValue(AGE) + 1), 2);
                }
            }
        }
    }

    @Override
    public void getDrops(@Nonnull NonNullList<ItemStack> drops, @Nullable IBlockAccess world, @Nullable BlockPos pos, @Nonnull IBlockState state, int fortune) {
        drops.add(new ItemStack(this.getSeed(), 1, 0));
        drops.add(new ItemStack(this.getCrop(), 1, 0));
    }

    @Override
    public void harvestBlock(@Nonnull World worldIn, EntityPlayer player, @Nonnull BlockPos pos, @Nonnull IBlockState state, TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
    }
}