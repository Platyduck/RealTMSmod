// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class ModelKingKobe extends ModelBase {
	private final ModelRenderer bb_main;

	public ModelKingKobe() {
		textureWidth = 256;
		textureHeight = 256;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 102, 119, -12.0F, -15.0F, -4.0F, 8, 15, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 70, 119, 4.0F, -15.0F, -4.0F, 8, 15, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -16.0F, -47.0F, -16.0F, 32, 32, 32, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 99, 16.0F, -37.0F, -4.0F, 8, 15, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -24.0F, -37.0F, -4.0F, 8, 15, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 64, -14.0F, -52.0F, -14.0F, 28, 5, 28, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 96, 0, -10.0F, -57.0F, -9.0F, 20, 5, 19, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 91, 104, -5.0F, -62.0F, -5.0F, 10, 5, 10, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 99, -16.0F, -52.0F, -16.0F, 2, 5, 32, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 37, 104, -14.0F, -52.0F, -16.0F, 29, 5, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 87, 66, 14.0F, -52.0F, -16.0F, 2, 5, 32, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 96, 25, -14.0F, -52.0F, 14.0F, 29, 5, 2, 0.0F, false));
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