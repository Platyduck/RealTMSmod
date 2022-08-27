
package net.mcreator.tmsmod.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.block.BlockKrinkelWood;
import net.mcreator.tmsmod.block.BlockKrinkelLog;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class OreDictKrinkelItemsTag extends ElementsTmsModMod.ModElement {
	public OreDictKrinkelItemsTag(ElementsTmsModMod instance) {
		super(instance, 961);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("krinkel_log", new ItemStack(BlockKrinkelWood.block, (int) (1)));
		OreDictionary.registerOre("krinkel_log", new ItemStack(BlockKrinkelLog.block, (int) (1)));
	}
}
