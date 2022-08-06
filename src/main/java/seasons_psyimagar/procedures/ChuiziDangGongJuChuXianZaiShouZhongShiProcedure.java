package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ChuiziDangGongJuChuXianZaiShouZhongShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure ChuiziDangGongJuChuXianZaiShouZhongShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS,(int) 1,(int) 1, (false), (false)));
	}

}
