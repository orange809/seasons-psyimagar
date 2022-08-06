package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class CaomeiDangShiWuBeiChiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure CaomeiDangShiWuBeiChiShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if (Math.random()<0.15) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH,(int) 1,(int) 0));}
	}

}
