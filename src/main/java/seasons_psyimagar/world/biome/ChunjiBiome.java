
package seasons_psyimagar.world.biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraft.block.material.Material;
import java.util.ArrayList;
import java.util.HashMap;

@SeasonsPsyimagarModElements.ModElement.Tag public class ChunjiBiome extends SeasonsPsyimagarModElements.ModElement{

	public static Biome biome;

	public ChunjiBiome(SeasonsPsyimagarModElements instance) {
		super(instance, 327);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {

		@SubscribeEvent public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder()
						.setFogColor(-3211849)
						.setWaterColor(-6684724)
						.setWaterFogColor(-13382401)
						.withSkyColor(-3211849)
						.withFoliageColor(-6684775)
						.withGrassColor(-10027213)
                        .setMusic(new BackgroundMusicSelector((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("seasons_psyimagar:chun")), 12000, 24000, true))
                        .build();

				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(
								new SurfaceBuilderConfig(CaofangkuaiBlock.block.getDefaultState(),
									NituBlock.block.getDefaultState(),
									NituBlock.block.getDefaultState())));






















				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG)
						.withPlacement(Features.Placements.PATCH_PLACEMENT)
						.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 4))));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.SEAGRASS.withConfiguration(new ProbabilityConfig(0.3F))
								.func_242731_b(25)
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.FLOWER.withConfiguration(Features.Configs.NORMAL_FLOWER_CONFIG)
								.withPlacement(Features.Placements.VEGETATION_PLACEMENT)
								.withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
								.func_242731_b(5));



				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), FeatureSpread.func_242253_a(2, 4), 2,
								ImmutableList.of(CaofangkuaiBlock.block.getDefaultState(), NituBlock.block.getDefaultState())))
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(10));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), FeatureSpread.func_242253_a(2, 3), 2,
								ImmutableList.of(CaofangkuaiBlock.block.getDefaultState(), NituBlock.block.getDefaultState())))
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(10));



						DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
						DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
						DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);
						DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGenerationSettings);
						DefaultBiomeFeatures.withSimpleSeagrass(biomeGenerationSettings);

				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
						mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EntityType.BEE, 20, 2, 4));
						mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.COD, 200, 2, 4));
						mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.SALMON, 200, 2, 4));
						mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(BaoZhaKuaiEntity.entity, 15, 1, 2));
						mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(YezhuEntity.entity, 9, 1, 1));
						mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(ShuiguihuaEntity.entity, 8, 2, 4));

				biome = new Biome.Builder()
						.precipitation(Biome.RainType.RAIN)
						.category(Biome.Category.NONE)
						.depth(0f)
						.scale(0.1f)
						.temperature(0.7f)
						.downfall(0.8f)
						.setEffects(effects)
						.withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build())
						.build();

				event.getRegistry().register(biome.setRegistryName("seasons_psyimagar:fan_mao_yi_lin"));
			}
		}

	}

	@Override public void init(FMLCommonSetupEvent event) {
	}

	private static class CustomLeaveVineTreeDecorator extends LeaveVineTreeDecorator {

		public static final CustomLeaveVineTreeDecorator instance = new CustomLeaveVineTreeDecorator();
		public static com.mojang.serialization.Codec<LeaveVineTreeDecorator> codec;
		public static TreeDecoratorType tdt;

		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("fan_mao_yi_lin_lvtd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}

		@Override protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override protected void func_227424_a_(IWorldWriter ww, BlockPos bp, BooleanProperty bpr, Set<BlockPos> sbc, MutableBoundingBox mbb) {
			this.func_227423_a_(ww, bp, Blocks.AIR.getDefaultState(), sbc, mbb);
		}

	}

	private static class CustomTrunkVineTreeDecorator extends TrunkVineTreeDecorator {

		public static final CustomTrunkVineTreeDecorator instance = new CustomTrunkVineTreeDecorator();
		public static com.mojang.serialization.Codec<CustomTrunkVineTreeDecorator> codec;
		public static TreeDecoratorType tdt;

		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("fan_mao_yi_lin_tvtd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}

		@Override protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override protected void func_227424_a_(IWorldWriter ww, BlockPos bp, BooleanProperty bpr, Set<BlockPos> sbc, MutableBoundingBox mbb) {
			this.func_227423_a_(ww, bp, Blocks.AIR.getDefaultState(), sbc, mbb);
		}

	}

	private static class CustomCocoaTreeDecorator extends CocoaTreeDecorator {

		public static final CustomCocoaTreeDecorator instance = new CustomCocoaTreeDecorator();
		public static com.mojang.serialization.Codec<CustomCocoaTreeDecorator> codec;
		public static TreeDecoratorType tdt;

		static {
			codec = com.mojang.serialization.Codec.unit(() -> instance);
			tdt = new TreeDecoratorType(codec);
			tdt.setRegistryName("fan_mao_yi_lin_ctd");
			ForgeRegistries.TREE_DECORATOR_TYPES.register(tdt);
		}

		public CustomCocoaTreeDecorator() {
			super(0.2f);
		}

		@Override protected TreeDecoratorType<?> func_230380_a_() {
			return tdt;
		}

		@Override /* failed to load code for net.minecraft.world.gen.treedecorator.CocoaTreeDecorator */

	}

}

