package seasons_psyimagar.entity.renderer;

@OnlyIn(Dist.CLIENT) public class LeiingfazhangRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent @OnlyIn(Dist.CLIENT) public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(LeiingfazhangItem.arrow, renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
		}

	}


}
