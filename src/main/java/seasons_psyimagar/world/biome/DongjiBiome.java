
package seasons_psyimagar.world.biome;

import net.minecraftforge.common.BiomeManager;
import net.minecraft.block.material.Material;
import java.util.ArrayList;
import java.util.HashMap;

@SeasonsPsyimagarModElements.ModElement.Tag public class DongjiBiome extends SeasonsPsyimagarModElements.ModElement{

	public static Biome biome;

	public DongjiBiome(SeasonsPsyimagarModElements instance) {
		super(instance, 342);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BiomeRegisterHandler());
	}

	private static class BiomeRegisterHandler {

		@SubscribeEvent public void registerBiomes(RegistryEvent.Register<Biome> event) {
			if (biome == null) {
				BiomeAmbience effects = new BiomeAmbience.Builder()
						.setFogColor(-3545094)
						.setWaterColor(-1)
						.setWaterFogColor(-1)
						.withSkyColor(-3545094)
						.withFoliageColor(-3342337)
						.withGrassColor(-1)
                        .setMusic(new BackgroundMusicSelector((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("seasons_psyimagar:dong")), 12000, 24000, true))
                        .setParticle(new ParticleEffectAmbience(XuehuaParticle.particle, 0.025f))
                        .build();

				BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder()
						.withSurfaceBuilder(SurfaceBuilder.DEFAULT.func_242929_a(
								new SurfaceBuilderConfig(DongzhimuBlock.block.getDefaultState(),
									NituBlock.block.getDefaultState(),
									NituBlock.block.getDefaultState())));










				biomeGenerationSettings.withStructure(StructureFeatures.IGLOO);












				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(Features.Configs.GRASS_PATCH_CONFIG)
						.withPlacement(Features.Placements.PATCH_PLACEMENT)
						.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 5, 6))));

				biomeGenerationSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.SEAGRASS.withConfiguration(new ProbabilityConfig(0.3F))
								.func_242731_b(10)
								.withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT));








						DefaultBiomeFeatures.withCavesAndCanyons(biomeGenerationSettings);
						DefaultBiomeFeatures.withOverworldOres(biomeGenerationSettings);
						DefaultBiomeFeatures.withFrozenTopLayer(biomeGenerationSettings);
						DefaultBiomeFeatures.withLavaAndWaterLakes(biomeGenerationSettings);
						DefaultBiomeFeatures.withSimpleSeagrass(biomeGenerationSettings);

				MobSpawnInfo.Builder mobSpawnInfo = new MobSpawnInfo.Builder().isValidSpawnBiomeForPlayer();
						mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(QieEntity.entity, 18, 2, 4));
						mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(XiyouqieEntity.entity, 5, 1, 3));
						mobSpawnInfo.withSpawner(EntityClassification.WATER_CREATURE, new MobSpawnInfo.Spawners(ShuiguihuaEntity.entity, 4, 2, 4));
						mobSpawnInfo.withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(TuboshushuijiaoEntity.entity, 7, 1, 3));

				biome = new Biome.Builder()
						.precipitation(Biome.RainType.NONE)
						.category(Biome.Category.NONE)
						.depth(0f)
						.scale(1.5f)
						.temperature(2f)
						.downfall(0f)
						.setEffects(effects)
						.withMobSpawnSettings(mobSpawnInfo.copy())
						.withGenerationSettings(biomeGenerationSettings.build())
						.build();

				event.getRegistry().register(biome.setRegistryName("seasons_psyimagar:han_chao_lin"));
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
			tdt.setRegistryName("han_chao_lin_lvtd");
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
			tdt.setRegistryName("han_chao_lin_tvtd");
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
			tdt.setRegistryName("han_chao_lin_ctd");
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

