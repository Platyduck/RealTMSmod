
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
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

import net.mcreator.tmsmod.ElementsTmsModMod;

@ElementsTmsModMod.ModElement.Tag
public class EntityCrawler extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 129;
	public static final int ENTITYID_RANGED = 130;
	public EntityCrawler(ElementsTmsModMod instance) {
		super(instance, 720);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "crawler"), ENTITYID)
				.name("crawler").tracker(64, 3, true).egg(-13421773, -10092544).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:krinkel_woods")),
				Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:snurbum_highlands")),
				Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:snurbum_lowlands")),
				Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:snurb_lake")),
				Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:squinkel_woodlands")),
				Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:snurbum_wilds")),
				Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:snurbian_plains")),
				Biome.REGISTRY.getObject(new ResourceLocation("tms_mod:classic_snurblands")),};
		EntityRegistry.addSpawn(EntityCustom.class, 15, 4, 4, EnumCreatureType.CREATURE, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelspidey(), 1f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/spidey.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(1f, 1.8f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
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
		protected Item getDropItem() {
			return new ItemStack(Items.SPIDER_EYE, (int) (1)).getItem();
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
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}
	}

	// Made with Blockbench 4.0.1
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelspidey extends ModelBase {
		private final ModelRenderer head;
		private final ModelRenderer neck;
		private final ModelRenderer body;
		private final ModelRenderer leg8;
		private final ModelRenderer leg2;
		private final ModelRenderer leg3;
		private final ModelRenderer leg4;
		public Modelspidey() {
			textureWidth = 128;
			textureHeight = 128;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 15.0F, -3.0F);
			head.cubeList.add(new ModelBox(head, 0, 30, -6.0F, -10.5F, -13.5F, 12, 12, 12, 0.0F, false));
			neck = new ModelRenderer(this);
			neck.setRotationPoint(0.0F, 15.0F, 0.0F);
			neck.cubeList.add(new ModelBox(neck, 39, 45, -4.5F, -9.0F, -4.5F, 9, 9, 9, 0.0F, false));
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 13.0F, 8.0F);
			setRotationAngle(body, 0.3054F, 0.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 0, -7.5F, -10.5F, -4.0F, 15, 12, 18, 0.0F, false));
			leg8 = new ModelRenderer(this);
			leg8.setRotationPoint(-4.0F, 15.0F, -5.0F);
			setRotationAngle(leg8, 0.0F, 0.0F, 0.1745F);
			leg8.cubeList.add(new ModelBox(leg8, 57, 63, 8.5F, -6.0F, -4.0F, 12, 3, 3, 0.0F, false));
			leg8.cubeList.add(new ModelBox(leg8, 63, 27, 8.5F, -6.0F, 2.0F, 12, 3, 3, 0.0F, false));
			leg8.cubeList.add(new ModelBox(leg8, 27, 63, 8.5F, -6.0F, 8.0F, 12, 3, 3, 0.0F, false));
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(11.0F, 10.0F, -5.0F);
			setRotationAngle(leg2, 0.0F, 0.0F, 1.0036F);
			leg2.cubeList.add(new ModelBox(leg2, 63, 39, 5.5F, -3.8F, -4.0F, 12, 3, 3, 0.0F, false));
			leg2.cubeList.add(new ModelBox(leg2, 63, 33, 5.5F, -3.8F, 2.0F, 12, 3, 3, 0.0F, false));
			leg2.cubeList.add(new ModelBox(leg2, 0, 60, 5.5F, -3.8F, 8.0F, 12, 3, 3, 0.0F, false));
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(-18.0F, 19.0F, -5.0F);
			setRotationAngle(leg3, 0.0F, 0.0F, -0.1745F);
			leg3.cubeList.add(new ModelBox(leg3, 0, 54, 1.5F, -4.0F, -4.0F, 12, 3, 3, 0.0F, false));
			leg3.cubeList.add(new ModelBox(leg3, 48, 12, 1.5F, -4.0F, 2.0F, 12, 3, 3, 0.0F, false));
			leg3.cubeList.add(new ModelBox(leg3, 48, 6, 1.5F, -4.0F, 8.0F, 12, 3, 3, 0.0F, false));
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(-20.0F, 18.0F, -5.0F);
			setRotationAngle(leg4, 0.0F, 0.0F, -1.0036F);
			leg4.cubeList.add(new ModelBox(leg4, 48, 0, -7.85F, 0.45F, -4.0F, 12, 3, 3, 0.0F, false));
			leg4.cubeList.add(new ModelBox(leg4, 36, 36, -7.85F, 0.45F, 2.0F, 12, 3, 3, 0.0F, false));
			leg4.cubeList.add(new ModelBox(leg4, 36, 30, -7.85F, 0.45F, 8.0F, 12, 3, 3, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			head.render(f5);
			neck.render(f5);
			body.render(f5);
			leg8.render(f5);
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
		}
	}
}
