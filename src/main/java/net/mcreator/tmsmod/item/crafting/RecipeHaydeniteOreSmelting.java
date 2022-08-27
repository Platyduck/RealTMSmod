
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemHaydeniteIngot;
import net.mcreator.tmsmod.block.BlockHaydeniteOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeHaydeniteOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipeHaydeniteOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1437);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockHaydeniteOre.block, (int) (1)), new ItemStack(ItemHaydeniteIngot.block, (int) (1)), 0.98F);
	}
}
