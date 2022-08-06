package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class JiancicongKaiShiPoPiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure JiancicongKaiShiPoPiShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.POISON,(int) 40,(int) 0));
	}

}
