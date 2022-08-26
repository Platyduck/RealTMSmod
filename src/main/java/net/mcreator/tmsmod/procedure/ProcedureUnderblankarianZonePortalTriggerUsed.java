package net.mcreator.tmsmod.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureUnderblankarianZonePortalTriggerUsed extends ElementsTmsModMod.ModElement {
	public ProcedureUnderblankarianZonePortalTriggerUsed(ElementsTmsModMod instance) {
		super(instance, 1524);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure UnderblankarianZonePortalTriggerUsed!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure UnderblankarianZonePortalTriggerUsed!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure UnderblankarianZonePortalTriggerUsed!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UnderblankarianZonePortalTriggerUsed!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.playSound((EntityPlayer) null, x, y, z,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.end_portal.spawn")),
				SoundCategory.NEUTRAL, (float) 1, (float) 1);
		if (world instanceof WorldServer)
			((WorldServer) world).spawnParticle(EnumParticleTypes.PORTAL, x, y, z, (int) 1000, 1, 1, 1, 1, new int[0]);
	}
}
