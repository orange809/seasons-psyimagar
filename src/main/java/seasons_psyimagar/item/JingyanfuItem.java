
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class JingyanfuItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:jingyanfu")
	public static final Item block = null;

	public JingyanfuItem (SeasonsPsyimagarModElements instance) {
		super(instance, 236);
	}

	@Override public void initElements() {
		elements.items.add(() ->
			new AxeItem(new IItemTier() {
				public int getMaxUses() {
					return 300;
				}

   				public float getEfficiency() {
					return 5f;
				}

   				public float getAttackDamage() {
					return 4f;
				}

   				public int getHarvestLevel() {
					return 1;
				}

   				public int getEnchantability() {
					return 0;
				}

   				public Ingredient getRepairMaterial() {
					return Ingredient.fromStacks(
							new ItemStack(JingyandingItem.block)
							);
				}
			}, 1
			 ,-3.2f, new Item.Properties()
			 	.group(SeasonsPsyimagarItemGroup.tab)
			 ) {





		@Override public boolean onBlockDestroyed(ItemStack itemstack, World world, BlockState blockstate, BlockPos pos, LivingEntity entity){
			boolean retval = super.onBlockDestroyed(itemstack,world,blockstate,pos,entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
    


        JingyangaoDangFangKuaiBeiGongJuPoPiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}







		}.setRegistryName("jingyanfu"));
	}


}
