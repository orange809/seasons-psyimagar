

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class ShumuBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:shumu")
	public static final Block block = null;


	public ShumuBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 29);



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

		public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;


		public CustomBlock() {
			super(
			Block.Properties.create(Material.WOOD)
				.sound(SoundType.WOOD)
				.hardnessAndResistance(1.5f, 2f)
				.setLightLevel(s -> 0)
			);

            this.setDefaultState(this.stateContainer.getBaseState()
                                     .with(AXIS, Direction.Axis.Y)
            );

			setRegistryName("shumu");
		}







		@Override public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}


		@Override protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	  			builder.add(AXIS);
   		}

			@Override public BlockState rotate(BlockState state, Rotation rot) {
				if(rot == Rotation.CLOCKWISE_90 || rot == Rotation.COUNTERCLOCKWISE_90) {
					if ((Direction.Axis) state.get(AXIS) == Direction.Axis.X) {
						return state.with(AXIS, Direction.Axis.Z);
					} else if ((Direction.Axis) state.get(AXIS) == Direction.Axis.Z) {
						return state.with(AXIS, Direction.Axis.X);
					}
				}
				return state;
			}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
		    Direction.Axis axis = context.getFace().getAxis();
;
			return this.getDefaultState()
                    .with(AXIS, axis)
;
		}







		@Override public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 30;
		}










			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}













	}



}
