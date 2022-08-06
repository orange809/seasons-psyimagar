
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class ChijianItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:chijian")
	public static final Item block = null;

	public ChijianItem (SeasonsPsyimagarModElements instance) {
		super(instance, 239);
	}

	@Override public void initElements() {
		elements.items.add(() ->
			new SwordItem(new IItemTier() {
				public int getMaxUses() {
					return 550;
				}

   				public float getEfficiency() {
					return 0f;
				}

   				public float getAttackDamage() {
					return 1.9999999999999996f;
				}

   				public int getHarvestLevel() {
					return 0;
				}

   				public int getEnchantability() {
					return 15;
				}

   				public Ingredient getRepairMaterial() {
					return Ingredient.fromStacks(
							new ItemStack(YezhuyachiItem.block)
							);
				}
			}, 3
			 ,-2.6f, new Item.Properties()
			 	.group(SeasonsPsyimagarItemGroup.tab)
			 	.isImmuneToFire()
			 ) {



		@Override public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand){
			ActionResult<ItemStack> retval = super.onItemRightClick(world,entity,hand);
			ItemStack itemstack = retval.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
    


        ChijianDangYouJianDianJiKongQiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity),new AbstractMap.SimpleEntry<>("itemstack", itemstack)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}




		@Override public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity){
			boolean retval = super.hitEntity(itemstack,entity,sourceentity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
    


        ChijianDangShiTiBeiGongJuJiZhongShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}





		}.setRegistryName("chijian"));
	}


}
