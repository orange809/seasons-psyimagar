

package seasons_psyimagar.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class VineQueenEntity extends SeasonsPsyimagarModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
					.size(0.5f, 1.4f))
			.build("vine_queen").setRegistryName("vine_queen");


	public VineQueenEntity(SeasonsPsyimagarModElements instance) {
		super(instance, 281);

		FMLJavaModLoadingContext.get().getModEventBus().register(new VineQueenRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override public void initElements() {
		elements.entities.add(() -> entity);


		elements.items.add(() -> new SpawnEggItem(entity, -13408768, -13382656,
				new Item.Properties().group(SeasonsPsyimagarItemGroup.tab))
				.setRegistryName("vine_queen_spawn_egg"));
	}


	@Override public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 120);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 4);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 19);

			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1000);

			ammma = ammma.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1.5);




			event.put(entity, ammma.create());
		}

	}




	public static class CustomEntity extends MonsterEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        	this(entity, world);
    	}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
      		super(type, world);
			experienceValue = 100;
			setNoAI(false);


				enablePersistence();


		}

		@Override public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}
		
		@Override protected void registerGoals() {
			super.registerGoals();

                this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0, false) {

	@Override protected double getAttackReachSqr(LivingEntity entity) {
		return (double) (4.0 + entity.getWidth() * entity.getWidth());
    }


});this.targetSelector.addGoal(2, new HurtByTargetGoal(this)
);this.goalSelector.addGoal(3, new LookRandomlyGoal(this));this.goalSelector.addGoal(4, new SwimGoal(this));this.targetSelector.addGoal(5,
        new NearestAttackableTargetGoal(this, QieEntity.CustomEntity.class, true,
        false));

		}

		@Override public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}





		@Override public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.hurt"));
		}

		@Override public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.death"));
		}



		@Override public boolean attackEntityFrom(DamageSource source, float amount) {
				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;
				Entity sourceentity = source.getTrueSource();
    


        VineQueenDangShiTiShouShangShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("sourceentity", sourceentity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
				if (source.getImmediateSource() instanceof PotionEntity || source.getImmediateSource() instanceof AreaEffectCloudEntity)
					return false;
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.CACTUS)
					return false;
				if (source == DamageSource.DROWN)
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
    


        VineQueenDangShiTiSiWangShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("sourceentity", sourceentity)
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
    


        VineQueenChuShiShiTiShengChengProcedure.executeProcedure(Stream.of(
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
    


        VineQueenDangShiTiGengXinKeShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}






		   @Override public boolean isNonBoss() {
				return false;
			}

		   private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(),
					BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS);

		   @Override public void addTrackingPlayer(ServerPlayerEntity player) {
				super.addTrackingPlayer(player);
				this.bossInfo.addPlayer(player);
			}

		   @Override public void removeTrackingPlayer(ServerPlayerEntity player) {
				super.removeTrackingPlayer(player);
				this.bossInfo.removePlayer(player);
			}

		   @Override public void updateAITasks() {
				super.updateAITasks();
				this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
			}




	}


}
