
package net.mcreator.tmsmod.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.tmsmod.creativetab.TabUnitedPlanets;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class BlockRyanwoodLeaves extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:ryanwood_leaves")
	public static final Block block = null;
	public BlockRyanwoodLeaves(ElementsTmsModMod instance) {
		super(instance, 183);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("ryanwood_leaves"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("tms_mod:ryanwood_leaves", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.LEAVES);
			setUnlocalizedName("ryanwood_leaves");
			setSoundType(SoundType.PLANT);
			setHardness(0.22F);
			setResistance(0.22F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabUnitedPlanets.tab);
		}

		@Override
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 33;
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(Blocks.AIR, (int) (1)));
		}
	}
}
