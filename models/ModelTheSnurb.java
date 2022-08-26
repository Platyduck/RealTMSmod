// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class ModelTheSnurb extends ModelBase {
	private final ModelRenderer bb_main;

	public ModelTheSnurb() {
		textureWidth = 128;
		textureHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -6.0F, -13.0F, -13.0F, 12, 10, 25, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 9, 19, -5.0F, -3.0F, 8.0F, 3, 3, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 16, -5.0F, -3.0F, -11.0F, 3, 3, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 11, 13, 2.0F, -3.0F, -11.0F, 3, 3, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 11, 0, 2.0F, -3.0F, 8.0F, 3, 3, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 37, 39, -6.0F, -7.0F, -24.0F, 12, 4, 11, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 35, -7.0F, -11.0F, -10.0F, 14, 5, 10, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 49, 0, -1.0F, -9.0F, 12.0F, 2, 2, 15, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 17, 52, -1.0F, -11.0F, 12.0F, 2, 2, 13, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 50, -1.0F, -7.0F, 12.0F, 2, 2, 13, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -1.0F, -15.0F, -9.0F, 2, 2, 7, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 9, -1.0F, -17.0F, -6.0F, 2, 2, 5, 0.0F, false));
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