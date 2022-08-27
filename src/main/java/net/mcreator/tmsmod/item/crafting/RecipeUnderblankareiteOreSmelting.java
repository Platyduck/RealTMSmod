
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemUnderblankareiteIngot;
import net.mcreator.tmsmod.block.BlockUnderblankareiteOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeUnderblankareiteOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipeUnderblankareiteOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1079);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockUnderblankareiteOre.block, (int) (1)), new ItemStack(ItemUnderblankareiteIngot.block, (int) (1)),
				0.7F);
	}
}
