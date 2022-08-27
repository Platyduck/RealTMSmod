
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
public class ItemWateryGraves extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:watery_graves")
	public static final Item block = null;
	public ItemWateryGraves(ElementsTmsModMod instance) {
		super(instance, 695);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:watery_graves", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("watery_graves", ElementsTmsModMod.sounds.get(new ResourceLocation("tms_mod:waterygraves")));
			setUnlocalizedName("watery_graves");
			setRegistryName("watery_graves");
			setCreativeTab(CreativeTabs.MISC);
		}
	}
}
