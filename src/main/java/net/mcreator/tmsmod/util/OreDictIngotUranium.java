
package net.mcreator.tmsmod.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemDyslexiumIngot;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class OreDictIngotUranium extends ElementsTmsModMod.ModElement {
	public OreDictIngotUranium(ElementsTmsModMod instance) {
		super(instance, 1504);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("ingot_uranium", new ItemStack(ItemDyslexiumIngot.block, (int) (1)));
	}
}
