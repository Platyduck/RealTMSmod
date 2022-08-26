
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.tmsmod.procedure.ProcedureOweniumSwordLivingEntityIsHitWithTool;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

@ElementsTmsModMod.ModElement.Tag
public class ItemOweniumPickaxe extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:owenium_pickaxe")
	public static final Item block = null;
	public ItemOweniumPickaxe(ElementsTmsModMod instance) {
		super(instance, 740);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("OWENIUM_PICKAXE", 2, 183, 5f, -2f, 11)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 2);
				return ret.keySet();
			}

			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, IBlockState bl, BlockPos pos, EntityLivingBase entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, bl, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureOweniumSwordLivingEntityIsHitWithTool.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setUnlocalizedName("owenium_pickaxe").setRegistryName("owenium_pickaxe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:owenium_pickaxe", "inventory"));
	}
}
