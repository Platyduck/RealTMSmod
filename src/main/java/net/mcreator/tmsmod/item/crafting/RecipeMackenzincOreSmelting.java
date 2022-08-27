
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemMackenzincIngot;
import net.mcreator.tmsmod.block.BlockMackenzincOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeMackenzincOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipeMackenzincOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1444);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockMackenzincOre.block, (int) (1)), new ItemStack(ItemMackenzincIngot.block, (int) (1)),
				0.8400000000000001F);
	}
}
