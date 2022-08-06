

package seasons_psyimagar.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class VineFlowerEntity extends SeasonsPsyimagarModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
					.size(0.4f, 1.5f))
			.build("vine_flower").setRegistryName("vine_flower");


	public VineFlowerEntity(SeasonsPsyimagarModElements instance) {
		super(instance, 307);

		FMLJavaModLoadingContext.get().getModEventBus().register(new VineFlowerRenderer.ModelRegisterHandler());
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
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 10);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);

			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 10);





			event.put(entity, ammma.create());
		}

	}




	public static class CustomEntity extends MonsterEntity implements IRangedAttackMob {

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
        false));this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false) {

	@Override protected double getAttackReachSqr(LivingEntity entity) {
		return (double) (4.0 + entity.getWidth() * entity.getWidth());
    }


});

                this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10) {
					@Override public boolean shouldContinueExecuting() {
						return this.shouldExecute();
					}
				});
		}

		@Override public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}





		@Override public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}



		@Override public boolean attackEntityFrom(DamageSource source, float amount) {
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








		    public void attackEntityWithRangedAttack(LivingEntity target, float flval) {
					ArrowEntity entityarrow = new ArrowEntity(this.world, this);
					double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
					double d1 = target.getPosX() - this.getPosX();
					double d3 = target.getPosZ() - this.getPosZ();
					entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
					world.addEntity(entityarrow);
			}








	}


}
