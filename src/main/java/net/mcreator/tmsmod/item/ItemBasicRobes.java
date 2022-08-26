
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
public class ItemBasicRobes extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:basic_robeshelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("tms_mod:basic_robesbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("tms_mod:basic_robeslegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("tms_mod:basic_robesboots")
	public static final Item boots = null;
	public ItemBasicRobes(ElementsTmsModMod instance) {
		super(instance, 538);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("BASIC_ROBES", "tms_mod:robes_layer_1", 0, new int[]{0, 0, 0, 0}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("basic_robesbody")
				.setRegistryName("basic_robesbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("basic_robeslegs")
				.setRegistryName("basic_robeslegs").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("tms_mod:basic_robesbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("tms_mod:basic_robeslegs", "inventory"));
	}
}
