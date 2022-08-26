// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class ModelMackenzoid extends ModelBase {
	private final ModelRenderer bb_main;

	public ModelMackenzoid() {
		textureWidth = 64;
		textureHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 4, 5, -2.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 5, 1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 9, -3.0F, -7.0F, -3.0F, 6, 6, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 18, 9, -4.0F, -5.0F, 0.0F, 1, 3, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 9, 3.0F, -5.0F, 0.0F, 1, 3, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -4.0F, -8.0F, -4.0F, 8, 1, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 18, 15, -3.0F, -10.0F, -3.0F, 6, 2, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 21, -2.0F, -13.0F, -2.0F, 4, 3, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -1.0F, -16.0F, -1.0F, 2, 3, 2, 0.0F, false));
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