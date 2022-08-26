// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelmoobloom extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer rotation;
	private final ModelRenderer mushrooms;
	private final ModelRenderer mushroom2;
	private final ModelRenderer mushroom3;
	private final ModelRenderer head;
	private final ModelRenderer mushroom1;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;

	public Modelmoobloom() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 5.0F, 2.0F);

		rotation = new ModelRenderer(this);
		rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(rotation);
		setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);
		rotation.cubeList.add(new ModelBox(rotation, 18, 4, -6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F, false));
		rotation.cubeList.add(new ModelBox(rotation, 52, 0, -2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F, false));

		mushrooms = new ModelRenderer(this);
		mushrooms.setRotationPoint(0.0F, -5.0F, 3.0F);
		rotation.addChild(mushrooms);
		setRotationAngle(mushrooms, -1.5708F, 0.0F, 0.0F);

		mushroom2 = new ModelRenderer(this);
		mushroom2.setRotationPoint(-2.025F, 0.0F, 2.8F);
		mushrooms.addChild(mushroom2);
		setRotationAngle(mushroom2, 0.0F, 0.6807F, 0.0F);
		mushroom2.cubeList.add(new ModelBox(mushroom2, 0, 35, -8.0F, -13.0F, 0.0F, 16, 13, 0, 0.0F, false));
		mushroom2.cubeList.add(new ModelBox(mushroom2, 0, 19, 0.0F, -13.0F, -8.0F, 0, 13, 16, 0.0F, false));

		mushroom3 = new ModelRenderer(this);
		mushroom3.setRotationPoint(3.2F, 0.0F, 11.0F);
		mushrooms.addChild(mushroom3);
		setRotationAngle(mushroom3, 0.0F, -0.0524F, 0.0F);
		mushroom3.cubeList.add(new ModelBox(mushroom3, 0, 35, -8.0F, -13.0F, 0.0F, 16, 13, 0, 0.0F, false));
		mushroom3.cubeList.add(new ModelBox(mushroom3, 0, 19, 0.0F, -13.0F, -8.0F, 0, 13, 16, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 4.0F, -8.0F);
		head.cubeList.add(new ModelBox(head, 22, 0, -5.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 22, 0, 4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F, false));

		mushroom1 = new ModelRenderer(this);
		mushroom1.setRotationPoint(0.0F, -4.0F, -3.2F);
		head.addChild(mushroom1);
		setRotationAngle(mushroom1, 0.0F, -0.576F, 0.0F);
		mushroom1.cubeList.add(new ModelBox(mushroom1, 0, 35, -8.0F, -13.0F, 0.0F, 16, 13, 0, 0.0F, false));
		mushroom1.cubeList.add(new ModelBox(mushroom1, 0, 19, 0.0F, -13.0F, -8.0F, 0, 13, 16, 0.0F, false));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(4.0F, 12.0F, 7.0F);
		leg1.cubeList.add(new ModelBox(leg1, 0, 16, -10.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-4.0F, 12.0F, 7.0F);
		leg2.cubeList.add(new ModelBox(leg2, 0, 16, 6.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(4.0F, 12.0F, -6.0F);
		leg3.cubeList.add(new ModelBox(leg3, 0, 16, -10.0F, 0.0F, -1.0F, 4, 12, 4, 0.0F, false));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-4.0F, 12.0F, -6.0F);
		leg4.cubeList.add(new ModelBox(leg4, 0, 16, 6.0F, 0.0F, -1.0F, 4, 12, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		leg1.render(f5);
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
		this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}