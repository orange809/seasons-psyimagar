
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class QiuzhifuItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:qiuzhifu")
	public static final Item block = null;

	public QiuzhifuItem (SeasonsPsyimagarModElements instance) {
		super(instance, 248);
	}

	@Override public void initElements() {
		elements.items.add(() ->
			new AxeItem(new IItemTier() {
				public int getMaxUses() {
					return 500;
				}

   				public float getEfficiency() {
					return 13f;
				}

   				public float getAttackDamage() {
					return 6f;
				}

   				public int getHarvestLevel() {
					return 4;
				}

   				public int getEnchantability() {
					return 0;
				}

   				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 1
			 ,-3.1f, new Item.Properties()
			 	.group(SeasonsPsyimagarItemGroup.tab)
			 ) {












		}.setRegistryName("qiuzhifu"));
	}


}
