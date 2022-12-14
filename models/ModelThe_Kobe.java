// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.14 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelThe_Kobe extends EntityModel {
	private final ModelRenderer bb_main;

	public ModelThe_Kobe() {
		textureWidth = 32;
		textureHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 20, 0, -3.0F, -2.0F, -4.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 8, 18, 0.0F, -2.0F, -4.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -4.0F, -9.0F, -6.0F, 7, 7, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 18, 3.0F, -6.0F, -4.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 16, 16, -6.0F, -6.0F, -4.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 13, -3.0F, -10.0F, -5.0F, 5, 1, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 14, 13, -2.0F, -11.0F, -4.0F, 3, 1, 2, 0.0F, false));
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