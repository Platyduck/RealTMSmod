package net.mcreator.tmsmod.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.tmsmod.gui.GuiScam;
import net.mcreator.tmsmod.TmsModMod;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureLaurenVenomOnPotionActiveTick extends ElementsTmsModMod.ModElement {
	public ProcedureLaurenVenomOnPotionActiveTick(ElementsTmsModMod instance) {
		super(instance, 1156);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure LaurenVenomOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure LaurenVenomOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure LaurenVenomOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure LaurenVenomOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure LaurenVenomOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((Math.random() < 0.2)) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).openGui(TmsModMod.instance, GuiScam.GUIID, world, x, y, z);
		}
	}
}
