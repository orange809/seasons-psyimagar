
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class ZhiregaoItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:zhiregao")
	public static final Item block = null;

	public ZhiregaoItem (SeasonsPsyimagarModElements instance) {
		super(instance, 246);
	}

	@Override public void initElements() {
		elements.items.add(() ->
			new PickaxeItem(new IItemTier() {
				public int getMaxUses() {
					return 500;
				}

   				public float getEfficiency() {
					return 4f;
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
					return Ingredient.EMPTY;
				}
			}, 1
			 ,-2.8f, new Item.Properties()
			 	.group(SeasonsPsyimagarItemGroup.tab)
			 	.isImmuneToFire()
			 ) {





		@Override public boolean onBlockDestroyed(ItemStack itemstack, World world, BlockState blockstate, BlockPos pos, LivingEntity entity){
			boolean retval = super.onBlockDestroyed(itemstack,world,blockstate,pos,entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
    


        ZhiregaoDangFangKuaiBeiGongJuPoPiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
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
    


        ZhiregaoDangGongJuChuXianZaiShouZhongShiProcedure.executeProcedure(Stream.of(
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
    


        ZhiregaoDangGongJuChuXianZaiShouZhongShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}


		}.setRegistryName("zhiregao"));
	}


}
