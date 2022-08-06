
package seasons_psyimagar.world.biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraft.block.material.Material;
import java.util.ArrayList;
import java.util.HashMap;

@SeasonsPsyimagarModElements.ModElement.Tag public class QiujiqunxiBiome extends SeasonsPsyimagarModElements.ModElement{

	public static Biome biome;

	public QiujiqunxiBiome(SeasonsPsyimagarModElements instance) {
		super(instance, 382);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {

		@SubscribeEvent public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder()
						.setFogColor(-208460)
						.setWaterColor(-39424)
						.setWaterFogColor(-39424)
						.withSkyColor(-208460)
						.withFoliageColor(-26317)
						.withGrassColor(-39424)
                        .setMusic(new BackgroundMusicSelector((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("seasons_psyimagar:qiu")), 12000, 24000, true))
                        .setParticle(new ParticleEffectAmbience(LuoyeParticle.particle, 0.003f))
                        .build();

				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(
								new SurfaceBuilderConfig(QiuzhicaofangkuaiBlock.block.getDefaultState(),
									NituBlock.block.getDefaultState(),
									NituBlock.block.getDefaultState())));






















				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG)
						.withPlacement(Features.Placements.PATCH_PLACEMENT)
						.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 12))));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.SEAGRASS.withConfiguration(new ProbabilityConfig(0.3F))
								.func_242731_b(20)
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));




				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), FeatureSpread.func_242253_a(2, 4), 2,
								ImmutableList.of(QiuzhicaofangkuaiBlock.block.getDefaultState(), NituBlock.block.getDefaultState())))
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(15));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.DISK.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), FeatureSpread.func_242253_a(2, 3), 2,
								ImmutableList.of(QiuzhicaofangkuaiBlock.block.getDefaultState(), NituBlock.block.getDefaultState())))
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT).func_242731_b(15));



						DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
						DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
						DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGenerationSettings);
						DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);
						DefaultBiomeFeatures.withSimpleSeagrass(biomeGenerationSettings);

				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
						mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.COD, 300, 2, 5));
						mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(EntityType.SALMON, 300, 2, 5));
						mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(JijingxiaoEntity.entity, 14, 2, 4));

				biome = new Biome.Builder()
						.precipitation(Biome.RainType.NONE)
						.category(Biome.Category.NONE)
						.depth(0f)
						.scale(0.2f)
						.temperature(0.4f)
						.downfall(0f)
						.setEffects(effects)
						.withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build())
						.build();

				event.getRegistry().register(biome.setRegistryName("seasons_psyimagar:feng_lin"));
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
			tdt.setRegistryName("feng_lin_lvtd");
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
			tdt.setRegistryName("feng_lin_tvtd");
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
			tdt.setRegistryName("feng_lin_ctd");
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

