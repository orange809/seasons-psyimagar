package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class XiajikanghuoyaoshuiDangShiWuBeiChiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure XiajikanghuoyaoshuiDangShiWuBeiChiShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,(int) 4800,(int) 1, (false), (false)));
	}

}
