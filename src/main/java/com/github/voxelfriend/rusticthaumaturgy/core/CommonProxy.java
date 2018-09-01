//Hello World

package com.github.voxelfriend.rusticthaumaturgy.core;

import com.github.voxelfriend.rusticthaumaturgy.common.block.ModBlocks;
import com.github.voxelfriend.rusticthaumaturgy.common.block.fluids.ModFluids;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItems;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.init();
		ModFluids.init();
		ModItems.init();
		
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postInit(FMLPostInitializationEvent event) {
	}

}
