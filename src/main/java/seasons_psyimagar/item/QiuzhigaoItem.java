
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class QiuzhigaoItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:qiuzhigao")
	public static final Item block = null;

	public QiuzhigaoItem (SeasonsPsyimagarModElements instance) {
		super(instance, 247);
	}

	@Override public void initElements() {
		elements.items.add(() ->
			new PickaxeItem(new IItemTier() {
				public int getMaxUses() {
					return 500;
				}

   				public float getEfficiency() {
					return 13f;
				}

   				public float getAttackDamage() {
					return 3f;
				}

   				public int getHarvestLevel() {
					return 4;
				}

   				public int getEnchantability() {
					return 0;
				}

   				public Ingredient getRepairMaterial() {
					return Ingredient.fromStacks(
							new ItemStack(FengzhidingItem.block)
							);
				}
			}, 1
			 ,-2.8f, new Item.Properties()
			 	.group(SeasonsPsyimagarItemGroup.tab)
			 ) {












		}.setRegistryName("qiuzhigao"));
	}


}
