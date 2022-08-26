
package net.mcreator.tmsmod.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.tmsmod.creativetab.TabTMSmod;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class BlockLowerCaveMazeBricks extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:lower_cave_maze_bricks")
	public static final Block block = null;
	public BlockLowerCaveMazeBricks(ElementsTmsModMod instance) {
		super(instance, 402);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("lower_cave_maze_bricks"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("tms_mod:lower_cave_maze_bricks", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("lower_cave_maze_bricks");
			setSoundType(SoundType.STONE);
			setHarvestLevel("pickaxe", 8);
			setHardness(50F);
			setResistance(80F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabTMSmod.tab);
		}
	}
}
