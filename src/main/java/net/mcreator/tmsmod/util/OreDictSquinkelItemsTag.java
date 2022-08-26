
package net.mcreator.tmsmod.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.block.BlockSquinkelWood;
import net.mcreator.tmsmod.block.BlockSquinkelLog;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class OreDictSquinkelItemsTag extends ElementsTmsModMod.ModElement {
	public OreDictSquinkelItemsTag(ElementsTmsModMod instance) {
		super(instance, 968);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("squinkel_log", new ItemStack(BlockSquinkelWood.block, (int) (1)));
		OreDictionary.registerOre("squinkel_log", new ItemStack(BlockSquinkelLog.block, (int) (1)));
	}
}
