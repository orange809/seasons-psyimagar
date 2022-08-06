
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag public class FengzhiyumaoItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:fengzhiyumao")
	public static final Item block = null;

	public FengzhiyumaoItem(SeasonsPsyimagarModElements instance) {
		super(instance, 260);

	}


	@Override public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}


	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties()
					.group(SeasonsPsyimagarItemGroup.tab)
					.maxDamage(350)
					.rarity(Rarity.COMMON)
			);
			setRegistryName("fengzhiyumao");
		}

        @Override public UseAction getUseAction(ItemStack itemstack) {
            return UseAction.EAT;
        }



		@Override public int getItemEnchantability() {
			return 0;
		}

		@Override public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}



		@Override public boolean canHarvestBlock(BlockState state) {
			return true;
		}


		@Override public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();


    


        FengzhiyumaoDangYouJianDianJiKongQiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity),new AbstractMap.SimpleEntry<>("itemstack", itemstack)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return ar;
		}










	}


}
