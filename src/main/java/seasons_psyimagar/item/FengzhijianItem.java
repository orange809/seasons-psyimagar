
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class FengzhijianItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:fengzhijian")
	public static final Item block = null;

	public FengzhijianItem (SeasonsPsyimagarModElements instance) {
		super(instance, 241);
	}

	@Override public void initElements() {
		elements.items.add(() ->
			new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 300;
				}

   				public float getEfficiency() {
					return 0f;
				}

   				public float getAttackDamage() {
					return -2f;
				}

   				public int getHarvestLevel() {
					return 0;
				}

   				public int getEnchantability() {
					return 10;
				}

   				public Ingredient getRepairMaterial() {
					return Ingredient.fromStacks(
							new ItemStack(FengzhibaoshiItem.block)
							);
				}
			}, 3
			 ,-2.4f, new Item.Properties()
			 	.group(SeasonsPsyimagarItemGroup.tab)
			 ) {







		@Override public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity){
			boolean retval = super.hitEntity(itemstack,entity,sourceentity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
    


        FengzhijianDangShiTiBeiGongJuJiZhongShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}





		}.setRegistryName("fengzhijian"));
	}


}
