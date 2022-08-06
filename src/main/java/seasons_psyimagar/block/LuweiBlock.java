
package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag public class LuweiBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:luwei")
	public static final Block block = null;


	public LuweiBlock(SeasonsPsyimagarModElements instance) {
		super(instance, 128);


		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());
	}

	@Override public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new TallBlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(block.getRegistryName()));
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

			    		    int x = pos.getX();
			    			int y = pos.getY();
			    			int z = pos.getZ();
			    			if (!


        LuweiFuJiaDeShengChengTiaoJianProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
)
								return false;

						return super.generate(world, generator, random, pos, config);
					}
				};

			configuredFeature = feature
					.withConfiguration((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(block.getDefaultState()),
											new DoublePlantBlockPlacer())).tries(64)
											.func_227317_b_().build()
			                          )
						.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(25)
					;

			event.getRegistry().register(feature.setRegistryName("luwei"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("seasons_psyimagar:luwei"), configuredFeature);
		}

	}

	@SubscribeEvent public void addFeatureToBiomes(BiomeLoadingEvent event) {
				boolean biomeCriteria = false;
					if (new ResourceLocation("seasons_psyimagar:feng_lin").equals(event.getName()))
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
			setRegistryName("luwei");
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
			    return Collections.singletonList(new ItemStack(this, 0));
		    }

			@Override public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {

				Block ground = state.getBlock();
				return
				(
						ground == QiuzhicaofangkuaiBlock.block
						
					)
				
				;
			}

			@Override public boolean isValidPosition(BlockState blockstate, IWorldReader worldIn, BlockPos pos) {
				BlockPos blockpos = pos.down();
				BlockState groundState = worldIn.getBlockState(blockpos);
				Block ground = groundState.getBlock();

					if (blockstate.get(HALF) == DoubleBlockHalf.UPPER)
						return groundState.isIn(this) && groundState.get(HALF) == DoubleBlockHalf.LOWER;
					else
						return this.isValidGround(groundState, worldIn, blockpos)
				;
			}

		@Override public PlantType getPlantType(IBlockReader world, BlockPos pos) {
			return PlantType.PLAINS;
		}






		@Override
		public boolean removedByPlayer(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity,
				boolean willHarvest, FluidState fluid) {
			boolean retval = super.removedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
    


        LuweiDangZhiWuBeiWanJiaPoPiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}






	}


}
