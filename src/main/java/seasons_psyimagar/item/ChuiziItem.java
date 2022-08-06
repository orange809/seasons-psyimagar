
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class ChuiziItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:chuizi")
	public static final Item block = null;

	public ChuiziItem (SeasonsPsyimagarModElements instance) {
		super(instance, 250);
	}

	@Override public void initElements() {
		elements.items.add(() ->
			new AxeItem(new IItemTier() {
				public int getMaxUses() {
					return 650;
				}

   				public float getEfficiency() {
					return 0f;
				}

   				public float getAttackDamage() {
					return 10f;
				}

   				public int getHarvestLevel() {
					return 0;
				}

   				public int getEnchantability() {
					return 11;
				}

   				public Ingredient getRepairMaterial() {
					return Ingredient.fromStacks(
							new ItemStack(Items.IRON_INGOT)
							);
				}
			}, 1
			 ,-3.65f, new Item.Properties()
			 	.group(SeasonsPsyimagarItemGroup.tab)
			 	.isImmuneToFire()
			 ) {



		@Override public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand){
			ActionResult<ItemStack> retval = super.onItemRightClick(world,entity,hand);
			ItemStack itemstack = retval.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
    


        ChuiziDangYouJiasdasdanDianJiKongQiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity),new AbstractMap.SimpleEntry<>("itemstack", itemstack)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}







		@Override public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (selected)
    


        ChuiziDangGongJuChuXianZaiShouZhongShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}


		}.setRegistryName("chuizi"));
	}


}
