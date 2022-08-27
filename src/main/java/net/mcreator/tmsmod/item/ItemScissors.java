
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemShears;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class ItemScissors extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:scissors")
	public static final Item block = null;
	public ItemScissors(ElementsTmsModMod instance) {
		super(instance, 845);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemShears() {
			{
				setMaxDamage(100);
			}
			@Override
			public int getItemEnchantability() {
				return 2;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
				return 4f;
			}
		}.setUnlocalizedName("scissors").setRegistryName("scissors").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:scissors", "inventory"));
	}
}
