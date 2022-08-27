
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemNathiniumIngot;
import net.mcreator.tmsmod.block.BlockNathiniumOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeNathiniumOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipeNathiniumOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1047);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockNathiniumOre.block, (int) (1)), new ItemStack(ItemNathiniumIngot.block, (int) (1)), 0.7F);
	}
}
