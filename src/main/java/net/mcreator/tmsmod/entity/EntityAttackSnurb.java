
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
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.tmsmod.item.ItemSummonorsScythe;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsTmsModMod.ModElement.Tag
public class EntityAttackSnurb extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 51;
	public static final int ENTITYID_RANGED = 52;
	public EntityAttackSnurb(ElementsTmsModMod instance) {
		super(instance, 669);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "attack_snurb"), ENTITYID)
						.name("attack_snurb").tracker(64, 3, true).egg(-14368512, -16756023).build());
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
			return new RenderLiving(renderManager, new Modelattacksnurb(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/attacksnurb.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 0.5f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, false));
			this.tasks.addTask(2, new EntityAIWander(this, 0.8));
			this.tasks.addTask(3, new EntityAILookIdle(this));
			this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityZombie.class, false, false));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, false, false));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityExpendable.EntityCustom.class, false, false));
			this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityCreeper.class, false, false));
			this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityEnderman.class, false, false));
			this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntitySansDoge.EntityCustom.class, false, false));
			this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntityLauren5Blue.EntityCustom.class, false, false));
			this.targetTasks.addTask(11, new EntityAINearestAttackableTarget(this, EntityMicarso.EntityCustom.class, false, false));
			this.targetTasks.addTask(12, new EntityAINearestAttackableTarget(this, EntityMeifWa.EntityCustom.class, false, false));
			this.targetTasks.addTask(13, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, false, false));
			this.targetTasks.addTask(14, new EntityAINearestAttackableTarget(this, EntityStray.class, false, false));
			this.targetTasks.addTask(15, new EntityAINearestAttackableTarget(this, EntityBoaritorTheHorrid.EntityCustom.class, false, false));
			this.tasks.addTask(16, new EntityAITempt(this, 3, new ItemStack(ItemSummonorsScythe.block, (int) (1)).getItem(), false));
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.bat.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.bat.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
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
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2D);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelattacksnurb extends ModelBase {
		private final ModelRenderer bb_main;
		public Modelattacksnurb() {
			textureWidth = 32;
			textureHeight = 32;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.cubeList.add(new ModelBox(bb_main, 15, 0, -2.0F, -1.0F, -4.0F, 1, 1, 1, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 14, 15, 1.0F, -1.0F, -4.0F, 1, 1, 1, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 11, 14, 1.0F, -1.0F, 2.0F, 1, 1, 1, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 7, 14, -2.0F, -1.0F, 2.0F, 1, 1, 1, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -2.0F, -4.0F, -4.0F, 4, 3, 7, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 10, -2.0F, -2.0F, -6.0F, 4, 1, 2, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 3, -1.0F, -3.0F, 3.0F, 1, 1, 2, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 0.0F, -2.0F, 3.0F, 1, 1, 2, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 13, -1.0F, -5.0F, -3.0F, 2, 1, 3, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 9, 10, -1.0F, -6.0F, -2.0F, 2, 1, 3, 0.0F, false));
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
