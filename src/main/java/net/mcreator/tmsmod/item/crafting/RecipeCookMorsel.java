
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemRawMorsel;
import net.mcreator.tmsmod.item.ItemCookedMorsel;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeCookMorsel extends ElementsTmsModMod.ModElement {
	public RecipeCookMorsel(ElementsTmsModMod instance) {
		super(instance, 1348);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemRawMorsel.block, (int) (1)), new ItemStack(ItemCookedMorsel.block, (int) (1)), 1F);
	}
}
