package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class YunhuaDangShiTiZaiFangKuaiZhongPengZhuangShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure YunhuaDangShiTiZaiFangKuaiZhongPengZhuangShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if (new Object(){int check(Entity _entity){
		if(_entity instanceof LivingEntity){
		Collection<EffectInstance> effects=((LivingEntity)_entity).getActivePotionEffects();
		for(EffectInstance effect:effects){
		if(effect.getPotion()== Effects.LEVITATION)
		return effect.getDuration();
		}
		}
		return 0;
		}}.check(entity)<=115||!(new Object(){boolean check(Entity _entity){
		if(_entity instanceof LivingEntity){
		Collection<EffectInstance> effects=((LivingEntity)_entity).getActivePotionEffects();
		for(EffectInstance effect:effects){
		if(effect.getPotion()== Effects.LEVITATION)
		return true;
		}
		}
		return false;
		}}.check(entity))) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.LEVITATION,(int) 120,(int) 2));}
	}

}
