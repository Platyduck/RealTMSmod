
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemRawBoi;
import net.mcreator.tmsmod.item.ItemCookedBoi;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeCookTheBoi extends ElementsTmsModMod.ModElement {
	public RecipeCookTheBoi(ElementsTmsModMod instance) {
		super(instance, 1402);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemRawBoi.block, (int) (1)), new ItemStack(ItemCookedBoi.block, (int) (1)), 1F);
	}
}
