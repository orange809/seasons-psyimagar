
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag public class QianHaiHuaBanItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:qian_hai_hua_ban")
	public static final Item block = null;

	public QianHaiHuaBanItem(SeasonsPsyimagarModElements instance) {
		super(instance, 195);

	}


	@Override public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}


	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties()
					.group(SeasonsPsyimagarItemGroup.tab)
					.maxStackSize(64)
					.rarity(Rarity.COMMON)
			);
			setRegistryName("qian_hai_hua_ban");
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












	}


}
