

package seasons_psyimagar.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class Yunguoguai3Entity extends SeasonsPsyimagarModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
					.size(1f, 1f))
			.build("yunguoguai_3").setRegistryName("yunguoguai_3");


	public Yunguoguai3Entity(SeasonsPsyimagarModElements instance) {
		super(instance, 300);

		FMLJavaModLoadingContext.get().getModEventBus().register(new Yunguoguai3Renderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override public void initElements() {
		elements.entities.add(() -> entity);


	}


	@Override public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 15);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);

			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 5);


			ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0.3);



			event.put(entity, ammma.create());
		}

	}




	public static class CustomEntity extends CreatureEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        	this(entity, world);
    	}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
      		super(type, world);
			experienceValue = 0;
			setNoAI(false);


				enablePersistence();


			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}
		
		@Override protected void registerGoals() {
			super.registerGoals();

                this.goalSelector.addGoal(1, new TemptGoal(this, 1, Ingredient.fromItems(YunduosuipianItem.block), false));this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1, 20) {

    @Override protected Vector3d getPosition() {
		Random random = CustomEntity.this.getRNG();
		double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
		double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
		double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
		return new Vector3d(dir_x, dir_y, dir_z);
	}


});
this.goalSelector.addGoal(3, new LookRandomlyGoal(this));this.goalSelector.addGoal(4, new SwimGoal(this));

		}

		@Override public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}





		@Override public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}


		@Override public boolean onLivingFall(float l, float d) {

				return false;
		}

		@Override public boolean attackEntityFrom(DamageSource source, float amount) {
				if (source == DamageSource.FALL)
					return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;
    


        Yunguoguai4ShiTiSiWangShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}



		@Override public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());


				super.func_230254_b_(sourceentity, hand);


				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;
    


        Yunguoguai3DangYouJianDianJiShiTiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity),new AbstractMap.SimpleEntry<>("sourceentity", sourceentity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
					return retval;
		}










		@Override protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
   		}

   		@Override public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

        public void livingTick() {
			super.livingTick();

			this.setNoGravity(true);

		}

	}


}
