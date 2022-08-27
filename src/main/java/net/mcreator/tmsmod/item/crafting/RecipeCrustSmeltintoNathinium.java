
package net.mcreator.tmsmod.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.tmsmod.item.ItemNathiniumIngot;
import net.mcreator.tmsmod.block.BlockNathiniumCrust;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class RecipeCrustSmeltintoNathinium extends ElementsTmsModMod.ModElement {
	public RecipeCrustSmeltintoNathinium(ElementsTmsModMod instance) {
		super(instance, 1234);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockNathiniumCrust.block, (int) (1)), new ItemStack(ItemNathiniumIngot.block, (int) (1)), 1F);
	}
}
