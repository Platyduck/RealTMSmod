
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class ItemUnitedSteelArmor extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:united_steel_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("tms_mod:united_steel_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("tms_mod:united_steel_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("tms_mod:united_steel_armorboots")
	public static final Item boots = null;
	public ItemUnitedSteelArmor(ElementsTmsModMod instance) {
		super(instance, 534);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("UNITED_STEEL_ARMOR", "tms_mod:unitedsteel", 53, new int[]{7, 21, 18, 7}, 32,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("united_steel_armorhelmet")
				.setRegistryName("united_steel_armorhelmet").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("united_steel_armorbody")
				.setRegistryName("united_steel_armorbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("united_steel_armorlegs")
				.setRegistryName("united_steel_armorlegs").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("united_steel_armorboots")
				.setRegistryName("united_steel_armorboots").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("tms_mod:united_steel_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("tms_mod:united_steel_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("tms_mod:united_steel_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("tms_mod:united_steel_armorboots", "inventory"));
	}
}
