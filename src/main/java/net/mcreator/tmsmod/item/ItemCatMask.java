
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

import net.mcreator.tmsmod.creativetab.TabTMSmod;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class ItemCatMask extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:cat_maskhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("tms_mod:cat_maskbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("tms_mod:cat_masklegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("tms_mod:cat_maskboots")
	public static final Item boots = null;
	public ItemCatMask(ElementsTmsModMod instance) {
		super(instance, 1670);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("CAT_MASK", "tms_mod:catmasklayer_1", 25, new int[]{2, 5, 6, 2}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("cat_maskhelmet")
				.setRegistryName("cat_maskhelmet").setCreativeTab(TabTMSmod.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("tms_mod:cat_maskhelmet", "inventory"));
	}
}
