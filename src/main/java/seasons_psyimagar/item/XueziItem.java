
package seasons_psyimagar.item;

@SeasonsPsyimagarModElements.ModElement.Tag public class XueziItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:xuezi_helmet")
	public static final Item helmet = null;

	@ObjectHolder("seasons_psyimagar:xuezi_chestplate")
	public static final Item body = null;

	@ObjectHolder("seasons_psyimagar:xuezi_leggings")
	public static final Item legs = null;

	@ObjectHolder("seasons_psyimagar:xuezi_boots")
	public static final Item boots = null;

	public XueziItem (SeasonsPsyimagarModElements instance) {
		super(instance, 231);
	}

	@Override public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 3;
			}

			@Override public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[] { 3, 6, 7, 4 }[slot.getIndex()];
			}

			@Override public int getEnchantability() {
				return 3;
			}

			@Override public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(
							new ItemStack(YunduofangkuaiBlock.block)
						);
			}

			@OnlyIn(Dist.CLIENT) @Override public String getName() {
				return "xuezi";
			}

			@Override public float getToughness() {
				return 0.5f;
			}

			@Override public float getKnockbackResistance() {
				return 0f;
			}
		};




        elements.items.add(() ->
			new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(SeasonsPsyimagarItemGroup.tab)) {


				@Override public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "seasons_psyimagar:textures/models/armor/fengzhi_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
				}

				@Override public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
    


        FengzhijiaXueZiShiJianMeiYouXiKeProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
				}
		}.setRegistryName("xuezi_boots"));
	}

	

		

}
