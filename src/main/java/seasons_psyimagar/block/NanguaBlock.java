

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class NanguaBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:nangua")
	public static final Block block = null;


	public NanguaBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 108);



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

		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;


		public CustomBlock() {
			super(
			Block.Properties.create(Material.WOOD)
				.sound(SoundType.WOOD)
				.hardnessAndResistance(1.5f, 2f)
				.setLightLevel(s -> 0)
				.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true)
			);

            this.setDefaultState(this.stateContainer.getBaseState()
                                     .with(FACING, Direction.NORTH)
            );

			setRegistryName("nangua");
		}





        @OnlyIn(Dist.CLIENT) public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
			return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
		}


		@Override public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}


		@Override protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	  			builder.add(FACING);
   		}

			public BlockState rotate(BlockState state, Rotation rot) {
      			return state.with(FACING, rot.rotate(state.get(FACING)));
   			}

   			public BlockState mirror(BlockState state, Mirror mirrorIn) {
      			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
   			}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
;
			return this.getDefaultState()
			        .with(FACING, context.getPlacementHorizontalFacing().getOpposite())
;
		}







		@Override public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 30;
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
    


        NanguaDangFangKuaiBeiWanJiaPoPiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}








	}



}
