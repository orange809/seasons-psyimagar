
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class ZhirejianItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:zhirejian")
	public static final Item block = null;

	public ZhirejianItem (SeasonsPsyimagarModElements instance) {
		super(instance, 240);
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
					return -1f;
				}

   				public int getHarvestLevel() {
					return 0;
				}

   				public int getEnchantability() {
					return 10;
				}

   				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}
			}, 3
			 ,-2.2f, new Item.Properties()
			 	.group(SeasonsPsyimagarItemGroup.tab)
			 	.isImmuneToFire()
			 ) {


		@Override public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\uFFFD\uFFFD\uFFFD\uFFFD\u02EB\uFFFD\uFFFD"));
		}





		@Override public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity){
			boolean retval = super.hitEntity(itemstack,entity,sourceentity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
    


        ZhirejianDangShiTiBeiGongJuJiZhongShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
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
    


        ZhirejianDangGongJuChuXianZaiShouZhongShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}


		}.setRegistryName("zhirejian"));
	}


}
