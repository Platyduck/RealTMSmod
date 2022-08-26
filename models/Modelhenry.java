// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelhenry extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer feather;
	private final ModelRenderer body;
	private final ModelRenderer left_wing;
	private final ModelRenderer left_wing_rotation;
	private final ModelRenderer right_wing;
	private final ModelRenderer right_wing_rotation;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_leg;
	private final ModelRenderer tail;

	public Modelhenry() {
		textureWidth = 32;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 16.0F, -0.5F);
		head.cubeList.add(new ModelBox(head, 8, 13, -1.0F, 0.5F, -1.0F, 2, 2, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 12, 0, -1.0F, -0.5F, -2.0F, 2, 1, 3, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 9, 0, -0.5F, 1.5F, -3.0F, 1, 1, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 16, 9, -0.5F, 0.5F, -2.0F, 1, 1, 1, 0.0F, false));

		feather = new ModelRenderer(this);
		feather.setRotationPoint(0.0F, -1.5F, -2.0F);
		head.addChild(feather);
		setRotationAngle(feather, -0.2618F, 0.0F, 0.0F);
		feather.cubeList.add(new ModelBox(feather, 0, 3, 0.0F, -4.0F, 1.0F, 0, 5, 4, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.5F, -1.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -1.5F, 2.0F, -1.5F, 3, 4, 3, 0.0F, false));

		left_wing = new ModelRenderer(this);
		left_wing.setRotationPoint(-1.5F, 16.9F, -0.8F);

		left_wing_rotation = new ModelRenderer(this);
		left_wing_rotation.setRotationPoint(3.0F, 2.5F, 0.0F);
		left_wing.addChild(left_wing_rotation);
		setRotationAngle(left_wing_rotation, 0.0F, 3.1416F, 0.0F);
		left_wing_rotation.cubeList
				.add(new ModelBox(left_wing_rotation, 0, 12, -0.5F, -0.5F, -1.5F, 1, 3, 3, 0.0F, false));

		right_wing = new ModelRenderer(this);
		right_wing.setRotationPoint(1.5F, 16.9F, -0.8F);

		right_wing_rotation = new ModelRenderer(this);
		right_wing_rotation.setRotationPoint(-3.0F, 2.5F, 0.0F);
		right_wing.addChild(right_wing_rotation);
		setRotationAngle(right_wing_rotation, 0.0F, 3.1416F, 0.0F);
		right_wing_rotation.cubeList
				.add(new ModelBox(right_wing_rotation, 8, 7, -0.5F, -0.5F, -1.5F, 1, 3, 3, 0.0F, false));

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(-1.0F, 22.0F, -1.0F);
		left_leg.cubeList.add(new ModelBox(left_leg, 15, 12, -0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F, false));

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(1.0F, 22.0F, -1.0F);
		right_leg.cubeList.add(new ModelBox(right_leg, 5, 12, -0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 21.1F, 1.2F);
		tail.cubeList.add(new ModelBox(tail, 13, 4, -1.5F, -1.0F, -0.7F, 3, 4, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		left_wing.render(f5);
		right_wing.render(f5);
		left_leg.render(f5);
		right_leg.render(f5);
		tail.render(f5);
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