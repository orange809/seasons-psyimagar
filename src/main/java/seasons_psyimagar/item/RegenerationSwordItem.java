
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class RegenerationSwordItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:regeneration_sword")
	public static final Item block = null;

	public RegenerationSwordItem (SeasonsPsyimagarModElements instance) {
		super(instance, 245);
	}

	@Override public void initElements() {
		elements.items.add(() ->
			new PickaxeItem(new IItemTier() {
				public int getMaxUses() {
					return 500;
				}

   				public float getEfficiency() {
					return 0f;
				}

   				public float getAttackDamage() {
					return -1f;
				}

   				public int getHarvestLevel() {
					return 0;
				}

   				public int getEnchantability() {
					return 0;
				}

   				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 1
			 ,96f, new Item.Properties()
			 	.group(SeasonsPsyimagarItemGroup.tab)
			 ) {







		@Override public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity){
			boolean retval = super.hitEntity(itemstack,entity,sourceentity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
    


        RegenerationSwordLivingEntityIsHitWithToolProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity),new AbstractMap.SimpleEntry<>("sourceentity", sourceentity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}





		}.setRegistryName("regeneration_sword"));
	}


}
