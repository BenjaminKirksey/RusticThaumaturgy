package com.github.voxelfriend.rusticthaumaturgy.proxy;

import com.github.voxelfriend.rusticthaumaturgy.block.ModBlocks;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		ModBlocks.initModels();
	}



}
