
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

import net.mcreator.tmsmod.procedure.ProcedureRawDirtyBirdyFoodEaten;
import net.mcreator.tmsmod.creativetab.TabDirtyBirdy;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;
import java.util.HashMap;

@ElementsTmsModMod.ModElement.Tag
public class ItemRawDirtyBirdy extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:raw_dirty_birdy")
	public static final Item block = null;
	public ItemRawDirtyBirdy(ElementsTmsModMod instance) {
		super(instance, 718);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:raw_dirty_birdy", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(3, 0.2f, true);
			setUnlocalizedName("raw_dirty_birdy");
			setRegistryName("raw_dirty_birdy");
			setAlwaysEdible();
			setCreativeTab(TabDirtyBirdy.tab);
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
				ProcedureRawDirtyBirdyFoodEaten.executeProcedure($_dependencies);
			}
		}
	}
}
