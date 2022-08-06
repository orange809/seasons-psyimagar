package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class VineQueenDangShiTiGengXinKeShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure VineQueenDangShiTiGengXinKeShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure VineQueenDangShiTiGengXinKeShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure VineQueenDangShiTiGengXinKeShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure VineQueenDangShiTiGengXinKeShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure VineQueenDangShiTiGengXinKeShi!");
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


		world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+1,y-1,Math.floor(z)+1), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+1,y-1,Math.floor(z)-1), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-1,y-1,Math.floor(z)+1), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-1,y-1,Math.floor(z)-1), CaofangkuaiBlock.block.getDefaultState(),3);if (((Entity) world.getEntitiesWithinAABB(VineEntity.CustomEntity.class, new AxisAlignedBB(
            x - (3 / 2d), y - (3 / 2d), z - (3 / 2d),
            x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
) != null) {if(entity instanceof LivingEntity)((LivingEntity)entity).setHealth((float)120);}new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        {
	Entity _ent = entity;
    _ent.setPositionAndUpdate(x,y,z);
    if (_ent instanceof ServerPlayerEntity) {
    	((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, z, _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
    }
}
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 1);
entity.getPersistentData().putDouble("start", (entity.getPersistentData().getDouble("start")+1));entity.getPersistentData().putDouble("baozhatengwan", (entity.getPersistentData().getDouble("baozhatengwan")+1));entity.getPersistentData().putDouble("tengwanhua", (entity.getPersistentData().getDouble("tengwanhua")+1));entity.getPersistentData().putDouble("huaxiaoguai", (entity.getPersistentData().getDouble("huaxiaoguai")+1));entity.getPersistentData().putDouble("tengwan", (entity.getPersistentData().getDouble("tengwan")+1));if (entity.getPersistentData().getDouble("start")==40) {if(world instanceof World && !world.isRemote()) {
	((World) world).playSound(null, new BlockPos(x,y,z),
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("seasons_psyimagar:tengwanshengchengshi")),
		SoundCategory.MASTER, (float) 1, (float) 1);
} else {
	((World) world).playSound(x, y, z,
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("seasons_psyimagar:tengwanshengchengshi")),
		SoundCategory.MASTER, (float) 1, (float) 1, false);
}	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new ExplosiveVineEntity.CustomEntity(ExplosiveVineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x+2), y, (z+2), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new ExplosiveVineEntity.CustomEntity(ExplosiveVineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x+2), y, (z-2), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new ExplosiveVineEntity.CustomEntity(ExplosiveVineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x-2), y, (z+2), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new ExplosiveVineEntity.CustomEntity(ExplosiveVineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x-2), y, (z-2), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineFlowerEntity.CustomEntity(VineFlowerEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x+3), y, (z+3), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineFlowerEntity.CustomEntity(VineFlowerEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x+3), y, (z-3), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineFlowerEntity.CustomEntity(VineFlowerEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x-3), y, (z+3), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineFlowerEntity.CustomEntity(VineFlowerEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x-3), y, (z-3), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
}if (!(((Entity) world.getEntitiesWithinAABB(ExplosiveVineEntity.CustomEntity.class, new AxisAlignedBB(
            x - (60 / 2d), y - (60 / 2d), z - (60 / 2d),
            x + (60 / 2d), y + (60 / 2d), z + (60 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
) != null)&&entity.getPersistentData().getDouble("baozhatengwan")>=400) {if(world instanceof World && !world.isRemote()) {
	((World) world).playSound(null, new BlockPos(x,y,z),
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("seasons_psyimagar:tengwanshengchengshi")),
		SoundCategory.MASTER, (float) 1, (float) 1);
} else {
	((World) world).playSound(x, y, z,
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("seasons_psyimagar:tengwanshengchengshi")),
		SoundCategory.MASTER, (float) 1, (float) 1, false);
}	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new ExplosiveVineEntity.CustomEntity(ExplosiveVineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x+2), y, (z+2), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new ExplosiveVineEntity.CustomEntity(ExplosiveVineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x+2), y, (z-2), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new ExplosiveVineEntity.CustomEntity(ExplosiveVineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x-2), y, (z+2), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new ExplosiveVineEntity.CustomEntity(ExplosiveVineEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x-2), y, (z-2), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
entity.getPersistentData().putDouble("baozhatengwan", 0);}if (!(((Entity) world.getEntitiesWithinAABB(VineFlowerEntity.CustomEntity.class, new AxisAlignedBB(
            x - (60 / 2d), y - (60 / 2d), z - (60 / 2d),
            x + (60 / 2d), y + (60 / 2d), z + (60 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
) != null)&&entity.getPersistentData().getDouble("tengwanhua")>=400) {if(world instanceof World && !world.isRemote()) {
	((World) world).playSound(null, new BlockPos(x,y,z),
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("seasons_psyimagar:tengwanshengchengshi")),
		SoundCategory.MASTER, (float) 1, (float) 1);
} else {
	((World) world).playSound(x, y, z,
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("seasons_psyimagar:tengwanshengchengshi")),
		SoundCategory.MASTER, (float) 1, (float) 1, false);
}	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineFlowerEntity.CustomEntity(VineFlowerEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x+3), y, (z+3), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineFlowerEntity.CustomEntity(VineFlowerEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x+3), y, (z-3), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineFlowerEntity.CustomEntity(VineFlowerEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x-3), y, (z+3), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new VineFlowerEntity.CustomEntity(VineFlowerEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x-3), y, (z-3), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
entity.getPersistentData().putDouble("tengwanhua", 0);}if (!(((Entity) world.getEntitiesWithinAABB(FlowerSpiritEntity.CustomEntity.class, new AxisAlignedBB(
            x - (16 / 2d), y - (16 / 2d), z - (16 / 2d),
            x + (16 / 2d), y + (16 / 2d), z + (16 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
) != null)&&!(((Entity) world.getEntitiesWithinAABB(VineEntity.CustomEntity.class, new AxisAlignedBB(
            x - (3 / 2d), y - (3 / 2d), z - (3 / 2d),
            x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
) != null)&&entity.getPersistentData().getDouble("huaxiaoguai")>=200) {	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new FlowerSpiritEntity.CustomEntity(FlowerSpiritEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x+1), y, z, (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new FlowerSpiritEntity.CustomEntity(FlowerSpiritEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles((x-1), y, z, (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new FlowerSpiritEntity.CustomEntity(FlowerSpiritEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles(x, y, (z+1), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
	if(world instanceof ServerWorld) {
			Entity entityToSpawn = new FlowerSpiritEntity.CustomEntity(FlowerSpiritEntity.entity, (World) world);
		entityToSpawn.setLocationAndAngles(x, y, (z-1), (float) 0, (float) 0);
		entityToSpawn.setRenderYawOffset((float) 0);
		entityToSpawn.setRotationYawHead((float) 0);

		if (entityToSpawn instanceof MobEntity)
			((MobEntity)entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);

		world.addEntity(entityToSpawn);
	}
entity.getPersistentData().putDouble("huaxiaoguai", 0);}if (entity.getPersistentData().getDouble("tengwan")>=60) {entity.getPersistentData().putDouble("tengwan", 0);new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+3,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+3,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-3,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-3,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)+3), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)+3), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)-3), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)-3), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 5);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+4,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+4,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-4,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-4,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)+4), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)+4), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)-4), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)-4), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 10);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+5,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+5,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-5,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-5,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)+5), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)+5), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)-5), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)-5), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 15);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+6,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+6,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-6,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-6,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)+6), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)+6), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)-6), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)-6), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 20);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+7,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+7,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-7,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-7,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)+7), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)+7), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)-7), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)-7), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 25);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+8,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+8,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-8,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-8,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)+8), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)+8), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)-8), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)-8), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 30);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+9,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+9,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-9,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-9,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)+9), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)+9), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)-9), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)-9), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 35);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+10,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+10,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-10,y-1,Math.floor(z)), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-10,y-2,Math.floor(z)), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)+10), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)+10), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-1,Math.floor(z)-10), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x),y-2,Math.floor(z)-10), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 40);
}if (!(((Entity) world.getEntitiesWithinAABB(VineEntity.CustomEntity.class, new AxisAlignedBB(
            x - (3 / 2d), y - (3 / 2d), z - (3 / 2d),
            x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
) != null)&&entity.getPersistentData().getDouble("huaxiaoguai")>=60) {new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+5,y-1,Math.floor(z)+5), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+5,y-2,Math.floor(z)+5), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+5,y-1,Math.floor(z)-5), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+5,y-2,Math.floor(z)-5), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-5,y-1,Math.floor(z)+5), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-5,y-2,Math.floor(z)+5), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-5,y-1,Math.floor(z)-5), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-5,y-2,Math.floor(z)-5), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 5);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+6,y-1,Math.floor(z)+6), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+6,y-2,Math.floor(z)+6), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+6,y-1,Math.floor(z)-6), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+6,y-2,Math.floor(z)-6), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-6,y-1,Math.floor(z)+6), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-6,y-2,Math.floor(z)+6), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-6,y-1,Math.floor(z)-6), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-6,y-2,Math.floor(z)-6), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 10);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+7,y-1,Math.floor(z)+7), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+7,y-2,Math.floor(z)+7), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+7,y-1,Math.floor(z)-7), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+7,y-2,Math.floor(z)-7), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-7,y-1,Math.floor(z)+7), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-7,y-2,Math.floor(z)+7), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-7,y-1,Math.floor(z)-7), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-7,y-2,Math.floor(z)-7), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 15);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+8,y-1,Math.floor(z)+8), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+8,y-2,Math.floor(z)+8), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+8,y-1,Math.floor(z)-8), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+8,y-2,Math.floor(z)-8), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-8,y-1,Math.floor(z)+8), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-8,y-2,Math.floor(z)+8), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-8,y-1,Math.floor(z)-8), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-8,y-2,Math.floor(z)-8), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 20);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+9,y-1,Math.floor(z)+9), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+9,y-2,Math.floor(z)+9), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+9,y-1,Math.floor(z)-9), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+9,y-2,Math.floor(z)-9), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-9,y-1,Math.floor(z)+9), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-9,y-2,Math.floor(z)+9), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-9,y-1,Math.floor(z)-9), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-9,y-2,Math.floor(z)-9), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 25);
new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        world.setBlockState(new BlockPos(Math.floor(x)+10,y-1,Math.floor(z)+10), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+10,y-2,Math.floor(z)+10), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+10,y-1,Math.floor(z)-10), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)+10,y-2,Math.floor(z)-10), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-10,y-1,Math.floor(z)+10), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-10,y-2,Math.floor(z)+10), CaofangkuaiBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-10,y-1,Math.floor(z)-10), JingcicongBlock.block.getDefaultState(),3);world.setBlockState(new BlockPos(Math.floor(x)-10,y-2,Math.floor(z)-10), CaofangkuaiBlock.block.getDefaultState(),3);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 30);
}
	}

}
