
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemColtiniumDust;
import net.mcreator.tmsmod.block.BlockColtiniumOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeColtiniumOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipeColtiniumOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1061);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockColtiniumOre.block, (int) (1)), new ItemStack(ItemColtiniumDust.block, (int) (1)),
				0.5599999999999999F);
	}
}
