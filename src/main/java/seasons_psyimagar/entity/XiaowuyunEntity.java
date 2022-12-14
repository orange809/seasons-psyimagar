

package seasons_psyimagar.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class XiaowuyunEntity extends SeasonsPsyimagarModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
					.immuneToFire().size(0.8f, 0.2f))
			.build("xiaowuyun").setRegistryName("xiaowuyun");


	public XiaowuyunEntity(SeasonsPsyimagarModElements instance) {
		super(instance, 312);

		FMLJavaModLoadingContext.get().getModEventBus().register(new XiaowuyunRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override public void initElements() {
		elements.entities.add(() -> entity);


	}

	@SubscribeEvent public void addFeatureToBiomes(BiomeLoadingEvent event) {
				boolean biomeCriteria = false;
					if (new ResourceLocation("seasons_psyimagar:feng_lin").equals(event.getName()))
						biomeCriteria = true;
			if (!biomeCriteria)
				return;

		event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(entity, 25,
			2, 3));
	}

	@Override public void init(FMLCommonSetupEvent event) {
			EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos, random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8)
			);

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.32);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);



			ammma = ammma.createMutableAttribute(Attributes.FLYING_SPEED, 0.32);



			event.put(entity, ammma.create());
		}

	}




	public static class CustomEntity extends MonsterEntity {

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
				if (source == DamageSource.LIGHTNING_BOLT)
					return false;
			return super.attackEntityFrom(source, amount);
		}







		@Override public void onCollideWithPlayer(PlayerEntity sourceentity) {
			super.onCollideWithPlayer(sourceentity);
			Entity entity = this;
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
    


        XiaowuyunDangWanJiaYuGaiShiTiFaShengPengZhuangShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
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
