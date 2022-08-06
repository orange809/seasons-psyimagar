

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class YingzhicaofangkuaiBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:yingzhicaofangkuai")
	public static final Block block = null;


	public YingzhicaofangkuaiBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 16);

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
			Block.Properties.create(Material.ORGANIC)
				.sound(SoundType.GROUND)
				.hardnessAndResistance(0.5f, 0.5f)
				.setLightLevel(s -> 0)
			);


			setRegistryName("yingzhicaofangkuai");
		}





        @OnlyIn(Dist.CLIENT) public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
			return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
		}


		@Override public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}



















			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(NituBlock.block));
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

			if(blockAt.getBlock() == CaofangkuaiBlock.block)
				blockCriteria = true;

			return blockCriteria;
		}

		protected IRuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}

	}

	private static class FeatureRegisterHandler {

		@SubscribeEvent public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			CUSTOM_MATCH = Registry.register(Registry.RULE_TEST, new ResourceLocation("seasons_psyimagar:yingzhicaofangkuai_match"), () -> CustomRuleTest.codec);

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
					.withConfiguration(new OreFeatureConfig(CustomRuleTest.INSTANCE, block.getDefaultState(), 20))
					    .range(140)
					.square()
					.func_242731_b(20);

			event.getRegistry().register(feature.setRegistryName("yingzhicaofangkuai"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("seasons_psyimagar:yingzhicaofangkuai"), configuredFeature);
		}

	}

	@SubscribeEvent public void addFeatureToBiomes(BiomeLoadingEvent event) {
				boolean biomeCriteria = false;
					if (new ResourceLocation("seasons_psyimagar:fan_mao_yi_lin").equals(event.getName()))
						biomeCriteria = true;
				if (!biomeCriteria)
					return;
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> configuredFeature);
	}

}
