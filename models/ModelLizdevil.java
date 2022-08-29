// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class ModelLizdevil extends ModelBase {
	private final ModelRenderer Head;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;

	public ModelLizdevil() {
		textureWidth = 128;
		textureHeight = 128;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-5.0F, -5.5F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 28, 1.0F, -0.5F, -4.0F, 8, 8, 8, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.1705F, -0.0376F, -0.215F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 56, 26, 1.0F, -2.5F, -3.0F, 2, 5, 2, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 56, 38, 1.0F, -4.5F, -1.0F, 2, 3, 2, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(10.0F, 0.0F, 0.0F);
		Head.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.1666F, 0.0522F, 0.3011F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 52, 55, -3.0F, -2.5F, -3.0F, 2, 5, 2, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 56, 33, -3.0F, -4.5F, -1.0F, 2, 3, 2, 0.0F, false));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 52, 0, -4.0F, -11.0F, -2.0F, 4, 11, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 51, 0.0F, -11.0F, -2.0F, 4, 11, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 32, 28, -4.0F, -22.0F, -2.0F, 8, 11, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 36, 50, -8.0F, -22.0F, -2.0F, 4, 11, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 20, 50, 4.0F, -22.0F, -2.0F, 4, 11, 4, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(5.0F, -9.5F, 0.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.4363F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 52, 15, -1.0F, -2.5F, -3.0F, 1, 5, 6, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-5.0F, -9.5F, 0.0F);
		bb_main.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.4363F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 52, 44, 0.0F, -2.5F, -3.0F, 1, 5, 6, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, -9.5F, -3.0F);
		bb_main.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.4363F, 0.0F, 0.0F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 30, 43, -5.0F, -2.5F, 0.0F, 10, 5, 1, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, -9.5F, 3.0F);
		bb_main.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.4363F, 0.0F, 0.0F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 44, -5.0F, -2.5F, -1.0F, 10, 5, 1, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(13.0F, -16.0F, 2.0F);
		bb_main.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, 0.1309F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 0, -12.0F, -7.0F, 0.01F, 26, 14, 0, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-13.0F, -16.0F, 2.0F);
		bb_main.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, -0.1309F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 14, -14.0F, -7.0F, 0.01F, 26, 14, 0, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
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
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}