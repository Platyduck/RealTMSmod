
package net.mcreator.tmsmod.world.biome;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import net.mcreator.tmsmod.block.BlockLowerLog;
import net.mcreator.tmsmod.block.BlockLowerLeaves;
import net.mcreator.tmsmod.block.BlockLowerGrass;
import net.mcreator.tmsmod.block.BlockLowerDirt;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Random;

@ElementsTmsModMod.ModElement.Tag
public class BiomeLowerWorld extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:lower_world")
	public static final BiomeGenCustom biome = null;
	public BiomeLowerWorld(ElementsTmsModMod instance) {
		super(instance, 1453);
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
			super(new Biome.BiomeProperties("Lower World").setRainfall(0.5F).setBaseHeight(0.1F).setWaterColor(-10027009).setHeightVariation(0F)
					.setTemperature(0.5F));
			setRegistryName("lower_world");
			topBlock = BlockLowerGrass.block.getDefaultState();
			fillerBlock = BlockLowerDirt.block.getDefaultState();
			decorator.treesPerChunk = 1;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -16724890;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -16724890;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -6697729;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return new CustomTree();
		}
	}

	static class CustomTree extends WorldGenAbstractTree {
		CustomTree() {
			super(false);
		}

		@Override
		public boolean generate(World world, Random rand, BlockPos position) {
			int height = rand.nextInt(5) + 2;
			boolean spawnTree = true;
			if (position.getY() >= 1 && position.getY() + height + 1 <= world.getHeight()) {
				for (int j = position.getY(); j <= position.getY() + 1 + height; j++) {
					int k = 1;
					if (j == position.getY())
						k = 0;
					if (j >= position.getY() + height - 1)
						k = 2;
					for (int px = position.getX() - k; px <= position.getX() + k && spawnTree; px++) {
						for (int pz = position.getZ() - k; pz <= position.getZ() + k && spawnTree; pz++) {
							if (j >= 0 && j < world.getHeight()) {
								if (!this.isReplaceable(world, new BlockPos(px, j, pz))) {
									spawnTree = false;
								}
							} else {
								spawnTree = false;
							}
						}
					}
				}
				if (!spawnTree) {
					return false;
				} else {
					Block ground = world.getBlockState(position.add(0, -1, 0)).getBlock();
					Block ground2 = world.getBlockState(position.add(0, -2, 0)).getBlock();
					if (!((ground == BlockLowerGrass.block.getDefaultState().getBlock()
							|| ground == BlockLowerDirt.block.getDefaultState().getBlock())
							&& (ground2 == BlockLowerGrass.block.getDefaultState().getBlock()
									|| ground2 == BlockLowerDirt.block.getDefaultState().getBlock())))
						return false;
					IBlockState state = world.getBlockState(position.down());
					if (position.getY() < world.getHeight() - height - 1) {
						world.setBlockState(position.down(), BlockLowerDirt.block.getDefaultState(), 2);
						for (int genh = position.getY() - 3 + height; genh <= position.getY() + height; genh++) {
							int i4 = genh - (position.getY() + height);
							int j1 = (int) (1 - i4 * 0.5);
							for (int k1 = position.getX() - j1; k1 <= position.getX() + j1; ++k1) {
								for (int i2 = position.getZ() - j1; i2 <= position.getZ() + j1; ++i2) {
									int j2 = i2 - position.getZ();
									if (Math.abs(position.getX()) != j1 || Math.abs(j2) != j1 || rand.nextInt(2) != 0 && i4 != 0) {
										BlockPos blockpos = new BlockPos(k1, genh, i2);
										state = world.getBlockState(blockpos);
										if (state.getBlock().isAir(state, world, blockpos) || state.getBlock().isLeaves(state, world, blockpos)
												|| state.getBlock() == Blocks.AIR.getDefaultState().getBlock()
												|| state.getBlock() == BlockLowerLeaves.block.getDefaultState().getBlock()) {
											this.setBlockAndNotifyAdequately(world, blockpos, BlockLowerLeaves.block.getDefaultState());
										}
									}
								}
							}
						}
						for (int genh = 0; genh < height; genh++) {
							BlockPos genhPos = position.up(genh);
							state = world.getBlockState(genhPos);
							if (state.getBlock().isAir(state, world, genhPos) || state.getBlock() == Blocks.AIR.getDefaultState().getBlock()
									|| state.getBlock() == BlockLowerLeaves.block.getDefaultState().getBlock()) {
								this.setBlockAndNotifyAdequately(world, position.up(genh), BlockLowerLog.block.getDefaultState());
								if (genh > 0) {
									if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(-1, genh, 0)))
										this.setBlockAndNotifyAdequately(world, position.add(-1, genh, 0), Blocks.AIR.getDefaultState());
									if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(1, genh, 0)))
										this.setBlockAndNotifyAdequately(world, position.add(1, genh, 0), Blocks.AIR.getDefaultState());
									if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(0, genh, -1)))
										this.setBlockAndNotifyAdequately(world, position.add(0, genh, -1), Blocks.AIR.getDefaultState());
									if (rand.nextInt(3) > 0 && world.isAirBlock(position.add(0, genh, 1)))
										this.setBlockAndNotifyAdequately(world, position.add(0, genh, 1), Blocks.AIR.getDefaultState());
								}
							}
						}
						for (int genh = position.getY() - 3 + height; genh <= position.getY() + height; genh++) {
							int k4 = (int) (1 - (genh - (position.getY() + height)) * 0.5);
							for (int genx = position.getX() - k4; genx <= position.getX() + k4; genx++) {
								for (int genz = position.getZ() - k4; genz <= position.getZ() + k4; genz++) {
									BlockPos bpos = new BlockPos(genx, genh, genz);
									state = world.getBlockState(bpos);
									if (state.getBlock().isLeaves(state, world, bpos)
											|| state.getBlock() == BlockLowerLeaves.block.getDefaultState().getBlock()) {
										BlockPos blockpos1 = bpos.south();
										BlockPos blockpos2 = bpos.west();
										BlockPos blockpos3 = bpos.east();
										BlockPos blockpos4 = bpos.north();
										if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos2))
											this.addVines(world, blockpos2);
										if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos3))
											this.addVines(world, blockpos3);
										if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos4))
											this.addVines(world, blockpos4);
										if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos1))
											this.addVines(world, blockpos1);
									}
								}
							}
						}
						if (rand.nextInt(4) == 0 && height > 5) {
							for (int hlevel = 0; hlevel < 2; hlevel++) {
								for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
									if (rand.nextInt(4 - hlevel) == 0) {
										EnumFacing enumfacing1 = enumfacing.getOpposite();
										this.setBlockAndNotifyAdequately(world,
												position.add(enumfacing1.getFrontOffsetX(), height - 5 + hlevel, enumfacing1.getFrontOffsetZ()),
												Blocks.AIR.getDefaultState());
									}
								}
							}
						}
						return true;
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		}

		private void addVines(World world, BlockPos pos) {
			this.setBlockAndNotifyAdequately(world, pos, Blocks.AIR.getDefaultState());
			int i = 5;
			for (BlockPos blockpos = pos.down(); world.isAirBlock(blockpos) && i > 0; --i) {
				this.setBlockAndNotifyAdequately(world, blockpos, Blocks.AIR.getDefaultState());
				blockpos = blockpos.down();
			}
		}

		@Override
		protected boolean canGrowInto(Block blockType) {
			return blockType.getDefaultState().getMaterial() == Material.AIR || blockType == BlockLowerLog.block.getDefaultState().getBlock()
					|| blockType == BlockLowerLeaves.block.getDefaultState().getBlock()
					|| blockType == BlockLowerGrass.block.getDefaultState().getBlock()
					|| blockType == BlockLowerDirt.block.getDefaultState().getBlock();
		}

		@Override
		protected void setDirtAt(World world, BlockPos pos) {
			if (world.getBlockState(pos).getBlock() != BlockLowerDirt.block.getDefaultState().getBlock())
				this.setBlockAndNotifyAdequately(world, pos, BlockLowerDirt.block.getDefaultState());
		}

		@Override
		public boolean isReplaceable(World world, BlockPos pos) {
			net.minecraft.block.state.IBlockState state = world.getBlockState(pos);
			return state.getBlock().isAir(state, world, pos) || canGrowInto(state.getBlock()) || state.getBlock().isReplaceable(world, pos);
		}
	}
}
