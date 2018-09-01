package com.github.voxelfriend.rusticthaumaturgy.common.items;

import net.minecraft.creativetab.CreativeTabs;
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
import net.minecraft.creativetab.CreativeTabs;
import com.github.voxelfriend.rusticthaumaturgy.core.RusticThaumaturgy;
import net.minecraftforge.fml.common.Mod;


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
		BLAZE_POWDER_TINY.setCreativeTab(RusticThaumaturgy.mainTab);
		CINDERMOTE = new ItemBase("cindermote");
		CINDERMOTE.setCreativeTab(RusticThaumaturgy.mainTab);
		CINDERMOTE_SEEDS = new ItemBase("cindermote_seeds");
		CINDERMOTE_SEEDS.setCreativeTab(RusticThaumaturgy.mainTab);
		SHIMMERPETAL = new ItemBase("shimmerpetal");
		SHIMMERPETAL.setCreativeTab(RusticThaumaturgy.mainTab);
		SHIMMERPETAL_BULB = new ItemBase("shimmerpetal_bulb");
		SHIMMERPETAL_BULB.setCreativeTab(RusticThaumaturgy.mainTab);
		VISCAP =new ItemBase("viscap");
		VISCAP.setCreativeTab(RusticThaumaturgy.mainTab);
		VISCAP_SPORES =new ItemBase("viscap_spores");
		VISCAP_SPORES.setCreativeTab(RusticThaumaturgy.mainTab);

		
		
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
