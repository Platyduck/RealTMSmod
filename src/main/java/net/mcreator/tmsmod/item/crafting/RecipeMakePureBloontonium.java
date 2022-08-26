
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemRawBloontonium;
import net.mcreator.tmsmod.item.ItemBloontonium;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeMakePureBloontonium extends ElementsTmsModMod.ModElement {
	public RecipeMakePureBloontonium(ElementsTmsModMod instance) {
		super(instance, 1514);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemRawBloontonium.block, (int) (1)), new ItemStack(ItemBloontonium.block, (int) (1)), 1F);
	}
}
