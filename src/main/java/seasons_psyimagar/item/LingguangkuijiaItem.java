
package seasons_psyimagar.item;

@SeasonsPsyimagarModElements.ModElement.Tag public class LingguangkuijiaItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:lingguangkuijia_helmet")
	public static final Item helmet = null;

	@ObjectHolder("seasons_psyimagar:lingguangkuijia_chestplate")
	public static final Item body = null;

	@ObjectHolder("seasons_psyimagar:lingguangkuijia_leggings")
	public static final Item legs = null;

	@ObjectHolder("seasons_psyimagar:lingguangkuijia_boots")
	public static final Item boots = null;

	public LingguangkuijiaItem (SeasonsPsyimagarModElements instance) {
		super(instance, 228);
	}

	@Override public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 12;
			}

			@Override public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[] { 3, 6, 7, 4 }[slot.getIndex()];
			}

			@Override public int getEnchantability() {
				return 6;
			}

			@Override public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(
							new ItemStack(YingguangdingItem.block)
						);
			}

			@OnlyIn(Dist.CLIENT) @Override public String getName() {
				return "lingguangkuijia";
			}

			@Override public float getToughness() {
				return 1f;
			}

			@Override public float getKnockbackResistance() {
				return 0f;
			}
		};

        elements.items.add(() ->
			new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(SeasonsPsyimagarItemGroup.tab)) {


				@Override public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "seasons_psyimagar:textures/models/armor/yingguangjia_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
				}

				@Override public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
					super.onArmorTick(itemstack, world, entity);
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
    


        LingguangkuijiaTouKuiShiJianMeiYouXiKeProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
				}
		}.setRegistryName("lingguangkuijia_helmet"));



	}

	

		

}
