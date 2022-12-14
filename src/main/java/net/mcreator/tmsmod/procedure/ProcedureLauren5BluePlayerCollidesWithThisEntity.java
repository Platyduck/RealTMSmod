package net.mcreator.tmsmod.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.tmsmod.potion.PotionLaurenVenom;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureLauren5BluePlayerCollidesWithThisEntity extends ElementsTmsModMod.ModElement {
	public ProcedureLauren5BluePlayerCollidesWithThisEntity(ElementsTmsModMod instance) {
		super(instance, 1158);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Lauren5BluePlayerCollidesWithThisEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionLaurenVenom.potion, (int) 60, (int) 1, (false), (true)));
	}
}
