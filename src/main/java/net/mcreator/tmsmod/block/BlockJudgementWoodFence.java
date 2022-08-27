
package net.mcreator.tmsmod.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockFence;
import net.minecraft.block.Block;

import net.mcreator.tmsmod.creativetab.TabFinalBattle;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class BlockJudgementWoodFence extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:judgement_wood_fence")
	public static final Block block = null;
	public BlockJudgementWoodFence(ElementsTmsModMod instance) {
		super(instance, 864);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("judgement_wood_fence"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("tms_mod:judgement_wood_fence", "inventory"));
	}
	public static class BlockCustom extends BlockFence {
		public BlockCustom() {
			super(Material.WOOD, Material.WOOD.getMaterialMapColor());
			setUnlocalizedName("judgement_wood_fence");
			setSoundType(SoundType.WOOD);
			setHardness(6F);
			setResistance(9F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabFinalBattle.tab);
			setBlockUnbreakable();
		}

		@Override
		public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
			return 15;
		}
	}
}
