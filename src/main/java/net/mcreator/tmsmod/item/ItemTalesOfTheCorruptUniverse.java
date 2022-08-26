
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.tmsmod.creativetab.TabUnitedPlanets;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class ItemTalesOfTheCorruptUniverse extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:tales_of_the_corrupt_universe")
	public static final Item block = null;
	public ItemTalesOfTheCorruptUniverse(ElementsTmsModMod instance) {
		super(instance, 219);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:tales_of_the_corrupt_universe", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("tales_of_the_corrupt_universe", ElementsTmsModMod.sounds.get(new ResourceLocation("tms_mod:corruptuniversesong")));
			setUnlocalizedName("tales_of_the_corrupt_universe");
			setRegistryName("tales_of_the_corrupt_universe");
			setCreativeTab(TabUnitedPlanets.tab);
		}
	}
}
