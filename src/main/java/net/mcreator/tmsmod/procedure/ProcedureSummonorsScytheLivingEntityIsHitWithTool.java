package net.mcreator.tmsmod.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.Entity;

import net.mcreator.tmsmod.entity.EntityAttackSnurb;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureSummonorsScytheLivingEntityIsHitWithTool extends ElementsTmsModMod.ModElement {
	public ProcedureSummonorsScytheLivingEntityIsHitWithTool(ElementsTmsModMod instance) {
		super(instance, 1186);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SummonorsScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SummonorsScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SummonorsScytheLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SummonorsScytheLivingEntityIsHitWithTool!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((Math.random() < 0.7)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityAttackSnurb.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, (y + 2), z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			if (world instanceof WorldServer)
				((WorldServer) world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, x, y, z, (int) 10, 0.5, 0.5, 0.5, 0.1, new int[0]);
		}
	}
}
