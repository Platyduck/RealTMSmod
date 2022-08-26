
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemSansDogeiumIngot;
import net.mcreator.tmsmod.block.BlockSansDogeiumOre;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeSansDogeiumOreSmelting extends ElementsTmsModMod.ModElement {
	public RecipeSansDogeiumOreSmelting(ElementsTmsModMod instance) {
		super(instance, 1330);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockSansDogeiumOre.block, (int) (1)), new ItemStack(ItemSansDogeiumIngot.block, (int) (1)), 3.5F);
	}
}
