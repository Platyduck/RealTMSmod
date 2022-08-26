
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.tmsmod.procedure.ProcedurePawkiteArmorBodyTickEvent;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;
import java.util.HashMap;

@ElementsTmsModMod.ModElement.Tag
public class ItemPawkiteArmor extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:pawkite_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("tms_mod:pawkite_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("tms_mod:pawkite_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("tms_mod:pawkite_armorboots")
	public static final Item boots = null;
	public ItemPawkiteArmor(ElementsTmsModMod instance) {
		super(instance, 518);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("PAWKITE_ARMOR", "tms_mod:pawkite_", 33, new int[]{4, 10, 11, 4}, 20,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("pawkite_armorhelmet")
				.setRegistryName("pawkite_armorhelmet").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedurePawkiteArmorBodyTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("pawkite_armorbody").setRegistryName("pawkite_armorbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("pawkite_armorlegs")
				.setRegistryName("pawkite_armorlegs").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("pawkite_armorboots")
				.setRegistryName("pawkite_armorboots").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("tms_mod:pawkite_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("tms_mod:pawkite_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("tms_mod:pawkite_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("tms_mod:pawkite_armorboots", "inventory"));
	}
}
