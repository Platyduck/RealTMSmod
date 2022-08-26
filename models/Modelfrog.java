// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelfrog extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer mouth;
	private final ModelRenderer tongue;
	private final ModelRenderer sac;
	private final ModelRenderer front_left_leg;
	private final ModelRenderer front_right_leg;
	private final ModelRenderer front_right_leg_sub_0;
	private final ModelRenderer back_left_leg;
	private final ModelRenderer back_right_leg;
	private final ModelRenderer back_right_leg_sub_0;

	public Modelfrog() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 12, -3.5F, -4.0F, -4.5F, 7, 3, 9, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 23, 18, -3.5F, -3.01F, -4.5F, 7, 0, 9, 0.0F, false));

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(0.0F, 20.0F, 2.5F);
		mouth.cubeList.add(new ModelBox(mouth, 0, 0, -3.5F, -2.0F, -7.0F, 7, 3, 9, 0.0F, false));
		mouth.cubeList.add(new ModelBox(mouth, 23, 18, -3.5F, -1.0F, -7.0F, 7, 0, 9, 0.0F, false));
		mouth.cubeList.add(new ModelBox(mouth, 23, 13, 0.5F, -4.0F, -6.0F, 3, 2, 3, 0.0F, false));
		mouth.cubeList.add(new ModelBox(mouth, 35, 13, -3.5F, -4.0F, -6.0F, 3, 2, 3, 0.0F, false));

		tongue = new ModelRenderer(this);
		tongue.setRotationPoint(0.0F, 24.0F, 0.0F);
		tongue.cubeList.add(new ModelBox(tongue, -8, 24, -2.0F, -3.25F, -3.5F, 4, 0, 8, 0.0F, false));

		sac = new ModelRenderer(this);
		sac.setRotationPoint(0.0F, 24.0F, 0.0F);
		sac.cubeList.add(new ModelBox(sac, 8, 24, -3.5F, -3.25F, -4.5F, 7, 2, 3, -0.1F, false));

		front_left_leg = new ModelRenderer(this);
		front_left_leg.setRotationPoint(0.0F, 24.0F, 0.0F);
		front_left_leg.cubeList.add(new ModelBox(front_left_leg, 32, 7, 3.0F, -3.0F, -4.0F, 2, 3, 3, 0.0F, false));
		front_left_leg.cubeList.add(new ModelBox(front_left_leg, -4, 0, 1.0F, 0.0F, -6.0F, 4, 0, 4, 0.0F, false));

		front_right_leg = new ModelRenderer(this);
		front_right_leg.setRotationPoint(0.0F, 24.0F, 0.0F);

		front_right_leg_sub_0 = new ModelRenderer(this);
		front_right_leg_sub_0.setRotationPoint(0.0F, 0.0F, 0.0F);
		front_right_leg.addChild(front_right_leg_sub_0);
		front_right_leg_sub_0.cubeList
				.add(new ModelBox(front_right_leg_sub_0, 42, 7, -5.0F, -3.0F, -4.0F, 2, 3, 3, 0.0F, true));
		front_right_leg_sub_0.cubeList
				.add(new ModelBox(front_right_leg_sub_0, -4, 4, -5.0F, 0.0F, -6.0F, 4, 0, 4, 0.0F, true));

		back_left_leg = new ModelRenderer(this);
		back_left_leg.setRotationPoint(0.0F, 24.0F, 0.0F);
		back_left_leg.cubeList.add(new ModelBox(back_left_leg, 23, 0, 2.5F, -3.0F, 1.5F, 3, 3, 4, 0.0F, false));
		back_left_leg.cubeList.add(new ModelBox(back_left_leg, -4, 12, 4.5F, 0.0F, 0.5F, 3, 0, 4, 0.0F, false));

		back_right_leg = new ModelRenderer(this);
		back_right_leg.setRotationPoint(0.0F, 24.0F, 0.0F);

		back_right_leg_sub_0 = new ModelRenderer(this);
		back_right_leg_sub_0.setRotationPoint(0.0F, 0.0F, 0.0F);
		back_right_leg.addChild(back_right_leg_sub_0);
		back_right_leg_sub_0.cubeList
				.add(new ModelBox(back_right_leg_sub_0, 37, 0, -5.5F, -3.0F, 1.5F, 3, 3, 4, 0.0F, true));
		back_right_leg_sub_0.cubeList
				.add(new ModelBox(back_right_leg_sub_0, -4, 16, -7.5F, 0.0F, 0.5F, 3, 0, 4, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		mouth.render(f5);
		tongue.render(f5);
		sac.render(f5);
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
		this.back_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.front_left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}