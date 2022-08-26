
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Blocks;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.tmsmod.creativetab.TabTraditionalWeaponry;
import net.mcreator.tmsmod.block.BlockTarget;
import net.mcreator.tmsmod.block.BlockMoss;
import net.mcreator.tmsmod.ElementsTmsModMod;

import com.google.common.collect.Multimap;

@ElementsTmsModMod.ModElement.Tag
public class ItemSnurbumScythe extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:snurbum_scythe")
	public static final Item block = null;
	public ItemSnurbumScythe(ElementsTmsModMod instance) {
		super(instance, 797);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
		}.setUnlocalizedName("snurbum_scythe").setRegistryName("snurbum_scythe").setCreativeTab(TabTraditionalWeaponry.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("tms_mod:snurbum_scythe", "inventory"));
	}
	private static class ItemToolCustom extends Item {
		protected ItemToolCustom() {
			setMaxDamage(444);
			setMaxStackSize(1);
		}

		@Override
		public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
			Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
			if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", 5f, 0));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", 40, 0));
			}
			return multimap;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			IBlockState require;
			require = Blocks.HAY_BLOCK.getDefaultState();
			if (par2Block.getBlock() == require.getBlock())
				return 4f;
			require = Blocks.NETHER_WART_BLOCK.getDefaultState();
			if (par2Block.getBlock() == require.getBlock())
				return 4f;
			require = Blocks.LEAVES.getDefaultState();
			if (par2Block.getBlock() == require.getBlock())
				return 4f;
			require = BlockTarget.block.getDefaultState();
			if (par2Block.getBlock() == require.getBlock())
				return 4f;
			require = BlockMoss.block.getDefaultState();
			if (par2Block.getBlock() == require.getBlock())
				return 4f;
			return 0;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
			stack.damageItem(1, entityLiving);
			return true;
		}

		@Override
		public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
			stack.damageItem(2, attacker);
			return true;
		}

		@Override
		public boolean isFull3D() {
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 2;
		}
	}
}
