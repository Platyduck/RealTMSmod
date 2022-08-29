
package net.mcreator.tmsmod.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;
import net.minecraft.block.state.IBlockState;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Random;
import java.util.Iterator;
import java.util.ArrayList;

@ElementsTmsModMod.ModElement.Tag
public class EntityLizdevil extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 157;
	public static final int ENTITYID_RANGED = 158;
	public EntityLizdevil(ElementsTmsModMod instance) {
		super(instance, 1653);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "lizdevil"), ENTITYID)
				.name("lizdevil").tracker(64, 3, true).egg(-13434880, -6750208).build());
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
			return new RenderLiving(renderManager, new Lizdevil(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/lizdevil.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 0;
			this.isImmuneToFire = true;
			setNoAI(!true);
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
					EntityCustom.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
				}

				@Override
				public void updateTask() {
					EntityLivingBase livingentity = EntityCustom.this.getAttackTarget();
					double d0 = EntityCustom.this.getDistanceSq(livingentity);
					if (d0 <= getAttackReachSq(livingentity)) {
						EntityCustom.this.attackEntityAsMob(livingentity);
					} else if (d0 < 16) {
						Vec3d vec3d = livingentity.getPositionEyes(1);
						EntityCustom.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
					}
				}

				protected double getAttackReachSq(EntityLivingBase attackTarget) {
					return EntityCustom.this.width * 1.5 * EntityCustom.this.height * 1.5 + attackTarget.height;
				}
			});
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
			this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.2, false));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, false));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, false));
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
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
			this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS);
		@Override
		public void addTrackingPlayer(EntityPlayerMP player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(EntityPlayerMP player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.setNoGravity(true);
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void onLivingUpdate() {
			super.onLivingUpdate();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 4; ++l) {
					double d0 = (i + random.nextFloat());
					double d1 = (j + random.nextFloat());
					double d2 = (k + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.5D;
					double d4 = (random.nextFloat() - 0.5D) * 0.5D;
					double d5 = (random.nextFloat() - 0.5D) * 0.5D;
					world.spawnParticle(EnumParticleTypes.SPELL_INSTANT, d0, d1, d2, d3, d4, d5);
				}
		}
	}

	// Made with Blockbench 4.2.5
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public class Lizdevil extends ModelBase {
		private final ModelRenderer Head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		public Lizdevil() {
			textureWidth = 128;
			textureHeight = 128;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(-5.0F, -5.5F, 0.0F);
			Head.cubeList.add(new ModelBox(Head, 0, 28, 1.0F, -0.5F, -4.0F, 8, 8, 8, 0.0F, false));
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			Head.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.1705F, -0.0376F, -0.215F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 56, 26, 1.0F, -2.5F, -3.0F, 2, 5, 2, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 56, 38, 1.0F, -4.5F, -1.0F, 2, 3, 2, 0.0F, false));
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(10.0F, 0.0F, 0.0F);
			Head.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.1666F, 0.0522F, 0.3011F);
			cube_r2.cubeList.add(new ModelBox(cube_r2, 52, 55, -3.0F, -2.5F, -3.0F, 2, 5, 2, 0.0F, false));
			cube_r2.cubeList.add(new ModelBox(cube_r2, 56, 33, -3.0F, -4.5F, -1.0F, 2, 3, 2, 0.0F, false));
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.cubeList.add(new ModelBox(bb_main, 52, 0, -4.0F, -11.0F, -2.0F, 4, 11, 4, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 51, 0.0F, -11.0F, -2.0F, 4, 11, 4, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 32, 28, -4.0F, -22.0F, -2.0F, 8, 11, 4, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 36, 50, -8.0F, -22.0F, -2.0F, 4, 11, 4, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 20, 50, 4.0F, -22.0F, -2.0F, 4, 11, 4, 0.0F, false));
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(5.0F, -9.5F, 0.0F);
			bb_main.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.0F, -0.4363F);
			cube_r3.cubeList.add(new ModelBox(cube_r3, 52, 15, -1.0F, -2.5F, -3.0F, 1, 5, 6, 0.0F, false));
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-5.0F, -9.5F, 0.0F);
			bb_main.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, 0.4363F);
			cube_r4.cubeList.add(new ModelBox(cube_r4, 52, 44, 0.0F, -2.5F, -3.0F, 1, 5, 6, 0.0F, false));
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, -9.5F, -3.0F);
			bb_main.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.4363F, 0.0F, 0.0F);
			cube_r5.cubeList.add(new ModelBox(cube_r5, 30, 43, -5.0F, -2.5F, 0.0F, 10, 5, 1, 0.0F, false));
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, -9.5F, 3.0F);
			bb_main.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.4363F, 0.0F, 0.0F);
			cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 44, -5.0F, -2.5F, -1.0F, 10, 5, 1, 0.0F, false));
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(13.0F, -16.0F, 2.0F);
			bb_main.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, 0.0F, 0.1309F);
			cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 0, -12.0F, -7.0F, 0.01F, 26, 14, 0, 0.0F, false));
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-13.0F, -16.0F, 2.0F);
			bb_main.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, 0.0F, -0.1309F);
			cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 14, -14.0F, -7.0F, 0.01F, 26, 14, 0, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			Head.render(f5);
			bb_main.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
