package com.github.voxelfriend.rusticthaumaturgy.common.potions;


import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PotionsRT {

	public static final Potion VISCERAL_SURGE = new PotionBase(false, 6563840, "visceral_surge").setIconIndex(5, 0).setRegistryName(new ResourceLocation("rusticthaumaturgy:visceral_surge"));
		
	
	public static void init() {
		//Potions
		GameRegistry.findRegistry(Potion.class).register(VISCERAL_SURGE);
	
	}

}