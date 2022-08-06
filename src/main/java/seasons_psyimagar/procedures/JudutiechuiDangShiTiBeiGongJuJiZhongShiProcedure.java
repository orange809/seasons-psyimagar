package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class JudutiechuiDangShiTiBeiGongJuJiZhongShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure JudutiechuiDangShiTiBeiGongJuJiZhongShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.POISON,(int) 60,(int) 0));
	}

}
