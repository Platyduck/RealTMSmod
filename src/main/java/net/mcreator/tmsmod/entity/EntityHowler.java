
package net.mcreator.tmsmod.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsTmsModMod.ModElement.Tag
public class EntityHowler extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 149;
	public static final int ENTITYID_RANGED = 150;
	public EntityHowler(ElementsTmsModMod instance) {
		super(instance, 702);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "howler"), ENTITYID)
				.name("howler").tracker(64, 3, true).egg(-2891803, -9536385).build());
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelHowler(), 2f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/howler.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(2f, 1.8f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, false));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, (float) 30));
			this.tasks.addTask(5, new EntityAISwimming(this));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.wolf.howl"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.donkey.death"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("ambient.cave"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.7D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12D);
		}
	}

	// Made with Blockbench 4.2.5
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class ModelHowler extends ModelBase {
		private final ModelRenderer Arm1;
		private final ModelRenderer cube_r1;
		private final ModelRenderer Arm2;
		private final ModelRenderer cube_r2;
		private final ModelRenderer Leg1;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer Leg2;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer Head;
		private final ModelRenderer cube_r7;
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r8;
		public ModelHowler() {
			textureWidth = 128;
			textureHeight = 128;
			Arm1 = new ModelRenderer(this);
			Arm1.setRotationPoint(0.0F, 19.0F, -13.0F);
			Arm1.cubeList.add(new ModelBox(Arm1, 33, 0, -7.0F, 2.0F, -19.0F, 4, 2, 8, 0.0F, false));
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			Arm1.addChild(cube_r1);
			setRotationAngle(cube_r1, -2.5229F, 0.0F, 0.0F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 31, -6.0F, 4.0F, -17.0F, 2, 2, 29, 0.0F, false));
			Arm2 = new ModelRenderer(this);
			Arm2.setRotationPoint(11.0F, 19.0F, -13.0F);
			Arm2.cubeList.add(new ModelBox(Arm2, 0, 31, -7.0F, 2.0F, -19.0F, 4, 2, 8, 0.0F, false));
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			Arm2.addChild(cube_r2);
			setRotationAngle(cube_r2, -2.5229F, 0.0F, 0.0F);
			cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, -6.0F, 4.0F, -17.0F, 2, 2, 29, 0.0F, false));
			Leg1 = new ModelRenderer(this);
			Leg1.setRotationPoint(0.0F, 24.0F, 0.0F);
			Leg1.cubeList.add(new ModelBox(Leg1, 0, 41, -7.0F, -2.0F, 5.0F, 4, 2, 7, 0.0F, false));
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			Leg1.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.5236F, 0.0F, 0.0F);
			cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 14, -6.0F, -8.0F, -3.0F, 2, 2, 12, 0.0F, false));
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
			Leg1.addChild(cube_r4);
			setRotationAngle(cube_r4, -2.7925F, 0.0F, 0.0F);
			cube_r4.cubeList.add(new ModelBox(cube_r4, 30, 62, -6.0F, 6.0F, -15.0F, 2, 2, 13, 0.0F, false));
			Leg2 = new ModelRenderer(this);
			Leg2.setRotationPoint(10.0F, 24.0F, 0.0F);
			Leg2.cubeList.add(new ModelBox(Leg2, 33, 17, -7.0F, -2.0F, 5.0F, 4, 2, 7, 0.0F, false));
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
			Leg2.addChild(cube_r5);
			setRotationAngle(cube_r5, -2.7925F, 0.0F, 0.0F);
			cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 62, -6.0F, 6.0F, -15.0F, 2, 2, 13, 0.0F, false));
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
			Leg2.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.5236F, 0.0F, 0.0F);
			cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 0, -6.0F, -8.0F, -3.0F, 2, 2, 12, 0.0F, false));
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.1309F, 0.0F, 0.0F);
			cube_r7.cubeList.add(new ModelBox(cube_r7, 52, 52, -5.0F, -27.0F, -14.0F, 10, 11, 10, 0.0F, false));
			cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 0, 3.0F, -16.0F, -14.0F, 1, 3, 5, 0.0F, false));
			cube_r7.cubeList.add(new ModelBox(cube_r7, 15, 41, -3.0F, -16.0F, -10.0F, 6, 3, 1, 0.0F, false));
			cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 14, -4.0F, -16.0F, -14.0F, 1, 3, 5, 0.0F, false));
			cube_r7.cubeList.add(new ModelBox(cube_r7, 33, 10, -4.0F, -13.0F, -14.0F, 8, 2, 5, 0.0F, false));
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r8);
			setRotationAngle(cube_r8, -0.4363F, 0.0F, 0.0F);
			cube_r8.cubeList.add(new ModelBox(cube_r8, 33, 18, 0.0F, -24.0F, -14.0F, 0, 5, 22, 0.0F, false));
			cube_r8.cubeList.add(new ModelBox(cube_r8, 40, 9, -4.0F, -19.0F, -14.0F, 8, 9, 22, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Arm1.render(f5);
			Arm2.render(f5);
			Leg1.render(f5);
			Leg2.render(f5);
			Head.render(f5);
			bb_main.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.Leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Arm2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.Arm1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
