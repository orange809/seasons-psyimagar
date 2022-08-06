package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ParalysisOnPotionActiveTickProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure ParalysisOnPotionActiveTick!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST,(int) 2,(int) (-3), (false), (false)));if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS,(int) 2,(int) 10, (false), (false)));if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS,(int) 2,(int) 1, (false), (false)));if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS,(int) 2,(int) 1, (false), (false)));
	}

}
