
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
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

import net.mcreator.tmsmod.procedure.ProcedureTheLastSnurbaderbEntityIsHurt;
import net.mcreator.tmsmod.procedure.ProcedureTheLastSnurbaderbEntityDies;
import net.mcreator.tmsmod.item.ItemSnurbullet;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Random;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

@ElementsTmsModMod.ModElement.Tag
public class EntityTheLastSnurbaderb extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 145;
	public static final int ENTITYID_RANGED = 146;
	public EntityTheLastSnurbaderb(ElementsTmsModMod instance) {
		super(instance, 739);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "the_last_snurbaderb"), ENTITYID)
						.name("the_last_snurbaderb").tracker(64, 3, true).egg(-4784384, -14990593).build());
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityArrowCustom.class)
				.id(new ResourceLocation("tms_mod", "entitybulletthe_last_snurbaderb"), ENTITYID_RANGED).name("entitybulletthe_last_snurbaderb")
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
			return new RenderLiving(renderManager, new ModelTheLastSnurbaderb(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/thelastsnurbaderb.png");
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
			setSize(0.6f, 2.3000000000000003f);
			experienceValue = 0;
			this.isImmuneToFire = false;
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
					EntityCustom.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 2);
				}

				@Override
				public void updateTask() {
					EntityLivingBase livingentity = EntityCustom.this.getAttackTarget();
					double d0 = EntityCustom.this.getDistanceSq(livingentity);
					if (d0 <= getAttackReachSq(livingentity)) {
						EntityCustom.this.attackEntityAsMob(livingentity);
					} else if (d0 < 16) {
						Vec3d vec3d = livingentity.getPositionEyes(1);
						EntityCustom.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 2);
					}
				}

				protected double getAttackReachSq(EntityLivingBase attackTarget) {
					return EntityCustom.this.width * 1.5 * EntityCustom.this.height * 1.5 + attackTarget.height;
				}
			});
			this.tasks.addTask(2, new EntityAIWander(this, 2, 20) {
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
			this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, (float) 6));
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.parrot.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.llama.death"));
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
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureTheLastSnurbaderbEntityIsHurt.executeProcedure($_dependencies);
			}
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureTheLastSnurbaderbEntityDies.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(444D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8D);
			this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.6);
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
		public boolean isNonBoss() {
			return false;
		}
		private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS);
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
				for (int l = 0; l < 8; ++l) {
					double d0 = (i + random.nextFloat());
					double d1 = (j + random.nextFloat());
					double d2 = (k + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 1D;
					double d4 = (random.nextFloat() - 0.5D) * 1D;
					double d5 = (random.nextFloat() - 0.5D) * 1D;
					world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, d0, d1, d2, d3, d4, d5);
				}
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
	public static class ModelTheLastSnurbaderb extends ModelBase {
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		public ModelTheLastSnurbaderb() {
			textureWidth = 128;
			textureHeight = 128;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.cubeList.add(new ModelBox(bb_main, 56, 16, -5.0F, -8.0F, -2.0F, 4, 5, 4, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 40, 16, 1.0F, -8.0F, -2.0F, 4, 5, 4, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -6.0F, -34.0F, -4.0F, 12, 26, 8, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 40, 10, -5.0F, -19.0F, -12.0F, 10, 1, 5, 0.0F, false));
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 12.0F, -1.0F);
			bb_main.addChild(cube_r1);
			setRotationAngle(cube_r1, 2.0071F, 0.0F, 0.0F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 63, -1.5F, 15.0F, 53.0F, 3, 2, 2, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 52, 61, -1.5F, 13.0F, 52.0F, 3, 2, 3, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 14, 62, -1.5F, 8.0F, 53.0F, 3, 5, 2, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 16, 53, -1.5F, 7.0F, 50.0F, 3, 6, 3, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 34, -5.5F, -9.0F, 42.0F, 11, 15, 4, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 31, 25, -6.5F, 4.0F, 41.0F, 13, 17, 9, 0.0F, false));
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 3.0F, 6.0F);
			bb_main.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.9599F, 0.0F, 0.0F);
			cube_r2.cubeList.add(new ModelBox(cube_r2, 40, 0, -7.0F, -31.0F, 10.0F, 14, 9, 1, 0.0F, false));
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 12.0F, -1.0F);
			bb_main.addChild(cube_r3);
			setRotationAngle(cube_r3, -1.0472F, 0.0F, 0.0F);
			cube_r3.cubeList.add(new ModelBox(cube_r3, 28, 51, -1.0F, -31.0F, -18.0F, 2, 19, 2, 0.0F, false));
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 12.0F, -1.0F);
			bb_main.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.8727F, 0.0F, 0.0F);
			cube_r4.cubeList.add(new ModelBox(cube_r4, 36, 51, -1.0F, -34.0F, -18.0F, 2, 19, 2, 0.0F, false));
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, 12.0F, -1.0F);
			bb_main.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.9599F, 0.0F, 0.0F);
			cube_r5.cubeList.add(new ModelBox(cube_r5, 44, 51, -1.0F, -35.0F, -18.0F, 2, 19, 2, 0.0F, false));
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 12.0F, -1.0F);
			bb_main.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.2618F, 0.0F, 0.0F);
			cube_r6.cubeList.add(new ModelBox(cube_r6, 52, 51, 1.0F, -38.0F, -15.0F, 4, 6, 4, 0.0F, false));
			cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 53, -5.0F, -38.0F, -15.0F, 4, 6, 4, 0.0F, false));
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

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		}
	}
}
