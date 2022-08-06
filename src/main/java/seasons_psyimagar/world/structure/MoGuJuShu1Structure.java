
package seasons_psyimagar.world.structure;

@Mod.EventBusSubscriber public class MoGuJuShu1Structure {

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

					if ((random.nextInt(1000000) + 1) <= 50000) {
						int count = random.nextInt(1) + 1;
						for(int a = 0; a < count; a++) {
							int i = ci + random.nextInt(16);
							int k = ck + random.nextInt(16);
							int j = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, i, k);

								j -= 1;

								BlockState blockAt = world.getBlockState(new BlockPos(i, j, k));
								boolean blockCriteria = false;
									if (blockAt.getBlock() == ShaojiaodesijizhiniBlock.block)
										blockCriteria = true;
								if (!blockCriteria)
									continue;

								Rotation rotation = Rotation.values()[random.nextInt(3)];
								Mirror mirror = Mirror.values()[random.nextInt(2)];

							BlockPos spawnTo = new BlockPos(i + 0, j + -3, k + 0);

							int x = spawnTo.getX();
							int y = spawnTo.getY();
							int z = spawnTo.getZ();

							if (!


        Yingshu1FuJiaDeShengChengTiaoJianProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
)
								continue;

							Template template = world.getWorld().getStructureTemplateManager().getTemplateDefaulted(new ResourceLocation("seasons_psyimagar" ,"juxingmogu1"));

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

			event.getRegistry().register(feature.setRegistryName("mo_gu_ju_shu_1"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("seasons_psyimagar:mo_gu_ju_shu_1"), configuredFeature);
		}

	}

	@SubscribeEvent public static void addFeatureToBiomes(BiomeLoadingEvent event) {
				boolean biomeCriteria = false;
					if (new ResourceLocation("seasons_psyimagar:mo_gu_lin").equals(event.getName()))
						biomeCriteria = true;
				if (!biomeCriteria)
					return;

		event.getGeneration().getFeatures(GenerationStage.Decoration.
				SURFACE_STRUCTURES
				)
			 .add(() -> configuredFeature);
	}

}
