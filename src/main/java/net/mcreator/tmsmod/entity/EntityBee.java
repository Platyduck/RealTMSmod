
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;
import net.minecraft.block.state.IBlockState;

import net.mcreator.tmsmod.item.ItemHoneyBottle;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Random;

@ElementsTmsModMod.ModElement.Tag
public class EntityBee extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 66;
	public static final int ENTITYID_RANGED = 67;
	public EntityBee(ElementsTmsModMod instance) {
		super(instance, 290);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "bee"), ENTITYID)
				.name("bee").tracker(64, 3, true).egg(-7680, -14409470).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:beehive")),};
		EntityRegistry.addSpawn(EntityCustom.class, 20, 4, 4, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelbee(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/bee.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 0.5f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
			this.navigator = new PathNavigateFlying(this, this.world);
			this.moveHelper = new EntityFlyHelper(this);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, false));
			this.tasks.addTask(2, new EntityAIWander(this, 0.8, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = EntityCustom.this.getRNG();
					double dir_x = EntityCustom.this.posX + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = EntityCustom.this.posY + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = EntityCustom.this.posZ + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.tasks.addTask(5, new EntityAISwimming(this));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemHoneyBottle.block, (int) (1)).getItem();
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
		public void fall(float l, float d) {
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1D);
			this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.setNoGravity(true);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelbee extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer left_wing;
		private final ModelRenderer right_wing;
		private final ModelRenderer front_legs;
		private final ModelRenderer middle_legs;
		private final ModelRenderer back_legs;
		private final ModelRenderer left_antenna;
		private final ModelRenderer stinger;
		private final ModelRenderer right_antenna;
		private final ModelRenderer torso;
		public Modelbee() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			left_wing = new ModelRenderer(this);
			left_wing.setRotationPoint(-1.5F, 15.0F, -3.0F);
			left_wing.cubeList.add(new ModelBox(left_wing, 0, 18, 3.0F, 0.0F, 0.0F, 9, 0, 6, 0.0F, true));
			right_wing = new ModelRenderer(this);
			right_wing.setRotationPoint(1.5F, 15.0F, -3.0F);
			right_wing.cubeList.add(new ModelBox(right_wing, 0, 18, -12.0F, 0.0F, 0.0F, 9, 0, 6, 0.0F, false));
			front_legs = new ModelRenderer(this);
			front_legs.setRotationPoint(-1.5F, 22.0F, -2.0F);
			front_legs.cubeList.add(new ModelBox(front_legs, 28, 1, 0.0F, 0.0F, 0.0F, 3, 2, 0, 0.0F, false));
			middle_legs = new ModelRenderer(this);
			middle_legs.setRotationPoint(-1.5F, 22.0F, 0.0F);
			middle_legs.cubeList.add(new ModelBox(middle_legs, 27, 3, -1.0F, 0.0F, 0.0F, 5, 2, 0, 0.0F, false));
			back_legs = new ModelRenderer(this);
			back_legs.setRotationPoint(-1.5F, 22.0F, 2.0F);
			back_legs.cubeList.add(new ModelBox(back_legs, 27, 5, -1.0F, 0.0F, 0.0F, 5, 2, 0, 0.0F, false));
			left_antenna = new ModelRenderer(this);
			left_antenna.setRotationPoint(0.0F, 17.0F, -5.0F);
			left_antenna.cubeList.add(new ModelBox(left_antenna, 2, 0, 1.5F, -2.0F, -3.0F, 1, 2, 3, 0.0F, false));
			stinger = new ModelRenderer(this);
			stinger.setRotationPoint(0.0F, 19.0F, 0.0F);
			stinger.cubeList.add(new ModelBox(stinger, 24, 7, 0.0F, -1.0F, 5.0F, 0, 1, 2, 0.0F, false));
			right_antenna = new ModelRenderer(this);
			right_antenna.setRotationPoint(0.0F, 17.0F, -5.0F);
			right_antenna.cubeList.add(new ModelBox(right_antenna, 2, 3, -2.5F, -2.0F, -3.0F, 1, 2, 3, 0.0F, false));
			torso = new ModelRenderer(this);
			torso.setRotationPoint(0.0F, 19.0F, 0.0F);
			torso.cubeList.add(new ModelBox(torso, 0, 0, -3.5F, -4.0F, -5.0F, 7, 7, 10, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			left_wing.render(f5);
			right_wing.render(f5);
			front_legs.render(f5);
			middle_legs.render(f5);
			back_legs.render(f5);
			left_antenna.render(f5);
			stinger.render(f5);
			right_antenna.render(f5);
			torso.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.right_wing.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.left_wing.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
