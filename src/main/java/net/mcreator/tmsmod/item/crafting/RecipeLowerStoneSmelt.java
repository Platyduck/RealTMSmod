
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.block.BlockLowerStone;
import net.mcreator.tmsmod.block.BlockLowerCobble;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeLowerStoneSmelt extends ElementsTmsModMod.ModElement {
	public RecipeLowerStoneSmelt(ElementsTmsModMod instance) {
		super(instance, 1445);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockLowerCobble.block, (int) (1)), new ItemStack(BlockLowerStone.block, (int) (1)), 1F);
	}
}
