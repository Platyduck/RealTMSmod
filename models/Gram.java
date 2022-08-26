// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


public class Gram extends ModelBase {
	private final ModelRenderer bb_main;

	public Gram() {
		textureWidth = 32;
		textureHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -3.0F, -6.0F, -3.0F, 6, 5, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 14, -2.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 4, 1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 12, 11, 3.0F, -3.0F, -1.0F, 1, 3, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 8, 11, -4.0F, -3.0F, -1.0F, 1, 3, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 11, -1.0F, -7.0F, -1.0F, 2, 1, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 2, 0.0F, -8.0F, -1.0F, 2, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -3.0F, -8.0F, 0.0F, 2, 1, 1, 0.0F, false));
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
}