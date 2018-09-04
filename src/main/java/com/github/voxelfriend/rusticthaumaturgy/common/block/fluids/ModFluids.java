package com.github.voxelfriend.rusticthaumaturgy.common.block.fluids;

    import java.util.ArrayList;
    import java.util.List;
    
    import net.minecraft.block.material.Material;
	import net.minecraft.block.state.IBlockState;
	import net.minecraft.entity.Entity;
	import net.minecraft.entity.player.EntityPlayer;
	import net.minecraft.init.MobEffects;
	import net.minecraft.item.ItemStack;
	import net.minecraft.potion.PotionEffect;
	import net.minecraft.util.DamageSource;
	import net.minecraft.util.ResourceLocation;
	import net.minecraft.util.math.BlockPos;
	import net.minecraft.world.World;
	import net.minecraftforge.fluids.Fluid;
	import net.minecraftforge.fluids.FluidRegistry;
	import net.minecraftforge.fluids.FluidStack;
    import rustic.common.blocks.fluids.FluidBooze;
    import rustic.common.blocks.fluids.FluidDrinkable;
    import rustic.common.potions.PotionsRustic;

    public class ModFluids {
    	
    	public static Fluid CINDERFIRE_WORT;
		public static Fluid SHIMMERDEW_WORT;
		public static Fluid VISCOUS_WORT;
		public static Fluid CINDERFIRE_WHISKEY;
		public static Fluid SHIMMERDEW_SPIRITS;	
		public static Fluid VISCOUS_BREW;		
		
		private static List<Fluid> FLUIDS = new ArrayList<Fluid>();
		
		public static BlockFluidRT BLOCK_CINDERFIRE_WORT;
		public static BlockFluidRT BLOCK_SHIMMERDEW_WORT;
		public static BlockFluidRT BLOCK_VISCOUS_WORT;
		public static BlockFluidRT BLOCK_CINDERFIRE_WHISKEY;
		public static BlockFluidRT BLOCK_SHIMMERDEW_SPIRITS;
		public static BlockFluidRT BLOCK_VISCOUS_BREW;
		
		public static void init() {
			
			CINDERFIRE_WORT = new FluidDrinkable("cinderfire_wort",
					new ResourceLocation("rusticthaumaturgy:blocks/fluids/cinderfire_wort_still"),
					new ResourceLocation("rusticthaumaturgy:blocks/fluids/cinderfire_wort_flow")) {
				@Override
				public void onDrank(World world, EntityPlayer player, ItemStack stack, FluidStack fluid) {
					player.getFoodStats().addStats(1, 2F);
					player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 400, 1));
				}
			}.setDensity(1004).setViscosity(2000);
			
			register(CINDERFIRE_WORT);
			
			SHIMMERDEW_WORT = new FluidDrinkable("shimmerdew_wort",
					new ResourceLocation("rusticthaumaturgy:blocks/fluids/shimmerdew_wort_still"),
					new ResourceLocation("rusticthaumaturgy:blocks/fluids/shimmerdew_wort_flow")) {
				@Override
				public void onDrank(World world, EntityPlayer player, ItemStack stack, FluidStack fluid) {
					player.getFoodStats().addStats(1, 2F);
					player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 400, 1));
				}
			}.setDensity(1004).setViscosity(2000);
			
			register(SHIMMERDEW_WORT);
						
			VISCOUS_WORT = new FluidDrinkable("viscous_wort",
					new ResourceLocation("rusticthaumaturgy:blocks/fluids/viscous_wort_still"),
					new ResourceLocation("rusticthaumaturgy:blocks/fluids/viscous_wort_flow")) {
				@Override
				public void onDrank(World world, EntityPlayer player, ItemStack stack, FluidStack fluid) {
					player.getFoodStats().addStats(1, 2F);
					player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 400, 1));
				}
			}.setDensity(1004).setViscosity(2000);
			
			register(VISCOUS_WORT);
		
			CINDERFIRE_WHISKEY = new FluidBooze("cinderfire_whiskey",
					new ResourceLocation("rusticthaumaturgy:blocks/fluids/booze/cinderfire_whiskey_still"),
					new ResourceLocation("rusticthaumaturgy:blocks/fluids/booze/cinderfire_whiskey_flow")) {
				@Override
				protected void affectPlayer(World world, EntityPlayer player, float quality) {
					if (quality >= 0.5F) {
						float saturation = 4F * quality;
						player.getFoodStats().addStats(2, saturation);
						int duration = (int) (12000 * (Math.max(Math.abs((quality - 0.5F) * 2F), 0F)));
						player.addPotionEffect(new PotionEffect(PotionsRustic.FULL_POTION, duration));
					} else {
						int duration = (int) (6000 * Math.max(1 - quality, 0));
						player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, duration));
						player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, duration));
					}
				}
			}.setInebriationChance(0.5F).setDensity(1004).setViscosity(1016);
	        register(CINDERFIRE_WHISKEY);
	        
	        SHIMMERDEW_SPIRITS = new FluidBooze("shimmering_spirits",
	        		new ResourceLocation("rusticthaumaturgy:blocks/fluids/booze/shimmering_spirits_still"),
	        		new ResourceLocation("rusticthaumaturgy:blocks/fluids/booze/shimmering_spirits_flow")) {
				@Override
				protected void affectPlayer(World world, EntityPlayer player, float quality) {
					if (quality >= 0.5F) {
						float saturation = 4F * quality;
						player.getFoodStats().addStats(2, saturation);
						int duration = (int) (12000 * (Math.max(Math.abs((quality - 0.5F) * 2F), 0F)));
						player.addPotionEffect(new PotionEffect(PotionsRustic.FULL_POTION, duration));
					} else {
						int duration = (int) (6000 * Math.max(1 - quality, 0));
						player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, duration));
						player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, duration));
					}
				}
			}.setInebriationChance(0.5F).setDensity(1004).setViscosity(1016);
	        register(SHIMMERDEW_SPIRITS);
	        
	        VISCOUS_BREW = new FluidBooze("viscous_brew",
	        		new ResourceLocation("rusticthaumaturgy:blocks/fluids/booze/viscous_brew_still"),
	        		new ResourceLocation("rusticthaumaturgy:blocks/fluids/booze/viscous_brew_flow")) {
				@Override
				protected void affectPlayer(World world, EntityPlayer player, float quality) {
					if (quality >= 0.5F) {
						float saturation = 4F * quality;
						player.getFoodStats().addStats(2, saturation);
						int duration = (int) (12000 * (Math.max(Math.abs((quality - 0.5F) * 2F), 0F)));
						player.addPotionEffect(new PotionEffect(PotionsRustic.FULL_POTION, duration));
					} else {
						int duration = (int) (6000 * Math.max(1 - quality, 0));
						player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, duration));
						player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, duration));
					}
				}
			}.setInebriationChance(0.5F).setDensity(1004).setViscosity(1016);
	        register(VISCOUS_BREW);

			BLOCK_CINDERFIRE_WORT = new BlockFluidRT("cinderfire_wort", CINDERFIRE_WORT, Material.WATER);
			BLOCK_CINDERFIRE_WORT.setQuantaPerBlock(4);
			
			BLOCK_SHIMMERDEW_WORT = new BlockFluidRT("shimmerdew_wort", SHIMMERDEW_WORT, Material.WATER);
			BLOCK_SHIMMERDEW_WORT.setQuantaPerBlock(4);
			
			BLOCK_VISCOUS_WORT = new BlockFluidRT("viscous_wort", VISCOUS_WORT, Material.WATER);
			BLOCK_VISCOUS_WORT.setQuantaPerBlock(4);
			
		}
		public static void initModels() {
			BLOCK_CINDERFIRE_WORT.initModel();
			BLOCK_SHIMMERDEW_WORT.initModel();
			BLOCK_VISCOUS_WORT.initModel();
	    }
		
		private static void register(Fluid fluid) {
            if (!FluidRegistry.registerFluid(fluid)) {
                fluid = FluidRegistry.getFluid(fluid.getName());
            }
            FluidRegistry.addBucketForFluid(fluid);

			FLUIDS.add(fluid);
	}
		
		public static ArrayList<Fluid> getFluids() {
			return new ArrayList<Fluid>(FLUIDS);
	    }
		
}