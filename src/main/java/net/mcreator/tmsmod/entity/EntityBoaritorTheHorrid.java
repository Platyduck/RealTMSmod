
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayerMP;
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

import net.mcreator.tmsmod.item.ItemUnderblankarianZone;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsTmsModMod.ModElement.Tag
public class EntityBoaritorTheHorrid extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 112;
	public static final int ENTITYID_RANGED = 113;
	public EntityBoaritorTheHorrid(ElementsTmsModMod instance) {
		super(instance, 669);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "boaritor_the_horrid"), ENTITYID)
						.name("boaritor_the_horrid").tracker(64, 3, true).egg(-14149107, -10350062).build());
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
			return new RenderLiving(renderManager, new ModelBoaritor(), 3.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/boaritorthehorrid-4.png.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(2.5f, 3f);
			experienceValue = 0;
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
			return EnumCreatureAttribute.UNDEAD;
		}

		@Override
		protected boolean canDespawn() {
			return false;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemUnderblankarianZone.block, (int) (1)).getItem();
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
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(8D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(800D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(21D);
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
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

	// Made with Blockbench 4.0.1
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class ModelBoaritor extends ModelBase {
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
		public ModelBoaritor() {
			textureWidth = 256;
			textureHeight = 256;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 3.0F, -8.5F);
			head_rotation = new ModelRenderer(this);
			head_rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(head_rotation);
			setRotationAngle(head_rotation, 0.8727F, 0.0F, 0.0F);
			head_rotation.cubeList.add(new ModelBox(head_rotation, 0, 80, -14.0F, -26.56F, -25.2443F, 28, 12, 38, 0.0F, false));
			head_rotation.cubeList.add(new ModelBox(head_rotation, 16, 80, 12.0F, -38.56F, -13.2443F, 4, 22, 4, 0.0F, false));
			head_rotation.cubeList.add(new ModelBox(head_rotation, 0, 80, -16.0F, -38.56F, -13.2443F, 4, 22, 4, 0.0F, false));
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
			left_ear_rotation2.cubeList.add(new ModelBox(left_ear_rotation2, 116, 40, -11.6889F, -24.6889F, 5.7557F, 12, 2, 8, 0.0F, false));
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
			right_ear_rotation2.cubeList.add(new ModelBox(right_ear_rotation2, 0, 40, -0.3111F, -24.6889F, 5.7557F, 12, 2, 8, 0.0F, false));
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 7.0F, 4.5F);
			body.cubeList.add(new ModelBox(body, 0, 0, -16.0F, -31.0F, -21.5F, 32, 28, 52, 0.0F, false));
			mane = new ModelRenderer(this);
			mane.setRotationPoint(0.0F, -7.0F, -2.5F);
			front_left_leg = new ModelRenderer(this);
			front_left_leg.setRotationPoint(-4.0F, 10.0F, -4.75F);
			front_left_leg.cubeList.add(new ModelBox(front_left_leg, 116, 0, 6.0F, -14.0F, -10.25F, 12, 28, 12, 0.0F, false));
			front_right_leg = new ModelRenderer(this);
			front_right_leg.setRotationPoint(4.0F, 10.0F, -4.5F);
			front_right_leg.cubeList.add(new ModelBox(front_right_leg, 0, 0, -18.0F, -14.0F, -10.5F, 12, 28, 12, 0.0F, false));
			back_left_leg = new ModelRenderer(this);
			back_left_leg.setRotationPoint(-4.5F, 13.0F, 14.0F);
			back_left_leg.cubeList.add(new ModelBox(back_left_leg, 122, 120, 8.5F, -11.0F, 9.0F, 10, 22, 10, 0.0F, false));
			back_right_leg = new ModelRenderer(this);
			back_right_leg.setRotationPoint(4.5F, 13.0F, 14.0F);
			back_right_leg.cubeList.add(new ModelBox(back_right_leg, 94, 80, -18.5F, -11.0F, 9.0F, 10, 22, 10, 0.0F, false));
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
			this.front_right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.back_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.front_left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.back_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
