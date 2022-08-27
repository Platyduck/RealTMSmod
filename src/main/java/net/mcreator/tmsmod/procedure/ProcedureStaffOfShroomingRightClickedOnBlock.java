package net.mcreator.tmsmod.procedure;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.tmsmod.entity.EntityPuffShroom;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Random;
import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureStaffOfShroomingRightClickedOnBlock extends ElementsTmsModMod.ModElement {
	public ProcedureStaffOfShroomingRightClickedOnBlock(ElementsTmsModMod instance) {
		super(instance, 1191);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure StaffOfShroomingRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure StaffOfShroomingRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure StaffOfShroomingRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure StaffOfShroomingRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure StaffOfShroomingRightClickedOnBlock!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Entity entityToSpawn = new EntityPuffShroom.EntityCustom(world);
			if (entityToSpawn != null) {
				entityToSpawn.setLocationAndAngles(x, (y + 3), z, world.rand.nextFloat() * 360F, 0.0F);
				world.spawnEntity(entityToSpawn);
			}
		}
		{
			ItemStack _ist = (itemstack);
			if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setItemDamage(0);
			}
		}
	}
}
