// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class ModelMoonBoss extends ModelBase {
	private final ModelRenderer bb_main;

	public ModelMoonBoss() {
		textureWidth = 128;
		textureHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 48, 17, -22.0F, -16.0F, 0.0F, 16, 16, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 48, 0, 6.0F, -16.0F, 0.0F, 16, 16, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -6.0F, -32.0F, -6.0F, 12, 32, 12, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 34, 44, -22.0F, -33.0F, 0.0F, 16, 16, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 44, 6.0F, -33.0F, 0.0F, 16, 16, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 60, 60, -4.0F, -39.0F, -8.0F, 8, 8, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 36, 5, -3.0F, -43.0F, -7.0F, 1, 4, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 36, 0, 2.0F, -43.0F, -7.0F, 1, 4, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 7, 7, 2.0F, -30.0F, -7.0F, 1, 4, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 6, 0, -3.0F, -30.0F, -7.0F, 1, 4, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 3, 4, -3.0F, -4.0F, -7.0F, 1, 4, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 2.0F, -4.0F, -7.0F, 1, 4, 1, 0.0F, false));
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