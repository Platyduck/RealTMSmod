
package net.mcreator.tmsmod.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
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

@ElementsTmsModMod.ModElement.Tag
public class EntityKobeGuard extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 139;
	public static final int ENTITYID_RANGED = 140;
	public EntityKobeGuard(ElementsTmsModMod instance) {
		super(instance, 696);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "kobe_guard"), ENTITYID)
				.name("kobe_guard").tracker(64, 3, true).egg(-16772097, -8421505).build());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelKobeGuard(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/kobeguard.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1f);
			experienceValue = 7;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, false));
			this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(3, new EntityAIWander(this, 0.8));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, false));
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
			return new ItemStack(Items.IRON_NUGGET, (int) (1)).getItem();
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
			if (source.getImmediateSource() instanceof EntityArrow)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4D);
		}
	}

	// Made with Blockbench 4.2.5
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class ModelKobeGuard extends ModelBase {
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r1;
		public ModelKobeGuard() {
			textureWidth = 64;
			textureHeight = 64;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.cubeList.add(new ModelBox(bb_main, 10, 21, -3.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 21, 1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 9, -3.0F, -8.0F, -3.0F, 6, 6, 6, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 4, -5.0F, -6.0F, -1.0F, 2, 2, 2, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 3.0F, -6.0F, -1.0F, 2, 2, 2, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 18, 15, -3.0F, -10.0F, -3.0F, 6, 1, 6, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 18, 9, -2.0F, -11.0F, -2.0F, 4, 1, 4, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 10, 22, -4.0F, -8.0F, -4.0F, 1, 1, 8, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 21, 3.0F, -8.0F, -4.0F, 1, 1, 8, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 28, 22, 4.8F, -17.0F, -1.8F, 1, 17, 1, 0.0F, false));
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.0436F, 0.3491F, 0.0F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 9, -5.0F, -8.0F, -4.0F, 2, 1, 1, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 11, -8.0F, -8.0F, -4.0F, 2, 1, 1, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 20, 22, -7.0F, -4.0F, -4.0F, 3, 2, 1, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 24, 0, -8.0F, -7.0F, -4.0F, 5, 3, 1, 0.0F, false));
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
