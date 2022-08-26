
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.tmsmod.procedure.ProcedureBoarEntityDies;
import net.mcreator.tmsmod.item.ItemWildCarrots;
import net.mcreator.tmsmod.item.ItemRawBoar;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;
import java.util.HashMap;

@ElementsTmsModMod.ModElement.Tag
public class EntityBoar extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 86;
	public static final int ENTITYID_RANGED = 87;
	public EntityBoar(ElementsTmsModMod instance) {
		super(instance, 657);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "boar"), ENTITYID)
				.name("boar").tracker(64, 3, true).egg(-13293297, -13426420).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:hell_valley")),
				Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:rift_biome")),
				Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:crag_peaks")),};
		EntityRegistry.addSpawn(EntityCustom.class, 20, 1, 6, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelboar(), 1.2000000000000002f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/hoglin.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityAnimal {
		public EntityCustom(World world) {
			super(world);
			setSize(1.2f, 1.7999999999999998f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, false));
			this.tasks.addTask(2, new EntityAIWander(this, 1));
			this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.tasks.addTask(5, new EntityAISwimming(this));
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
			return new ItemStack(ItemRawBoar.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.pig.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.zombie_pig.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
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
				ProcedureBoarEntityDies.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
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
			if (new ItemStack(ItemWildCarrots.block, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}
	}

	// Made with Blockbench 4.0.1
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelboar extends ModelBase {
		private final ModelRenderer head;
		private final ModelRenderer head_rotation;
		private final ModelRenderer left_ear;
		private final ModelRenderer left_ear_rotation;
		private final ModelRenderer left_ear_rotation2;
		private final ModelRenderer right_ear;
		private final ModelRenderer right_ear_rotation;
		private final ModelRenderer right_ear_rotation2;
		private final ModelRenderer body;
		private final ModelRenderer mane;
		private final ModelRenderer front_left_leg;
		private final ModelRenderer front_right_leg;
		private final ModelRenderer back_left_leg;
		private final ModelRenderer back_right_leg;
		public Modelboar() {
			textureWidth = 128;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 3.0F, -8.5F);
			head_rotation = new ModelRenderer(this);
			head_rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(head_rotation);
			setRotationAngle(head_rotation, 0.8727F, 0.0F, 0.0F);
			head_rotation.cubeList.add(new ModelBox(head_rotation, 61, 1, -7.0F, -3.0F, -19.0F, 14, 6, 19, 0.0F, false));
			head_rotation.cubeList.add(new ModelBox(head_rotation, 1, 13, 6.0F, -9.0F, -13.0F, 2, 11, 2, 0.0F, false));
			head_rotation.cubeList.add(new ModelBox(head_rotation, 10, 13, -8.0F, -9.0F, -13.0F, 2, 11, 2, 0.0F, false));
			left_ear = new ModelRenderer(this);
			left_ear.setRotationPoint(-6.0F, 1.0F, -11.5F);
			left_ear_rotation = new ModelRenderer(this);
			left_ear_rotation.setRotationPoint(5.5F, 1.75F, 3.0F);
			left_ear.addChild(left_ear_rotation);
			setRotationAngle(left_ear_rotation, 0.8727F, 0.0F, 0.0F);
			left_ear_rotation2 = new ModelRenderer(this);
			left_ear_rotation2.setRotationPoint(6.5F, -1.75F, -3.0F);
			left_ear_rotation.addChild(left_ear_rotation2);
			setRotationAngle(left_ear_rotation2, 0.0F, 0.0F, 0.7854F);
			left_ear_rotation2.cubeList.add(new ModelBox(left_ear_rotation2, 1, 6, 0.0F, -1.0F, -2.0F, 6, 1, 4, 0.0F, false));
			right_ear = new ModelRenderer(this);
			right_ear.setRotationPoint(6.0F, 1.0F, -11.5F);
			right_ear_rotation = new ModelRenderer(this);
			right_ear_rotation.setRotationPoint(-5.5F, 1.75F, 3.0F);
			right_ear.addChild(right_ear_rotation);
			setRotationAngle(right_ear_rotation, 0.8727F, 0.0F, 0.0F);
			right_ear_rotation2 = new ModelRenderer(this);
			right_ear_rotation2.setRotationPoint(-6.5F, -1.75F, -3.0F);
			right_ear_rotation.addChild(right_ear_rotation2);
			setRotationAngle(right_ear_rotation2, 0.0F, 0.0F, -0.7854F);
			right_ear_rotation2.cubeList.add(new ModelBox(right_ear_rotation2, 1, 1, -6.0F, -1.0F, -2.0F, 6, 1, 4, 0.0F, false));
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 7.0F, 4.5F);
			body.cubeList.add(new ModelBox(body, 1, 1, -8.0F, -7.0F, -13.0F, 16, 14, 26, 0.0F, false));
			mane = new ModelRenderer(this);
			mane.setRotationPoint(0.0F, -7.0F, -2.5F);
			mane.cubeList.add(new ModelBox(mane, 90, 33, 0.0F, 0.0F, -9.0F, 0, 10, 19, 0.0F, false));
			front_left_leg = new ModelRenderer(this);
			front_left_leg.setRotationPoint(-4.0F, 10.0F, -4.75F);
			front_left_leg.cubeList.add(new ModelBox(front_left_leg, 41, 42, 5.0F, 0.0F, -2.75F, 6, 14, 6, 0.0F, false));
			front_right_leg = new ModelRenderer(this);
			front_right_leg.setRotationPoint(4.0F, 10.0F, -4.5F);
			front_right_leg.cubeList.add(new ModelBox(front_right_leg, 66, 42, -11.0F, 0.0F, -3.0F, 6, 14, 6, 0.0F, false));
			back_left_leg = new ModelRenderer(this);
			back_left_leg.setRotationPoint(-4.5F, 13.0F, 14.0F);
			back_left_leg.cubeList.add(new ModelBox(back_left_leg, 0, 45, 6.5F, 0.0F, -2.5F, 5, 11, 5, 0.0F, false));
			back_right_leg = new ModelRenderer(this);
			back_right_leg.setRotationPoint(4.5F, 13.0F, 14.0F);
			back_right_leg.cubeList.add(new ModelBox(back_right_leg, 21, 45, -11.5F, 0.0F, -2.5F, 5, 11, 5, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			head.render(f5);
			left_ear.render(f5);
			right_ear.render(f5);
			body.render(f5);
			mane.render(f5);
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
			this.front_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.back_right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.front_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.back_left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
