// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class ModelUnderblankarian extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer headwear;
	private final ModelRenderer body;
	private final ModelRenderer jacket;
	private final ModelRenderer left_arm;
	private final ModelRenderer left_sleve;
	private final ModelRenderer right_arm;
	private final ModelRenderer right_sleve;
	private final ModelRenderer left_leg;
	private final ModelRenderer left_pants;
	private final ModelRenderer right_leg;
	private final ModelRenderer right_pants;

	public ModelUnderblankarian() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -2.0F, -4.0F, 8, 8, 8, 0.0F, false));

		headwear = new ModelRenderer(this);
		headwear.setRotationPoint(0.0F, 0.0F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 16, 16, -4.0F, 6.0F, -2.0F, 8, 7, 4, 0.0F, false));

		jacket = new ModelRenderer(this);
		jacket.setRotationPoint(0.0F, 0.0F, 0.0F);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
		left_arm.cubeList.add(new ModelBox(left_arm, 34, 50, -1.0F, 3.0F, -1.0F, 2, 12, 2, 0.0F, false));

		left_sleve = new ModelRenderer(this);
		left_sleve.setRotationPoint(5.0F, 2.0F, 0.0F);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		right_arm.cubeList.add(new ModelBox(right_arm, 40, 32, -4.0F, 7.0F, -3.0F, 5, 6, 6, 0.0F, false));
		right_arm.cubeList.add(new ModelBox(right_arm, 0, 32, -5.0F, 13.0F, -4.0F, 6, 7, 8, 0.0F, false));
		right_arm.cubeList.add(new ModelBox(right_arm, 40, 16, -3.0F, 3.0F, -2.0F, 4, 4, 4, 0.0F, false));

		right_sleve = new ModelRenderer(this);
		right_sleve.setRotationPoint(-5.0F, 2.0F, 0.0F);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(2.0F, 12.0F, 0.0F);
		left_leg.cubeList.add(new ModelBox(left_leg, 16, 48, -2.0F, 1.0F, -2.0F, 4, 11, 4, 0.0F, false));

		left_pants = new ModelRenderer(this);
		left_pants.setRotationPoint(2.0F, 12.0F, 0.0F);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		right_leg.cubeList.add(new ModelBox(right_leg, 0, 16, -2.0F, 1.0F, -2.0F, 4, 11, 4, 0.0F, false));

		right_pants = new ModelRenderer(this);
		right_pants.setRotationPoint(-2.0F, 12.0F, 0.0F);

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		headwear.render(f5);
		body.render(f5);
		jacket.render(f5);
		left_arm.render(f5);
		left_sleve.render(f5);
		right_arm.render(f5);
		right_sleve.render(f5);
		left_leg.render(f5);
		left_pants.render(f5);
		right_leg.render(f5);
		right_pants.render(f5);
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
		this.left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}