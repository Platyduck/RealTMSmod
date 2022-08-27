package net.mcreator.tmsmod.procedure;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.tmsmod.entity.EntityDirtyBirdymob;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureRossminiumAxeLivingEntityIsHitWithTool extends ElementsTmsModMod.ModElement {
	public ProcedureRossminiumAxeLivingEntityIsHitWithTool(ElementsTmsModMod instance) {
		super(instance, 1396);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RossminiumAxeLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof EntityDirtyBirdymob.EntityCustom)) {
			entity.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 1000);
		}
	}
}
