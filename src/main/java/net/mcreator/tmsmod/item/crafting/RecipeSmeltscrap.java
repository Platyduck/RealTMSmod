
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemNetheriteScrap;
import net.mcreator.tmsmod.block.BlockAncientDebris;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSmeltscrap extends ElementsTmsModMod.ModElement {
	public RecipeSmeltscrap(ElementsTmsModMod instance) {
		super(instance, 1207);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockAncientDebris.block, (int) (1)), new ItemStack(ItemNetheriteScrap.block, (int) (1)), 1F);
	}
}
