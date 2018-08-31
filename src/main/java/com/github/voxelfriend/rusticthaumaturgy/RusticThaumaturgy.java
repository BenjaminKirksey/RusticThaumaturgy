//Hello World

package com.github.voxelfriend.rusticthaumaturgy;

import org.apache.logging.log4j.Logger;

import com.github.voxelfriend.rusticthaumaturgy.crafting.Recipes;
import com.github.voxelfriend.rusticthaumaturgy.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RusticThaumaturgy.MODID, name = RusticThaumaturgy.NAME, version = RusticThaumaturgy.VERSION, dependencies = "required-after:rustic;required-after:thaumcraft")
public class RusticThaumaturgy {
	public static final String MODID = "rusticthaumaturgy";
	public static final String NAME = "Rustic Thaumaturgy";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide = "com.github.voxelfriend.rusticthaumaturgy.proxy.ClientProxy", serverSide = "com.github.voxelfriend.rusticthaumaturgy.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

}