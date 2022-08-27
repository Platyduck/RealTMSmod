
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Set;
import java.util.HashMap;

@ElementsTmsModMod.ModElement.Tag
public class ItemUnitedSteelPickaxe extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:united_steel_pickaxe")
	public static final Item block = null;
	public ItemUnitedSteelPickaxe(ElementsTmsModMod instance) {
		super(instance, 821);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("UNITED_STEEL_PICKAXE", 7, 1500, 13f, 3f, 49)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 7);
				return ret.keySet();
			}
		}.setUnlocalizedName("united_steel_pickaxe").setRegistryName("united_steel_pickaxe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:united_steel_pickaxe", "inventory"));
	}
}
