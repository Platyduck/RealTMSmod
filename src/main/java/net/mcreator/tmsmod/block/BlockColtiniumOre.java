
package net.mcreator.tmsmod.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.tmsmod.world.WorldLowerRealmDim;
import net.mcreator.tmsmod.item.ItemColtiniumDust;
import net.mcreator.tmsmod.creativetab.TabUnitedPlanets;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Random;

@ElementsTmsModMod.ModElement.Tag
public class BlockColtiniumOre extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:coltinium_ore")
	public static final Block block = null;
	public BlockColtiniumOre(ElementsTmsModMod instance) {
		super(instance, 200);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("coltinium_ore"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("tms_mod:coltinium_ore", "inventory"));
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == WorldLowerRealmDim.DIMID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		for (int i = 0; i < 3; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(76) + 1;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 8, new com.google.common.base.Predicate<IBlockState>() {
				public boolean apply(IBlockState blockAt) {
					boolean blockCriteria = false;
					IBlockState require;
					if (blockAt.getBlock() == BlockLowerStone.block.getDefaultState().getBlock())
						blockCriteria = true;
					return blockCriteria;
				}
			})).generate(world, random, new BlockPos(x, y, z));
		}
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("coltinium_ore");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 2);
			setHardness(2.4000000000000004F);
			setResistance(4.182558210365094F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabUnitedPlanets.tab);
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(ItemColtiniumDust.block, (int) (3)));
		}
	}
}
