

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class LeimingzhikuaiBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:leimingzhikuai")
	public static final Block block = null;


	public LeimingzhikuaiBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 106);



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
			Block.Properties.create(Material.ROCK)
				.sound(SoundType.STONE)
				.hardnessAndResistance(5f, 30f)
				.setLightLevel(s -> 0)
				.harvestLevel(2)
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool()
			);


			setRegistryName("leimingzhikuai");
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



















			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}













	}



}
