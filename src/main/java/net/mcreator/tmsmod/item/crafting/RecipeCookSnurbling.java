
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemRawSnurb;
import net.mcreator.tmsmod.item.ItemCookedSnurb;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeCookSnurbling extends ElementsTmsModMod.ModElement {
	public RecipeCookSnurbling(ElementsTmsModMod instance) {
		super(instance, 1426);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemRawSnurb.block, (int) (1)), new ItemStack(ItemCookedSnurb.block, (int) (1)), 1F);
	}
}
