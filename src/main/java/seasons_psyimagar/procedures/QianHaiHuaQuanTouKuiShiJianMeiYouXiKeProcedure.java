package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class QianHaiHuaQuanTouKuiShiJianMeiYouXiKeProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure QianHaiHuaQuanTouKuiShiJianMeiYouXiKe!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if (entity.isInWater()) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING,(int) 1,(int) 0, (false), (false)));if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.HASTE,(int) 1,(int) 0, (false), (false)));}
	}

}
