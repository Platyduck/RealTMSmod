// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


public class Snurb_Protector extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;

	public Snurb_Protector() {
		textureWidth = 128;
		textureHeight = 128;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 24, 45, -6.0F, -5.0F, -3.0F, 5, 5, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 44, 22, 1.0F, -5.0F, -3.0F, 5, 5, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -7.0F, -38.0F, -4.0F, 14, 33, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 36, 33, -6.0F, -29.0F, -12.0F, 12, 4, 8, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 91, 4, 7.0F, -46.0F, -7.0F, 1, 46, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 91, 4, 7.0F, -50.0F, -7.0F, 1, 4, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 91, 4, 8.0F, -48.0F, -7.0F, 1, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 91, 4, 6.0F, -48.0F, -7.0F, 1, 2, 1, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3927F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 41, -5.0F, -25.0F, -1.0F, 10, 15, 2, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.1309F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 44, 0, 3.0F, -24.0F, -8.0F, 5, 5, 6, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.1309F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 44, 11, -8.0F, -24.0F, -8.0F, 5, 5, 6, 0.0F, false));
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