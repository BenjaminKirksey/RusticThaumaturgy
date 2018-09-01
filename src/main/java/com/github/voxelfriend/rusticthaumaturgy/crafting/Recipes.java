//Hello World

package com.github.voxelfriend.rusticthaumaturgy.crafting;

import java.util.ArrayList;
import java.util.List;

import com.github.voxelfriend.rusticthaumaturgy.core.RusticThaumaturgy;
import com.github.voxelfriend.rusticthaumaturgy.common.block.ModBlocks;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItems;

import thaumcraft.api.blocks.BlocksTC;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import rustic.common.Config;

@Mod.EventBusSubscriber(modid = RusticThaumaturgy.MODID)
public class Recipes {
	
	@SubscribeEvent
	public static void initRecipes(RegistryEvent.Register<IRecipe> event) {
		if (Config.ENABLE_CHAIRS) {
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "greatwood_chair"), new ResourceLocation(RusticThaumaturgy.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_GREATWOOD, 4), "P  ", "PPP", "S S", 'P', new ItemStack(BlocksTC.plankGreatwood), 'S', new ItemStack(Items.STICK));
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "silverwood_chair"), new ResourceLocation(RusticThaumaturgy.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_SILVERWOOD, 4), "P  ", "PPP", "S S", 'P', new ItemStack(BlocksTC.plankSilverwood), 'S', new ItemStack(Items.STICK));
		}
		if (Config.ENABLE_TABLES) {
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "greatwood_table"), new ResourceLocation(RusticThaumaturgy.MODID, "table"), new ItemStack(ModBlocks.TABLE_GREATWOOD, 2), "PPP", "S S", 'P', new ItemStack(BlocksTC.plankGreatwood), 'S', new ItemStack(Items.STICK));
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "silverwood_table"), new ResourceLocation(RusticThaumaturgy.MODID, "table"), new ItemStack(ModBlocks.TABLE_SILVERWOOD, 2), "PPP", "S S", 'P', new ItemStack(BlocksTC.plankSilverwood), 'S', new ItemStack(Items.STICK));
			
			

		}
		//Cindermote to Tiny Pile of Blaze Powder
		//GameRegistry.addShapelessRecipe(), new ResourceLocation(), new ItemStack(ModItems.CINDERMOTE, 1));
		
	}
	private static void initOres() {
		addOreDictEntries();
		
	}
	private static void addOreDictEntries() {
		OreDictionary.registerOre("dustTinyBlaze", new ItemStack(ModItems.BLAZE_POWDER_TINY));
		
	}
	
}