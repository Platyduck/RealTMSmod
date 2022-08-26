package net.mcreator.tmsmod.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.tmsmod.entity.EntityWoodenSnurbGolem;
import net.mcreator.tmsmod.entity.EntitySnurbScoutDrone;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureTheLastSnurbaderbEntityIsHurt extends ElementsTmsModMod.ModElement {
	public ProcedureTheLastSnurbaderbEntityIsHurt(ElementsTmsModMod instance) {
		super(instance, 1522);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TheLastSnurbaderbEntityIsHurt!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TheLastSnurbaderbEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TheLastSnurbaderbEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TheLastSnurbaderbEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TheLastSnurbaderbEntityIsHurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) < 200)) {
			if ((Math.random() < 0.5)) {
				if (!world.isRemote) {
					Entity entityToSpawn = new EntitySnurbScoutDrone.EntityCustom(world);
					if (entityToSpawn != null) {
						entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntity(entityToSpawn);
					}
				}
				if ((Math.random() < 0.5)) {
					if (!world.isRemote) {
						Entity entityToSpawn = new EntitySnurbScoutDrone.EntityCustom(world);
						if (entityToSpawn != null) {
							entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
							world.spawnEntity(entityToSpawn);
						}
					}
					if (!world.isRemote) {
						Entity entityToSpawn = new EntitySnurbScoutDrone.EntityCustom(world);
						if (entityToSpawn != null) {
							entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
							world.spawnEntity(entityToSpawn);
						}
					}
				}
				if ((Math.random() < 0.2)) {
					if (!world.isRemote) {
						Entity entityToSpawn = new EntityWoodenSnurbGolem.EntityCustom(world);
						if (entityToSpawn != null) {
							entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
							world.spawnEntity(entityToSpawn);
						}
					}
					if (!world.isRemote) {
						Entity entityToSpawn = new EntityWoodenSnurbGolem.EntityCustom(world);
						if (entityToSpawn != null) {
							entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
							world.spawnEntity(entityToSpawn);
						}
					}
				}
			}
		} else {
			if ((Math.random() < 0.1)) {
				if (!world.isRemote) {
					Entity entityToSpawn = new EntityWoodenSnurbGolem.EntityCustom(world);
					if (entityToSpawn != null) {
						entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntity(entityToSpawn);
					}
				}
				if (!world.isRemote) {
					Entity entityToSpawn = new EntityWoodenSnurbGolem.EntityCustom(world);
					if (entityToSpawn != null) {
						entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
