
package net.mcreator.tmsmod.fuel;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemPlasticoal;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class FuelPlasticCoal extends ElementsTmsModMod.ModElement {
	public FuelPlasticCoal(ElementsTmsModMod instance) {
		super(instance, 1248);
	}

	@Override
	public int addFuel(ItemStack fuel) {
		if (fuel.getItem() == new ItemStack(ItemPlasticoal.block, (int) (1)).getItem())
			return 1600;
		return 0;
	}
}
