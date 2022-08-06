package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SongguodongGengXinYouXiKeProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure SongguodongGengXinYouXiKe!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure SongguodongGengXinYouXiKe!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure SongguodongGengXinYouXiKe!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure SongguodongGengXinYouXiKe!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


		if (Math.random()<0.45&&!(((Entity) world.getEntitiesWithinAABB(SongshuEntity.CustomEntity.class, new AxisAlignedBB(
            x - (60 / 2d), y - (60 / 2d), z - (60 / 2d),
            x + (60 / 2d), y + (60 / 2d), z + (60 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
) != null)) {if ((new Object() {
	public Direction getDirection(BlockPos pos){
		try {
			BlockState _bs = world.getBlockState(pos);
			DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
			if (property != null)
				return _bs.get(property);
			return Direction.getFacingFromAxisDirection(_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock()
				.getStateContainer().getProperty("axis")), Direction.AxisDirection.POSITIVE);
		} catch (Exception e) {
			return Direction.NORTH;
		}
}}.getDirection(new BlockPos(x,y,z))) == Direction.EAST) {	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new SongshuEntity.CustomEntity(SongshuEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((Math.floor(x)+1.5), (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (Math.floor(x)+1.5), (int) (Math.floor(z)+0.5))), (Math.floor(z)+0.5), world.getRandom().nextFloat() * 360F, 0);

		if (entityToSpawn instanceof MobEntity)
               ((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
}if ((new Object() {
	public Direction getDirection(BlockPos pos){
		try {
			BlockState _bs = world.getBlockState(pos);
			DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
			if (property != null)
				return _bs.get(property);
			return Direction.getFacingFromAxisDirection(_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock()
				.getStateContainer().getProperty("axis")), Direction.AxisDirection.POSITIVE);
		} catch (Exception e) {
			return Direction.NORTH;
		}
}}.getDirection(new BlockPos(x,y,z))) == Direction.WEST) {	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new SongshuEntity.CustomEntity(SongshuEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((Math.floor(x)-1.5), (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (Math.floor(x)-1.5), (int) (Math.floor(z)+0.5))), (Math.floor(z)+0.5), world.getRandom().nextFloat() * 360F, 0);

		if (entityToSpawn instanceof MobEntity)
               ((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
}if ((new Object() {
	public Direction getDirection(BlockPos pos){
		try {
			BlockState _bs = world.getBlockState(pos);
			DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
			if (property != null)
				return _bs.get(property);
			return Direction.getFacingFromAxisDirection(_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock()
				.getStateContainer().getProperty("axis")), Direction.AxisDirection.POSITIVE);
		} catch (Exception e) {
			return Direction.NORTH;
		}
}}.getDirection(new BlockPos(x,y,z))) == Direction.SOUTH) {	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new SongshuEntity.CustomEntity(SongshuEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((Math.floor(x)+0.5), (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (Math.floor(x)+0.5), (int) (Math.floor(z)+1.5))), (Math.floor(z)+1.5), world.getRandom().nextFloat() * 360F, 0);

		if (entityToSpawn instanceof MobEntity)
               ((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
}if ((new Object() {
	public Direction getDirection(BlockPos pos){
		try {
			BlockState _bs = world.getBlockState(pos);
			DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
			if (property != null)
				return _bs.get(property);
			return Direction.getFacingFromAxisDirection(_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock()
				.getStateContainer().getProperty("axis")), Direction.AxisDirection.POSITIVE);
		} catch (Exception e) {
			return Direction.NORTH;
		}
}}.getDirection(new BlockPos(x,y,z))) == Direction.NORTH) {	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new SongshuEntity.CustomEntity(SongshuEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((Math.floor(x)+0.5), (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (Math.floor(x)+0.5), (int) (Math.floor(z)-1.5))), (Math.floor(z)-1.5), world.getRandom().nextFloat() * 360F, 0);

		if (entityToSpawn instanceof MobEntity)
               ((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
}}
	}

}
