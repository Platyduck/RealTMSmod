
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemUnrefinedUnderblankareite;
import net.mcreator.tmsmod.item.ItemUnderblankareiteIngot;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSmeltUnrefinedUnderblanket extends ElementsTmsModMod.ModElement {
	public RecipeSmeltUnrefinedUnderblanket(ElementsTmsModMod instance) {
		super(instance, 1294);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemUnrefinedUnderblankareite.block, (int) (1)),
				new ItemStack(ItemUnderblankareiteIngot.block, (int) (1)), 1F);
	}
}
