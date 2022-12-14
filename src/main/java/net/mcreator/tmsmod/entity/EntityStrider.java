
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
import net.minecraft.util.EnumHand;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.tmsmod.item.ItemSacrifice;
import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class EntityStrider extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 90;
	public static final int ENTITYID_RANGED = 91;
	public EntityStrider(ElementsTmsModMod instance) {
		super(instance, 699);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "strider"), ENTITYID)
				.name("strider").tracker(64, 3, true).egg(-8054760, -11382447).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("hell")),};
		EntityRegistry.addSpawn(EntityCustom.class, 20, 2, 4, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelstrider(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/strider.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityAnimal {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 0;
			this.isImmuneToFire = true;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
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
			return new ItemStack(Items.STRING, (int) (1)).getItem();
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public boolean processInteract(EntityPlayer entity, EnumHand hand) {
			super.processInteract(entity, hand);
			entity.startRiding(this);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			ItemStack itemstack = entity.getHeldItem(hand);
			return true;
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

		@Override
		public EntityCustom createChild(EntityAgeable ageable) {
			return new EntityCustom(world);
		}

		@Override
		public float getEyeHeight() {
			return this.isChild() ? this.height : 1.3F;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(ItemSacrifice.block, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}

		@Override
		public void travel(float ti, float tj, float tk) {
			Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
			if (this.isBeingRidden()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
				this.renderYawOffset = entity.rotationYaw;
				this.rotationYawHead = entity.rotationYaw;
				this.stepHeight = 1.0F;
				if (entity instanceof EntityLivingBase) {
					this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
					float forward = ((EntityLivingBase) entity).moveForward;
					float strafe = 0;
					super.travel(strafe, 0, forward);
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.posX - this.prevPosX;
				double d0 = this.posZ - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F)
					f1 = 1.0F;
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
				return;
			}
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(ti, tj, tk);
		}
	}

	// Made with Blockbench 4.0.1
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelstrider extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer left_leg;
		private final ModelRenderer right_leg;
		private final ModelRenderer hair_left_top;
		private final ModelRenderer hair_left_top_rotation;
		private final ModelRenderer hair_left_middle;
		private final ModelRenderer hair_left_middle_rotation;
		private final ModelRenderer hair_left_bottom;
		private final ModelRenderer hair_left_bottom_rotation;
		private final ModelRenderer hair_right_top;
		private final ModelRenderer hair_right_top_rotation;
		private final ModelRenderer hair_right_middle;
		private final ModelRenderer hair_right_middle_rotation;
		private final ModelRenderer hair_right_bottom;
		private final ModelRenderer hair_right_bottom_rotation;
		public Modelstrider() {
			textureWidth = 64;
			textureHeight = 128;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 1.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 0, -8.0F, -6.0F, -8.0F, 16, 14, 16, 0.0F, false));
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(4.0F, 7.0F, 0.0F);
			left_leg.cubeList.add(new ModelBox(left_leg, 0, 55, -10.0F, 0.0F, -2.0F, 4, 17, 4, 0.0F, false));
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-4.0F, 7.0F, 0.0F);
			right_leg.cubeList.add(new ModelBox(right_leg, 0, 32, 6.0F, 0.0F, -2.0F, 4, 17, 4, 0.0F, false));
			hair_left_top = new ModelRenderer(this);
			hair_left_top.setRotationPoint(-8.0F, -5.0F, -8.0F);
			hair_left_top_rotation = new ModelRenderer(this);
			hair_left_top_rotation.setRotationPoint(16.0F, 0.0F, 8.0F);
			hair_left_top.addChild(hair_left_top_rotation);
			setRotationAngle(hair_left_top_rotation, 0.0F, 0.0F, 1.0472F);
			hair_left_top_rotation.cubeList.add(new ModelBox(hair_left_top_rotation, 4, 33, 0.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, false));
			hair_left_middle = new ModelRenderer(this);
			hair_left_middle.setRotationPoint(-8.0F, -1.0F, -8.0F);
			hair_left_middle_rotation = new ModelRenderer(this);
			hair_left_middle_rotation.setRotationPoint(16.0F, 0.0F, 8.0F);
			hair_left_middle.addChild(hair_left_middle_rotation);
			setRotationAngle(hair_left_middle_rotation, 0.0F, 0.0F, 1.0472F);
			hair_left_middle_rotation.cubeList.add(new ModelBox(hair_left_middle_rotation, 4, 49, 0.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, false));
			hair_left_bottom = new ModelRenderer(this);
			hair_left_bottom.setRotationPoint(-8.0F, 4.0F, -8.0F);
			hair_left_bottom_rotation = new ModelRenderer(this);
			hair_left_bottom_rotation.setRotationPoint(16.0F, 0.0F, 8.0F);
			hair_left_bottom.addChild(hair_left_bottom_rotation);
			setRotationAngle(hair_left_bottom_rotation, 0.0F, 0.0F, 1.0472F);
			hair_left_bottom_rotation.cubeList.add(new ModelBox(hair_left_bottom_rotation, 4, 65, 0.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, false));
			hair_right_top = new ModelRenderer(this);
			hair_right_top.setRotationPoint(8.0F, -4.0F, -8.0F);
			hair_right_top_rotation = new ModelRenderer(this);
			hair_right_top_rotation.setRotationPoint(-16.0F, 0.0F, 8.0F);
			hair_right_top.addChild(hair_right_top_rotation);
			setRotationAngle(hair_right_top_rotation, 0.0F, 0.0F, -1.0472F);
			hair_right_top_rotation.cubeList.add(new ModelBox(hair_right_top_rotation, 4, 33, -12.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, true));
			hair_right_middle = new ModelRenderer(this);
			hair_right_middle.setRotationPoint(8.0F, 0.0F, -8.0F);
			hair_right_middle_rotation = new ModelRenderer(this);
			hair_right_middle_rotation.setRotationPoint(-16.0F, 0.0F, 8.0F);
			hair_right_middle.addChild(hair_right_middle_rotation);
			setRotationAngle(hair_right_middle_rotation, 0.0F, 0.0F, -1.0472F);
			hair_right_middle_rotation.cubeList.add(new ModelBox(hair_right_middle_rotation, 4, 49, -12.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, true));
			hair_right_bottom = new ModelRenderer(this);
			hair_right_bottom.setRotationPoint(8.0F, 5.0F, -8.0F);
			hair_right_bottom_rotation = new ModelRenderer(this);
			hair_right_bottom_rotation.setRotationPoint(-16.0F, 0.0F, 8.0F);
			hair_right_bottom.addChild(hair_right_bottom_rotation);
			setRotationAngle(hair_right_bottom_rotation, 0.0F, 0.0F, -1.0472F);
			hair_right_bottom_rotation.cubeList.add(new ModelBox(hair_right_bottom_rotation, 4, 65, -12.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, true));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			left_leg.render(f5);
			right_leg.render(f5);
			hair_left_top.render(f5);
			hair_left_middle.render(f5);
			hair_left_bottom.render(f5);
			hair_right_top.render(f5);
			hair_right_middle.render(f5);
			hair_right_bottom.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
