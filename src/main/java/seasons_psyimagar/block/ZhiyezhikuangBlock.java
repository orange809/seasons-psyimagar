

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class ZhiyezhikuangBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:zhiyezhikuang")
	public static final Block block = null;


	public ZhiyezhikuangBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 41);

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());


	}

	@Override public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties()
		                             .group(SeasonsPsyimagarItemGroup.tab)
		                             ).setRegistryName(block.getRegistryName()));
	}




	public static class CustomBlock extends
				Block
 {



		public CustomBlock() {
			super(
			Block.Properties.create(Material.ROCK)
				.sound(SoundType.STONE)
				.hardnessAndResistance(6f, 50f)
				.setLightLevel(s -> 0)
			);


			setRegistryName("zhiyezhikuang");
		}



		@Override public boolean shouldDisplayFluidOverlay(BlockState state, IBlockDisplayReader world, BlockPos pos, FluidState fluidstate) {
			return true;
		}




		@Override public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}
























		@Override
		public boolean removedByPlayer(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, boolean willHarvest, FluidState fluid) {
			boolean retval = super.removedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
    


        ZhiyezhikuangDangFangKuaiBeiWanJiaPoPiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}








	}


	private static Feature<OreFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;

	private static IRuleTestType<CustomRuleTest> CUSTOM_MATCH = null;

	private static class CustomRuleTest extends RuleTest {

		static final CustomRuleTest INSTANCE = new CustomRuleTest();
		static final com.mojang.serialization.Codec<CustomRuleTest> codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);

		public boolean test(BlockState blockAt, Random random) {
			boolean blockCriteria = false;

			if(blockAt.getBlock() == JishiBlock.block)
				blockCriteria = true;

			return blockCriteria;
		}

		protected IRuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}

	}

	private static class FeatureRegisterHandler {

		@SubscribeEvent public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			CUSTOM_MATCH = Registry.register(Registry.RULE_TEST, new ResourceLocation("seasons_psyimagar:zhiyezhikuang_match"), () -> CustomRuleTest.codec);

			feature = new OreFeature(OreFeatureConfig.CODEC) {
				@Override public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
					RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
					boolean dimensionCriteria = false;

							if(dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("seasons_psyimagar:sijishijie")))
								dimensionCriteria = true;

					if(!dimensionCriteria)
						return false;


					return super.generate(world, generator, rand, pos, config);
				}
			};

			configuredFeature = feature
					.withConfiguration(new OreFeatureConfig(CustomRuleTest.INSTANCE, block.getDefaultState(), 3))
					    .range(20)
					.square()
					.func_242731_b(7);

			event.getRegistry().register(feature.setRegistryName("zhiyezhikuang"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("seasons_psyimagar:zhiyezhikuang"), configuredFeature);
		}

	}

	@SubscribeEvent public void addFeatureToBiomes(BiomeLoadingEvent event) {
				boolean biomeCriteria = false;
					if (new ResourceLocation("seasons_psyimagar:mo_gu_lin").equals(event.getName()))
						biomeCriteria = true;
				if (!biomeCriteria)
					return;
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> configuredFeature);
	}

}
