
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemOweniumIngot;
import net.mcreator.tmsmod.block.BlockOwenianGravelOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSmeltOwenGravel extends ElementsTmsModMod.ModElement {
	public RecipeSmeltOwenGravel(ElementsTmsModMod instance) {
		super(instance, 1491);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockOwenianGravelOre.block, (int) (1)), new ItemStack(ItemOweniumIngot.block, (int) (1)), 1F);
	}
}
