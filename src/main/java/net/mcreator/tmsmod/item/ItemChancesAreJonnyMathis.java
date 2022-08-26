
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
public class ItemChancesAreJonnyMathis extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:chances_are_jonny_mathis")
	public static final Item block = null;
	public ItemChancesAreJonnyMathis(ElementsTmsModMod instance) {
		super(instance, 672);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:chances_are_jonny_mathis", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("chances_are_jonny_mathis", ElementsTmsModMod.sounds.get(new ResourceLocation("tms_mod:lobbysong")));
			setUnlocalizedName("chances_are_jonny_mathis");
			setRegistryName("chances_are_jonny_mathis");
			setCreativeTab(CreativeTabs.MISC);
		}
	}
}
