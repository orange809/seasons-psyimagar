
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag public class CaidaoItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:caidao")
	public static final Item block = null;

	public CaidaoItem(SeasonsPsyimagarModElements instance) {
		super(instance, 223);

	}


	@Override public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}


	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties()
					.group(SeasonsPsyimagarItemGroup.tab)
					.maxDamage(200)
					.rarity(Rarity.COMMON)
			);
			setRegistryName("caidao");
		}

        @Override public UseAction getUseAction(ItemStack itemstack) {
            return UseAction.EAT;
        }


			@Override public boolean hasContainerItem() {
				return true;
			}

				@Override public ItemStack getContainerItem(ItemStack itemstack) {
					ItemStack retval = new ItemStack(this);
					retval.setDamage(itemstack.getDamage() + 1);
					if(retval.getDamage() >= retval.getMaxDamage()) {
						return ItemStack.EMPTY;
					}
					return retval;
				}

				@Override public boolean isRepairable(ItemStack itemstack) {
					return false;
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
