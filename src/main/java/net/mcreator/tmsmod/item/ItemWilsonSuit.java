
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
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.tmsmod.creativetab.TabDerpysAndSnurbs;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class ItemWilsonSuit extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:wilson_suithelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("tms_mod:wilson_suitbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("tms_mod:wilson_suitlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("tms_mod:wilson_suitboots")
	public static final Item boots = null;
	public ItemWilsonSuit(ElementsTmsModMod instance) {
		super(instance, 160);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("WILSON_SUIT", "tms_mod:wilson_layer_1", 40, new int[]{6, 8, 9, 7}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("wilson_suithelmet")
				.setRegistryName("wilson_suithelmet").setCreativeTab(TabDerpysAndSnurbs.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("wilson_suitbody")
				.setRegistryName("wilson_suitbody").setCreativeTab(TabDerpysAndSnurbs.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("wilson_suitlegs")
				.setRegistryName("wilson_suitlegs").setCreativeTab(TabDerpysAndSnurbs.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("wilson_suitboots")
				.setRegistryName("wilson_suitboots").setCreativeTab(TabDerpysAndSnurbs.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("tms_mod:wilson_suithelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("tms_mod:wilson_suitbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("tms_mod:wilson_suitlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("tms_mod:wilson_suitboots", "inventory"));
	}
}
