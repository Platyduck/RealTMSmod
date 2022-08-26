// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends ModelBase {
	private final ModelRenderer bb_main;

	public Modelcustom_model() {
		textureWidth = 128;
		textureHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -6.0F, -19.0F, -12.0F, 12, 10, 24, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 54, -6.0F, -9.0F, 8.0F, 4, 9, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 48, 0, 2.0F, -9.0F, 8.0F, 4, 9, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 44, 44, 2.0F, -9.0F, -12.0F, 4, 9, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -6.0F, -9.0F, -12.0F, 4, 9, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 34, -6.0F, -23.0F, -22.0F, 12, 10, 10, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -7.0F, -25.0F, -16.0F, 1, 3, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 6.0F, -25.0F, -16.0F, 1, 3, 1, 0.0F, false));
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