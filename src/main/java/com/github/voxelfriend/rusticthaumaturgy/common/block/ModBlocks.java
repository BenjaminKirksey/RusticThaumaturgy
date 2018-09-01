//Hello World

package com.github.voxelfriend.rusticthaumaturgy.common.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rustic.common.Config;
import rustic.common.blocks.BlockChair;
import rustic.common.blocks.BlockTable;

public class ModBlocks {

	public static BlockChair CHAIR_GREATWOOD;
	public static BlockChair CHAIR_SILVERWOOD;
	public static BlockTable TABLE_GREATWOOD;
	public static BlockTable TABLE_SILVERWOOD;


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
	}


}
