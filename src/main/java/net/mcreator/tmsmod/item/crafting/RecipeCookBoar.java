
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemRawBoar;
import net.mcreator.tmsmod.item.ItemCookedBoar;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeCookBoar extends ElementsTmsModMod.ModElement {
	public RecipeCookBoar(ElementsTmsModMod instance) {
		super(instance, 1347);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemRawBoar.block, (int) (1)), new ItemStack(ItemCookedBoar.block, (int) (1)), 1F);
	}
}
