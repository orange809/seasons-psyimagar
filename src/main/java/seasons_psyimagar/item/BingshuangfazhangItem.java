
package seasons_psyimagar.item;

import net.minecraft.entity.ai.attributes.Attributes;

@SeasonsPsyimagarModElements.ModElement.Tag
public class BingshuangfazhangItem extends SeasonsPsyimagarModElements.ModElement{

	@ObjectHolder("seasons_psyimagar:bingshuangfazhang")
	public static final Item block = null;

	public static final EntityType arrow = (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
			.size(0.5f, 0.5f)).build("projectile_bingshuangfazhang").setRegistryName("projectile_bingshuangfazhang");

	public BingshuangfazhangItem(SeasonsPsyimagarModElements instance) {
		super(instance, 255);

		FMLJavaModLoadingContext.get().getModEventBus().register(new BingshuangfazhangRenderer.ModelRegisterHandler());
	}

	@Override public void initElements() {
		elements.items.add(() -> new ItemRanged());
		elements.entities.add(() -> arrow);
	}

	public static class ItemRanged extends Item {

		public ItemRanged() {
			super(new Item.Properties()
					.group(SeasonsPsyimagarItemGroup.tab)
					.maxDamage(500)
					);

			setRegistryName("bingshuangfazhang");
		}

		@Override public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			entity.setActiveHand(hand);
			return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
		}



		@Override public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.BOW;
		}

		@Override public int getUseDuration(ItemStack itemstack) {
			return 72000;
		}



			@Override
			public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
				if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
					ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
					double x = entity.getPosX();
					double y = entity.getPosY();
					double z = entity.getPosZ();
					if (        true
) {

	ArrowCustomEntity entityarrow = shoot(world, entity, random, 2f, 0.75, 1);

	itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));

	entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;


					}
				}
			}

	}

	@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
	public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {

		public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        	super(arrow, world);
    	}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
			super(type, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
			super(type, x, y, z, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
			super(type, entity, world);
		}

		@Override public IPacket<?> createSpawnPacket() {
        	return NetworkHooks.getEntitySpawningPacket(this);
    	}

		@Override @OnlyIn(Dist.CLIENT) public ItemStack getItem() {
			return new ItemStack(ZidanItem.block);
		}

		@Override protected ItemStack getArrowStack() {
			return ItemStack.EMPTY;
		}

		@Override protected void arrowHit(LivingEntity entity) {
			super.arrowHit(entity);
			entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1); 
		}


		@Override public void onEntityHit(EntityRayTraceResult entityRayTraceResult) {
			super.onEntityHit(entityRayTraceResult);
			Entity entity = entityRayTraceResult.getEntity();
			Entity sourceentity = this.func_234616_v_();
			Entity immediatesourceentity = this;
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			World world = this.world;
    


        BingshuangfazhangDangZiDanJiZhongShengCunShiTiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}

		@Override public void func_230299_a_(BlockRayTraceResult blockRayTraceResult) {
			super.func_230299_a_(blockRayTraceResult);
			double x = blockRayTraceResult.getPos().getX();
			double y = blockRayTraceResult.getPos().getY();
			double z = blockRayTraceResult.getPos().getZ();
			World world = this.world;
			Entity entity = this.func_234616_v_();
			Entity immediatesourceentity = this;
    


        BingshuangfazhangDangZiDanJiZhongFangKuaiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}

		@Override public void tick() {
			super.tick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			World world = this.world;
			Entity entity = this.func_234616_v_();
			Entity immediatesourceentity = this;
			if (this.inGround) {
    


        BingshuangfazhangDangZiDanJiZhongFangKuaiShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
				this.remove();
			}
		}

	}

	public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
		entityarrow.shoot(entity.getLook(1).x, entity.getLook(1).y, entity.getLook(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setIsCritical(false);
		entityarrow.setDamage(damage);
		entityarrow.setKnockbackStrength(knockback);
		world.addEntity(entityarrow);

		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z, (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
				.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));

		return entityarrow;
	}

	public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
		double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
		double d1 = target.getPosX() - entity.getPosX();
		double d3 = target.getPosZ() - entity.getPosZ();
		entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 2f * 2, 12.0F);

		entityarrow.setSilent(true);
		entityarrow.setDamage(0.75);
		entityarrow.setKnockbackStrength(1);
		entityarrow.setIsCritical(false);
		entity.world.addEntity(entityarrow);

		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z, (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
				.getValue(new ResourceLocation("")), SoundCategory.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));

		return entityarrow;
	}

}

