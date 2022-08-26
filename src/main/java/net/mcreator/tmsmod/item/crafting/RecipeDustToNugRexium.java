
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemRexiumNugget;
import net.mcreator.tmsmod.item.ItemRexiumDust;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeDustToNugRexium extends ElementsTmsModMod.ModElement {
	public RecipeDustToNugRexium(ElementsTmsModMod instance) {
		super(instance, 1656);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemRexiumDust.block, (int) (1)), new ItemStack(ItemRexiumNugget.block, (int) (1)), 1F);
	}
}
