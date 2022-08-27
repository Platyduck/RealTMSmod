
package net.mcreator.tmsmod.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class EntityFrog extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 127;
	public static final int ENTITYID_RANGED = 128;
	public EntityFrog(ElementsTmsModMod instance) {
		super(instance, 719);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "frog"), ENTITYID)
				.name("frog").tracker(64, 3, true).egg(-13395712, -6724096).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:snurbum_lowlands")),};
		EntityRegistry.addSpawn(EntityCustom.class, 20, 2, 4, EnumCreatureType.AMBIENT, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelfrog(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/frog.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 0.8f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}
	}

	// Made with Blockbench 4.0.1
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelfrog extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer mouth;
		private final ModelRenderer tongue;
		private final ModelRenderer sac;
		private final ModelRenderer front_left_leg;
		private final ModelRenderer front_right_leg;
		private final ModelRenderer front_right_leg_sub_0;
		private final ModelRenderer back_left_leg;
		private final ModelRenderer back_right_leg;
		private final ModelRenderer back_right_leg_sub_0;
		public Modelfrog() {
			textureWidth = 64;
			textureHeight = 32;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 12, -3.5F, -4.0F, -4.5F, 7, 3, 9, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 23, 18, -3.5F, -3.01F, -4.5F, 7, 0, 9, 0.0F, false));
			mouth = new ModelRenderer(this);
			mouth.setRotationPoint(0.0F, 20.0F, 2.5F);
			mouth.cubeList.add(new ModelBox(mouth, 0, 0, -3.5F, -2.0F, -7.0F, 7, 3, 9, 0.0F, false));
			mouth.cubeList.add(new ModelBox(mouth, 23, 18, -3.5F, -1.0F, -7.0F, 7, 0, 9, 0.0F, false));
			mouth.cubeList.add(new ModelBox(mouth, 23, 13, 0.5F, -4.0F, -6.0F, 3, 2, 3, 0.0F, false));
			mouth.cubeList.add(new ModelBox(mouth, 35, 13, -3.5F, -4.0F, -6.0F, 3, 2, 3, 0.0F, false));
			tongue = new ModelRenderer(this);
			tongue.setRotationPoint(0.0F, 24.0F, 0.0F);
			tongue.cubeList.add(new ModelBox(tongue, -8, 24, -2.0F, -3.25F, -3.5F, 4, 0, 8, 0.0F, false));
			sac = new ModelRenderer(this);
			sac.setRotationPoint(0.0F, 24.0F, 0.0F);
			sac.cubeList.add(new ModelBox(sac, 8, 24, -3.5F, -3.25F, -4.5F, 7, 2, 3, -0.1F, false));
			front_left_leg = new ModelRenderer(this);
			front_left_leg.setRotationPoint(0.0F, 24.0F, 0.0F);
			front_left_leg.cubeList.add(new ModelBox(front_left_leg, 32, 7, 3.0F, -3.0F, -4.0F, 2, 3, 3, 0.0F, false));
			front_left_leg.cubeList.add(new ModelBox(front_left_leg, -4, 0, 1.0F, 0.0F, -6.0F, 4, 0, 4, 0.0F, false));
			front_right_leg = new ModelRenderer(this);
			front_right_leg.setRotationPoint(0.0F, 24.0F, 0.0F);
			front_right_leg_sub_0 = new ModelRenderer(this);
			front_right_leg_sub_0.setRotationPoint(0.0F, 0.0F, 0.0F);
			front_right_leg.addChild(front_right_leg_sub_0);
			front_right_leg_sub_0.cubeList.add(new ModelBox(front_right_leg_sub_0, 42, 7, -5.0F, -3.0F, -4.0F, 2, 3, 3, 0.0F, true));
			front_right_leg_sub_0.cubeList.add(new ModelBox(front_right_leg_sub_0, -4, 4, -5.0F, 0.0F, -6.0F, 4, 0, 4, 0.0F, true));
			back_left_leg = new ModelRenderer(this);
			back_left_leg.setRotationPoint(0.0F, 24.0F, 0.0F);
			back_left_leg.cubeList.add(new ModelBox(back_left_leg, 23, 0, 2.5F, -3.0F, 1.5F, 3, 3, 4, 0.0F, false));
			back_left_leg.cubeList.add(new ModelBox(back_left_leg, -4, 12, 4.5F, 0.0F, 0.5F, 3, 0, 4, 0.0F, false));
			back_right_leg = new ModelRenderer(this);
			back_right_leg.setRotationPoint(0.0F, 24.0F, 0.0F);
			back_right_leg_sub_0 = new ModelRenderer(this);
			back_right_leg_sub_0.setRotationPoint(0.0F, 0.0F, 0.0F);
			back_right_leg.addChild(back_right_leg_sub_0);
			back_right_leg_sub_0.cubeList.add(new ModelBox(back_right_leg_sub_0, 37, 0, -5.5F, -3.0F, 1.5F, 3, 3, 4, 0.0F, true));
			back_right_leg_sub_0.cubeList.add(new ModelBox(back_right_leg_sub_0, -4, 16, -7.5F, 0.0F, 0.5F, 3, 0, 4, 0.0F, true));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			mouth.render(f5);
			tongue.render(f5);
			sac.render(f5);
			front_left_leg.render(f5);
			front_right_leg.render(f5);
			back_left_leg.render(f5);
			back_right_leg.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.front_right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.back_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.back_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.front_left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
