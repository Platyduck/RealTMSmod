// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class ModelJon extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;

	public ModelJon() {
		textureWidth = 64;
		textureHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 4, 0, -2.0F, -1.0F, -0.5F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 3, 2, 1.0F, -1.0F, -0.5F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 3, -4.0F, -4.0F, -0.5F, 1, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 3.0F, -4.0F, -0.5F, 1, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -4.0F, -10.0F, -4.0F, 8, 4, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 24, 0, -3.0F, -9.0F, -5.0F, 6, 3, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 24, -4.0F, -6.0F, -3.0F, 1, 2, 7, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 17, 16, 3.0F, -6.0F, -3.0F, 1, 2, 7, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 18, 12, -3.0F, -6.0F, 3.0F, 6, 2, 1, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, -3.1416F, 0.0F, 3.1416F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 12, -3.0F, -6.0F, -3.0F, 6, 5, 6, 0.0F, false));
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