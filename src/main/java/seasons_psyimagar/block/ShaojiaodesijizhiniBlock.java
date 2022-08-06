

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class ShaojiaodesijizhiniBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:shaojiaodesijizhini")
	public static final Block block = null;


	public ShaojiaodesijizhiniBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 17);



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
				.hardnessAndResistance(3f, 0.5f)
				.setLightLevel(s -> 0)
				.harvestLevel(0)
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool()
			);


			setRegistryName("shaojiaodesijizhini");
		}





        @OnlyIn(Dist.CLIENT) public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
			return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
		}


		@Override public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}



















			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(ShaojiaodenituBlock.block));
			}













	}



}
