
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.tmsmod.item.ItemMonkeFeather;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsTmsModMod.ModElement.Tag
public class EntityMonke extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 94;
	public static final int ENTITYID_RANGED = 95;
	public EntityMonke(ElementsTmsModMod instance) {
		super(instance, 660);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "monke"), ENTITYID)
				.name("monke").tracker(64, 3, true).egg(-12048892, -2831755).build());
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
			return new RenderLiving(renderManager, new Modelmonke(), 0.7999999999999999f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/chicken.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityAnimal {
		public EntityCustom(World world) {
			super(world);
			setSize(0.7999999999999999f, 1f);
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
			return new ItemStack(ItemMonkeFeather.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.endermen.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.vex.death"));
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
	public static class Modelmonke extends ModelBase {
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer rotation;
		private final ModelRenderer right_leg;
		private final ModelRenderer left_leg;
		private final ModelRenderer right_wing;
		private final ModelRenderer left_wing;
		private final ModelRenderer bill;
		private final ModelRenderer chin;
		public Modelmonke() {
			textureWidth = 64;
			textureHeight = 32;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 15.0F, -4.0F);
			head.cubeList.add(new ModelBox(head, 0, 0, -2.0F, -8.0F, 3.0F, 4, 6, 3, 0.0F, false));
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 16.0F, 0.0F);
			rotation = new ModelRenderer(this);
			rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(rotation);
			setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);
			rotation.cubeList.add(new ModelBox(rotation, 0, 9, -3.0F, 0.0F, -3.0F, 6, 2, 6, 0.0F, false));
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(2.0F, 19.0F, 1.0F);
			right_leg.cubeList.add(new ModelBox(right_leg, 26, 0, -5.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F, false));
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(-1.0F, 19.0F, 1.0F);
			left_leg.cubeList.add(new ModelBox(left_leg, 26, 0, 1.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F, false));
			right_wing = new ModelRenderer(this);
			right_wing.setRotationPoint(4.0F, 13.0F, 0.0F);
			right_wing.cubeList.add(new ModelBox(right_wing, 13, 9, -8.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F, false));
			left_wing = new ModelRenderer(this);
			left_wing.setRotationPoint(-4.0F, 13.0F, 0.0F);
			left_wing.cubeList.add(new ModelBox(left_wing, 13, 9, 7.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F, false));
			bill = new ModelRenderer(this);
			bill.setRotationPoint(0.0F, 15.0F, -4.0F);
			bill.cubeList.add(new ModelBox(bill, 14, 0, -2.0F, -5.0F, 1.0F, 4, 2, 2, 0.0F, false));
			chin = new ModelRenderer(this);
			chin.setRotationPoint(0.0F, 15.0F, -4.0F);
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			head.render(f5);
			body.render(f5);
			right_leg.render(f5);
			left_leg.render(f5);
			right_wing.render(f5);
			left_wing.render(f5);
			bill.render(f5);
			chin.render(f5);
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
			this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.right_wing.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.left_wing.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
