//Hello World

package com.github.voxelfriend.rusticthaumaturgy.core;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.fluids.ModFluids;

import com.github.voxelfriend.rusticthaumaturgy.common.blocks.ModBlocks;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItems;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @SubscribeEvent
    public void onModelRegistry(ModelRegistryEvent event) {
        ModBlocks.initModels();
        ModItems.initModels();
        ModFluids.initModels();
    }
}