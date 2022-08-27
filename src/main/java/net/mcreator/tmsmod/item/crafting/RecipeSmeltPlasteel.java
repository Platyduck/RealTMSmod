
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemPlasteelIngot;
import net.mcreator.tmsmod.block.BlockPlasteelOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSmeltPlasteel extends ElementsTmsModMod.ModElement {
	public RecipeSmeltPlasteel(ElementsTmsModMod instance) {
		super(instance, 1292);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockPlasteelOre.block, (int) (1)), new ItemStack(ItemPlasteelIngot.block, (int) (1)), 1F);
	}
}
