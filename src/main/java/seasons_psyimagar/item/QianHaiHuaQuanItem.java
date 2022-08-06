
package seasons_psyimagar.item;

@SeasonsPsyimagarModElements.ModElement.Tag public class QianHaiHuaQuanItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:qian_hai_hua_quan_helmet")
	public static final Item helmet = null;

	@ObjectHolder("seasons_psyimagar:qian_hai_hua_quan_chestplate")
	public static final Item body = null;

	@ObjectHolder("seasons_psyimagar:qian_hai_hua_quan_leggings")
	public static final Item legs = null;

	@ObjectHolder("seasons_psyimagar:qian_hai_hua_quan_boots")
	public static final Item boots = null;

	public QianHaiHuaQuanItem (SeasonsPsyimagarModElements instance) {
		super(instance, 225);
	}

	@Override public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 8;
			}

			@Override public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[] { 3, 6, 7, 4 }[slot.getIndex()];
			}

			@Override public int getEnchantability() {
				return 7;
			}

			@Override public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT) @Override public String getName() {
				return "qian_hai_hua_quan";
			}

			@Override public float getToughness() {
				return 1f;
			}

			@Override public float getKnockbackResistance() {
				return 0.5f;
			}
		};

        elements.items.add(() ->
			new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(SeasonsPsyimagarItemGroup.tab)) {


				@Override public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "seasons_psyimagar:textures/models/armor/qianhaihuaquan_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
				}

				@Override public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
					super.onArmorTick(itemstack, world, entity);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
    


        QianHaiHuaQuanTouKuiShiJianMeiYouXiKeProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
				}
		}.setRegistryName("qian_hai_hua_quan_helmet"));



	}

	

		

}
