
package net.mcreator.tmsmod.potion;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.Minecraft;

import net.mcreator.tmsmod.procedure.ProcedureBallAndChainAbilityPotionExpires;
import net.mcreator.tmsmod.procedure.ProcedureBallAndChainAbilityOnPotionActiveTick;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;
import java.util.HashMap;

@ElementsTmsModMod.ModElement.Tag
public class PotionBallAndChainAbility extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:ball_and_chain_ability")
	public static final Potion potion = null;
	@GameRegistry.ObjectHolder("tms_mod:ball_and_chain_ability")
	public static final PotionType potionType = null;
	public PotionBallAndChainAbility(ElementsTmsModMod instance) {
		super(instance, 1177);
	}

	@Override
	public void initElements() {
		elements.potions.add(() -> new PotionCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		ForgeRegistries.POTION_TYPES.register(new PotionTypeCustom());
	}
	public static class PotionTypeCustom extends PotionType {
		public PotionTypeCustom() {
			super(new PotionEffect[]{new PotionEffect(potion, 3600)});
			setRegistryName("ball_and_chain_ability");
		}
	}

	public static class PotionCustom extends Potion {
		private final ResourceLocation potionIcon;
		public PotionCustom() {
			super(true, -3355393);
			setRegistryName("ball_and_chain_ability");
			setPotionName("effect.ball_and_chain_ability");
			potionIcon = new ResourceLocation("tms_mod:textures/mob_effect/ball_and_chain_ability.png");
		}

		@Override
		public boolean isInstant() {
			return false;
		}

		@Override
		public boolean shouldRenderInvText(PotionEffect effect) {
			return true;
		}

		@Override
		public boolean shouldRenderHUD(PotionEffect effect) {
			return true;
		}

		@Override
		public void performEffect(EntityLivingBase entity, int amplifier) {
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureBallAndChainAbilityOnPotionActiveTick.executeProcedure($_dependencies);
			}
		}

		@Override
		public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMapIn, int amplifier) {
			super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
			World world = entity.world;
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureBallAndChainAbilityPotionExpires.executeProcedure($_dependencies);
			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
			if (mc.currentScreen != null) {
				mc.getTextureManager().bindTexture(potionIcon);
				Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
			}
		}

		@SideOnly(Side.CLIENT)
		@Override
		public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
			mc.getTextureManager().bindTexture(potionIcon);
			Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
		}

		@Override
		public boolean isReady(int duration, int amplifier) {
			return true;
		}
	}
}
