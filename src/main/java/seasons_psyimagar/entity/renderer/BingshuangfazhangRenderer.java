package seasons_psyimagar.entity.renderer;

@OnlyIn(Dist.CLIENT) public class BingshuangfazhangRenderer {

	public static class ModelRegisterHandler {

		@SubscribeEvent @OnlyIn(Dist.CLIENT) public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(BingshuangfazhangItem.arrow, renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
		}

	}


}
