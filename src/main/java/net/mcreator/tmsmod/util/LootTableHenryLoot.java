
package net.mcreator.tmsmod.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.ResourceLocation;

import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class LootTableHenryLoot extends ElementsTmsModMod.ModElement {
	public LootTableHenryLoot(ElementsTmsModMod instance) {
		super(instance, 1400);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		LootTableList.register(new ResourceLocation("tms_mod", "henry_loot"));
	}
}
