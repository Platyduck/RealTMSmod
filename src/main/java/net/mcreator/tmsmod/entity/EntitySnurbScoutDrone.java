
package net.mcreator.tmsmod.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;

import net.mcreator.tmsmod.item.ItemSnurbullet;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

@ElementsTmsModMod.ModElement.Tag
public class EntitySnurbScoutDrone extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 147;
	public static final int ENTITYID_RANGED = 148;
	public EntitySnurbScoutDrone(ElementsTmsModMod instance) {
		super(instance, 701);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "snurb_scout_drone"), ENTITYID)
						.name("snurb_scout_drone").tracker(64, 3, true).egg(-11115932, -9596523).build());
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("tms_mod", "entitybulletsnurb_scout_drone"), ENTITYID_RANGED).name("entitybulletsnurb_scout_drone")
				.tracker(64, 1, true).build());
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
			return new RenderLiving(renderManager, new SnurbRogueDrone(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/snurbroguedrone.png");
				}
			};
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, renderManager -> {
			return new RenderSnowball<EntityArrowCustom>(renderManager, null, Minecraft.getMinecraft().getRenderItem()) {
				public ItemStack getStackToRender(EntityArrowCustom entity) {
					return new ItemStack(ItemSnurbullet.block, (int) (1));
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob implements IRangedAttackMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1f);
			experienceValue = 0;
			this.isImmuneToFire = true;
			setNoAI(!true);
			enablePersistence();
			this.navigator = new PathNavigateFlying(this, this.world);
			this.moveHelper = new EntityFlyHelper(this);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIBase() {
				{
					this.setMutexBits(1);
				}
				public boolean shouldExecute() {
					if (EntityCustom.this.getAttackTarget() != null && !EntityCustom.this.getMoveHelper().isUpdating()) {
						return true;
					} else {
						return false;
					}
				}

				@Override
				public boolean shouldContinueExecuting() {
					return EntityCustom.this.getMoveHelper().isUpdating() && EntityCustom.this.getAttackTarget() != null
							&& EntityCustom.this.getAttackTarget().isEntityAlive();
				}

				@Override
				public void startExecuting() {
					EntityLivingBase livingentity = EntityCustom.this.getAttackTarget();
					Vec3d vec3d = livingentity.getPositionEyes(1);
					EntityCustom.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 4);
				}

				@Override
				public void updateTask() {
					EntityLivingBase livingentity = EntityCustom.this.getAttackTarget();
					double d0 = EntityCustom.this.getDistanceSq(livingentity);
					if (d0 <= getAttackReachSq(livingentity)) {
						EntityCustom.this.attackEntityAsMob(livingentity);
					} else if (d0 < 16) {
						Vec3d vec3d = livingentity.getPositionEyes(1);
						EntityCustom.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 4);
					}
				}

				protected double getAttackReachSq(EntityLivingBase attackTarget) {
					return EntityCustom.this.width * 1.5 * EntityCustom.this.height * 1.5 + attackTarget.height;
				}
			});
			this.tasks.addTask(2, new EntityAIWander(this, 4, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = EntityCustom.this.getRNG();
					double dir_x = EntityCustom.this.posX + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = EntityCustom.this.posY + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = EntityCustom.this.posZ + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
			this.tasks.addTask(3, new EntityAIAttackMelee(this, 3, false));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, false));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("entity.evocation_fangs.attack"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.explode"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void fall(float l, float d) {
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.7000000000000001D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4D);
			this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.7000000000000001);
		}

		@Override
		public void setSwingingArms(boolean swingingArms) {
		}

		public void attackEntityWithRangedAttack(EntityLivingBase target, float flval) {
			EntityArrowCustom entityarrow = new EntityArrowCustom(this.world, this);
			double d0 = target.posY + (double) target.getEyeHeight() - 1.1;
			double d1 = target.posX - this.posX;
			double d3 = target.posZ - this.posZ;
			entityarrow.shoot(d1, d0 - entityarrow.posY + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
			this.world.spawnEntity(entityarrow);
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

	public static class EntityArrowCustom extends EntityTippedArrow {
		public EntityArrowCustom(World a) {
			super(a);
		}

		public EntityArrowCustom(World worldIn, double x, double y, double z) {
			super(worldIn, x, y, z);
		}

		public EntityArrowCustom(World worldIn, EntityLivingBase shooter) {
			super(worldIn, shooter);
		}
	}

	// Made with Blockbench 4.2.5
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public class SnurbRogueDrone extends ModelBase {
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		public SnurbRogueDrone() {
			textureWidth = 64;
			textureHeight = 64;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -4.0F, -12.0F, -4.0F, 8, 8, 8, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 23, -3.0F, -8.0F, -10.0F, 6, 2, 6, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 18, 17, 0.0F, -17.0F, -3.0F, 0, 5, 7, 0.0F, false));
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, 0.2182F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 16, 1.0F, -10.0F, -3.0F, 8, 1, 6, 0.0F, false));
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, -0.2182F);
			cube_r2.cubeList.add(new ModelBox(cube_r2, 22, 17, -9.0F, -10.0F, -3.0F, 8, 1, 6, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			bb_main.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
