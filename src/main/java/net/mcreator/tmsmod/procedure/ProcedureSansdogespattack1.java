package net.mcreator.tmsmod.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.effect.EntityLightningBolt;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureSansdogespattack1 extends ElementsTmsModMod.ModElement {
	public ProcedureSansdogespattack1(ElementsTmsModMod instance) {
		super(instance, 1151);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Sansdogespattack1!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Sansdogespattack1!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Sansdogespattack1!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Sansdogespattack1!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.addWeatherEffect(new EntityLightningBolt(world, (int) (x + 5), (int) y, (int) (z + 5), false));
		world.addWeatherEffect(new EntityLightningBolt(world, (int) (x - 5), (int) y, (int) (z - 5), false));
	}
}
