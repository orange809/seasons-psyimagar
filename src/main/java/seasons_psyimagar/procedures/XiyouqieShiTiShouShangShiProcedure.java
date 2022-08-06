package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class XiyouqieShiTiShouShangShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("sourceentity") == null) {
				if(!dependencies.containsKey("sourceentity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency sourceentity for procedure XiyouqieShiTiShouShangShi!");
				return;
			}

				Entity sourceentity = (Entity) dependencies.get("sourceentity");


		if(sourceentity instanceof LivingEntity)
	((LivingEntity)sourceentity).addPotionEffect(new EffectInstance(Effects.SPEED,(int) 2000000,(int) 2));
	}

}
