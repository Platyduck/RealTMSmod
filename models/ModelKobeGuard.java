// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class ModelKobeGuard extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;

	public ModelKobeGuard() {
		textureWidth = 64;
		textureHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 10, 21, -3.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 21, 1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 9, -3.0F, -8.0F, -3.0F, 6, 6, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 4, -5.0F, -6.0F, -1.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 3.0F, -6.0F, -1.0F, 2, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 18, 15, -3.0F, -10.0F, -3.0F, 6, 1, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 18, 9, -2.0F, -11.0F, -2.0F, 4, 1, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 10, 22, -4.0F, -8.0F, -4.0F, 1, 1, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 21, 3.0F, -8.0F, -4.0F, 1, 1, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 28, 22, 4.8F, -17.0F, -1.8F, 1, 17, 1, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.0436F, 0.3491F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 9, -5.0F, -8.0F, -4.0F, 2, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 11, -8.0F, -8.0F, -4.0F, 2, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 20, 22, -7.0F, -4.0F, -4.0F, 3, 2, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 24, 0, -8.0F, -7.0F, -4.0F, 5, 3, 1, 0.0F, false));
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