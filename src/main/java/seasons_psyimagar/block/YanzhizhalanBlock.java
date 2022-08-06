

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class YanzhizhalanBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:yanzhizhalan")
	public static final Block block = null;


	public YanzhizhalanBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 78);



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
				FenceBlock
 {



		public CustomBlock() {
			super(
			Block.Properties.create(Material.WOOD)
				.sound(SoundType.WOOD)
				.hardnessAndResistance(1.5f, 2f)
				.setLightLevel(s -> 0)
				.notSolid()
				.setOpaque((bs, br, bp) -> false)
			);


			setRegistryName("yanzhizhalan");
		}

		@Override public boolean canConnect(BlockState state, boolean checkattach, Direction face) {
    	  boolean flag = state.getBlock() instanceof FenceBlock && state.getMaterial() == this.material;
    	  boolean flag1 = state.getBlock() instanceof FenceGateBlock && FenceGateBlock.isParallel(state, face);
    	  return !cannotAttach(state.getBlock()) && checkattach || flag || flag1;
   		}




        @OnlyIn(Dist.CLIENT) public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
			return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
		}





















			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}







		@Override public void onBlockClicked(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity) {
			super.onBlockClicked(blockstate, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
    


        YanzhimubanDangWanJiaKaiShiPoPiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}






	}



}
