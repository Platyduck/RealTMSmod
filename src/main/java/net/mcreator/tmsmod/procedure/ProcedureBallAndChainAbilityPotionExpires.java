package net.mcreator.tmsmod.procedure;

import net.minecraft.world.World;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureBallAndChainAbilityPotionExpires extends ElementsTmsModMod.ModElement {
	public ProcedureBallAndChainAbilityPotionExpires(ElementsTmsModMod instance) {
		super(instance, 1123);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BallAndChainAbilityPotionExpires!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BallAndChainAbilityPotionExpires!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BallAndChainAbilityPotionExpires!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BallAndChainAbilityPotionExpires!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 5, true);
		}
	}
}
