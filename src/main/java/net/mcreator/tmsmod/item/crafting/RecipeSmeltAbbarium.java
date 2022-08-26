
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemAbarium;
import net.mcreator.tmsmod.block.BlockGuildedCrubstone;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSmeltAbbarium extends ElementsTmsModMod.ModElement {
	public RecipeSmeltAbbarium(ElementsTmsModMod instance) {
		super(instance, 1670);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockGuildedCrubstone.block, (int) (1)), new ItemStack(ItemAbarium.block, (int) (1)), 1F);
	}
}
