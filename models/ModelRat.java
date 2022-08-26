// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class ModelRat extends ModelBase {
	private final ModelRenderer bb_main;

	public ModelRat() {
		textureWidth = 32;
		textureHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -1.0F, -3.0F, -3.0F, 3, 3, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 12, 2, -2.0F, -1.0F, 1.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 12, 0, 2.0F, -1.0F, 1.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 11, 12, 2.0F, -1.0F, -2.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 8, 11, -2.0F, -1.0F, -2.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 9, 9, 0.0F, -2.0F, -4.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 9, 0.0F, -1.0F, 4.0F, 1, 1, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 5, 9, 0.0F, -2.0F, 3.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 3, -2.0F, -4.0F, -2.0F, 2, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 1.0F, -4.0F, -2.0F, 2, 2, 1, 0.0F, false));
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