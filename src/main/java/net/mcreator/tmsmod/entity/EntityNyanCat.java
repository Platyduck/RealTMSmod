
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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAILookIdle;
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
public class EntityNyanCat extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 135;
	public static final int ENTITYID_RANGED = 136;
	public EntityNyanCat(ElementsTmsModMod instance) {
		super(instance, 731);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "nyan_cat"), ENTITYID)
				.name("nyan_cat").tracker(64, 3, true).egg(-13057, -103).build());
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
			return new RenderLiving(renderManager, new Modelfunnicat(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/cat.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 0.6f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIPanic(this, 4));
			this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2, false));
			this.tasks.addTask(3, new EntityAIWander(this, 1));
			this.targetTasks.addTask(4, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(5, new EntityAILookIdle(this));
			this.tasks.addTask(6, new EntityAISwimming(this));
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.cat.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.note.pling"));
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

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelfunnicat extends ModelBase {
		private final ModelRenderer back_left_leg;
		private final ModelRenderer back_right_leg;
		private final ModelRenderer front_left_leg;
		private final ModelRenderer front_right_leg;
		private final ModelRenderer tail;
		private final ModelRenderer tail2;
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer rotation;
		public Modelfunnicat() {
			textureWidth = 64;
			textureHeight = 32;
			back_left_leg = new ModelRenderer(this);
			back_left_leg.setRotationPoint(-1.1F, 18.0F, 5.0F);
			back_left_leg.cubeList.add(new ModelBox(back_left_leg, 8, 13, 1.2F, 0.0F, 1.0F, 2, 6, 2, 0.0F, false));
			back_right_leg = new ModelRenderer(this);
			back_right_leg.setRotationPoint(1.1F, 18.0F, 5.0F);
			back_right_leg.cubeList.add(new ModelBox(back_right_leg, 8, 13, -3.2F, 0.0F, 1.0F, 2, 6, 2, 0.0F, false));
			front_left_leg = new ModelRenderer(this);
			front_left_leg.setRotationPoint(-1.1F, 14.0F, -5.0F);
			front_left_leg.cubeList.add(new ModelBox(front_left_leg, 40, 0, 1.2F, 0.0F, 0.0F, 2, 10, 2, 0.0F, false));
			front_right_leg = new ModelRenderer(this);
			front_right_leg.setRotationPoint(1.1F, 14.0F, -5.0F);
			front_right_leg.cubeList.add(new ModelBox(front_right_leg, 40, 0, -3.2F, 0.0F, 0.0F, 2, 10, 2, 0.0F, false));
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, 14.5F, 9.0F);
			tail.cubeList.add(new ModelBox(tail, 0, 15, -0.5F, 0.0F, 0.0F, 1, 8, 1, 0.0F, false));
			tail2 = new ModelRenderer(this);
			tail2.setRotationPoint(0.0F, 22.5F, 9.0F);
			tail2.cubeList.add(new ModelBox(tail2, 4, 15, -0.5F, 0.0F, 0.0F, 1, 8, 1, 0.0F, false));
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 15.0F, -9.0F);
			head.cubeList.add(new ModelBox(head, 0, 0, -2.5F, -2.0F, -3.0F, 5, 4, 5, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 0, 24, -1.5F, -0.02F, -4.0F, 3, 2, 2, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 0, 10, -2.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 6, 10, 1.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F, false));
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 6.0F, 6.1F);
			rotation = new ModelRenderer(this);
			rotation.setRotationPoint(0.0F, 11.0F, -5.1F);
			body.addChild(rotation);
			setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);
			rotation.cubeList.add(new ModelBox(rotation, 20, 0, -2.0F, -8.0F, -2.9F, 4, 16, 6, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			back_left_leg.render(f5);
			back_right_leg.render(f5);
			front_left_leg.render(f5);
			front_right_leg.render(f5);
			tail.render(f5);
			tail2.render(f5);
			head.render(f5);
			body.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.front_right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.back_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.back_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.front_left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
