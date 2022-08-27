
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class ItemCookedPurpleMutton extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:cooked_purple_mutton")
	public static final Item block = null;
	public ItemCookedPurpleMutton(ElementsTmsModMod instance) {
		super(instance, 598);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:cooked_purple_mutton", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(7, 0.7000000000000001f, false);
			setUnlocalizedName("cooked_purple_mutton");
			setRegistryName("cooked_purple_mutton");
			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}
	}
}