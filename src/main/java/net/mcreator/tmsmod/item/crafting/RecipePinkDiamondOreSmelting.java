
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemPinkDiamond;
import net.mcreator.tmsmod.block.BlockPinkDiamondOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipePinkDiamondOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipePinkDiamondOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1198);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockPinkDiamondOre.block, (int) (1)), new ItemStack(ItemPinkDiamond.block, (int) (1)),
				1.0499999999999998F);
	}
}
