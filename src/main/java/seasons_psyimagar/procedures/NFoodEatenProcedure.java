package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class NFoodEatenProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure NFoodEaten!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if (Math.random()<0.4) {if(entity instanceof PlayerEntity)((PlayerEntity)entity).giveExperiencePoints((int)2);}else{if(entity instanceof PlayerEntity)((PlayerEntity)entity).giveExperiencePoints((int)Math.random());}
	}

}
