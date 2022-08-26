
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.tmsmod.procedure.ProcedureRedPlasticBerriesFoodEaten;
import net.mcreator.tmsmod.creativetab.TabPlaticWorld;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;
import java.util.HashMap;

@ElementsTmsModMod.ModElement.Tag
public class ItemRedPlasticBerries extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:red_plastic_berries")
	public static final Item block = null;
	public ItemRedPlasticBerries(ElementsTmsModMod instance) {
		super(instance, 466);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:red_plastic_berries", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(1, 1f, false);
			setUnlocalizedName("red_plastic_berries");
			setRegistryName("red_plastic_berries");
			setCreativeTab(TabPlaticWorld.tab);
			setMaxStackSize(64);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

		@Override
		protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity) {
			super.onFoodEaten(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureRedPlasticBerriesFoodEaten.executeProcedure($_dependencies);
			}
		}
	}
}
