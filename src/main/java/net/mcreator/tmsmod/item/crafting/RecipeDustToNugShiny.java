
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemShinyNugget;
import net.mcreator.tmsmod.item.ItemShinyDust;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeDustToNugShiny extends ElementsTmsModMod.ModElement {
	public RecipeDustToNugShiny(ElementsTmsModMod instance) {
		super(instance, 1510);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemShinyDust.block, (int) (1)), new ItemStack(ItemShinyNugget.block, (int) (1)), 1F);
	}
}
