package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ShuiguihuaDangYouJianDianJiShiTiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure ShuiguihuaDangYouJianDianJiShiTi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure ShuiguihuaDangYouJianDianJiShiTi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure ShuiguihuaDangYouJianDianJiShiTi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure ShuiguihuaDangYouJianDianJiShiTi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure ShuiguihuaDangYouJianDianJiShiTi!");
				return;
			}
			if(dependencies.get("sourceentity") == null) {
				if(!dependencies.containsKey("sourceentity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ShuiguihuaDangYouJianDianJiShiTi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				Entity entity = (Entity) dependencies.get("entity");
				Entity sourceentity = (Entity) dependencies.get("sourceentity");

double fangxiang = 0;double health = 0;double jiaodu = 0;
		if (((sourceentity instanceof LivingEntity)?((LivingEntity)sourceentity).getItemStackFromSlot(EquipmentSlotType.HEAD):ItemStack.EMPTY).getItem() == LingguangkuijiaItem.helmet&&((sourceentity instanceof LivingEntity)?((LivingEntity)sourceentity).getHeldItemMainhand():ItemStack.EMPTY).getItem() == YingguangyuansuItem.block) {if (!((sourceentity instanceof PlayerEntity)?((PlayerEntity)sourceentity).abilities.isCreativeMode:false)) {if(sourceentity instanceof LivingEntity) {
	ItemStack _setstack = new ItemStack(YingguangyuansuItem.block);
	_setstack.setCount((int) ((((sourceentity instanceof LivingEntity)?((LivingEntity)sourceentity).getHeldItemMainhand():ItemStack.EMPTY)).getCount()-1));
	((LivingEntity)sourceentity).setHeldItem(Hand.MAIN_HAND, _setstack);
	if(sourceentity instanceof ServerPlayerEntity)
		((ServerPlayerEntity)sourceentity).inventory.markDirty();
}}if(!entity.world.isRemote())
    entity.remove();health = ((entity instanceof LivingEntity)?((LivingEntity)entity).getHealth():-1);jiaodu = (entity.rotationPitch);fangxiang = (entity.rotationYaw);	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new Shuiguihua2Entity.CustomEntity(Shuiguihua2Entity.entity, (World) world);
		entityToSpawn.setLocationAndAngles(x, y, z, (float) fangxiang, (float) jiaodu);
		entityToSpawn.setRenderYawOffset((float) fangxiang);
		entityToSpawn.setRotationYawHead((float) fangxiang);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
if(((Entity) world.getEntitiesWithinAABB(Shuiguihua2Entity.CustomEntity.class, new AxisAlignedBB(
            x - (1 / 2d), y - (1 / 2d), z - (1 / 2d),
            x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
) instanceof LivingEntity)((LivingEntity)((Entity) world.getEntitiesWithinAABB(Shuiguihua2Entity.CustomEntity.class, new AxisAlignedBB(
            x - (1 / 2d), y - (1 / 2d), z - (1 / 2d),
            x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
)).setHealth((float)health);if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(QianHaiHuaBanItem.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}if(sourceentity instanceof ServerPlayerEntity) {
	Advancement _adv = ((MinecraftServer)((ServerPlayerEntity)sourceentity).server).getAdvancementManager()
        .getAdvancement(new ResourceLocation("seasons_psyimagar:deleted_mod_element"));
    AdvancementProgress _ap = ((ServerPlayerEntity) sourceentity).getAdvancements().getProgress(_adv);
    if (!_ap.isDone()) {
        Iterator _iterator = _ap.getRemaningCriteria().iterator();
        while(_iterator.hasNext()) {
            String _criterion = (String)_iterator.next();
            ((ServerPlayerEntity) sourceentity).getAdvancements().grantCriterion(_adv, _criterion);
        }
    }
}}
	}

}
