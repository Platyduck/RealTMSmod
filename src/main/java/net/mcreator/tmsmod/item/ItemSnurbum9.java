
package net.mcreator.tmsmod.item;

import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;

import net.mcreator.tmsmod.world.WorldSnurbum9;
import net.mcreator.tmsmod.creativetab.TabSnurbsStuff;

public class ItemSnurbum9 extends Item {
	@GameRegistry.ObjectHolder("tms_mod:snurbum_9")
	public static final Item block = null;
	public ItemSnurbum9() {
		super();
		this.maxStackSize = 1;
		setMaxDamage(64);
		setCreativeTab(TabSnurbsStuff.tab);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer entity, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY,
			float hitZ) {
		pos = pos.offset(facing);
		ItemStack itemstack = entity.getHeldItem(hand);
		if (!entity.canPlayerEdit(pos, facing, itemstack)) {
			return EnumActionResult.FAIL;
		} else {
			if (world.isAirBlock(pos))
				WorldSnurbum9.portal.portalSpawn(world, pos);
			itemstack.damageItem(1, entity);
			return EnumActionResult.SUCCESS;
		}
	}
}
