
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag public class ZongyeItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:zongye")
	public static final Item block = null;

	public ZongyeItem(SeasonsPsyimagarModElements instance) {
		super(instance, 218);

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
			setRegistryName("zongye");
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
