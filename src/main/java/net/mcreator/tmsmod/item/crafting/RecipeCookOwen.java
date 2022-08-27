
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemRat;
import net.mcreator.tmsmod.item.ItemCookedRat;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeCookOwen extends ElementsTmsModMod.ModElement {
	public RecipeCookOwen(ElementsTmsModMod instance) {
		super(instance, 955);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemRat.block, (int) (1)), new ItemStack(ItemCookedRat.block, (int) (1)), 1F);
	}
}
