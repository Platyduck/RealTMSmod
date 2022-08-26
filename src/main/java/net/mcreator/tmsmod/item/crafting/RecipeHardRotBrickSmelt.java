
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.block.BlockRotBrick;
import net.mcreator.tmsmod.block.BlockHardRot;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeHardRotBrickSmelt extends ElementsTmsModMod.ModElement {
	public RecipeHardRotBrickSmelt(ElementsTmsModMod instance) {
		super(instance, 1469);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockHardRot.block, (int) (1)), new ItemStack(BlockRotBrick.block, (int) (1)), 1F);
	}
}
