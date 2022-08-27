
package net.mcreator.tmsmod.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.tmsmod.item.ItemKillBoars61;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class TabKillBoars extends ElementsTmsModMod.ModElement {
	public TabKillBoars(ElementsTmsModMod instance) {
		super(instance, 1222);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabkill_boars") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemKillBoars61.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
