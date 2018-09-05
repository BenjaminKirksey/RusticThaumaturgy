//Hello World

package com.github.voxelfriend.rusticthaumaturgy.common.blocks;

import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

import com.github.voxelfriend.rusticthaumaturgy.common.crops.BlockCropCindermote;
import com.github.voxelfriend.rusticthaumaturgy.common.crops.BlockCropShimmerpetal;
import com.github.voxelfriend.rusticthaumaturgy.common.crops.BlockCropViscap;
import com.github.voxelfriend.rusticthaumaturgy.common.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import rustic.common.Config;

public class ModBlocks {

	public static BlockChair CHAIR_GREATWOOD;
	public static BlockChair CHAIR_SILVERWOOD;
	public static BlockTable TABLE_GREATWOOD;
	public static BlockTable TABLE_SILVERWOOD;	
	public static final List<Block> BLOCKS = new ArrayList<>();

	public static final BlockCropCindermote CINDERMOTE = new BlockCropCindermote();
	public static final BlockCropShimmerpetal SHIMMERPETAL = new BlockCropShimmerpetal();
	public static final BlockCropViscap VISCAP = new BlockCropViscap();
	
	public static void init() {
		if (Config.ENABLE_CHAIRS) {
			CHAIR_GREATWOOD = new BlockChair("greatwood");
			CHAIR_SILVERWOOD = new BlockChair("silverwood");

		}
		if (Config.ENABLE_TABLES) {
			TABLE_GREATWOOD = new BlockTable("greatwood");
			TABLE_SILVERWOOD = new BlockTable("silverwood");

		}

}

	@SideOnly(Side.CLIENT)
	public static void initModels() {
		if (Config.ENABLE_CHAIRS) {
			CHAIR_GREATWOOD.initModel();
			CHAIR_SILVERWOOD.initModel();

		}
		if (Config.ENABLE_TABLES) {
			TABLE_GREATWOOD.initModel();
			TABLE_SILVERWOOD.initModel();

		}
		for (Block block : BLOCKS) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName().toString()));
}
}


}
