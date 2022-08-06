package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class MoguguaiDangShiTiGengXinKeShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure MoguguaiDangShiTiGengXinKeShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure MoguguaiDangShiTiGengXinKeShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure MoguguaiDangShiTiGengXinKeShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure MoguguaiDangShiTiGengXinKeShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure MoguguaiDangShiTiGengXinKeShi!");
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


		if (Math.random()<0.0001) {if(!entity.world.isRemote())
    entity.remove();	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new HongsmoguguaiEntity.CustomEntity(HongsmoguguaiEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);

		if (entityToSpawn instanceof MobEntity)
               ((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
}if (Math.random()<0.0001) {if(!entity.world.isRemote())
    entity.remove();	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new ZongsemoguguaiEntity.CustomEntity(ZongsemoguguaiEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);

		if (entityToSpawn instanceof MobEntity)
               ((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
}
	}

}
