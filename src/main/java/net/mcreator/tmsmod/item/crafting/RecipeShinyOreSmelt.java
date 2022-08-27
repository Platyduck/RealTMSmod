
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemShinyIngot;
import net.mcreator.tmsmod.block.BlockShinyOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeShinyOreSmelt extends ElementsTmsModMod.ModElement {
	public RecipeShinyOreSmelt(ElementsTmsModMod instance) {
		super(instance, 1171);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockShinyOre.block, (int) (1)), new ItemStack(ItemShinyIngot.block, (int) (1)), 1F);
	}
}
