
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
public class ItemSnurbinianArmor extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:snurbinian_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("tms_mod:snurbinian_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("tms_mod:snurbinian_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("tms_mod:snurbinian_armorboots")
	public static final Item boots = null;
	public ItemSnurbinianArmor(ElementsTmsModMod instance) {
		super(instance, 531);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("SNURBINIAN_ARMOR", "tms_mod:snurbite_", 30, new int[]{4, 8, 10, 4}, 18,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("snurbinian_armorhelmet")
				.setRegistryName("snurbinian_armorhelmet").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("snurbinian_armorbody")
				.setRegistryName("snurbinian_armorbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("snurbinian_armorlegs")
				.setRegistryName("snurbinian_armorlegs").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("snurbinian_armorboots")
				.setRegistryName("snurbinian_armorboots").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("tms_mod:snurbinian_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("tms_mod:snurbinian_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("tms_mod:snurbinian_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("tms_mod:snurbinian_armorboots", "inventory"));
	}
}
