package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class YunnaitongDangShiWuBeiChiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure YunnaitongDangShiWuBeiChiShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(TengfeiPotionEffect.potion,(int) 600,(int) 0));
	}

}
