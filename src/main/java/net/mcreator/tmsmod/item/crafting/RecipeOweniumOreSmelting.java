
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemOweniumIngot;
import net.mcreator.tmsmod.block.BlockOweniumOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeOweniumOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipeOweniumOreSmelting(ElementsTmsModMod instance) {
		super(instance, 996);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockOweniumOre.block, (int) (1)), new ItemStack(ItemOweniumIngot.block, (int) (1)),
				0.5599999999999999F);
	}
}
