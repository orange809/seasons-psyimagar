

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class Shuidao1Block extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:shuidao_1")
	public static final Block block = null;


	public Shuidao1Block (SeasonsPsyimagarModElements instance) {
		super(instance, 209);



	}

	@Override public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties()
		                             .group(SeasonsPsyimagarItemGroup.tab)
		                             ).setRegistryName(block.getRegistryName()));
	}


	@Override @OnlyIn(Dist.CLIENT) public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	

	public static class CustomBlock extends
				Block
            implements IWaterLoggable
             {

        public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


		public CustomBlock() {
			super(
			Block.Properties.create(Material.PLANTS)
				.sound(SoundType.PLANT)
				.hardnessAndResistance(0.5f, 1f)
				.setLightLevel(s -> 0)
				.doesNotBlockMovement()
				.notSolid()
				.setOpaque((bs, br, bp) -> false)
			);

            this.setDefaultState(this.stateContainer.getBaseState()
                                     .with(WATERLOGGED, false)
            );

			setRegistryName("shuidao_1");
		}






		@Override public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return state.getFluidState().isEmpty();
		}

		@Override public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}




            @Override
            public BlockState getStateForPlacement(BlockItemUseContext context) {
            boolean flag = context.getWorld().getFluidState(context.getPos()).getFluid() == Fluids.WATER;
                return this.getDefaultState().with(WATERLOGGED, flag);
            }
            @Override protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
                builder.add(WATERLOGGED);
            }

        @Override public FluidState getFluidState(BlockState state) {
            return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
        }

		@Override public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
			if (state.get(WATERLOGGED)) {
				world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
			}
			return  super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
		}














			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}

		@Override public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
			super.onBlockAdded(blockstate, world, pos, oldState, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			world.getPendingBlockTicks().scheduleTick(pos, this, 1);
    


        Shuidao1FangZhiFangKuaiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}


		@Override public void tick
				(BlockState blockstate, ServerWorld world, BlockPos pos, Random random) {
			super.tick(blockstate, world, pos, random);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

    


        Shuidao1GengXinYouXiKeProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;

			world.getPendingBlockTicks().scheduleTick(pos, this, 1);
		}








		@Override
		public ActionResultType onBlockActivated(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, Hand hand, BlockRayTraceResult hit) {
			super.onBlockActivated(blockstate, world, pos, entity, hand, hit);

			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();


				double hitX = hit.getHitVec().x;
				double hitY = hit.getHitVec().y;
				double hitZ = hit.getHitVec().z;
				Direction direction = hit.getFace();
    


        Shuidao1ZaiFangKuaiShangYouJianProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;

			return ActionResultType.SUCCESS;
		}


	}



}
