
package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag public class HuahuaBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:huahua")
	public static final Block block = null;


	public HuahuaBlock(SeasonsPsyimagarModElements instance) {
		super(instance, 120);


		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());
	}

	@Override public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new TallBlockItem(block, new Item.Properties().group(SeasonsPsyimagarItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}


	@Override @OnlyIn(Dist.CLIENT) public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}


	private static Feature<BlockClusterFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;

	private static class FeatureRegisterHandler {

		@SubscribeEvent public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new RandomPatchFeature(BlockClusterFeatureConfig.field_236587_a_) {
					@Override public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, BlockClusterFeatureConfig config) {
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;

			    				if(dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("seasons_psyimagar:sijishijie")))
									dimensionCriteria = true;

						if(!dimensionCriteria)
							return false;


						return super.generate(world, generator, random, pos, config);
					}
				};

			configuredFeature = feature
					.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(block.getDefaultState()),
											new DoublePlantBlockPlacer())).tries(64)
											.func_227317_b_().build()
			                          )
						.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5)
					;

			event.getRegistry().register(feature.setRegistryName("huahua"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("seasons_psyimagar:huahua"), configuredFeature);
		}

	}

	@SubscribeEvent public void addFeatureToBiomes(BiomeLoadingEvent event) {
				boolean biomeCriteria = false;
					if (new ResourceLocation("seasons_psyimagar:fan_mao_yi_lin").equals(event.getName()))
						biomeCriteria = true;
				if (!biomeCriteria)
					return;

		event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)
				.add(() -> configuredFeature);
	}

	public static class BlockCustomFlower extends DoublePlantBlock {

		public BlockCustomFlower() {
			super(
					Block.Properties.create(Material.PLANTS)
					.doesNotBlockMovement()
						.sound(SoundType.PLANT)
					.hardnessAndResistance(0f, 0f)
					.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true)
					.setLightLevel(s -> 1)
			);
			setRegistryName("huahua");
		}




		@Override public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 100;
		}


		@Override public Block.OffsetType getOffsetType() {
			return Block.OffsetType.XYZ;
		}


		@Override public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 60;
		}


		    @Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
                if(state.get(BlockStateProperties.DOUBLE_BLOCK_HALF) != DoubleBlockHalf.LOWER)
                    return Collections.emptyList();

                List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			    if(!dropsOriginal.isEmpty())
				    return dropsOriginal;
			    return Collections.singletonList(new ItemStack(this, 1));
		    }


		@Override public PlantType getPlantType(IBlockReader world, BlockPos pos) {
			return PlantType.PLAINS;
		}












	}


}
