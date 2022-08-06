
package seasons_psyimagar.world.structure;

@Mod.EventBusSubscriber public class SeasonsPortalStructure {

	private static Feature<NoFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD) private static class FeatureRegisterHandler {

		@SubscribeEvent public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
				@Override public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
					int ci = (pos.getX() >> 4) << 4;
					int ck = (pos.getZ() >> 4) << 4;

					RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
					boolean dimensionCriteria = false;

							if(dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("seasons_psyimagar:sijishijie")))
								dimensionCriteria = true;

					if(!dimensionCriteria)
						return false;

					if ((random.nextInt(1000000) + 1) <= 0) {
						int count = random.nextInt(1) + 1;
						for(int a = 0; a < count; a++) {
							int i = ci + random.nextInt(16);
							int k = ck + random.nextInt(16);
							int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);

								j -= 1;


								Rotation rotation = Rotation.NONE;
								Mirror mirror = Mirror.NONE;

							BlockPos spawnTo = new BlockPos(i + 0, j + 0, k + 0);

							int x = spawnTo.getX();
							int y = spawnTo.getY();
							int z = spawnTo.getZ();


							Template template = world.getWorld().getStructureTemplateManager().getTemplateDefaulted(new ResourceLocation("seasons_psyimagar" ,"seasons_portal"));

							if (template == null)
								return false;

							template.func_237144_a_(world, spawnTo,
									new PlacementSettings()
											.setRotation(rotation)
											.setRandom(random)
											.setMirror(mirror)
											.addProcessor(BlockIgnoreStructureProcessor.AIR_AND_STRUCTURE_BLOCK)
											.setChunk(null)
											.setIgnoreEntities(false), random);

						}
					}

					return true;
				}
			};

			configuredFeature = feature
					.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
					.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));

			event.getRegistry().register(feature.setRegistryName("seasons_portal"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("seasons_psyimagar:seasons_portal"), configuredFeature);
		}

	}

	@SubscribeEvent public static void addFeatureToBiomes(BiomeLoadingEvent event) {

		event.getGeneration().getFeatures(GenerationStage.Decoration.
				SURFACE_STRUCTURES
				)
			 .add(() -> configuredFeature);
	}

}
