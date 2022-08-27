
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemRexiumIngot;
import net.mcreator.tmsmod.block.BlockRexiumOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeRexiumOreSmelt extends ElementsTmsModMod.ModElement {
	public RecipeRexiumOreSmelt(ElementsTmsModMod instance) {
		super(instance, 1170);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockRexiumOre.block, (int) (1)), new ItemStack(ItemRexiumIngot.block, (int) (1)), 1F);
	}
}
