//Hello World

package com.github.voxelfriend.rusticthaumaturgy.core;

import java.io.File;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocks;
import com.github.voxelfriend.rusticthaumaturgy.common.blocks.fluids.ModFluids;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItems;
import com.github.voxelfriend.rusticthaumaturgy.common.potions.PotionsRT;
import com.github.voxelfriend.rusticthaumaturgy.crafting.Recipes;

import net.minecraft.block.BlockDispenser;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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


public abstract class CommonProxy implements IProxy {
	
	public static Configuration config;
    
	@Override
	public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
		ModFluids.init();
        ModBlocks.init();
        ModItems.init();
        PotionsRT.init();
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