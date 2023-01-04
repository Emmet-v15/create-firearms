package studio.v15.createfirearms.blocks.sulfur_ore;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import studio.v15.createfirearms.ExampleMod;

public class ModBlocks {

	private static Block registerBlockWithoutItem(String name, Block block) {
		return Registry.register(Registry.BLOCK, new ResourceLocation(ExampleMod.ID, name), block);
	}

	private static Block registerBlock(String name, Block block, CreativeModeTab tab) {
		registerBlockItem(name, block, tab);
		return Registry.register(Registry.BLOCK, new ResourceLocation(ExampleMod.ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block, CreativeModeTab tab) {
		return Registry.register(Registry.ITEM, new ResourceLocation(ExampleMod.ID, name),
				new BlockItem(block, new FabricItemSettings().group(tab)));
	}

	public static void registerModBlocks() {
		ExampleMod.LOGGER.debug("Registering ModBlocks for " + ExampleMod.ID);
	}
}
