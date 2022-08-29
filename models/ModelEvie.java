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