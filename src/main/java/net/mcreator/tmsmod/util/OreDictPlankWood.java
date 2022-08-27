
package net.mcreator.tmsmod.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.block.BlockSquinkelPlanks;
import net.mcreator.tmsmod.block.BlockRyanwoodPlanks;
import net.mcreator.tmsmod.block.BlockLowerPlanks;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class OreDictPlankWood extends ElementsTmsModMod.ModElement {
	public OreDictPlankWood(ElementsTmsModMod instance) {
		super(instance, 1505);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("plank_wood", new ItemStack(BlockLowerPlanks.block, (int) (1)));
		OreDictionary.registerOre("plank_wood", new ItemStack(BlockSquinkelPlanks.block, (int) (1)));
		OreDictionary.registerOre("plank_wood", new ItemStack(BlockRyanwoodPlanks.block, (int) (1)));
	}
}
