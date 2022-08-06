

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class DaixuedekuangshiduiBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:daixuedekuangshidui")
	public static final Block block = null;


	public DaixuedekuangshiduiBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 151);



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

		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
        public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


		public CustomBlock() {
			super(
			Block.Properties.create(Material.ROCK)
				.sound(SoundType.STONE)
				.hardnessAndResistance(2.5f, 10f)
				.setLightLevel(s -> 0)
				.harvestLevel(1)
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool()
				.notSolid()
				.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true)
				.setOpaque((bs, br, bp) -> false)
			);

            this.setDefaultState(this.stateContainer.getBaseState()
                                     .with(FACING, Direction.NORTH)
                                     .with(WATERLOGGED, false)
            );

			setRegistryName("daixuedekuangshidui");
		}






		@Override public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return state.getFluidState().isEmpty();
		}

		@Override public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}

		@Override public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
				Vector3d offset = state.getOffset(world, pos);
        switch ((Direction) state.get(FACING)) {
            case SOUTH:
            default:
    return 
    VoxelShapes.or(
                makeCuboidShape(14, 0, 15, 1, 10, 1)
 
    )
    
    .withOffset(offset.x, offset.y, offset.z);
            case NORTH:
    return 
    VoxelShapes.or(
                makeCuboidShape(2, 0, 1, 15, 10, 15)
 
    )
    
    .withOffset(offset.x, offset.y, offset.z);
            case EAST:
    return 
    VoxelShapes.or(
                makeCuboidShape(15, 0, 2, 1, 10, 15)
 
    )
    
    .withOffset(offset.x, offset.y, offset.z);
            case WEST:
    return 
    VoxelShapes.or(
                makeCuboidShape(1, 0, 14, 15, 10, 1)
 
    )
    
    .withOffset(offset.x, offset.y, offset.z);
        }
		}

		@Override protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	  			builder.add(FACING, WATERLOGGED);
   		}

			public BlockState rotate(BlockState state, Rotation rot) {
      			return state.with(FACING, rot.rotate(state.get(FACING)));
   			}

   			public BlockState mirror(BlockState state, Mirror mirrorIn) {
      			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
   			}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
            boolean flag = context.getWorld().getFluidState(context.getPos()).getFluid() == Fluids.WATER;
            ;
			return this.getDefaultState()
			        .with(FACING, context.getPlacementHorizontalFacing().getOpposite())
			        .with(WATERLOGGED, flag)
;
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
				return Collections.singletonList(new ItemStack(this, 0));
			}





		@Override
		public boolean removedByPlayer(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, boolean willHarvest, FluidState fluid) {
			boolean retval = super.removedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
    


        DaixuedekuangshiduiDangFangKuaiBeiWanJiaPoPiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}








	}



}
