
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemSnurbiteNugget;
import net.mcreator.tmsmod.item.ItemSnurbiteDust;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeDustToNugSnurbite extends ElementsTmsModMod.ModElement {
	public RecipeDustToNugSnurbite(ElementsTmsModMod instance) {
		super(instance, 1511);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemSnurbiteDust.block, (int) (1)), new ItemStack(ItemSnurbiteNugget.block, (int) (1)), 1F);
	}
}
