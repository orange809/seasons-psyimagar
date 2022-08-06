

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class QiuzhiloutiBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:qiuzhilouti")
	public static final Block block = null;


	public QiuzhiloutiBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 85);



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
				StairsBlock
 {



		public CustomBlock() {
			super(() -> new Block(			Block.Properties.create(Material.WOOD)
				.sound(SoundType.WOOD)
				.hardnessAndResistance(0.75f, 2f)
				.setLightLevel(s -> 0)
				.notSolid()
				.setOpaque((bs, br, bp) -> false)
).getDefaultState(),
			Block.Properties.create(Material.WOOD)
				.sound(SoundType.WOOD)
				.hardnessAndResistance(0.75f, 2f)
				.setLightLevel(s -> 0)
				.notSolid()
				.setOpaque((bs, br, bp) -> false)
			);


			setRegistryName("qiuzhilouti");
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
