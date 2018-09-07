//Hello World

package com.github.voxelfriend.rusticthaumaturgy.crafting;

import java.util.ArrayList;
import java.util.List;

import com.github.voxelfriend.rusticthaumaturgy.core.RusticThaumaturgy;
import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocks;
import com.github.voxelfriend.rusticthaumaturgy.common.blocks.fluids.ModFluids;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItems;

import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.client.lib.obj.Material;
import thaumcraft.common.blocks.BlockTC;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;
import rustic.common.Config;
import rustic.common.crafting.BrewingBarrelRecipe;
import rustic.common.crafting.CondenserRecipe;
import rustic.common.crafting.CrushingTubRecipe;
import rustic.common.crafting.EvaporatingBasinRecipe;
import rustic.common.crafting.RecipeNonIngredientReturn;
import rustic.core.Rustic;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.capabilities.IPlayerKnowledge.EnumKnowledgeType;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IThaumcraftRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.api.research.ResearchEntry;
import thaumcraft.api.research.ResearchEntry.EnumResearchMeta;
import thaumcraft.api.research.ResearchStage;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.lib.research.ResearchManager;

import static rustic.common.crafting.Recipes.crushingTubRecipes;
import static rustic.common.crafting.Recipes.evaporatingRecipes;
import static rustic.common.crafting.Recipes.condenserRecipes;
import static rustic.common.crafting.Recipes.brewingRecipes;

@Mod.EventBusSubscriber(modid = RusticThaumaturgy.MODID)
public class Recipes {
	
	
    public static void init() {
		//addCraftingRecipes();
		addCrushingTubRecipes();
		addEvaporatingRecipes();
		//addCondenserRecipes();
		addBrewingRecipes();
    }
    
   public static void addOreDictEntries() {
		//Adds Tiny Pile of Blaze Powder to OreDict
    	OreDictionary.registerOre("dustTinyBlaze", new ItemStack(ModItems.BLAZE_POWDER_TINY));	
	}
		
	@SubscribeEvent
	public static void initRecipes(RegistryEvent.Register<IRecipe> event) {
		if (Config.ENABLE_CHAIRS) {
			//Greatwood Chair Recipe
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "greatwood_chair"),
				new ResourceLocation(RusticThaumaturgy.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_GREATWOOD, 4), "P  ", "PPP", "S S", 'P', new ItemStack(BlocksTC.plankGreatwood), 'S', new ItemStack(Items.STICK));
			
			//Silverwood Chair Recipe
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "silverwood_chair"),
				new ResourceLocation(RusticThaumaturgy.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_SILVERWOOD, 4), "P  ", "PPP", "S S", 'P', new ItemStack(BlocksTC.plankSilverwood), 'S', new ItemStack(Items.STICK));
		}
		if (Config.ENABLE_TABLES) {
			//Greatwood Table Recipe
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "greatwood_table"),
				new ResourceLocation(RusticThaumaturgy.MODID, "table"), new ItemStack(ModBlocks.TABLE_GREATWOOD, 2), "PPP", "S S", 'P', new ItemStack(BlocksTC.plankGreatwood), 'S', new ItemStack(Items.STICK));
			
			//Silverwood Table Recipe
			GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "silverwood_table"),
				new ResourceLocation(RusticThaumaturgy.MODID, "table"), new ItemStack(ModBlocks.TABLE_SILVERWOOD, 2), "PPP", "S S", 'P', new ItemStack(BlocksTC.plankSilverwood), 'S', new ItemStack(Items.STICK));
		}
		//Tiny Pile of Blaze Powder to Blaze Powder Recipe
		GameRegistry.addShapedRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "dustTinyBlaze"), new ResourceLocation(RusticThaumaturgy.MODID, "conversion"), new ItemStack(Items.BLAZE_POWDER, 1), "PP", "PP", 'P', new ItemStack(ModItems.BLAZE_POWDER_TINY));
		//Blaze Powder to Tiny Pile of Blaze Powder Recipe
		GameRegistry.addShapelessRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "blaze_powder"), new ResourceLocation(RusticThaumaturgy.MODID, "conversion"), new ItemStack(ModItems.BLAZE_POWDER_TINY, 4), Ingredient.fromStacks(new ItemStack(Items.BLAZE_POWDER)));
		//Cindermote to Tiny Pile of Blaze Powder Conversion Recipe
		GameRegistry.addShapelessRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "cindermote"), new ResourceLocation(RusticThaumaturgy.MODID, "conversion"), new ItemStack(ModItems.BLAZE_POWDER_TINY), Ingredient.fromStacks(new ItemStack(ModItems.CINDERMOTE)));
		GameRegistry.addShapelessRecipe(new ResourceLocation(RusticThaumaturgy.MODID, "shimmerpetal"), new ResourceLocation(RusticThaumaturgy.MODID, "conversion"), new ItemStack(ItemsTC.nuggets, 1 ,5), Ingredient.fromStacks(new ItemStack(ModItems.SHIMMERPETAL)));
	}
	
	
	public static void addCrushingTubRecipes() {
		//Cinderfire Wort Crushing Recipes
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluids.CINDERFIRE_WORT, 125), new ItemStack(ModItems.CINDERMOTE)));
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluids.CINDERFIRE_WORT, 250), new ItemStack(BlocksTC.cinderpearl)));
		
		//Shimmerdew Wort Crushing Recipes
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluids.SHIMMERDEW_WORT, 125), new ItemStack(ModItems.SHIMMERPETAL)));
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluids.SHIMMERDEW_WORT, 250), new ItemStack(BlocksTC.shimmerleaf)));
		
		//Viscous Brew Crushing Recipes
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluids.VISCOUS_WORT, 125), new ItemStack(ModItems.VISCAP)));
		crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluids.VISCOUS_WORT, 250), new ItemStack(BlocksTC.vishroom)));
	}
		
	public static void addEvaporatingRecipes() {
		//Tiny Pile of Blaze Powder Evaporation Recipe
		evaporatingRecipes.add(new EvaporatingBasinRecipe(new ItemStack(ModItems.BLAZE_POWDER_TINY, 1),
					new FluidStack(ModFluids.CINDERFIRE_WORT, 500)));
	}
		
	public static void addBrewingRecipes() {
		//Cinderfire Whiskey Recipe
		brewingRecipes.add(new BrewingBarrelRecipe(new FluidStack(ModFluids.CINDERFIRE_WHISKEY, 1), new FluidStack(ModFluids.CINDERFIRE_WORT, 1)));
		
		//Shimmerdew Spirits Recipe
		brewingRecipes.add(new BrewingBarrelRecipe(new FluidStack(ModFluids.SHIMMERDEW_SPIRITS, 1), new FluidStack(ModFluids.SHIMMERDEW_WORT, 1)));
		
		//Viscous Brew Recipe
		brewingRecipes.add(new BrewingBarrelRecipe(new FluidStack(ModFluids.VISCOUS_BREW, 1),new FluidStack(ModFluids.VISCOUS_WORT, 1)));
	}
}