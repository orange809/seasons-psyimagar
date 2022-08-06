

package seasons_psyimagar.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class NanguaguaiEntity extends SeasonsPsyimagarModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
					.size(0.9f, 2f))
			.build("nanguaguai").setRegistryName("nanguaguai");


	public NanguaguaiEntity(SeasonsPsyimagarModElements instance) {
		super(instance, 294);

		FMLJavaModLoadingContext.get().getModEventBus().register(new NanguaguaiRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override public void initElements() {
		elements.entities.add(() -> entity);


		elements.items.add(() -> new SpawnEggItem(entity, -3381760, -26317,
				new Item.Properties().group(SeasonsPsyimagarItemGroup.tab))
				.setRegistryName("nanguaguai_spawn_egg"));
	}


	@Override public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.33);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 14);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);






			event.put(entity, ammma.create());
		}

	}




	public static class CustomEntity extends CreatureEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        	this(entity, world);
    	}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
      		super(type, world);
			experienceValue = 6;
			setNoAI(false);


				enablePersistence();


		}

		@Override public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}
		
		@Override protected void registerGoals() {
			super.registerGoals();

                this.targetSelector.addGoal(1, new HurtByTargetGoal(this)
.setCallsForHelp());this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1, true) {

	@Override protected double getAttackReachSqr(LivingEntity entity) {
		return (double) (4.0 + entity.getWidth() * entity.getWidth());
    }


});this.targetSelector.addGoal(3,
        new NearestAttackableTargetGoal(this, PlayerEntity.class, true,
        true));this.goalSelector.addGoal(4, new LookRandomlyGoal(this));this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1));this.goalSelector.addGoal(6, new SwimGoal(this));

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
    


        NanguaguaiShiTiSiWangShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}

		@Override public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty,
				SpawnReason reason, @Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
    


        NanguaguaiChuShiShiTiShengChengProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}




		@Override public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
    


        NanguaguaiDangShiTiGengXinKeShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}










	}


}
