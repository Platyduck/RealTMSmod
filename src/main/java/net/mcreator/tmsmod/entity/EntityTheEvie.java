
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
import net.minecraft.item.Item;
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

import net.mcreator.tmsmod.procedure.ProcedureBoiMeatDrop;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

@ElementsTmsModMod.ModElement.Tag
public class EntityTheEvie extends ElementsTmsModMod.ModElement {
	public static final int ENTITYID = 155;
	public static final int ENTITYID_RANGED = 156;
	public EntityTheEvie(ElementsTmsModMod instance) {
		super(instance, 1652);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tms_mod", "the_evie"), ENTITYID)
				.name("the_evie").tracker(64, 3, true).egg(-13108, -16751104).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityCustom.class, 20, 4, 4, EnumCreatureType.MONSTER, spawnBiomes);
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
			return new RenderLiving(renderManager, new ModelEvie(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tms_mod:textures/evie.png");
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
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, false));
			this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(3, new EntityAIWander(this, 0.8));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, false));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntitySnurby.EntityCustom.class, false, false));
			this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntitySnurb.EntityCustom.class, false, false));
			this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityAlex.EntityCustom.class, false, false));
			this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntityGraham.EntityCustom.class, false, false));
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.ghast.death"));
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
				ProcedureBoiMeatDrop.executeProcedure($_dependencies);
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
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
		}
	}

	// Made with Blockbench 4.2.5
	// Exported for Minecraft version 1.7 - 1.12
	// Paste this class into your mod and generate all required imports
	public static class ModelEvie extends ModelBase {
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		public ModelEvie() {
			textureWidth = 64;
			textureHeight = 64;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.cubeList.add(new ModelBox(bb_main, 24, 2, -2.0F, -1.0F, -0.5F, 1, 1, 1, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 12, 21, -4.0F, -5.0F, -0.5F, 1, 3, 1, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 21, 3.0F, -5.0F, -0.5F, 1, 3, 1, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 24, 0, 1.0F, -1.0F, -0.5F, 1, 1, 1, 0.0F, false));
			bb_main.cubeList.add(new ModelBox(bb_main, 0, 9, -3.0F, -7.0F, -3.0F, 6, 6, 6, 0.0F, false));
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -8.491F, 0.4144F);
			bb_main.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.0435F, 0.0038F, 0.0872F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 22, 9, 3.0F, -2.5F, 0.0F, 1, 1, 1, 0.0F, false));
			cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 9, 3.0F, -1.5F, -1.0F, 1, 3, 2, 0.0F, false));
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -8.491F, 0.4144F);
			bb_main.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.0435F, -0.0038F, -0.0872F);
			cube_r2.cubeList.add(new ModelBox(cube_r2, 23, 13, -4.0F, -2.5F, 0.0F, 1, 1, 1, 0.0F, false));
			cube_r2.cubeList.add(new ModelBox(cube_r2, 18, 9, -4.0F, -1.5F, -1.0F, 1, 3, 2, 0.0F, false));
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, -8.491F, 0.4144F);
			bb_main.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.48F, 0.0F, 0.0F);
			cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 21, -2.0F, -5.5F, -2.0F, 4, 5, 4, 0.0F, false));
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, -13.3983F, 3.9092F);
			bb_main.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.9599F, 0.0F, 0.0F);
			cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 0, -1.0F, -3.0F, -1.0F, 2, 5, 2, 0.0F, false));
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, -8.491F, 0.4144F);
			bb_main.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.0436F, 0.0F, 0.0F);
			cube_r5.cubeList.add(new ModelBox(cube_r5, 18, 15, -3.0F, -1.5F, -3.0F, 6, 3, 6, 0.0F, false));
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, -6.5F, 0.0F);
			bb_main.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.0436F, 0.0F, 0.0F);
			cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 0, -4.0F, -0.5F, -4.0F, 8, 1, 8, 0.0F, false));
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, -18.0F, 0.0F);
			bb_main.addChild(cube_r7);
			setRotationAngle(cube_r7, -2.618F, 0.0F, 0.0F);
			cube_r7.cubeList.add(new ModelBox(cube_r7, 24, 0, -2.0F, -8.0F, -7.0F, 4, 4, 4, 0.0F, false));
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
