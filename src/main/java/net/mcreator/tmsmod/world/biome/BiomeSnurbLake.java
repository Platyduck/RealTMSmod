
package net.mcreator.tmsmod.world.biome;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.monster.EntityBlaze;

import net.mcreator.tmsmod.block.BlockRichGrass;
import net.mcreator.tmsmod.block.BlockRichDirt;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Random;

@ElementsTmsModMod.ModElement.Tag
public class BiomeSnurbLake extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:snurb_lake")
	public static final BiomeGenCustom biome = null;
	public BiomeSnurbLake(ElementsTmsModMod instance) {
		super(instance, 958);
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
			super(new Biome.BiomeProperties("Snurb Drylands").setRainfall(0F).setBaseHeight(0F).setWaterColor(-3342337).setHeightVariation(0F)
					.setTemperature(0.5F));
			setRegistryName("snurb_lake");
			topBlock = BlockRichGrass.block.getDefaultState();
			fillerBlock = BlockRichDirt.block.getDefaultState();
			decorator.treesPerChunk = 6;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 3;
			decorator.gravelPatchesPerChunk = 5;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
			this.spawnableCreatureList.add(new SpawnListEntry(EntityBlaze.class, 5, 1, 1));
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -3342439;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -3342439;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -3342337;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return new WorldGenBirchTree(true, true);
		}
	}
}
