// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class ModelBoaritor extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer head_rotation;
	private final ModelRenderer left_ear;
	private final ModelRenderer left_ear_rotation;
	private final ModelRenderer left_ear_rotation2;
	private final ModelRenderer right_ear;
	private final ModelRenderer right_ear_rotation;
	private final ModelRenderer right_ear_rotation2;
	private final ModelRenderer body;
	private final ModelRenderer mane;
	private final ModelRenderer front_left_leg;
	private final ModelRenderer front_right_leg;
	private final ModelRenderer back_left_leg;
	private final ModelRenderer back_right_leg;

	public ModelBoaritor() {
		textureWidth = 256;
		textureHeight = 256;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 3.0F, -8.5F);

		head_rotation = new ModelRenderer(this);
		head_rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(head_rotation);
		setRotationAngle(head_rotation, 0.8727F, 0.0F, 0.0F);
		head_rotation.cubeList
				.add(new ModelBox(head_rotation, 0, 80, -14.0F, -26.56F, -25.2443F, 28, 12, 38, 0.0F, false));
		head_rotation.cubeList
				.add(new ModelBox(head_rotation, 16, 80, 12.0F, -38.56F, -13.2443F, 4, 22, 4, 0.0F, false));
		head_rotation.cubeList
				.add(new ModelBox(head_rotation, 0, 80, -16.0F, -38.56F, -13.2443F, 4, 22, 4, 0.0F, false));

		left_ear = new ModelRenderer(this);
		left_ear.setRotationPoint(-6.0F, 1.0F, -11.5F);

		left_ear_rotation = new ModelRenderer(this);
		left_ear_rotation.setRotationPoint(5.5F, 1.75F, 3.0F);
		left_ear.addChild(left_ear_rotation);
		setRotationAngle(left_ear_rotation, 0.8727F, 0.0F, 0.0F);

		left_ear_rotation2 = new ModelRenderer(this);
		left_ear_rotation2.setRotationPoint(6.5F, -1.75F, -3.0F);
		left_ear_rotation.addChild(left_ear_rotation2);
		setRotationAngle(left_ear_rotation2, 0.0F, 0.0F, 0.7854F);
		left_ear_rotation2.cubeList
				.add(new ModelBox(left_ear_rotation2, 116, 40, -11.6889F, -24.6889F, 5.7557F, 12, 2, 8, 0.0F, false));

		right_ear = new ModelRenderer(this);
		right_ear.setRotationPoint(6.0F, 1.0F, -11.5F);

		right_ear_rotation = new ModelRenderer(this);
		right_ear_rotation.setRotationPoint(-5.5F, 1.75F, 3.0F);
		right_ear.addChild(right_ear_rotation);
		setRotationAngle(right_ear_rotation, 0.8727F, 0.0F, 0.0F);

		right_ear_rotation2 = new ModelRenderer(this);
		right_ear_rotation2.setRotationPoint(-6.5F, -1.75F, -3.0F);
		right_ear_rotation.addChild(right_ear_rotation2);
		setRotationAngle(right_ear_rotation2, 0.0F, 0.0F, -0.7854F);
		right_ear_rotation2.cubeList
				.add(new ModelBox(right_ear_rotation2, 0, 40, -0.3111F, -24.6889F, 5.7557F, 12, 2, 8, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 7.0F, 4.5F);
		body.cubeList.add(new ModelBox(body, 0, 0, -16.0F, -31.0F, -21.5F, 32, 28, 52, 0.0F, false));

		mane = new ModelRenderer(this);
		mane.setRotationPoint(0.0F, -7.0F, -2.5F);

		front_left_leg = new ModelRenderer(this);
		front_left_leg.setRotationPoint(-4.0F, 10.0F, -4.75F);
		front_left_leg.cubeList
				.add(new ModelBox(front_left_leg, 116, 0, 6.0F, -14.0F, -10.25F, 12, 28, 12, 0.0F, false));

		front_right_leg = new ModelRenderer(this);
		front_right_leg.setRotationPoint(4.0F, 10.0F, -4.5F);
		front_right_leg.cubeList
				.add(new ModelBox(front_right_leg, 0, 0, -18.0F, -14.0F, -10.5F, 12, 28, 12, 0.0F, false));

		back_left_leg = new ModelRenderer(this);
		back_left_leg.setRotationPoint(-4.5F, 13.0F, 14.0F);
		back_left_leg.cubeList.add(new ModelBox(back_left_leg, 122, 120, 8.5F, -11.0F, 9.0F, 10, 22, 10, 0.0F, false));

		back_right_leg = new ModelRenderer(this);
		back_right_leg.setRotationPoint(4.5F, 13.0F, 14.0F);
		back_right_leg.cubeList
				.add(new ModelBox(back_right_leg, 94, 80, -18.5F, -11.0F, 9.0F, 10, 22, 10, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		left_ear.render(f5);
		right_ear.render(f5);
		body.render(f5);
		mane.render(f5);
		front_left_leg.render(f5);
		front_right_leg.render(f5);
		back_left_leg.render(f5);
		back_right_leg.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.front_right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.back_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.front_left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.back_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}