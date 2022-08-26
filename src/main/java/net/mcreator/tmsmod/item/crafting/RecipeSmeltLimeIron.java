
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.tmsmod.block.BlockIronLimestone;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSmeltLimeIron extends ElementsTmsModMod.ModElement {
	public RecipeSmeltLimeIron(ElementsTmsModMod instance) {
		super(instance, 889);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockIronLimestone.block, (int) (1)), new ItemStack(Items.IRON_INGOT, (int) (1)), 1F);
	}
}
