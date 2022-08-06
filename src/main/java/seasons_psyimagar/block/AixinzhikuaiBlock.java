

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class AixinzhikuaiBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:aixinzhikuai")
	public static final Block block = null;


	public AixinzhikuaiBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 105);



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
			Block.Properties.create(Material.ROCK)
				.sound(SoundType.STONE)
				.hardnessAndResistance(2f, 10f)
				.setLightLevel(s -> 0)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool()
			);

            this.setDefaultState(this.stateContainer.getBaseState()
                                     .with(FACING, Direction.NORTH)
            );

			setRegistryName("aixinzhikuai");
		}





        @OnlyIn(Dist.CLIENT) public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
			return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
		}

		@Override public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
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

















			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}




		@OnlyIn(Dist.CLIENT) @Override
		public void animateTick(BlockState blockstate, World world, BlockPos pos, Random random) {
			super.animateTick(blockstate, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
if(        true
)
	for (int l = 0; l < 2; ++l) {
	    double d0 = (x + random.nextFloat());
	    double d1 = (y + random.nextFloat());
	    double d2 = (z + random.nextFloat());
	    int i1 = random.nextInt(2) * 2 - 1;
	    double d3 = (random.nextFloat() - 0.5D) * 1D;
	    double d4 = (random.nextFloat() - 0.5D) * 1D;
	    double d5 = (random.nextFloat() - 0.5D) * 1D;
	    world.addParticle(ParticleTypes.HEART, d0, d1, d2, d3, d4, d5);
	}
		}









	}



}
