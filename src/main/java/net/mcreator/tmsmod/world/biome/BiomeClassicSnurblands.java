
package net.mcreator.tmsmod.world.biome;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;

import net.mcreator.tmsmod.entity.EntitySnurb;
import net.mcreator.tmsmod.entity.EntityCrawler;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Random;

@ElementsTmsModMod.ModElement.Tag
public class BiomeClassicSnurblands extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:classic_snurblands")
	public static final BiomeGenCustom biome = null;
	public BiomeClassicSnurblands(ElementsTmsModMod instance) {
		super(instance, 1422);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Classic Snurblands").setRainfall(0.5F).setBaseHeight(0.1F).setWaterColor(-13369396)
					.setHeightVariation(0.2F).setTemperature(0.5F));
			setRegistryName("classic_snurblands");
			topBlock = Blocks.GRASS.getDefaultState();
			fillerBlock = Blocks.DIRT.getStateFromMeta(0);
			decorator.treesPerChunk = 2;
			decorator.flowersPerChunk = 4;
			decorator.grassPerChunk = 4;
			decorator.mushroomsPerChunk = 2;
			decorator.bigMushroomsPerChunk = 1;
			decorator.reedsPerChunk = 2;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
			this.spawnableCreatureList.add(new SpawnListEntry(EntitySnurb.EntityCustom.class, 20, 2, 4));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityCrawler.EntityCustom.class, 15, 1, 3));
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -13382656;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -13382656;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -3342439;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return new WorldGenMegaPineTree(false, true);
		}
	}
}
