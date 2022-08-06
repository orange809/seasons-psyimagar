
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag public class DeveloperMedallionItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:developer_medallion")
	public static final Item block = null;

	public DeveloperMedallionItem(SeasonsPsyimagarModElements instance) {
		super(instance, 697);

	}


	@Override public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}


	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties()
					.group(null)
					.maxStackSize(1)
					.isImmuneToFire()
					.rarity(Rarity.COMMON)
			);
			setRegistryName("developer_medallion");
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















	}


}
