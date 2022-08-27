
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
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
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

import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class EntityMoobloom extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 84;
	public static final int ENTITYID_RANGED = 85;
	public EntityMoobloom(ElementsTmsModMod instance) {
		super(instance, 697);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "moobloom"), ENTITYID)
				.name("moobloom").tracker(64, 3, true).egg(-983202, -3355236).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:snurbum_highlands")),};
		EntityRegistry.addSpawn(EntityCustom.class, 20, 2, 4, EnumCreatureType.AMBIENT, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelmoobloom(), 1f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/moobloom.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityAnimal {
		public EntityCustom(World world) {
			super(world);
			setSize(1f, 1.2f);
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
			return new ItemStack(Blocks.YELLOW_FLOWER, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.cow.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.cow.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.cow.death"));
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
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
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
			if (new ItemStack(Items.WHEAT, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}
	}

	// Made with Blockbench 4.0.1
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelmoobloom extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer rotation;
		private final ModelRenderer mushrooms;
		private final ModelRenderer mushroom2;
		private final ModelRenderer mushroom3;
		private final ModelRenderer head;
		private final ModelRenderer mushroom1;
		private final ModelRenderer leg1;
		private final ModelRenderer leg2;
		private final ModelRenderer leg3;
		private final ModelRenderer leg4;
		public Modelmoobloom() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 5.0F, 2.0F);
			rotation = new ModelRenderer(this);
			rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(rotation);
			setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);
			rotation.cubeList.add(new ModelBox(rotation, 18, 4, -6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F, false));
			rotation.cubeList.add(new ModelBox(rotation, 52, 0, -2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F, false));
			mushrooms = new ModelRenderer(this);
			mushrooms.setRotationPoint(0.0F, -5.0F, 3.0F);
			rotation.addChild(mushrooms);
			setRotationAngle(mushrooms, -1.5708F, 0.0F, 0.0F);
			mushroom2 = new ModelRenderer(this);
			mushroom2.setRotationPoint(-2.025F, 0.0F, 2.8F);
			mushrooms.addChild(mushroom2);
			setRotationAngle(mushroom2, 0.0F, 0.6807F, 0.0F);
			mushroom2.cubeList.add(new ModelBox(mushroom2, 0, 35, -8.0F, -13.0F, 0.0F, 16, 13, 0, 0.0F, false));
			mushroom2.cubeList.add(new ModelBox(mushroom2, 0, 19, 0.0F, -13.0F, -8.0F, 0, 13, 16, 0.0F, false));
			mushroom3 = new ModelRenderer(this);
			mushroom3.setRotationPoint(3.2F, 0.0F, 11.0F);
			mushrooms.addChild(mushroom3);
			setRotationAngle(mushroom3, 0.0F, -0.0524F, 0.0F);
			mushroom3.cubeList.add(new ModelBox(mushroom3, 0, 35, -8.0F, -13.0F, 0.0F, 16, 13, 0, 0.0F, false));
			mushroom3.cubeList.add(new ModelBox(mushroom3, 0, 19, 0.0F, -13.0F, -8.0F, 0, 13, 16, 0.0F, false));
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 4.0F, -8.0F);
			head.cubeList.add(new ModelBox(head, 22, 0, -5.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 22, 0, 4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F, false));
			mushroom1 = new ModelRenderer(this);
			mushroom1.setRotationPoint(0.0F, -4.0F, -3.2F);
			head.addChild(mushroom1);
			setRotationAngle(mushroom1, 0.0F, -0.576F, 0.0F);
			mushroom1.cubeList.add(new ModelBox(mushroom1, 0, 35, -8.0F, -13.0F, 0.0F, 16, 13, 0, 0.0F, false));
			mushroom1.cubeList.add(new ModelBox(mushroom1, 0, 19, 0.0F, -13.0F, -8.0F, 0, 13, 16, 0.0F, false));
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(4.0F, 12.0F, 7.0F);
			leg1.cubeList.add(new ModelBox(leg1, 0, 16, -10.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(-4.0F, 12.0F, 7.0F);
			leg2.cubeList.add(new ModelBox(leg2, 0, 16, 6.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(4.0F, 12.0F, -6.0F);
			leg3.cubeList.add(new ModelBox(leg3, 0, 16, -10.0F, 0.0F, -1.0F, 4, 12, 4, 0.0F, false));
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(-4.0F, 12.0F, -6.0F);
			leg4.cubeList.add(new ModelBox(leg4, 0, 16, 6.0F, 0.0F, -1.0F, 4, 12, 4, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			head.render(f5);
			leg1.render(f5);
			leg2.render(f5);
			leg3.render(f5);
			leg4.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
