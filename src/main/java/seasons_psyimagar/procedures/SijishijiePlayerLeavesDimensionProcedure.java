package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SijishijiePlayerLeavesDimensionProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure SijishijiePlayerLeavesDimension!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		{
  boolean _setval = (true);
  entity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
    capability.leftSeasonsDimension = _setval;
    capability.syncPlayerVariables(entity);
  });
}
	}

}
