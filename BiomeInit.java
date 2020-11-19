package com.krassepizza.abyss.init;

import com.krassepizza.abyss.Abyss;
import com.krassepizza.abyss.world.biomes.AbyssBiome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Abyss.MOD_ID);

	public static final RegistryObject<Biome> ABYSS_BIOME = BIOMES.register("abyss_biome",
			() -> new AbyssBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(1.2f).temperature(20.0f)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(BlockInit.abyss_dirt.getDefaultState(),
									BlockInit.abyss_rock.getDefaultState(), Blocks.ANDESITE.getDefaultState()))
					.category(Category.PLAINS).downfall(0.5f).depth(0.125f).parent(null)));
	
	public static void registerBiomes()
	{
		registerBiome(ABYSS_BIOME.get(), Type.PLAINS, Type.HOT, Type.OVERWORLD); //Kann noch einiges ändern hier Type.etc , Type.VOID, Type.NETHER
	}
	
	private static void registerBiome(Biome biome, Type... types)
	{
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}
}
