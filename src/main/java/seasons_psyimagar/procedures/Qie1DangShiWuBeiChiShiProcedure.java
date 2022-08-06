package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class Qie1DangShiWuBeiChiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure Qie1DangShiWuBeiChiShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.HUNGER,(int) 100,(int) 3));if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.POISON,(int) 100,(int) 3));if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.NAUSEA,(int) 100,(int) 5));
	}

}
