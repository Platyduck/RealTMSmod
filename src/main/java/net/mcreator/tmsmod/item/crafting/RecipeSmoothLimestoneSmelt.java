
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.block.BlockSmoothLimestone;
import net.mcreator.tmsmod.block.BlockLimestone;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSmoothLimestoneSmelt extends ElementsTmsModMod.ModElement {
	public RecipeSmoothLimestoneSmelt(ElementsTmsModMod instance) {
		super(instance, 1493);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockLimestone.block, (int) (1)), new ItemStack(BlockSmoothLimestone.block, (int) (1)), 1F);
	}
}
