
package net.mcreator.tmsmod.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.block.BlockOvergrownLog;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class OreDictOvergrownItemsTag extends ElementsTmsModMod.ModElement {
	public OreDictOvergrownItemsTag(ElementsTmsModMod instance) {
		super(instance, 1121);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("overgrown_log", new ItemStack(BlockOvergrownLog.block, (int) (1)));
	}
}
