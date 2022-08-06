

package seasons_psyimagar.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class BingShuangShouHuZheEntity extends SeasonsPsyimagarModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
					.size(0.5f, 0.5f))
			.build("bing_shuang_shou_hu_zhe").setRegistryName("bing_shuang_shou_hu_zhe");


	public BingShuangShouHuZheEntity(SeasonsPsyimagarModElements instance) {
		super(instance, 284);

		FMLJavaModLoadingContext.get().getModEventBus().register(new BingShuangShouHuZheRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override public void initElements() {
		elements.entities.add(() -> entity);


		elements.items.add(() -> new SpawnEggItem(entity, -6684673, -3342337,
				new Item.Properties().group(SeasonsPsyimagarItemGroup.tab))
				.setRegistryName("bing_shuang_shou_hu_zhe_spawn_egg"));
	}


	@Override public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.29);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 300);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 4);

			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 5);

			ammma = ammma.createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1);




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

                this.targetSelector.addGoal(1, new HurtByTargetGoal(this)
.setCallsForHelp());this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {

	@Override protected double getAttackReachSqr(LivingEntity entity) {
		return (double) (4.0 + entity.getWidth() * entity.getWidth());
    }


});this.targetSelector.addGoal(3,
        new NearestAttackableTargetGoal(this, PlayerEntity.class, false,
        false));this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 0.8));this.goalSelector.addGoal(5, new LookRandomlyGoal(this));

		}

		@Override public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override public double getMountedYOffset() {
			return super.getMountedYOffset() + 1.5;
		}




		@Override public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}




		@Override public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;
    


        BingShuangShouHuZheDangShiTiSiWangShiProcedure.executeProcedure(Stream.of(
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
    


        BingShuangShouHuZheDangShiTiGengXinKeShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}






		   @Override public boolean isNonBoss() {
				return false;
			}

		   private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(),
					BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS);

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
