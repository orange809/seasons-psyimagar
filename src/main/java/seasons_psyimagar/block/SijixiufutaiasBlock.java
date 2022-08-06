

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class SijixiufutaiasBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:seasons_alter")
	public static final Block block = null;


	public SijixiufutaiasBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 6);



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
			Block.Properties.create(Material.ROCK)
				.sound(SoundType.STONE)
				.hardnessAndResistance(10f, 10f)
				.setLightLevel(s -> 0)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool()
				.notSolid()
				.setOpaque((bs, br, bp) -> false)
			);

            this.setDefaultState(this.stateContainer.getBaseState()
                                     .with(WATERLOGGED, false)
            );

			setRegistryName("seasons_alter");
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












		@Override public PushReaction getPushReaction(BlockState state) {
			return PushReaction.BLOCK;
		}


			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}













	}



}
