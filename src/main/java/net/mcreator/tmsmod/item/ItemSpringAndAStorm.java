
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.tmsmod.creativetab.TabSnurbsStuff;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.List;

@ElementsTmsModMod.ModElement.Tag
public class ItemSpringAndAStorm extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:spring_and_a_storm")
	public static final Item block = null;
	public ItemSpringAndAStorm(ElementsTmsModMod instance) {
		super(instance, 63);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:spring_and_a_storm", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("spring_and_a_storm", ElementsTmsModMod.sounds.get(new ResourceLocation("tms_mod:springandastorm")));
			setUnlocalizedName("spring_and_a_storm");
			setRegistryName("spring_and_a_storm");
			setCreativeTab(TabSnurbsStuff.tab);
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add("8 Bit Version");
		}
	}
}
