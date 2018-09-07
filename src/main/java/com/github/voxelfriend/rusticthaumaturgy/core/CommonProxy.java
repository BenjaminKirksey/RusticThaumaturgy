//Hello World

package com.github.voxelfriend.rusticthaumaturgy.core;

import java.io.File;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocks;
import com.github.voxelfriend.rusticthaumaturgy.common.blocks.fluids.ModFluids;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItems;
import com.github.voxelfriend.rusticthaumaturgy.crafting.Recipes;

import net.minecraft.block.BlockDispenser;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rustic.common.Config;
import rustic.common.items.ItemFluidBottle;
import rustic.common.network.PacketHandler;
import rustic.common.util.DispenseRope;
import rustic.common.world.WorldGeneratorRustic;
import rustic.compat.Compat;
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


public abstract class CommonProxy implements IProxy {
	
	public static Configuration config;
    
	@Override
	public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
		ModFluids.init();
        ModBlocks.init();
        ModItems.init();
    }
	
	public void init(FMLInitializationEvent event) {
		Recipes.init();
		initFluidBottle();
		ResearchCategories.registerCategory("RUSTIC_THAUMATURGY", "UNLOCKAUROMANCY",
				new AspectList(),
				new ResourceLocation("rusticthaumaturgy", "textures/research/brewing_barrel.png"),
				new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_2.jpg"),
                new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png"));
		
		ThaumcraftApi.registerResearchLocation(new ResourceLocation(RusticThaumaturgy.MODID, "research/rustic_thaumaturgy"));
		
		
		 
	}

    public void postInit(FMLPostInitializationEvent event) {
    	
    	initResearch();
 
    }
    
    public void initFluidBottle() {
        ItemFluidBottle.addFluid(ModFluids.CINDERFIRE_WHISKEY);
	    ItemFluidBottle.addFluid(ModFluids.SHIMMERDEW_SPIRITS);
	    ItemFluidBottle.addFluid(ModFluids.VISCOUS_BREW);
    }
    protected void initResearch() {
    	ResearchCategory rusticthaumaturgy = ResearchCategories.getResearchCategory("RUSTIC_THAUMATURGY");
    	
    	ThaumcraftApi.addInfusionCraftingRecipe(
    			new ResourceLocation(RusticThaumaturgy.MODID, "cindermote_seeds"
    			),
				new InfusionRecipe("CINDERMOTE_SEEDS",
						//Result
						new ItemStack(ModItems.CINDERMOTE_SEEDS), 1,
						//Essentia
						new AspectList()
						.add(Aspect.PLANT, 50)
						.add(Aspect.LIFE, 50)
						.add(Aspect.FIRE, 25),
						//Center Item
						new ItemStack(BlocksTC.cinderpearl),
						//Outer Items
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET)
			    )
		);
    	
    	ThaumcraftApi.addInfusionCraftingRecipe(
    			new ResourceLocation(RusticThaumaturgy.MODID, "shimmerpetal_bulb"
    			),
				new InfusionRecipe("SHIMMERPETAL_BULB",
						//Result
						new ItemStack(ModItems.SHIMMERPETAL_BULB),
						//Amount Made
						1,
						//Essentia Requirements
						new AspectList()
						.add(Aspect.PLANT, 50)
						.add(Aspect.LIFE, 50)
						.add(Aspect.AURA, 25),
						//Center Item
						new ItemStack(BlocksTC.shimmerleaf),
						//Outer Items
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET)
			    )
		);
    	
    	ThaumcraftApi.addInfusionCraftingRecipe(
    			new ResourceLocation(RusticThaumaturgy.MODID, "viscap_spores"
    			),
				new InfusionRecipe("VISCAP_SPORES",
						//Result
						new ItemStack(ModItems.VISCAP_SPORES),
						//Amount Made
						1,
						//Essentia Requirements
						new AspectList()
						.add(Aspect.PLANT, 50)
						.add(Aspect.LIFE, 50)
						.add(Aspect.MAGIC, 25),
						//Center Item
						new ItemStack(BlocksTC.vishroom),
						//Outer Items
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET),
						new ItemStack(Items.WHEAT_SEEDS),
						new ItemStack(Items.DYE, 1, 15),
						new ItemStack(Items.WATER_BUCKET)
			    )
		);
    	

    	
    }
    
}