
package seasons_psyimagar.item;

@SeasonsPsyimagarModElements.ModElement.Tag public class JudukuijiaItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:judukuijia_helmet")
	public static final Item helmet = null;

	@ObjectHolder("seasons_psyimagar:judukuijia_chestplate")
	public static final Item body = null;

	@ObjectHolder("seasons_psyimagar:judukuijia_leggings")
	public static final Item legs = null;

	@ObjectHolder("seasons_psyimagar:judukuijia_boots")
	public static final Item boots = null;

	public JudukuijiaItem (SeasonsPsyimagarModElements instance) {
		super(instance, 227);
	}

	@Override public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 17;
			}

			@Override public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[] { 3, 6, 7, 4 }[slot.getIndex()];
			}

			@Override public int getEnchantability() {
				return 10;
			}

			@Override public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(
							new ItemStack(DuciweipiItem.block)
						);
			}

			@OnlyIn(Dist.CLIENT) @Override public String getName() {
				return "judukuijia";
			}

			@Override public float getToughness() {
				return 1.5f;
			}

			@Override public float getKnockbackResistance() {
				return 0f;
			}
		};


        elements.items.add(() ->
			new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(SeasonsPsyimagarItemGroup.tab)) {


				@Override public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "seasons_psyimagar:textures/models/armor/judukuijia_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
				}

		}.setRegistryName("judukuijia_chestplate"));


	}

	

		

}
