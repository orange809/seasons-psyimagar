package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class BingxuezhihuaMobplayerCollidesWithPlantProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure BingxuezhihuaMobplayerCollidesWithPlant!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if (new Object(){int check(Entity _entity){
		if(_entity instanceof LivingEntity){
		Collection<EffectInstance> effects=((LivingEntity)_entity).getActivePotionEffects();
		for(EffectInstance effect:effects){
		if(effect.getPotion()== Effects.SLOWNESS)
		return effect.getDuration();
		}
		}
		return 0;
		}}.check(entity)<=55||!(new Object(){boolean check(Entity _entity){
		if(_entity instanceof LivingEntity){
		Collection<EffectInstance> effects=((LivingEntity)_entity).getActivePotionEffects();
		for(EffectInstance effect:effects){
		if(effect.getPotion()== Effects.SLOWNESS)
		return true;
		}
		}
		return false;
		}}.check(entity))) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS,(int) 60,(int) 2));}
	}

}
