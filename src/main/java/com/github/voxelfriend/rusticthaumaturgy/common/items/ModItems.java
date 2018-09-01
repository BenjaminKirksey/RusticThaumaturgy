package com.github.voxelfriend.rusticthaumaturgy.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import rustic.common.items.ItemBase;
import rustic.core.Rustic;

public class ModItems {
	public static ItemBase BLAZE_POWDER_TINY;
	public static ItemBase CINDERMOTE;
	public static ItemBase CINDERMOTE_SEEDS;
	public static ItemBase SHIMMERPETAL;
	public static ItemBase SHIMMERPETAL_BULB;
	public static ItemBase VISCAP;
	public static ItemBase VISCAP_SPORES;
	
	public static void init() {
		BLAZE_POWDER_TINY = new ItemBase("dust_tiny_blaze");
		BLAZE_POWDER_TINY.setCreativeTab(Rustic.farmingTab);
		CINDERMOTE = new ItemBase("cindermote");
		CINDERMOTE.setCreativeTab(Rustic.farmingTab);
		CINDERMOTE_SEEDS = new ItemBase("cindermote");
		CINDERMOTE_SEEDS.setCreativeTab(Rustic.farmingTab);
		SHIMMERPETAL = new ItemBase("shimmerpetal");
		SHIMMERPETAL.setCreativeTab(Rustic.farmingTab);
		SHIMMERPETAL_BULB = new ItemBase("shimmerpetal");
		SHIMMERPETAL_BULB.setCreativeTab(Rustic.farmingTab);
		VISCAP =new ItemBase("viscap");
		VISCAP.setCreativeTab(Rustic.farmingTab);
		VISCAP_SPORES =new ItemBase("viscap");
		VISCAP_SPORES.setCreativeTab(Rustic.farmingTab);

		
		
	}
	
	public static void initModels() {
		BLAZE_POWDER_TINY.initModel();
		CINDERMOTE.initModel();
		CINDERMOTE_SEEDS.initModel();
		SHIMMERPETAL.initModel();
		SHIMMERPETAL_BULB.initModel();
		VISCAP.initModel();
		VISCAP_SPORES.initModel();
		
	}

}
