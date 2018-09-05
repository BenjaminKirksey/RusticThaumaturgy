//Hello World

package com.github.voxelfriend.rusticthaumaturgy.core;

import java.io.File;

import com.github.voxelfriend.rusticthaumaturgy.common.block.ModBlocks;
import com.github.voxelfriend.rusticthaumaturgy.common.block.fluids.ModFluids;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItems;
import com.github.voxelfriend.rusticthaumaturgy.crafting.Recipes;

import net.minecraft.block.BlockDispenser;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
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


public class CommonProxy {
	
	public static Configuration config;

	public void preInit(FMLPreInitializationEvent event) {
        ModFluids.init();
        ModBlocks.init();
        ModItems.init();
    }
	
	public void init(FMLInitializationEvent event) {
		Recipes.init();
		initFluidBottle();
		 
	}

    public void postInit(FMLPostInitializationEvent event) {
 
    }
    
    public void initFluidBottle() {
        ItemFluidBottle.addFluid(ModFluids.CINDERFIRE_WHISKEY);
	    ItemFluidBottle.addFluid(ModFluids.SHIMMERDEW_SPIRITS);
	    ItemFluidBottle.addFluid(ModFluids.VISCOUS_BREW);
    }
	
}