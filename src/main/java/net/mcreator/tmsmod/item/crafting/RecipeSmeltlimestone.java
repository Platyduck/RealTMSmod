
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.block.BlockLimestone;
import net.mcreator.tmsmod.block.BlockCobbledLimestone;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSmeltlimestone extends ElementsTmsModMod.ModElement {
	public RecipeSmeltlimestone(ElementsTmsModMod instance) {
		super(instance, 885);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockCobbledLimestone.block, (int) (1)), new ItemStack(BlockLimestone.block, (int) (1)), 1F);
	}
}
