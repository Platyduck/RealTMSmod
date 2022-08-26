
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemRawBird;
import net.mcreator.tmsmod.item.ItemCookedBird;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeCookbird extends ElementsTmsModMod.ModElement {
	public RecipeCookbird(ElementsTmsModMod instance) {
		super(instance, 1297);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemRawBird.block, (int) (1)), new ItemStack(ItemCookedBird.block, (int) (1)), 1F);
	}
}
