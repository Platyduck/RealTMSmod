
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemOzmireIngot;
import net.mcreator.tmsmod.block.BlockOzmireOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSmeltOzmire extends ElementsTmsModMod.ModElement {
	public RecipeSmeltOzmire(ElementsTmsModMod instance) {
		super(instance, 1614);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockOzmireOre.block, (int) (1)), new ItemStack(ItemOzmireIngot.block, (int) (1)), 1F);
	}
}
