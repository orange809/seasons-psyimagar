

package seasons_psyimagar.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class HuoYanLongJuanFengEntity extends SeasonsPsyimagarModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
					.immuneToFire().size(1.5f, 1.5f))
			.build("huo_yan_long_juan_feng").setRegistryName("huo_yan_long_juan_feng");


	public HuoYanLongJuanFengEntity(SeasonsPsyimagarModElements instance) {
		super(instance, 282);

		FMLJavaModLoadingContext.get().getModEventBus().register(new HuoYanLongJuanFengRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override public void initElements() {
		elements.entities.add(() -> entity);


		elements.items.add(() -> new SpawnEggItem(entity, -9763065, -5733758,
				new Item.Properties().group(SeasonsPsyimagarItemGroup.tab))
				.setRegistryName("huo_yan_long_juan_feng_spawn_egg"));
	}


	@Override public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 90);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 4);



			ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0.3);



			event.put(entity, ammma.create());
		}

	}




	public static class CustomEntity extends MonsterEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        	this(entity, world);
    	}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
      		super(type, world);
			experienceValue = 40;
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

                this.goalSelector.addGoal(1, new Goal() {
	{
		this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	public boolean shouldExecute() {
		if (CustomEntity.this.getAttackTarget() != null && !CustomEntity.this.getMoveHelper().isUpdating()) {
			return true;
		} else {
			return false;
		}
	}

	@Override public boolean shouldContinueExecuting() {
		return 
			CustomEntity.this.getMoveHelper().isUpdating() && CustomEntity.this.getAttackTarget() != null && CustomEntity.this.getAttackTarget().isAlive();
	}

	@Override public void startExecuting() {
		LivingEntity livingentity = CustomEntity.this.getAttackTarget();
		Vector3d vec3d = livingentity.getEyePosition(1);
		CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
	}

	@Override public void tick() {
		LivingEntity livingentity = CustomEntity.this.getAttackTarget();
		if (CustomEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
			CustomEntity.this.attackEntityAsMob(livingentity);
		} else {
			double d0 = CustomEntity.this.getDistanceSq(livingentity);
			if (d0 < 32) {
				Vector3d vec3d = livingentity.getEyePosition(1);
				CustomEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1);
			}
		}
	}
});
this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.8, 20) {

    @Override protected Vector3d getPosition() {
		Random random = CustomEntity.this.getRNG();
		double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
		double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
		double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
		return new Vector3d(dir_x, dir_y, dir_z);
	}


});
this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, true) {

	@Override protected double getAttackReachSqr(LivingEntity entity) {
		return (double) (4.0 + entity.getWidth() * entity.getWidth());
    }


});this.goalSelector.addGoal(4, new LookRandomlyGoal(this));this.targetSelector.addGoal(5,
        new NearestAttackableTargetGoal(this, PlayerEntity.class, false,
        false));this.targetSelector.addGoal(6, new HurtByTargetGoal(this)
.setCallsForHelp());

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
				if (source.isExplosion())
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
    


        HuoYanLongJuanFengDangShiTiSiWangShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("sourceentity", sourceentity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}





		@Override public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
    


        HuoYanLongJuanFengDangShiTiGengXinKeShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}






		   @Override public boolean isNonBoss() {
				return false;
			}

		   private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(),
					BossInfo.Color.RED, BossInfo.Overlay.PROGRESS);

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
