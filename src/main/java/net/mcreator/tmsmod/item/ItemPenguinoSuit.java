
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
public class ItemPenguinoSuit extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:penguino_suithelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("tms_mod:penguino_suitbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("tms_mod:penguino_suitlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("tms_mod:penguino_suitboots")
	public static final Item boots = null;
	public ItemPenguinoSuit(ElementsTmsModMod instance) {
		super(instance, 159);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("PENGUINO_SUIT", "tms_mod:penguino_layer_1", 40, new int[]{5, 7, 8, 6}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("penguino_suithelmet")
				.setRegistryName("penguino_suithelmet").setCreativeTab(TabDerpysAndSnurbs.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("penguino_suitbody")
				.setRegistryName("penguino_suitbody").setCreativeTab(TabDerpysAndSnurbs.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("penguino_suitlegs")
				.setRegistryName("penguino_suitlegs").setCreativeTab(TabDerpysAndSnurbs.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("penguino_suitboots")
				.setRegistryName("penguino_suitboots").setCreativeTab(TabDerpysAndSnurbs.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("tms_mod:penguino_suithelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("tms_mod:penguino_suitbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("tms_mod:penguino_suitlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("tms_mod:penguino_suitboots", "inventory"));
	}
}
