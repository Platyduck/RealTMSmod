
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

import net.mcreator.tmsmod.world.WorldKobePlanetMoon15;
import net.mcreator.tmsmod.creativetab.TabUnitedPlanets;

public class ItemKobePlanetMoon15 extends Item {
	@GameRegistry.ObjectHolder("tms_mod:kobe_planet_moon_15")
	public static final Item block = null;
	public ItemKobePlanetMoon15() {
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
				WorldKobePlanetMoon15.portal.portalSpawn(world, pos);
			itemstack.damageItem(1, entity);
			return EnumActionResult.SUCCESS;
		}
	}
}
