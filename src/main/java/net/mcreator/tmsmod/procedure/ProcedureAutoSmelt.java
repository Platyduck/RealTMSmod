package net.mcreator.tmsmod.procedure;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.entity.item.EntityItem;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;

@ElementsTmsModMod.ModElement.Tag
public class ProcedureAutoSmelt extends ElementsTmsModMod.ModElement {
	public ProcedureAutoSmelt(ElementsTmsModMod instance) {
		super(instance, 1365);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure AutoSmelt!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure AutoSmelt!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure AutoSmelt!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure AutoSmelt!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((!((FurnaceRecipes.instance()
				.getSmeltingResult((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))).copy())
						.getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem()))) {
			if (!world.isRemote) {
				EntityItem entityToSpawn = new EntityItem(world, x, y, z, (FurnaceRecipes.instance()
						.getSmeltingResult((new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))).copy()));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
			}
			if (world instanceof WorldServer)
				((WorldServer) world).spawnParticle(EnumParticleTypes.FLAME, x, y, z, (int) 10, 0.5, 0.5, 0.5, 0.1, new int[0]);
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
		}
	}
}
