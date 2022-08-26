
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class ItemGoodbyeLuluPt2 extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:goodbye_lulu_pt_2")
	public static final Item block = null;
	public ItemGoodbyeLuluPt2(ElementsTmsModMod instance) {
		super(instance, 647);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:goodbye_lulu_pt_2", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("goodbye_lulu_pt_2", ElementsTmsModMod.sounds.get(new ResourceLocation("tms_mod:goodbyelulupt2")));
			setUnlocalizedName("goodbye_lulu_pt_2");
			setRegistryName("goodbye_lulu_pt_2");
			setCreativeTab(CreativeTabs.MISC);
		}
	}
}
