package net.mcreator.tmsmod.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedurePawkiteSwordLivingEntityIsHitWithTool extends ElementsTmsModMod.ModElement {
	public ProcedurePawkiteSwordLivingEntityIsHitWithTool(ElementsTmsModMod instance) {
		super(instance, 1077);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PawkiteSwordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 15);
	}
}
