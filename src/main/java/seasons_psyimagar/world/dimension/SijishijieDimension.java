
package seasons_psyimagar.world.dimension;

import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class SijishijieDimension extends SeasonsPsyimagarModElements.ModElement{


	public SijishijieDimension (SeasonsPsyimagarModElements instance) {
		super(instance, 167);

		MinecraftForge.EVENT_BUS.register(this);

	}

	@Override public void init(FMLCommonSetupEvent event) {
		Set<Block> replaceableBlocks = new HashSet<>();
		replaceableBlocks.add(JishiBlock.block);

		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:han_chao_lin"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:han_chao_lin"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:mo_gu_lin"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:mo_gu_lin"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:ying_hua_yuan"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:ying_hua_yuan"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:zhu_sha_di"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:zhu_sha_di"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:fan_mao_yi_lin"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:fan_mao_yi_lin"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:zhui_luo_tian_kong"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:zhui_luo_tian_kong"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:feng_lin"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:feng_lin"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:hui_jin_lin"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:hui_jin_lin"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getUnder().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:gui_hun_sen_ling"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getTop().getBlock());
		replaceableBlocks.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("seasons_psyimagar:gui_hun_sen_ling"))
				.getGenerationSettings().getSurfaceBuilder().get().getConfig().getUnder().getBlock());

		DeferredWorkQueue.runLater(() -> {
			try {
				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CAVE, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CAVE, "field_222718_j"))
						.addAll(replaceableBlocks).build(), "field_222718_j");

				ObfuscationReflectionHelper.setPrivateValue(WorldCarver.class, WorldCarver.CANYON, new ImmutableSet.Builder<Block>()
						.addAll((Set<Block>) ObfuscationReflectionHelper.getPrivateValue(WorldCarver.class, WorldCarver.CANYON, "field_222718_j"))
						.addAll(replaceableBlocks).build(), "field_222718_j");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override @OnlyIn(Dist.CLIENT) public void clientLoad(FMLClientSetupEvent event) {
		DimensionRenderInfo customEffect = new DimensionRenderInfo(128,
				true, DimensionRenderInfo.FogType.NORMAL, false, false) {

			@Override public Vector3d func_230494_a_(Vector3d color, float sunHeight) {
						return color.mul(sunHeight * 0.94 + 0.06, sunHeight * 0.94 + 0.06, sunHeight * 0.91 + 0.09);
			}

			@Override public boolean func_230493_a_(int x, int y) {
				return false;
			}

		};

		DeferredWorkQueue.runLater(() -> {
			try {
				Object2ObjectMap<ResourceLocation, DimensionRenderInfo> effectsRegistry =
						(Object2ObjectMap<ResourceLocation, DimensionRenderInfo>) ObfuscationReflectionHelper.getPrivateValue(DimensionRenderInfo.class, null, "field_239208_a_");
				effectsRegistry.put(new ResourceLocation("seasons_psyimagar:sijishijie"), customEffect);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}


	@SubscribeEvent public void onPlayerChangedDimensionEvent(PlayerEvent.PlayerChangedDimensionEvent event) {
		Entity entity = event.getPlayer();
		World world = entity.world;
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();

		if (event.getFrom() == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("seasons_psyimagar:sijishijie"))) {
    


        SijishijiePlayerLeavesDimensionProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}

	}

}

