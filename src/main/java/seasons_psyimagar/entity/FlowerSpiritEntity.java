

package seasons_psyimagar.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class FlowerSpiritEntity extends SeasonsPsyimagarModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
					.size(0.5f, 0.5f))
			.build("flower_spirit").setRegistryName("flower_spirit");


	public FlowerSpiritEntity(SeasonsPsyimagarModElements instance) {
		super(instance, 303);

		FMLJavaModLoadingContext.get().getModEventBus().register(new FlowerSpiritRenderer.ModelRegisterHandler());
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
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.45);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 2);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 2);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);


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
			experienceValue = 0;
			setNoAI(false);


				enablePersistence();


		}

		@Override public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}
		
		@Override protected void registerGoals() {
			super.registerGoals();

                this.targetSelector.addGoal(1,
        new NearestAttackableTargetGoal(this, PlayerEntity.class, false,
        false));this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2, true) {

	@Override protected double getAttackReachSqr(LivingEntity entity) {
		return (double) (4.0 + entity.getWidth() * entity.getWidth());
    }


});this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 1));this.targetSelector.addGoal(4, new HurtByTargetGoal(this)
.setCallsForHelp());this.goalSelector.addGoal(5, new LookRandomlyGoal(this));this.goalSelector.addGoal(6, new SwimGoal(this));

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



















	}


}
