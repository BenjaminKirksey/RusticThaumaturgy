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

public class ItemViscapSpores extends ItemSeeds {

    public ItemViscapSpores() {
        super(ModBlocks.VISCAP, null);
        this.setUnlocalizedName(Names.Items.VISCAP_SPORES);
        this.setRegistryName(Names.Items.VISCAP_SPORES);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if (stack.getItem() instanceof ItemSeeds) {
            tooltip.add(I18n.format("viscap.tip.spores"));
        }
    }
}