

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class HuijincaofangkuaiBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:huijincaofangkuai")
	public static final Block block = null;


	public HuijincaofangkuaiBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 27);



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
				.harvestLevel(0)
				.harvestTool(ToolType.SHOVEL)
				.setRequiresTool()
				.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true)
			);


			setRegistryName("huijincaofangkuai");
		}





        @OnlyIn(Dist.CLIENT) public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
			return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
		}


		@Override public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}















        @Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
		}




			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(NituBlock.block));
			}













	}



}
