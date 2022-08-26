
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
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsTmsModMod.ModElement.Tag
public class EntityAxolotl extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 68;
	public static final int ENTITYID_RANGED = 69;
	public EntityAxolotl(ElementsTmsModMod instance) {
		super(instance, 292);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "axolotl"), ENTITYID)
				.name("axolotl").tracker(64, 3, true).egg(-18963, -4037723).build());
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
			return new RenderLiving(renderManager, new Modelaxolotl(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/axolotl.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityCreature {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 0.4f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
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
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelaxolotl extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer head;
		private final ModelRenderer tail;
		private final ModelRenderer top_gills;
		private final ModelRenderer left_gills;
		private final ModelRenderer right_gills;
		private final ModelRenderer front_left_leg;
		private final ModelRenderer back_left_leg;
		private final ModelRenderer front_right_leg;
		private final ModelRenderer back_right_leg;
		public Modelaxolotl() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 18.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 11, -4.0F, -2.0F, -5.0F, 8, 4, 10, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 2, 17, 0.0F, -3.0F, -4.0F, 0, 5, 9, 0.0F, false));
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 18.0F, -5.0F);
			head.cubeList.add(new ModelBox(head, 0, 1, -4.0F, -3.0F, -5.0F, 8, 5, 5, 0.0F, false));
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, 17.5F, 5.0F);
			tail.cubeList.add(new ModelBox(tail, 2, 19, 0.0F, -2.5F, 0.0F, 0, 5, 12, 0.0F, false));
			top_gills = new ModelRenderer(this);
			top_gills.setRotationPoint(0.0F, 15.0F, -6.0F);
			top_gills.cubeList.add(new ModelBox(top_gills, 3, 37, -4.0F, -3.0F, 0.0F, 8, 3, 0, 0.0F, false));
			left_gills = new ModelRenderer(this);
			left_gills.setRotationPoint(4.0F, 16.5F, -6.0F);
			left_gills.cubeList.add(new ModelBox(left_gills, 11, 40, 0.0F, -3.5F, 0.0F, 3, 7, 0, 0.0F, false));
			right_gills = new ModelRenderer(this);
			right_gills.setRotationPoint(-4.0F, 16.5F, -6.0F);
			right_gills.cubeList.add(new ModelBox(right_gills, 0, 40, -3.0F, -3.5F, 0.0F, 3, 7, 0, 0.0F, false));
			front_left_leg = new ModelRenderer(this);
			front_left_leg.setRotationPoint(4.0F, 19.0F, -4.0F);
			front_left_leg.cubeList.add(new ModelBox(front_left_leg, 2, 13, -1.5F, 0.0F, 0.0F, 3, 5, 0, 0.0F, false));
			back_left_leg = new ModelRenderer(this);
			back_left_leg.setRotationPoint(4.0F, 19.0F, 3.0F);
			back_left_leg.cubeList.add(new ModelBox(back_left_leg, 2, 13, -1.5F, 0.0F, 0.0F, 3, 5, 0, 0.0F, false));
			front_right_leg = new ModelRenderer(this);
			front_right_leg.setRotationPoint(-4.0F, 19.0F, -4.0F);
			front_right_leg.cubeList.add(new ModelBox(front_right_leg, 2, 13, -1.5F, 0.0F, 0.0F, 3, 5, 0, 0.0F, false));
			back_right_leg = new ModelRenderer(this);
			back_right_leg.setRotationPoint(-4.0F, 19.0F, 3.0F);
			back_right_leg.cubeList.add(new ModelBox(back_right_leg, 2, 13, -1.5F, 0.0F, 0.0F, 3, 5, 0, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			head.render(f5);
			tail.render(f5);
			top_gills.render(f5);
			left_gills.render(f5);
			right_gills.render(f5);
			front_left_leg.render(f5);
			back_left_leg.render(f5);
			front_right_leg.render(f5);
			back_right_leg.render(f5);
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
			this.front_right_leg.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.back_right_leg.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.back_left_leg.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.front_left_leg.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
