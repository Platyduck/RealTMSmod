// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelaxolotl extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer tail;
	private final ModelRenderer top_gills;
	private final ModelRenderer left_gills;
	private final ModelRenderer right_gills;
	private final ModelRenderer front_left_leg;
	private final ModelRenderer back_left_leg;
	private final ModelRenderer front_right_leg;
	private final ModelRenderer back_right_leg;

	public Modelaxolotl() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 18.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 11, -4.0F, -2.0F, -5.0F, 8, 4, 10, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 2, 17, 0.0F, -3.0F, -4.0F, 0, 5, 9, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 18.0F, -5.0F);
		head.cubeList.add(new ModelBox(head, 0, 1, -4.0F, -3.0F, -5.0F, 8, 5, 5, 0.0F, false));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 17.5F, 5.0F);
		tail.cubeList.add(new ModelBox(tail, 2, 19, 0.0F, -2.5F, 0.0F, 0, 5, 12, 0.0F, false));

		top_gills = new ModelRenderer(this);
		top_gills.setRotationPoint(0.0F, 15.0F, -6.0F);
		top_gills.cubeList.add(new ModelBox(top_gills, 3, 37, -4.0F, -3.0F, 0.0F, 8, 3, 0, 0.0F, false));

		left_gills = new ModelRenderer(this);
		left_gills.setRotationPoint(4.0F, 16.5F, -6.0F);
		left_gills.cubeList.add(new ModelBox(left_gills, 11, 40, 0.0F, -3.5F, 0.0F, 3, 7, 0, 0.0F, false));

		right_gills = new ModelRenderer(this);
		right_gills.setRotationPoint(-4.0F, 16.5F, -6.0F);
		right_gills.cubeList.add(new ModelBox(right_gills, 0, 40, -3.0F, -3.5F, 0.0F, 3, 7, 0, 0.0F, false));

		front_left_leg = new ModelRenderer(this);
		front_left_leg.setRotationPoint(4.0F, 19.0F, -4.0F);
		front_left_leg.cubeList.add(new ModelBox(front_left_leg, 2, 13, -1.5F, 0.0F, 0.0F, 3, 5, 0, 0.0F, false));

		back_left_leg = new ModelRenderer(this);
		back_left_leg.setRotationPoint(4.0F, 19.0F, 3.0F);
		back_left_leg.cubeList.add(new ModelBox(back_left_leg, 2, 13, -1.5F, 0.0F, 0.0F, 3, 5, 0, 0.0F, false));

		front_right_leg = new ModelRenderer(this);
		front_right_leg.setRotationPoint(-4.0F, 19.0F, -4.0F);
		front_right_leg.cubeList.add(new ModelBox(front_right_leg, 2, 13, -1.5F, 0.0F, 0.0F, 3, 5, 0, 0.0F, false));

		back_right_leg = new ModelRenderer(this);
		back_right_leg.setRotationPoint(-4.0F, 19.0F, 3.0F);
		back_right_leg.cubeList.add(new ModelBox(back_right_leg, 2, 13, -1.5F, 0.0F, 0.0F, 3, 5, 0, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		tail.render(f5);
		top_gills.render(f5);
		left_gills.render(f5);
		right_gills.render(f5);
		front_left_leg.render(f5);
		back_left_leg.render(f5);
		front_right_leg.render(f5);
		back_right_leg.render(f5);
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
		this.front_right_leg.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.back_right_leg.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.back_left_leg.rotateAngleZ = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.front_left_leg.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
	}
}