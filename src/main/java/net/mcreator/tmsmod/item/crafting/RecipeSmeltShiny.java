
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemShinyIngot;
import net.mcreator.tmsmod.block.BlockBlueslateShinyOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSmeltShiny extends ElementsTmsModMod.ModElement {
	public RecipeSmeltShiny(ElementsTmsModMod instance) {
		super(instance, 1321);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockBlueslateShinyOre.block, (int) (1)), new ItemStack(ItemShinyIngot.block, (int) (1)), 1F);
	}
}
