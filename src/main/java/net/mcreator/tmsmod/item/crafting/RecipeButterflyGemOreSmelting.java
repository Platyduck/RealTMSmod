
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemButterflyGem;
import net.mcreator.tmsmod.block.BlockButterflyGemOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeButterflyGemOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipeButterflyGemOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1131);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockButterflyGemOre.block, (int) (1)), new ItemStack(ItemButterflyGem.block, (int) (1)), 0.7F);
	}
}
