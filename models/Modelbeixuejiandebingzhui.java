// Made with Blockbench 3.9.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelbeixuejiandebingzhui extends EntityModel<Entity> {
	private final ModelRenderer bone;

	public Modelbeixuejiandebingzhui() {
		textureWidth = 32;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(6.0F, 8.0F, 7.0F);
		setRotationAngle(bone, 0.0F, -1.5708F, -1.5708F);
		bone.setTextureOffset(0, 0).addBox(-8.0F, -7.0F, 3.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-7.0F, -7.0F, 6.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-8.0F, -6.0F, 5.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-8.0F, -8.0F, 6.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-9.0F, -7.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}