// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelallay extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_wing;
	private final ModelRenderer right_wing;
	private final ModelRenderer lower;

	public Modelallay() {
		textureWidth = 32;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 17.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -2.5F, -5.0F, -2.5F, 5, 5, 5, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.25F, 17.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 10, -1.75F, 0.0F, -1.0F, 3, 4, 2, 0.0F, false));

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(2.0F, 17.75F, 0.0F);
		left_arm.cubeList.add(new ModelBox(left_arm, 16, 10, -0.5F, -0.75F, -1.0F, 1, 4, 2, 0.0F, true));

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-2.0F, 17.75F, 0.0F);
		right_arm.cubeList.add(new ModelBox(right_arm, 10, 10, -0.5F, -0.75F, -1.0F, 1, 4, 2, 0.0F, false));

		left_wing = new ModelRenderer(this);
		left_wing.setRotationPoint(0.0F, 17.0F, 1.1F);
		left_wing.cubeList.add(new ModelBox(left_wing, 0, 16, 0.0F, -1.0F, 0.0F, 7, 4, 0, 0.0F, true));

		right_wing = new ModelRenderer(this);
		right_wing.setRotationPoint(0.0F, 17.0F, 1.1F);
		right_wing.cubeList.add(new ModelBox(right_wing, 0, 20, -7.0F, -1.0F, 0.0F, 7, 4, 0, 0.0F, false));

		lower = new ModelRenderer(this);
		lower.setRotationPoint(0.0F, 21.0F, -1.0F);
		lower.cubeList.add(new ModelBox(lower, 15, 0, -1.5F, 0.0F, 0.0F, 3, 3, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		left_arm.render(f5);
		right_arm.render(f5);
		left_wing.render(f5);
		right_wing.render(f5);
		lower.render(f5);
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