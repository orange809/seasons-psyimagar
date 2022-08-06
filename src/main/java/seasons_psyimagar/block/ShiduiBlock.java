
package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag public class ShiduiBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:shidui")
	public static final Block block = null;


	public ShiduiBlock(SeasonsPsyimagarModElements instance) {
		super(instance, 150);


		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());
	}

	@Override public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}


	@Override @OnlyIn(Dist.CLIENT) public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}


	private static Feature<BlockClusterFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;

	private static class FeatureRegisterHandler {

		@SubscribeEvent public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
				feature = new DefaultFlowersFeature(BlockClusterFeatureConfig.field_236587_a_) {
					@Override public BlockState getFlowerToPlace(Random random, BlockPos bp, BlockClusterFeatureConfig fc) {
						return block.getDefaultState();
					}

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
											new SimpleBlockPlacer())).tries(64)
											.build()
			                          )
						.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5)
					;

			event.getRegistry().register(feature.setRegistryName("shidui"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("seasons_psyimagar:shidui"), configuredFeature);
		}

	}

	@SubscribeEvent public void addFeatureToBiomes(BiomeLoadingEvent event) {
				boolean biomeCriteria = false;
					if (new ResourceLocation("seasons_psyimagar:fan_mao_yi_lin").equals(event.getName()))
						biomeCriteria = true;
					if (new ResourceLocation("seasons_psyimagar:han_chao_lin").equals(event.getName()))
						biomeCriteria = true;
					if (new ResourceLocation("seasons_psyimagar:feng_lin").equals(event.getName()))
						biomeCriteria = true;
					if (new ResourceLocation("seasons_psyimagar:mo_gu_lin").equals(event.getName()))
						biomeCriteria = true;
				if (!biomeCriteria)
					return;

		event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION)
				.add(() -> configuredFeature);
	}

	public static class BlockCustomFlower extends FlowerBlock {

		public BlockCustomFlower() {
			super(
				Effects.SATURATION, 0,
					Block.Properties.create(Material.PLANTS)
					.doesNotBlockMovement()
						.sound(SoundType.STONE)
					.hardnessAndResistance(0.3f, 0.1f)
					.setLightLevel(s -> 1)
			);
			setRegistryName("shidui");
		}



		@Override public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
				 Vector3d offset = state.getOffset(world, pos); 
    return 
    VoxelShapes.or(
                makeCuboidShape(2, 0, 2, 14, 4, 14)
 
    )
    
    .withOffset(offset.x, offset.y, offset.z);
		}


		@Override public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 100;
		}




		@Override public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 60;
		}


		    @Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

                List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			    if(!dropsOriginal.isEmpty())
				    return dropsOriginal;
			    return Collections.singletonList(new ItemStack(this, 0));
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
    


        ShiduiDangZhiWuBeiWanJiaPoPiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}






	}


}
