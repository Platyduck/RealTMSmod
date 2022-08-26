
package net.mcreator.tmsmod.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.tmsmod.item.ItemTheKobeAnimatronic;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class TabDerpysAndSnurbs extends ElementsTmsModMod.ModElement {
	public TabDerpysAndSnurbs(ElementsTmsModMod instance) {
		super(instance, 1261);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabderpys_and_snurbs") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemTheKobeAnimatronic.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
