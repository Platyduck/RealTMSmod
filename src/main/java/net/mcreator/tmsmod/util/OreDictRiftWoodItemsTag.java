
package net.mcreator.tmsmod.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.block.BlockRiftWoodWood;
import net.mcreator.tmsmod.block.BlockRiftWoodLog;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class OreDictRiftWoodItemsTag extends ElementsTmsModMod.ModElement {
	public OreDictRiftWoodItemsTag(ElementsTmsModMod instance) {
		super(instance, 1012);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("riftwood_log", new ItemStack(BlockRiftWoodWood.block, (int) (1)));
		OreDictionary.registerOre("riftwood_log", new ItemStack(BlockRiftWoodLog.block, (int) (1)));
	}
}
