
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
public class ItemDyslexiumArmor extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:dyslexium_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("tms_mod:dyslexium_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("tms_mod:dyslexium_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("tms_mod:dyslexium_armorboots")
	public static final Item boots = null;
	public ItemDyslexiumArmor(ElementsTmsModMod instance) {
		super(instance, 523);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("DYSLEXIUM_ARMOR", "tms_mod:dyslexium", 15, new int[]{2, 6, 5, 2}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("dyslexium_armorhelmet")
				.setRegistryName("dyslexium_armorhelmet").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("dyslexium_armorbody")
				.setRegistryName("dyslexium_armorbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("dyslexium_armorlegs")
				.setRegistryName("dyslexium_armorlegs").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("dyslexium_armorboots")
				.setRegistryName("dyslexium_armorboots").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("tms_mod:dyslexium_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("tms_mod:dyslexium_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("tms_mod:dyslexium_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("tms_mod:dyslexium_armorboots", "inventory"));
	}
}
