
package net.mcreator.tmsmod.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.Block;

import net.mcreator.tmsmod.creativetab.TabUnitedPlanets;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class BlockNeptunianGravel extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:neptunian_gravel")
	public static final Block block = null;
	public BlockNeptunianGravel(ElementsTmsModMod instance) {
		super(instance, 244);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("neptunian_gravel"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("tms_mod:neptunian_gravel", "inventory"));
	}
	public static class BlockCustom extends BlockFalling {
		public BlockCustom() {
			super(Material.GROUND);
			setUnlocalizedName("neptunian_gravel");
			setSoundType(SoundType.GROUND);
			setHarvestLevel("shovel", -1);
			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabUnitedPlanets.tab);
		}

		@Override
		public MapColor getMapColor(IBlockState state, IBlockAccess blockAccess, BlockPos pos) {
			return MapColor.CLAY;
		}
	}
}