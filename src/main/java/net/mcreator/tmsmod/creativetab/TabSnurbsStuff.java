
package net.mcreator.tmsmod.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.tmsmod.item.ItemSnurbite;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class TabSnurbsStuff extends ElementsTmsModMod.ModElement {
	public TabSnurbsStuff(ElementsTmsModMod instance) {
		super(instance, 940);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabsnurbs_stuff") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemSnurbite.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
