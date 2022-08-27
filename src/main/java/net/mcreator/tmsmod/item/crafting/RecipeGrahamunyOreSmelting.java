
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemGrahamunyIngot;
import net.mcreator.tmsmod.block.BlockGrahamunyOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeGrahamunyOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipeGrahamunyOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1030);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockGrahamunyOre.block, (int) (1)), new ItemStack(ItemGrahamunyIngot.block, (int) (1)),
				0.8400000000000001F);
	}
}
