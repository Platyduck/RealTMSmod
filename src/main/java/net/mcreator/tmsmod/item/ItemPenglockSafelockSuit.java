
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
public class ItemPenglockSafelockSuit extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:penglock_safelock_suithelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("tms_mod:penglock_safelock_suitbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("tms_mod:penglock_safelock_suitlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("tms_mod:penglock_safelock_suitboots")
	public static final Item boots = null;
	public ItemPenglockSafelockSuit(ElementsTmsModMod instance) {
		super(instance, 158);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("PENGLOCK_SAFELOCK_SUIT", "tms_mod:penglock_layer_1", 25, new int[]{5, 10, 12, 7},
				9, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0.5f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("penglock_safelock_suithelmet")
				.setRegistryName("penglock_safelock_suithelmet").setCreativeTab(TabDerpysAndSnurbs.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("penglock_safelock_suitbody")
				.setRegistryName("penglock_safelock_suitbody").setCreativeTab(TabDerpysAndSnurbs.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("penglock_safelock_suitlegs")
				.setRegistryName("penglock_safelock_suitlegs").setCreativeTab(TabDerpysAndSnurbs.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("penglock_safelock_suitboots")
				.setRegistryName("penglock_safelock_suitboots").setCreativeTab(TabDerpysAndSnurbs.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("tms_mod:penglock_safelock_suithelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("tms_mod:penglock_safelock_suitbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("tms_mod:penglock_safelock_suitlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("tms_mod:penglock_safelock_suitboots", "inventory"));
	}
}
