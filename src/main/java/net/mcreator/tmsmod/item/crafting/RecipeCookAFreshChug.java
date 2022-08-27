
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemRawChugget;
import net.mcreator.tmsmod.item.ItemCookedChugget;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeCookAFreshChug extends ElementsTmsModMod.ModElement {
	public RecipeCookAFreshChug(ElementsTmsModMod instance) {
		super(instance, 1471);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemRawChugget.block, (int) (1)), new ItemStack(ItemCookedChugget.block, (int) (1)), 1F);
	}
}
