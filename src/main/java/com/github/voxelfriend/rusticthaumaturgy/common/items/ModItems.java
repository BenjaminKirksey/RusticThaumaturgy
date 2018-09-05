package com.github.voxelfriend.rusticthaumaturgy.common.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.creativetab.CreativeTabs;
import com.github.voxelfriend.rusticthaumaturgy.core.RusticThaumaturgy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModItems {
	public static ItemBase BLAZE_POWDER_TINY;
	public static ItemBase CINDERMOTE;
	public static ItemBase SHIMMERPETAL;
	public static ItemBase VISCAP;
	public static ItemSeeds CINDERMOTE_SEEDS = new ItemCindermoteSeeds();
	public static ItemSeeds SHIMMERPETAL_BULB = new ItemShimmerpetalBulb();
	public static ItemSeeds VISCAP_SPORES = new ItemViscapSpores();

	
	
	public static void init() {
		BLAZE_POWDER_TINY = new ItemBase("dust_tiny_blaze");
		BLAZE_POWDER_TINY.setCreativeTab(RusticThaumaturgy.mainTab);
		CINDERMOTE = new ItemBase("cindermote");
		CINDERMOTE.setCreativeTab(RusticThaumaturgy.mainTab);
		SHIMMERPETAL = new ItemBase("shimmerpetal");
		SHIMMERPETAL.setCreativeTab(RusticThaumaturgy.mainTab);
		SHIMMERPETAL_BULB =new ItemShimmerpetalBulb();
		SHIMMERPETAL_BULB.setCreativeTab(RusticThaumaturgy.mainTab);
		VISCAP = new ItemBase("viscap");
		VISCAP.setCreativeTab(RusticThaumaturgy.mainTab);
		VISCAP_SPORES =new ItemViscapSpores();
		VISCAP_SPORES.setCreativeTab(RusticThaumaturgy.mainTab);
	}
	
	public static void initModels() {
		BLAZE_POWDER_TINY.initModel();
		CINDERMOTE.initModel();
		SHIMMERPETAL.initModel();
		VISCAP.initModel();
		ModelLoader.setCustomModelResourceLocation(CINDERMOTE_SEEDS, 0, new ModelResourceLocation(CINDERMOTE_SEEDS.getRegistryName().toString()));
		ModelLoader.setCustomModelResourceLocation(SHIMMERPETAL_BULB, 0, new ModelResourceLocation(SHIMMERPETAL_BULB.getRegistryName().toString()));
		ModelLoader.setCustomModelResourceLocation(VISCAP_SPORES, 0, new ModelResourceLocation(VISCAP_SPORES.getRegistryName().toString()));
		
	}
	
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
	    event.getRegistry().registerAll(CINDERMOTE_SEEDS, SHIMMERPETAL_BULB, VISCAP_SPORES);
	}

}
