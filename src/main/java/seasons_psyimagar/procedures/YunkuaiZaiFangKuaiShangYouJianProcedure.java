package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class YunkuaiZaiFangKuaiShangYouJianProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure YunkuaiZaiFangKuaiShangYouJian!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.LEVITATION,(int) 120,(int) 2));
	}

}
