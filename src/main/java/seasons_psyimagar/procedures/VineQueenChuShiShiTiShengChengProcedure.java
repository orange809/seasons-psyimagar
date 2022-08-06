package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class VineQueenChuShiShiTiShengChengProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure VineQueenChuShiShiTiShengCheng!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure VineQueenChuShiShiTiShengCheng!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure VineQueenChuShiShiTiShengCheng!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure VineQueenChuShiShiTiShengCheng!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


			if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineEntity.CustomEntity(VineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x+1), y, (z+1), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineEntity.CustomEntity(VineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x+1), y, (z-1), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineEntity.CustomEntity(VineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x-1), y, (z+1), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineEntity.CustomEntity(VineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x-1), y, (z-1), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
world.setBlockState(new BlockPos(Math.floor(x)+1,y,Math.floor(z)+1), Blocks.AIR.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+1,y,Math.floor(z)-1), Blocks.AIR.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+1,y+1,Math.floor(z)+1), Blocks.AIR.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+1,y+1,Math.floor(z)-1), Blocks.AIR.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-1,y,Math.floor(z)+1), Blocks.AIR.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-1,y,Math.floor(z)-1), Blocks.AIR.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-1,y+1,Math.floor(z)+1), Blocks.AIR.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-1,y+1,Math.floor(z)-1), Blocks.AIR.getDefaultState(),3);
	}

}
