// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class ModelmiCArso extends ModelBase {
	private final ModelRenderer bb_main;

	public ModelmiCArso() {
		textureWidth = 256;
		textureHeight = 256;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -10.0F, -18.0F, -10.0F, 20, 18, 20, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 64, 22, -8.0F, -32.0F, -8.0F, 16, 16, 16, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 38, -9.0F, -35.0F, -9.0F, 18, 17, 18, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 73, -11.0F, -19.0F, -8.0F, 2, 17, 16, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 92, 104, -10.0F, -34.0F, -8.0F, 1, 15, 16, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 72, 89, -8.0F, -35.0F, 9.0F, 16, 29, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 36, 89, -8.0F, -35.0F, -11.0F, 16, 29, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 56, 57, -8.0F, -51.0F, -8.0F, 16, 16, 16, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 106, -9.0F, -50.0F, -7.0F, 1, 14, 14, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -14.0F, -1.0F, 4.0F, 4, 1, 5, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -14.0F, -1.0F, -9.0F, 4, 1, 5, 0.0F, false));
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