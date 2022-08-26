// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelstrider extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_leg;
	private final ModelRenderer hair_left_top;
	private final ModelRenderer hair_left_top_rotation;
	private final ModelRenderer hair_left_middle;
	private final ModelRenderer hair_left_middle_rotation;
	private final ModelRenderer hair_left_bottom;
	private final ModelRenderer hair_left_bottom_rotation;
	private final ModelRenderer hair_right_top;
	private final ModelRenderer hair_right_top_rotation;
	private final ModelRenderer hair_right_middle;
	private final ModelRenderer hair_right_middle_rotation;
	private final ModelRenderer hair_right_bottom;
	private final ModelRenderer hair_right_bottom_rotation;

	public Modelstrider() {
		textureWidth = 64;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 1.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -8.0F, -6.0F, -8.0F, 16, 14, 16, 0.0F, false));

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(4.0F, 7.0F, 0.0F);
		left_leg.cubeList.add(new ModelBox(left_leg, 0, 55, -10.0F, 0.0F, -2.0F, 4, 17, 4, 0.0F, false));

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-4.0F, 7.0F, 0.0F);
		right_leg.cubeList.add(new ModelBox(right_leg, 0, 32, 6.0F, 0.0F, -2.0F, 4, 17, 4, 0.0F, false));

		hair_left_top = new ModelRenderer(this);
		hair_left_top.setRotationPoint(-8.0F, -5.0F, -8.0F);

		hair_left_top_rotation = new ModelRenderer(this);
		hair_left_top_rotation.setRotationPoint(16.0F, 0.0F, 8.0F);
		hair_left_top.addChild(hair_left_top_rotation);
		setRotationAngle(hair_left_top_rotation, 0.0F, 0.0F, 1.0472F);
		hair_left_top_rotation.cubeList
				.add(new ModelBox(hair_left_top_rotation, 4, 33, 0.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, false));

		hair_left_middle = new ModelRenderer(this);
		hair_left_middle.setRotationPoint(-8.0F, -1.0F, -8.0F);

		hair_left_middle_rotation = new ModelRenderer(this);
		hair_left_middle_rotation.setRotationPoint(16.0F, 0.0F, 8.0F);
		hair_left_middle.addChild(hair_left_middle_rotation);
		setRotationAngle(hair_left_middle_rotation, 0.0F, 0.0F, 1.0472F);
		hair_left_middle_rotation.cubeList
				.add(new ModelBox(hair_left_middle_rotation, 4, 49, 0.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, false));

		hair_left_bottom = new ModelRenderer(this);
		hair_left_bottom.setRotationPoint(-8.0F, 4.0F, -8.0F);

		hair_left_bottom_rotation = new ModelRenderer(this);
		hair_left_bottom_rotation.setRotationPoint(16.0F, 0.0F, 8.0F);
		hair_left_bottom.addChild(hair_left_bottom_rotation);
		setRotationAngle(hair_left_bottom_rotation, 0.0F, 0.0F, 1.0472F);
		hair_left_bottom_rotation.cubeList
				.add(new ModelBox(hair_left_bottom_rotation, 4, 65, 0.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, false));

		hair_right_top = new ModelRenderer(this);
		hair_right_top.setRotationPoint(8.0F, -4.0F, -8.0F);

		hair_right_top_rotation = new ModelRenderer(this);
		hair_right_top_rotation.setRotationPoint(-16.0F, 0.0F, 8.0F);
		hair_right_top.addChild(hair_right_top_rotation);
		setRotationAngle(hair_right_top_rotation, 0.0F, 0.0F, -1.0472F);
		hair_right_top_rotation.cubeList
				.add(new ModelBox(hair_right_top_rotation, 4, 33, -12.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, true));

		hair_right_middle = new ModelRenderer(this);
		hair_right_middle.setRotationPoint(8.0F, 0.0F, -8.0F);

		hair_right_middle_rotation = new ModelRenderer(this);
		hair_right_middle_rotation.setRotationPoint(-16.0F, 0.0F, 8.0F);
		hair_right_middle.addChild(hair_right_middle_rotation);
		setRotationAngle(hair_right_middle_rotation, 0.0F, 0.0F, -1.0472F);
		hair_right_middle_rotation.cubeList
				.add(new ModelBox(hair_right_middle_rotation, 4, 49, -12.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, true));

		hair_right_bottom = new ModelRenderer(this);
		hair_right_bottom.setRotationPoint(8.0F, 5.0F, -8.0F);

		hair_right_bottom_rotation = new ModelRenderer(this);
		hair_right_bottom_rotation.setRotationPoint(-16.0F, 0.0F, 8.0F);
		hair_right_bottom.addChild(hair_right_bottom_rotation);
		setRotationAngle(hair_right_bottom_rotation, 0.0F, 0.0F, -1.0472F);
		hair_right_bottom_rotation.cubeList
				.add(new ModelBox(hair_right_bottom_rotation, 4, 65, -12.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		left_leg.render(f5);
		right_leg.render(f5);
		hair_left_top.render(f5);
		hair_left_middle.render(f5);
		hair_left_bottom.render(f5);
		hair_right_top.render(f5);
		hair_right_middle.render(f5);
		hair_right_bottom.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}