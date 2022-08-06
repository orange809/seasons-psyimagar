// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modeltuboshujiao extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;

	public Modeltuboshujiao() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 6.0F, 1.0F);
		head.setTextureOffset(0, 23).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 5.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(3.0F, -6.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-3.0F, -6.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(3.0F, 21.0F, 1.0F);
		leftleg.setTextureOffset(0, 7).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 25).addBox(-2.0F, 3.0F, -3.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		leftleg.setTextureOffset(21, 23).addBox(1.0F, 3.0F, -3.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-3.0F, 21.0F, 1.0F);
		rightleg.setTextureOffset(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		rightleg.setTextureOffset(31, 23).addBox(-2.0F, 3.0F, -3.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		rightleg.setTextureOffset(17, 25).addBox(1.0F, 3.0F, -3.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(19, 30).addBox(1.0F, -16.0F, -6.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(22, 23).addBox(-4.0F, -16.0F, -6.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(17, 23).addBox(3.0F, -16.0F, -7.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 23).addBox(1.0F, -16.0F, -7.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(11, 7).addBox(-2.0F, -16.0F, -7.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(11, 0).addBox(-4.0F, -16.0F, -7.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.5672F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(30, 26).addBox(-1.0F, -8.0F, 0.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, -1.5708F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-5.0F, -5.0F, -18.0F, 10.0F, 8.0F, 15.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
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
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}