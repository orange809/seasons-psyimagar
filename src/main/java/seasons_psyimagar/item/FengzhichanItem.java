
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class FengzhichanItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:fengzhichan")
	public static final Item block = null;

	public FengzhichanItem (SeasonsPsyimagarModElements instance) {
		super(instance, 249);
	}

	@Override public void initElements() {
		elements.items.add(() ->
			new ShovelItem(new IItemTier() {
				public int getMaxUses() {
					return 500;
				}

   				public float getEfficiency() {
					return 13f;
				}

   				public float getAttackDamage() {
					return 2f;
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
			 ,-3f, new Item.Properties()
			 	.group(SeasonsPsyimagarItemGroup.tab)
			 ) {












		}.setRegistryName("fengzhichan"));
	}


}
