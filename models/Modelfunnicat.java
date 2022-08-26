// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelfunnicat extends ModelBase {
	private final ModelRenderer back_left_leg;
	private final ModelRenderer back_right_leg;
	private final ModelRenderer front_left_leg;
	private final ModelRenderer front_right_leg;
	private final ModelRenderer tail;
	private final ModelRenderer tail2;
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rotation;

	public Modelfunnicat() {
		textureWidth = 64;
		textureHeight = 32;

		back_left_leg = new ModelRenderer(this);
		back_left_leg.setRotationPoint(-1.1F, 18.0F, 5.0F);
		back_left_leg.cubeList.add(new ModelBox(back_left_leg, 8, 13, 1.2F, 0.0F, 1.0F, 2, 6, 2, 0.0F, false));

		back_right_leg = new ModelRenderer(this);
		back_right_leg.setRotationPoint(1.1F, 18.0F, 5.0F);
		back_right_leg.cubeList.add(new ModelBox(back_right_leg, 8, 13, -3.2F, 0.0F, 1.0F, 2, 6, 2, 0.0F, false));

		front_left_leg = new ModelRenderer(this);
		front_left_leg.setRotationPoint(-1.1F, 14.0F, -5.0F);
		front_left_leg.cubeList.add(new ModelBox(front_left_leg, 40, 0, 1.2F, 0.0F, 0.0F, 2, 10, 2, 0.0F, false));

		front_right_leg = new ModelRenderer(this);
		front_right_leg.setRotationPoint(1.1F, 14.0F, -5.0F);
		front_right_leg.cubeList.add(new ModelBox(front_right_leg, 40, 0, -3.2F, 0.0F, 0.0F, 2, 10, 2, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 14.5F, 9.0F);
		tail.cubeList.add(new ModelBox(tail, 0, 15, -0.5F, 0.0F, 0.0F, 1, 8, 1, 0.0F, false));

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.0F, 22.5F, 9.0F);
		tail2.cubeList.add(new ModelBox(tail2, 4, 15, -0.5F, 0.0F, 0.0F, 1, 8, 1, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.0F, -9.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -2.5F, -2.0F, -3.0F, 5, 4, 5, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 24, -1.5F, -0.02F, -4.0F, 3, 2, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 10, -2.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 6, 10, 1.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 6.0F, 6.1F);

		rotation = new ModelRenderer(this);
		rotation.setRotationPoint(0.0F, 11.0F, -5.1F);
		body.addChild(rotation);
		setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);
		rotation.cubeList.add(new ModelBox(rotation, 20, 0, -2.0F, -8.0F, -2.9F, 4, 16, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		back_left_leg.render(f5);
		back_right_leg.render(f5);
		front_left_leg.render(f5);
		front_right_leg.render(f5);
		tail.render(f5);
		tail2.render(f5);
		head.render(f5);
		body.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.front_right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.back_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.back_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.front_left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}