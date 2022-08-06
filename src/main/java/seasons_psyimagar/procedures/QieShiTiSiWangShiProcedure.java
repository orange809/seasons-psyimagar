package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class QieShiTiSiWangShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure QieShiTiSiWangShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure QieShiTiSiWangShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure QieShiTiSiWangShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure QieShiTiSiWangShi!");
				return;
			}
			if(dependencies.get("sourceentity") == null) {
				if(!dependencies.containsKey("sourceentity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency sourceentity for procedure QieShiTiSiWangShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				Entity sourceentity = (Entity) dependencies.get("sourceentity");


		if (sourceentity instanceof PlayerEntity) {{
  double _setval = ((sourceentity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null)
  .orElse(new SeasonsPsyimagarModVariables.PlayerVariables())).qie10+1);
  sourceentity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
    capability.qie10 = _setval;
    capability.syncPlayerVariables(sourceentity);
  });
}}if (Math.random()<0.25) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(QiqyumaoItem.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}if (Math.random()<0.5) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Qie1Item.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}
	}

}
