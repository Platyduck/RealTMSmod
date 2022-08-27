
package net.mcreator.tmsmod.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.tmsmod.item.ItemRotParticles;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class TabDirtyBirdy extends ElementsTmsModMod.ModElement {
	public TabDirtyBirdy(ElementsTmsModMod instance) {
		super(instance, 945);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabdirty_birdy") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemRotParticles.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
