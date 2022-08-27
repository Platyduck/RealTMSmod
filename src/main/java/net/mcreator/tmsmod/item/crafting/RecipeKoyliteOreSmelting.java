
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemKoyliteIngot;
import net.mcreator.tmsmod.block.BlockKoyliteOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeKoyliteOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipeKoyliteOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1480);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockKoyliteOre.block, (int) (1)), new ItemStack(ItemKoyliteIngot.block, (int) (1)), 0.84F);
	}
}
