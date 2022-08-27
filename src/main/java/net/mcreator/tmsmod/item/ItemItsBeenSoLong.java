
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
public class ItemItsBeenSoLong extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:its_been_so_long")
	public static final Item block = null;
	public ItemItsBeenSoLong(ElementsTmsModMod instance) {
		super(instance, 679);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:its_been_so_long", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("its_been_so_long", ElementsTmsModMod.sounds.get(new ResourceLocation("tms_mod:manbehindtheslaughter")));
			setUnlocalizedName("its_been_so_long");
			setRegistryName("its_been_so_long");
			setCreativeTab(CreativeTabs.MISC);
		}
	}
}
