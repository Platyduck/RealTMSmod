
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemPawkite;
import net.mcreator.tmsmod.block.BlockPawkiteOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipePawkiteOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipePawkiteOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1067);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockPawkiteOre.block, (int) (1)), new ItemStack(ItemPawkite.block, (int) (1)), 1.5399999999999998F);
	}
}
