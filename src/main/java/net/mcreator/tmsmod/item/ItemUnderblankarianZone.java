
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

import net.mcreator.tmsmod.world.WorldUnderblankarianZone;
import net.mcreator.tmsmod.procedure.ProcedureUnderblankarianZonePortalTriggerUsed;
import net.mcreator.tmsmod.creativetab.TabUnitedPlanets;

import java.util.Map;
import java.util.HashMap;

public class ItemUnderblankarianZone extends Item {
	@GameRegistry.ObjectHolder("tms_mod:underblankarian_zone")
	public static final Item block = null;
	public ItemUnderblankarianZone() {
		super();
		this.maxStackSize = 1;
		setMaxDamage(64);
		setCreativeTab(TabUnitedPlanets.tab);
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
				WorldUnderblankarianZone.portal.portalSpawn(world, pos);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureUnderblankarianZonePortalTriggerUsed.executeProcedure($_dependencies);
			}
			itemstack.damageItem(1, entity);
			return EnumActionResult.SUCCESS;
		}
	}
}
