// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class ModelHowler extends ModelBase {
	private final ModelRenderer Arm1;
	private final ModelRenderer cube_r1;
	private final ModelRenderer Arm2;
	private final ModelRenderer cube_r2;
	private final ModelRenderer Leg1;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer Leg2;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer Head;
	private final ModelRenderer cube_r7;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r8;

	public ModelHowler() {
		textureWidth = 128;
		textureHeight = 128;

		Arm1 = new ModelRenderer(this);
		Arm1.setRotationPoint(0.0F, 19.0F, -13.0F);
		Arm1.cubeList.add(new ModelBox(Arm1, 33, 0, -7.0F, 2.0F, -19.0F, 4, 2, 8, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arm1.addChild(cube_r1);
		setRotationAngle(cube_r1, -2.5229F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 31, -6.0F, 4.0F, -17.0F, 2, 2, 29, 0.0F, false));

		Arm2 = new ModelRenderer(this);
		Arm2.setRotationPoint(11.0F, 19.0F, -13.0F);
		Arm2.cubeList.add(new ModelBox(Arm2, 0, 31, -7.0F, 2.0F, -19.0F, 4, 2, 8, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arm2.addChild(cube_r2);
		setRotationAngle(cube_r2, -2.5229F, 0.0F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 0, -6.0F, 4.0F, -17.0F, 2, 2, 29, 0.0F, false));

		Leg1 = new ModelRenderer(this);
		Leg1.setRotationPoint(0.0F, 24.0F, 0.0F);
		Leg1.cubeList.add(new ModelBox(Leg1, 0, 41, -7.0F, -2.0F, 5.0F, 4, 2, 7, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg1.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.5236F, 0.0F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 14, -6.0F, -8.0F, -3.0F, 2, 2, 12, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg1.addChild(cube_r4);
		setRotationAngle(cube_r4, -2.7925F, 0.0F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 30, 62, -6.0F, 6.0F, -15.0F, 2, 2, 13, 0.0F, false));

		Leg2 = new ModelRenderer(this);
		Leg2.setRotationPoint(10.0F, 24.0F, 0.0F);
		Leg2.cubeList.add(new ModelBox(Leg2, 33, 17, -7.0F, -2.0F, 5.0F, 4, 2, 7, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg2.addChild(cube_r5);
		setRotationAngle(cube_r5, -2.7925F, 0.0F, 0.0F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 62, -6.0F, 6.0F, -15.0F, 2, 2, 13, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
		Leg2.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.5236F, 0.0F, 0.0F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 0, -6.0F, -8.0F, -3.0F, 2, 2, 12, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 24.0F, 0.0F);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.1309F, 0.0F, 0.0F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 52, 52, -5.0F, -27.0F, -14.0F, 10, 11, 10, 0.0F, false));
		cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 0, 3.0F, -16.0F, -14.0F, 1, 3, 5, 0.0F, false));
		cube_r7.cubeList.add(new ModelBox(cube_r7, 15, 41, -3.0F, -16.0F, -10.0F, 6, 3, 1, 0.0F, false));
		cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 14, -4.0F, -16.0F, -14.0F, 1, 3, 5, 0.0F, false));
		cube_r7.cubeList.add(new ModelBox(cube_r7, 33, 10, -4.0F, -13.0F, -14.0F, 8, 2, 5, 0.0F, false));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.4363F, 0.0F, 0.0F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 33, 18, 0.0F, -24.0F, -14.0F, 0, 5, 22, 0.0F, false));
		cube_r8.cubeList.add(new ModelBox(cube_r8, 40, 9, -4.0F, -19.0F, -14.0F, 8, 9, 22, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Arm1.render(f5);
		Arm2.render(f5);
		Leg1.render(f5);
		Leg2.render(f5);
		Head.render(f5);
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.Leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Arm2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.Arm1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}