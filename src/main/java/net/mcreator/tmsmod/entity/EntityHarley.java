
package net.mcreator.tmsmod.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
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

import net.mcreator.tmsmod.procedure.ProcedureHenryEntityDies;
import net.mcreator.tmsmod.item.ItemYogaFeather;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

@ElementsTmsModMod.ModElement.Tag
public class EntityHarley extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 78;
	public static final int ENTITYID_RANGED = 79;
	public EntityHarley(ElementsTmsModMod instance) {
		super(instance, 652);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "harley"), ENTITYID)
				.name("harley").tracker(64, 3, true).egg(-990468, -10532642).build());
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
			return new RenderLiving(renderManager, new Modelhenry(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/harley.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 0.6f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
			enablePersistence();
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIPanic(this, 4));
			this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2, false));
			this.tasks.addTask(3, new EntityAIWander(this, 1));
			this.targetTasks.addTask(4, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(5, new EntityAILookIdle(this));
			this.tasks.addTask(6, new EntityAISwimming(this));
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
			return new ItemStack(ItemYogaFeather.block, (int) (1)).getItem();
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("entity.parrot.imitate.ghast"));
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
				ProcedureHenryEntityDies.executeProcedure($_dependencies);
			}
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
	public static class Modelhenry extends ModelBase {
		private final ModelRenderer head;
		private final ModelRenderer feather;
		private final ModelRenderer body;
		private final ModelRenderer left_wing;
		private final ModelRenderer left_wing_rotation;
		private final ModelRenderer right_wing;
		private final ModelRenderer right_wing_rotation;
		private final ModelRenderer left_leg;
		private final ModelRenderer right_leg;
		private final ModelRenderer tail;
		public Modelhenry() {
			textureWidth = 32;
			textureHeight = 32;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 16.0F, -0.5F);
			head.cubeList.add(new ModelBox(head, 8, 13, -1.0F, 0.5F, -1.0F, 2, 2, 2, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 12, 0, -1.0F, -0.5F, -2.0F, 2, 1, 3, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 9, 0, -0.5F, 1.5F, -3.0F, 1, 1, 2, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 16, 9, -0.5F, 0.5F, -2.0F, 1, 1, 1, 0.0F, false));
			feather = new ModelRenderer(this);
			feather.setRotationPoint(0.0F, -1.5F, -2.0F);
			head.addChild(feather);
			setRotationAngle(feather, -0.2618F, 0.0F, 0.0F);
			feather.cubeList.add(new ModelBox(feather, 0, 3, 0.0F, -4.0F, 1.0F, 0, 5, 4, 0.0F, false));
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 16.5F, -1.0F);
			body.cubeList.add(new ModelBox(body, 0, 0, -1.5F, 2.0F, -1.5F, 3, 4, 3, 0.0F, false));
			left_wing = new ModelRenderer(this);
			left_wing.setRotationPoint(-1.5F, 16.9F, -0.8F);
			left_wing_rotation = new ModelRenderer(this);
			left_wing_rotation.setRotationPoint(3.0F, 2.5F, 0.0F);
			left_wing.addChild(left_wing_rotation);
			setRotationAngle(left_wing_rotation, 0.0F, 3.1416F, 0.0F);
			left_wing_rotation.cubeList.add(new ModelBox(left_wing_rotation, 0, 12, -0.5F, -0.5F, -1.5F, 1, 3, 3, 0.0F, false));
			right_wing = new ModelRenderer(this);
			right_wing.setRotationPoint(1.5F, 16.9F, -0.8F);
			right_wing_rotation = new ModelRenderer(this);
			right_wing_rotation.setRotationPoint(-3.0F, 2.5F, 0.0F);
			right_wing.addChild(right_wing_rotation);
			setRotationAngle(right_wing_rotation, 0.0F, 3.1416F, 0.0F);
			right_wing_rotation.cubeList.add(new ModelBox(right_wing_rotation, 8, 7, -0.5F, -0.5F, -1.5F, 1, 3, 3, 0.0F, false));
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(-1.0F, 22.0F, -1.0F);
			left_leg.cubeList.add(new ModelBox(left_leg, 15, 12, -0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F, false));
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(1.0F, 22.0F, -1.0F);
			right_leg.cubeList.add(new ModelBox(right_leg, 5, 12, -0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F, false));
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, 21.1F, 1.2F);
			tail.cubeList.add(new ModelBox(tail, 13, 4, -1.5F, -1.0F, -0.7F, 3, 4, 1, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			head.render(f5);
			body.render(f5);
			left_wing.render(f5);
			right_wing.render(f5);
			left_leg.render(f5);
			right_leg.render(f5);
			tail.render(f5);
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
