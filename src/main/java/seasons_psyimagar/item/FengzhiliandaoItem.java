
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class FengzhiliandaoItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:fengzhiliandao")
	public static final Item block = null;

	public FengzhiliandaoItem (SeasonsPsyimagarModElements instance) {
		super(instance, 252);
	}

	@Override public void initElements() {
		elements.items.add(() ->
			new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 400;
				}

   				public float getEfficiency() {
					return 0f;
				}

   				public float getAttackDamage() {
					return 4f;
				}

   				public int getHarvestLevel() {
					return 0;
				}

   				public int getEnchantability() {
					return 10;
				}

   				public Ingredient getRepairMaterial() {
					return Ingredient.fromStacks(
							new ItemStack(FengzhidingItem.block)
							);
				}
			}, 3
			 ,-2.7999999999999998f, new Item.Properties()
			 	.group(SeasonsPsyimagarItemGroup.tab)
			 ) {







		@Override public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity){
			boolean retval = super.hitEntity(itemstack,entity,sourceentity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
    


        FengzhiliandaoDangShiTiBeiGongJuJiZhongShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("sourceentity", sourceentity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}





		}.setRegistryName("fengzhiliandao"));
	}


}
