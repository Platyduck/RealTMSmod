package net.mcreator.tmsmod.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.tmsmod.entity.EntityFrendlyCrosco;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureNyanGunBulletHitsLivingEntity extends ElementsTmsModMod.ModElement {
	public ProcedureNyanGunBulletHitsLivingEntity(ElementsTmsModMod instance) {
		super(instance, 1131);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NyanGunBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NyanGunBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NyanGunBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NyanGunBulletHitsLivingEntity!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((Math.random() < 0.85)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityFrendlyCrosco.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, (y + 3), z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
		}
	}
}
