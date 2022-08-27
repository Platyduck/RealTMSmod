package net.mcreator.tmsmod.procedure;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureOweniumSwordLivingEntityIsHitWithTool extends ElementsTmsModMod.ModElement {
	public ProcedureOweniumSwordLivingEntityIsHitWithTool(ElementsTmsModMod instance) {
		super(instance, 1007);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OweniumSwordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity)
					.setHealth((float) (((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHealth() : -1) + 1));
	}
}
