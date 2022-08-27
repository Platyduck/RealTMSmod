
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Set;
import java.util.HashMap;

@ElementsTmsModMod.ModElement.Tag
public class ItemRexiumHoe extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:rexium_hoe")
	public static final Item block = null;
	public ItemRexiumHoe(ElementsTmsModMod instance) {
		super(instance, 770);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemHoe(EnumHelper.addToolMaterial("REXIUM_HOE", 3, 1260, 8f, 0f, 10)) {
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("hoe", 3);
				return ret.keySet();
			}
		}.setUnlocalizedName("rexium_hoe").setRegistryName("rexium_hoe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:rexium_hoe", "inventory"));
	}
}
