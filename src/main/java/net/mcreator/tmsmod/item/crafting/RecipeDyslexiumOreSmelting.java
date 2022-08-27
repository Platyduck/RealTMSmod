
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemDyslexiumIngot;
import net.mcreator.tmsmod.block.BlockDyslexiumOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeDyslexiumOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipeDyslexiumOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1105);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockDyslexiumOre.block, (int) (1)), new ItemStack(ItemDyslexiumIngot.block, (int) (1)), 0.7F);
	}
}
