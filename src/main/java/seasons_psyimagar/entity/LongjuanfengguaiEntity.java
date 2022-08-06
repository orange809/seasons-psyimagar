

package seasons_psyimagar.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class LongjuanfengguaiEntity extends SeasonsPsyimagarModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
					.immuneToFire().size(1f, 2f))
			.build("longjuanfengguai").setRegistryName("longjuanfengguai");


	public LongjuanfengguaiEntity(SeasonsPsyimagarModElements instance) {
		super(instance, 293);

		FMLJavaModLoadingContext.get().getModEventBus().register(new LongjuanfengguaiRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override public void initElements() {
		elements.entities.add(() -> entity);


		elements.items.add(() -> new SpawnEggItem(entity, -8553091, -9737365,
				new Item.Properties().group(SeasonsPsyimagarItemGroup.tab))
				.setRegistryName("longjuanfengguai_spawn_egg"));
	}

	@SubscribeEvent public void addFeatureToBiomes(BiomeLoadingEvent event) {
				boolean biomeCriteria = false;
					if (new ResourceLocation("seasons_psyimagar:feng_lin").equals(event.getName()))
						biomeCriteria = true;
			if (!biomeCriteria)
				return;

		event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(entity, 1,
			1, 1));
	}

	@Override public void init(FMLCommonSetupEvent event) {
			EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos, random) -> {
						int x = pos.getX();
						int y = pos.getY();
						int z = pos.getZ();
						return 


        ZongsemoguguaiZiRanShiTiShengChengTiaoJianProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
					}
			);

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.33);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 15);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);

			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 2);





			event.put(entity, ammma.create());
		}

	}




	public static class CustomEntity extends MonsterEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        	this(entity, world);
    	}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
      		super(type, world);
			experienceValue = 7;
			setNoAI(false);




		}

		@Override public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}
		
		@Override protected void registerGoals() {
			super.registerGoals();

                this.targetSelector.addGoal(1, new HurtByTargetGoal(this)
.setCallsForHelp());this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.5, true) {

	@Override protected double getAttackReachSqr(LivingEntity entity) {
		return (double) (4.0 + entity.getWidth() * entity.getWidth());
    }


});this.targetSelector.addGoal(3,
        new NearestAttackableTargetGoal(this, PlayerEntity.class, true,
        true));this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1));this.goalSelector.addGoal(5, new LookRandomlyGoal(this));this.goalSelector.addGoal(6, new SwimGoal(this));

		}

		@Override public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}






		@Override public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}



		@Override public boolean attackEntityFrom(DamageSource source, float amount) {
				if (source.getImmediateSource() instanceof AbstractArrowEntity)
					return false;
				if (source == DamageSource.FALL)
					return false;
				if (source == DamageSource.LIGHTNING_BOLT)
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
    


        LongjuanfengguaiShiTiSiWangShiProcedure.executeProcedure(Stream.of(
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
    


        LongjuanfengguaiDangShiTiGengXinKeShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}

		@Override public void onCollideWithPlayer(PlayerEntity sourceentity) {
			super.onCollideWithPlayer(sourceentity);
			Entity entity = this;
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
    


        LongjuanfengguaiDangWanJiaYuGaiShiTiXiangZhuangShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}









	}


}
