// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelspidey extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer neck;
	private final ModelRenderer body;
	private final ModelRenderer leg8;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;

	public Modelspidey() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.0F, -3.0F);
		head.cubeList.add(new ModelBox(head, 0, 30, -6.0F, -10.5F, -13.5F, 12, 12, 12, 0.0F, false));

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, 15.0F, 0.0F);
		neck.cubeList.add(new ModelBox(neck, 39, 45, -4.5F, -9.0F, -4.5F, 9, 9, 9, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 13.0F, 8.0F);
		setRotationAngle(body, 0.3054F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -7.5F, -10.5F, -4.0F, 15, 12, 18, 0.0F, false));

		leg8 = new ModelRenderer(this);
		leg8.setRotationPoint(-4.0F, 15.0F, -5.0F);
		setRotationAngle(leg8, 0.0F, 0.0F, 0.1745F);
		leg8.cubeList.add(new ModelBox(leg8, 57, 63, 8.5F, -6.0F, -4.0F, 12, 3, 3, 0.0F, false));
		leg8.cubeList.add(new ModelBox(leg8, 63, 27, 8.5F, -6.0F, 2.0F, 12, 3, 3, 0.0F, false));
		leg8.cubeList.add(new ModelBox(leg8, 27, 63, 8.5F, -6.0F, 8.0F, 12, 3, 3, 0.0F, false));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(11.0F, 10.0F, -5.0F);
		setRotationAngle(leg2, 0.0F, 0.0F, 1.0036F);
		leg2.cubeList.add(new ModelBox(leg2, 63, 39, 5.5F, -3.8F, -4.0F, 12, 3, 3, 0.0F, false));
		leg2.cubeList.add(new ModelBox(leg2, 63, 33, 5.5F, -3.8F, 2.0F, 12, 3, 3, 0.0F, false));
		leg2.cubeList.add(new ModelBox(leg2, 0, 60, 5.5F, -3.8F, 8.0F, 12, 3, 3, 0.0F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-18.0F, 19.0F, -5.0F);
		setRotationAngle(leg3, 0.0F, 0.0F, -0.1745F);
		leg3.cubeList.add(new ModelBox(leg3, 0, 54, 1.5F, -4.0F, -4.0F, 12, 3, 3, 0.0F, false));
		leg3.cubeList.add(new ModelBox(leg3, 48, 12, 1.5F, -4.0F, 2.0F, 12, 3, 3, 0.0F, false));
		leg3.cubeList.add(new ModelBox(leg3, 48, 6, 1.5F, -4.0F, 8.0F, 12, 3, 3, 0.0F, false));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-20.0F, 18.0F, -5.0F);
		setRotationAngle(leg4, 0.0F, 0.0F, -1.0036F);
		leg4.cubeList.add(new ModelBox(leg4, 48, 0, -7.85F, 0.45F, -4.0F, 12, 3, 3, 0.0F, false));
		leg4.cubeList.add(new ModelBox(leg4, 36, 36, -7.85F, 0.45F, 2.0F, 12, 3, 3, 0.0F, false));
		leg4.cubeList.add(new ModelBox(leg4, 36, 30, -7.85F, 0.45F, 8.0F, 12, 3, 3, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		neck.render(f5);
		body.render(f5);
		leg8.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}