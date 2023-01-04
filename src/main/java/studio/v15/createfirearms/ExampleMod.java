package studio.v15.createfirearms;

import com.mojang.logging.LogUtils;
import com.simibubi.create.Create;

import net.fabricmc.api.ModInitializer;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.util.valueproviders.UniformInt;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import net.minecraft.world.level.material.MaterialColor;

import org.slf4j.Logger;

public class ExampleMod implements ModInitializer {
	public static final String ID = "createfirearms";
	public static final String NAME = "Create's Firearms";
	public static final String VERSION = "0.0.1";

	public static final Logger LOGGER = LogUtils.getLogger();

	private static Block register(String key, Block block) {
		return (Block)Registry.register(Registry.BLOCK, key, block);
	}
	public static final Block SULFUR_ORE;
	public static final Block DEEPSLATE_SULFUR_ORE;
	public static final Block SULFUR_BLOCK;

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] loading alongside Create [{}]!", ID, Create.VERSION);
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}

	static {
		SULFUR_ORE = register("sulfur_ore", new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F), UniformInt.of(3, 7)));
		DEEPSLATE_SULFUR_ORE = register("deepslate_sulfur_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(SULFUR_ORE).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
		SULFUR_BLOCK = register("sulfur_block", new Block(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.GOLD).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.SAND)));
	}
}
