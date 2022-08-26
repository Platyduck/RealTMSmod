
package net.mcreator.tmsmod.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.tmsmod.item.ItemTheBirdyTwizzler;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class TabTraditionalWeaponry extends ElementsTmsModMod.ModElement {
	public TabTraditionalWeaponry(ElementsTmsModMod instance) {
		super(instance, 1631);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabtraditional_weaponry") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemTheBirdyTwizzler.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
