package com.github.voxelfriend.rusticthaumaturgy.crafting;
import com.github.voxelfriend.rusticthaumaturgy.RusticThaumaturgy;
import com.github.voxelfriend.rusticthaumaturgy.block.ModBlocks;

import thaumcraft.api.blocks.BlocksTC;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rustic.common.Config;

public class Recipes {

	public static void init() {
		addCraftingRecipes();
	}

	private static void addCraftingRecipes() {
		if (Config.ENABLE_CHAIRS) {
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "greatwood_chair"), new ResourceLocation(RusticThaumaturgy.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_GREATWOOD, 4), "P  ", "PPP", "S S", 'P', new ItemStack(BlocksTC.plankGreatwood), 'S', new ItemStack(Items.STICK));
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "silverwood_chair"), new ResourceLocation(RusticThaumaturgy.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_SILVERWOOD, 4), "P  ", "PPP", "S S", 'P', new ItemStack(BlocksTC.plankSilverwood), 'S', new ItemStack(Items.STICK));
			
		}
		if (Config.ENABLE_TABLES) {
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "greatwood_table"), new ResourceLocation(RusticThaumaturgy.MODID, "table"), new ItemStack(ModBlocks.TABLE_GREATWOOD, 2), "PPP", "S S", 'P', new ItemStack(BlocksTC.plankGreatwood), 'S', new ItemStack(Items.STICK));
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "silverwood_table"), new ResourceLocation(RusticThaumaturgy.MODID, "table"), new ItemStack(ModBlocks.TABLE_SILVERWOOD, 2), "PPP", "S S", 'P', new ItemStack(BlocksTC.plankSilverwood), 'S', new ItemStack(Items.STICK));

		}
	}
}