package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class LightningSwordRightClickedInAirProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure LightningSwordRightClickedInAir!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure LightningSwordRightClickedInAir!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure LightningSwordRightClickedInAir!");
				return;
			}
			if(dependencies.get("itemstack") == null) {
				if(!dependencies.containsKey("itemstack"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency itemstack for procedure LightningSwordRightClickedInAir!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				Entity entity = (Entity) dependencies.get("entity");
				ItemStack itemstack = (ItemStack) dependencies.get("itemstack");

double distance = 0;
		entity.getPersistentData().putDouble("lightningTime", 20);distance = (-2);entity.getPersistentData().putBoolean("eventEntity", (true));for (int index0 = 0; index0<(int)(8); index0++) {distance = (distance+3);if(world instanceof ServerWorld) {
	LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
    _ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
        RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getX(),world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
        RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()), (int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
        RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())),entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
        RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())));
    _ent.setEffectOnly(false);
    ((World) world).addEntity(_ent);
}{
    List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(
            (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
        RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) - (2 / 2d), y - (2 / 2d), (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
        RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) - (2 / 2d),
            (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
        RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) + (2 / 2d), y + (2 / 2d), (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
        RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (2 / 2d)), null)
		.stream()
		.sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
			}
		}.compareDistOf((entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
        RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()), y, (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
        RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
        .collect(Collectors.toList());
    for(Entity entityiterator : _entfound) {
        if (entityiterator.getPersistentData().getBoolean("eventEntity")==false) {if(entityiterator instanceof LivingEntity)
	((LivingEntity)entityiterator).addPotionEffect(new EffectInstance(ParalysisPotionEffect.potion,(int) 100,(int) 1, (true), (true)));}
    }
}}entity.getPersistentData().putBoolean("eventEntity", (false));if (!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {if(entity instanceof PlayerEntity)
	((PlayerEntity)entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 500);}
	}

}
