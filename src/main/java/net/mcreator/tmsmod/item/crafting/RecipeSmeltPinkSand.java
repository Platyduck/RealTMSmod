
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;

import net.mcreator.tmsmod.block.BlockPinkSand;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSmeltPinkSand extends ElementsTmsModMod.ModElement {
	public RecipeSmeltPinkSand(ElementsTmsModMod instance) {
		super(instance, 1481);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockPinkSand.block, (int) (1)), new ItemStack(Blocks.STAINED_GLASS, (int) (1), 6), 1F);
	}
}
