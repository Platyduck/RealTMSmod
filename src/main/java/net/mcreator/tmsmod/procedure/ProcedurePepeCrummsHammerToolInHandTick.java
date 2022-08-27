package net.mcreator.tmsmod.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedurePepeCrummsHammerToolInHandTick extends ElementsTmsModMod.ModElement {
	public ProcedurePepeCrummsHammerToolInHandTick(ElementsTmsModMod instance) {
		super(instance, 1419);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PepeCrummsHammerToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, (int) 60, (int) 2, (false), (false)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, (int) 60, (int) 0, (false), (false)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.HASTE, (int) 60, (int) 2, (false), (false)));
	}
}
