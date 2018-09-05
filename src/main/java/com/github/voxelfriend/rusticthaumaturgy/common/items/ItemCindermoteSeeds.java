package com.github.voxelfriend.rusticthaumaturgy.common.items;


import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;




import java.util.List;

import javax.annotation.Nullable;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocks;
import com.github.voxelfriend.rusticthaumaturgy.reference.Names;

public class ItemCindermoteSeeds extends ItemSeeds {

    public ItemCindermoteSeeds() {
        super(ModBlocks.CINDERMOTE, null);
        this.setUnlocalizedName(Names.Items.CINDERMOTE_SEEDS);
        this.setRegistryName(Names.Items.CINDERMOTE_SEEDS);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if (stack.getItem() instanceof ItemSeeds) {
            tooltip.add(I18n.format("cindermote.tip.seed"));
        }
    }
}