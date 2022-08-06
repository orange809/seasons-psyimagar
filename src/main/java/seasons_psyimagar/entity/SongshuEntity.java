

package seasons_psyimagar.entity;

import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.block.material.Material;

@SeasonsPsyimagarModElements.ModElement.Tag public class SongshuEntity extends SeasonsPsyimagarModElements.ModElement {

	public static EntityType entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
					.size(0.6f, 0.5f))
			.build("songshu").setRegistryName("songshu");


	public SongshuEntity(SeasonsPsyimagarModElements instance) {
		super(instance, 289);

		FMLJavaModLoadingContext.get().getModEventBus().register(new SongshuRenderer.ModelRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new EntityAttributesRegisterHandler());

	}

	@Override public void initElements() {
		elements.entities.add(() -> entity);


		elements.items.add(() -> new SpawnEggItem(entity, -8962814, -6993408,
				new Item.Properties().group(SeasonsPsyimagarItemGroup.tab))
				.setRegistryName("songshu_spawn_egg"));
	}


	@Override public void init(FMLCommonSetupEvent event) {

	}

	private static class EntityAttributesRegisterHandler {

		@SubscribeEvent public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
			AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
			ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.32);
			ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 5);
			ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
			ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);






			event.put(entity, ammma.create());
		}

	}




	public static class CustomEntity extends TameableEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        	this(entity, world);
    	}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
      		super(type, world);
			experienceValue = 2;
			setNoAI(false);


				enablePersistence();


		}

		@Override public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}
		
		@Override protected void registerGoals() {
			super.registerGoals();

                this.goalSelector.addGoal(1,new PanicGoal(this, 1.5));this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1, (float) 3, (float) 5, false));
this.goalSelector.addGoal(3, new LookRandomlyGoal(this));this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1));this.goalSelector.addGoal(5, new SwimGoal(this));

		}

		@Override public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}



		@Override public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("seasons_psyimagar:danxiaodesongshu"));
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
    


        SongshuShiTiSiWangShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}



		@Override public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());


				Item item = itemstack.getItem();
				if (itemstack.getItem() instanceof SpawnEggItem) {
					retval = super.func_230254_b_(sourceentity, hand);
				} else if (this.world.isRemote()) {
					retval = (this.isTamed() && this.isOwner(sourceentity) || this.isBreedingItem(itemstack))
							? ActionResultType.func_233537_a_(this.world.isRemote()) : ActionResultType.PASS;
				} else {
					if (this.isTamed()) {
						if (this.isOwner(sourceentity)) {
							if (item.isFood() && this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal((float)item.getFood().getHealing());
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
								this.consumeItemFromStack(sourceentity, itemstack);
								this.heal(4);
								retval = ActionResultType.func_233537_a_(this.world.isRemote());
							} else {
								retval = super.func_230254_b_(sourceentity, hand);
							}
						}
					} else if (this.isBreedingItem(itemstack)) {
						this.consumeItemFromStack(sourceentity, itemstack);
						if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
							this.setTamedBy(sourceentity);
							this.world.setEntityState(this, (byte) 7);
						} else {
							this.world.setEntityState(this, (byte) 6);
						}

						this.enablePersistence();
						retval = ActionResultType.func_233537_a_(this.world.isRemote());
					} else {
						retval = super.func_230254_b_(sourceentity, hand);
						if (retval == ActionResultType.SUCCESS || retval == ActionResultType.CONSUME)
							this.enablePersistence();
					}
				}


				return retval;
		}





            @Override public AgeableEntity func_241840_a(ServerWorld serverWorld, AgeableEntity ageable) {
				CustomEntity retval = (CustomEntity) entity.create(serverWorld);
				retval.onInitialSpawn(serverWorld, serverWorld.getDifficultyForLocation(new BlockPos(retval.getPosition())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
				return retval;
			}

			@Override public boolean isBreedingItem(ItemStack stack) {
				if (stack == null)
					return false;

					if (SongguoItem.block == stack.getItem())
						return true;

				return false;
			}







	}


}
