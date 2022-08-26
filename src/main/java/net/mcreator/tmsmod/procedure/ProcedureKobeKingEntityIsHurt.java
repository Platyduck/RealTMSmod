package net.mcreator.tmsmod.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.tmsmod.entity.EntityKobeGuard;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureKobeKingEntityIsHurt extends ElementsTmsModMod.ModElement {
	public ProcedureKobeKingEntityIsHurt(ElementsTmsModMod instance) {
		super(instance, 1494);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure KobeKingEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure KobeKingEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure KobeKingEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure KobeKingEntityIsHurt!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((Math.random() < 0.7)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityKobeGuard.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			if ((Math.random() < 0.5)) {
				if (!world.isRemote) {
					Entity entityToSpawn = new EntityKobeGuard.EntityCustom(world);
					if (entityToSpawn != null) {
						entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
						world.spawnEntity(entityToSpawn);
					}
				}
				if ((Math.random() < 0.2)) {
					if (!world.isRemote) {
						Entity entityToSpawn = new EntityKobeGuard.EntityCustom(world);
						if (entityToSpawn != null) {
							entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
							world.spawnEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
