// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelbee extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer left_wing;
	private final ModelRenderer right_wing;
	private final ModelRenderer front_legs;
	private final ModelRenderer middle_legs;
	private final ModelRenderer back_legs;
	private final ModelRenderer left_antenna;
	private final ModelRenderer stinger;
	private final ModelRenderer right_antenna;
	private final ModelRenderer torso;

	public Modelbee() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);

		left_wing = new ModelRenderer(this);
		left_wing.setRotationPoint(-1.5F, 15.0F, -3.0F);
		left_wing.cubeList.add(new ModelBox(left_wing, 0, 18, 3.0F, 0.0F, 0.0F, 9, 0, 6, 0.0F, true));

		right_wing = new ModelRenderer(this);
		right_wing.setRotationPoint(1.5F, 15.0F, -3.0F);
		right_wing.cubeList.add(new ModelBox(right_wing, 0, 18, -12.0F, 0.0F, 0.0F, 9, 0, 6, 0.0F, false));

		front_legs = new ModelRenderer(this);
		front_legs.setRotationPoint(-1.5F, 22.0F, -2.0F);
		front_legs.cubeList.add(new ModelBox(front_legs, 28, 1, 0.0F, 0.0F, 0.0F, 3, 2, 0, 0.0F, false));

		middle_legs = new ModelRenderer(this);
		middle_legs.setRotationPoint(-1.5F, 22.0F, 0.0F);
		middle_legs.cubeList.add(new ModelBox(middle_legs, 27, 3, -1.0F, 0.0F, 0.0F, 5, 2, 0, 0.0F, false));

		back_legs = new ModelRenderer(this);
		back_legs.setRotationPoint(-1.5F, 22.0F, 2.0F);
		back_legs.cubeList.add(new ModelBox(back_legs, 27, 5, -1.0F, 0.0F, 0.0F, 5, 2, 0, 0.0F, false));

		left_antenna = new ModelRenderer(this);
		left_antenna.setRotationPoint(0.0F, 17.0F, -5.0F);
		left_antenna.cubeList.add(new ModelBox(left_antenna, 2, 0, 1.5F, -2.0F, -3.0F, 1, 2, 3, 0.0F, false));

		stinger = new ModelRenderer(this);
		stinger.setRotationPoint(0.0F, 19.0F, 0.0F);
		stinger.cubeList.add(new ModelBox(stinger, 24, 7, 0.0F, -1.0F, 5.0F, 0, 1, 2, 0.0F, false));

		right_antenna = new ModelRenderer(this);
		right_antenna.setRotationPoint(0.0F, 17.0F, -5.0F);
		right_antenna.cubeList.add(new ModelBox(right_antenna, 2, 3, -2.5F, -2.0F, -3.0F, 1, 2, 3, 0.0F, false));

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, 19.0F, 0.0F);
		torso.cubeList.add(new ModelBox(torso, 0, 0, -3.5F, -4.0F, -5.0F, 7, 7, 10, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		left_wing.render(f5);
		right_wing.render(f5);
		front_legs.render(f5);
		middle_legs.render(f5);
		back_legs.render(f5);
		left_antenna.render(f5);
		stinger.render(f5);
		right_antenna.render(f5);
		torso.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.right_wing.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_wing.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}