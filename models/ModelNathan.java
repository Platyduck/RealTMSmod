// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class ModelNathan extends ModelBase {
	private final ModelRenderer Head;
	private final ModelRenderer cube_r1;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer Body_r1;
	private final ModelRenderer cube_r5;

	public ModelNathan() {
		textureWidth = 256;
		textureHeight = 256;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 24.0F, 0.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.2618F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 80, 128, -7.0F, -65.0F, -27.0F, 14, 6, 14, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 80, 96, -8.0F, -59.0F, -28.0F, 16, 16, 16, 0.0F, false));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 134, 138, 4.0F, -19.0F, -5.0F, 10, 19, 10, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -14.0F, -19.0F, -5.0F, 10, 19, 10, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 40, 96, 24.0F, -47.0F, -9.0F, 10, 47, 10, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -42.0F, 11.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 1.2217F, 0.0F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 184, 225, -30.0F, -61.0F, -45.15F, 2, 9, 12, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, -42.0F, 11.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.4363F, 0.0F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 184, 225, -30.0F, -20.15F, -75.0F, 2, 9, 12, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, -42.0F, 11.0F);
		bb_main.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.829F, 0.0F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 184, 225, -30.0F, -43.0F, -61.0F, 2, 8, 23, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 240, 205, -31.0F, -47.0F, -49.0F, 4, 47, 4, 0.0F, false));

		Body_r1 = new ModelRenderer(this);
		Body_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.0873F, 0.0F, 0.0F);
		Body_r1.cubeList.add(new ModelBox(Body_r1, 0, 0, -24.0F, -64.0F, -23.0F, 48, 48, 48, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.6109F, 0.0F, 0.0F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 96, -34.0F, -35.0F, -35.0F, 10, 47, 10, 0.0F, false));
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