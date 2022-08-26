// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class ModelTheLastSnurbaderb extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;

	public ModelTheLastSnurbaderb() {
		textureWidth = 128;
		textureHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 56, 16, -5.0F, -8.0F, -2.0F, 4, 5, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 40, 16, 1.0F, -8.0F, -2.0F, 4, 5, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -6.0F, -34.0F, -4.0F, 12, 26, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 40, 10, -5.0F, -19.0F, -12.0F, 10, 1, 5, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 12.0F, -1.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 2.0071F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 63, -1.5F, 15.0F, 53.0F, 3, 2, 2, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 52, 61, -1.5F, 13.0F, 52.0F, 3, 2, 3, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 14, 62, -1.5F, 8.0F, 53.0F, 3, 5, 2, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 16, 53, -1.5F, 7.0F, 50.0F, 3, 6, 3, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 34, -5.5F, -9.0F, 42.0F, 11, 15, 4, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 31, 25, -6.5F, 4.0F, 41.0F, 13, 17, 9, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 3.0F, 6.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.9599F, 0.0F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 40, 0, -7.0F, -31.0F, 10.0F, 14, 9, 1, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 12.0F, -1.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, -1.0472F, 0.0F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 28, 51, -1.0F, -31.0F, -18.0F, 2, 19, 2, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 12.0F, -1.0F);
		bb_main.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.8727F, 0.0F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 36, 51, -1.0F, -34.0F, -18.0F, 2, 19, 2, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 12.0F, -1.0F);
		bb_main.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.9599F, 0.0F, 0.0F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 44, 51, -1.0F, -35.0F, -18.0F, 2, 19, 2, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 12.0F, -1.0F);
		bb_main.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.2618F, 0.0F, 0.0F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 52, 51, 1.0F, -38.0F, -15.0F, 4, 6, 4, 0.0F, false));
		cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 53, -5.0F, -38.0F, -15.0F, 4, 6, 4, 0.0F, false));
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