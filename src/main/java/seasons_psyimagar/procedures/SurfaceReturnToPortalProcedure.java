package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SurfaceReturnToPortalProcedure {

	@Mod.EventBusSubscriber private static class GlobalTrigger {
	@SubscribeEvent public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if(event.phase == TickEvent.Phase.END){
			Entity entity = event.player;
			World world = entity.world;
			double i=entity.getPosX();
			double j=entity.getPosY();
			double k=entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x",i);
			dependencies.put("y",j);
			dependencies.put("z",k);
			dependencies.put("world",world);
			dependencies.put("entity",entity);
			dependencies.put("event",event);
			executeProcedure(dependencies);
		}
	}
}

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure SurfaceReturnToPortal!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure SurfaceReturnToPortal!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				Entity entity = (Entity) dependencies.get("entity");


		if ((entity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null)
  .orElse(new SeasonsPsyimagarModVariables.PlayerVariables())).leftSeasonsDimension==true) {{
	Entity _ent = entity;
    _ent.setPositionAndUpdate(SeasonsPsyimagarModVariables.MapVariables.get(world).surfaceTelePointX,(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) SeasonsPsyimagarModVariables.MapVariables.get(world).surfaceTelePointX, (int) SeasonsPsyimagarModVariables.MapVariables.get(world).surfaceTelePointZ)+1),SeasonsPsyimagarModVariables.MapVariables.get(world).surfaceTelePointZ);
    if (_ent instanceof ServerPlayerEntity) {
    	((ServerPlayerEntity) _ent).connection.setPlayerLocation(SeasonsPsyimagarModVariables.MapVariables.get(world).surfaceTelePointX, (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) SeasonsPsyimagarModVariables.MapVariables.get(world).surfaceTelePointX, (int) SeasonsPsyimagarModVariables.MapVariables.get(world).surfaceTelePointZ)+1), SeasonsPsyimagarModVariables.MapVariables.get(world).surfaceTelePointZ, _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
    }
}{
  boolean _setval = (false);
  entity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
    capability.leftSeasonsDimension = _setval;
    capability.syncPlayerVariables(entity);
  });
}}
	}

}
