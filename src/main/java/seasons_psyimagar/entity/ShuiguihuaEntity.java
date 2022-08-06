

package seasons_psyimagar.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class ShuiguihuaEntity extends SeasonsPsyimagarModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.WATER_CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
					.size(1f, 1f))
			.build("shuiguihua").setRegistryName("shuiguihua");


	public ShuiguihuaEntity(SeasonsPsyimagarModElements instance) {
		super(instance, 285);

		FMLJavaModLoadingContext.get().getModEventBus().register(new ShuiguihuaRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override public void initElements() {
		elements.entities.add(() -> entity);


		elements.items.add(() -> new SpawnEggItem(entity, -16751053, -437301,
				new Item.Properties().group(SeasonsPsyimagarItemGroup.tab))
				.setRegistryName("shuiguihua_spawn_egg"));
	}

	@SubscribeEvent public void addFeatureToBiomes(BiomeLoadingEvent event) {
				boolean biomeCriteria = false;
					if (new ResourceLocation("seasons_psyimagar:fan_mao_yi_lin").equals(event.getName()))
						biomeCriteria = true;
					if (new ResourceLocation("seasons_psyimagar:han_chao_lin").equals(event.getName()))
						biomeCriteria = true;
					if (new ResourceLocation("seasons_psyimagar:feng_lin").equals(event.getName()))
						biomeCriteria = true;
					if (new ResourceLocation("seasons_psyimagar:mo_gu_lin").equals(event.getName()))
						biomeCriteria = true;
					if (new ResourceLocation("seasons_psyimagar:zhui_luo_tian_kong").equals(event.getName()))
						biomeCriteria = true;
			if (!biomeCriteria)
				return;

		event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(entity, 100,
			1, 1));
	}

	@Override public void init(FMLCommonSetupEvent event) {
			EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
					SquidEntity::func_223365_b
			);

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 3.2);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 12);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 1);

			ammma = ammma.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 5);



			ammma = ammma.createMutableAttribute(ForgeMod.SWIM_SPEED.get(), 3.2);


			event.put(entity, ammma.create());
		}

	}




	public static class CustomEntity extends CreatureEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        	this(entity, world);
    	}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
      		super(type, world);
			experienceValue = 4;
			setNoAI(false);




			this.setPathPriority(PathNodeType.WATER, 0);
			this.moveController = new MovementController(this) {
				@Override public void tick() {
				    if (CustomEntity.this.isInWater())
                        CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, 0.005, 0));

					if (this.action == MovementController.Action.MOVE_TO && !CustomEntity.this.getNavigator().noPath()) {
						double dx = this.posX - CustomEntity.this.getPosX();
						double dy = this.posY - CustomEntity.this.getPosY();
						double dz = this.posZ - CustomEntity.this.getPosZ();

						float f = (float)(MathHelper.atan2(dz, dx) * (double)(180 / Math.PI)) - 90;
						float f1 = (float)(this.speed * CustomEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());

						CustomEntity.this.rotationYaw = this.limitAngle(CustomEntity.this.rotationYaw, f, 10);
						CustomEntity.this.renderYawOffset = CustomEntity.this.rotationYaw;
						CustomEntity.this.rotationYawHead = CustomEntity.this.rotationYaw;

						if (CustomEntity.this.isInWater()) {
							CustomEntity.this.setAIMoveSpeed((float)CustomEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());

							float f2 = - (float) (MathHelper.atan2(dy, MathHelper.sqrt(dx * dx + dz * dz)) * (180F / Math.PI));
							f2 = MathHelper.clamp(MathHelper.wrapDegrees(f2), -85, 85);
							CustomEntity.this.rotationPitch = this.limitAngle(CustomEntity.this.rotationPitch, f2, 5);
							float f3 = MathHelper.cos(CustomEntity.this.rotationPitch * (float) (Math.PI / 180.0));

							CustomEntity.this.setMoveForward(f3 * f1);
							CustomEntity.this.setMoveVertical((float) (f1 * dy));
						} else {
							CustomEntity.this.setAIMoveSpeed(f1 * 0.05F);
						}
					} else {
						CustomEntity.this.setAIMoveSpeed(0);
						CustomEntity.this.setMoveVertical(0);
						CustomEntity.this.setMoveForward(0);
					}
				}
			};
			this.navigator = new SwimmerPathNavigator(this, this.world);
		}

		@Override public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}
		
		@Override protected void registerGoals() {
			super.registerGoals();

                this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1, 40));this.goalSelector.addGoal(2,new PanicGoal(this, 1.2));

		}

		@Override public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.WATER;
		}




		@Override public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("seasons_psyimagar:shuiguihua"));
		}


		@Override public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}





		@Override public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty,
				SpawnReason reason, @Nullable ILivingEntityData livingdata, @Nullable CompoundNBT tag) {
			ILivingEntityData retval = super.onInitialSpawn(world, difficulty, reason, livingdata, tag);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
    


        ShuiguihuaChuShiShiTiShengChengProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}


		@Override public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());


				super.func_230254_b_(sourceentity, hand);


				double x = this.getPosX();
				double y = this.getPosY();
				double z = this.getPosZ();
				Entity entity = this;
    


        ShuiguihuaDangYouJianDianJiShiTiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity),new AbstractMap.SimpleEntry<>("sourceentity", sourceentity)
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
    


        ShuiguihuaDangShiTiGengXinKeShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}

		@Override public void onCollideWithPlayer(PlayerEntity sourceentity) {
			super.onCollideWithPlayer(sourceentity);
			Entity entity = this;
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
    


        ShuiguihuaDangWanJiaYuGaiShiTiXiangZhuangShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("sourceentity", sourceentity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}



		@Override public boolean canBreatheUnderwater() {
        	return true;
    	}

    	@Override public boolean isNotColliding(IWorldReader world) {
			return world.checkNoEntityCollision(this);
		}

    	@Override public boolean isPushedByWater() {
			return false;
    	}






	}


}
