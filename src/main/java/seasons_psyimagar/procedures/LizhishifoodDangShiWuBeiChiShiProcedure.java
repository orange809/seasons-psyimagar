package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class LizhishifoodDangShiWuBeiChiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure LizhishifoodDangShiWuBeiChiShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if (Math.random()<0.025) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.HASTE,(int) 240,(int) 4));if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS,(int) 240,(int) 4));if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.NAUSEA,(int) 240,(int) 4));if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS,(int) 200,(int) 2));if(entity instanceof ServerPlayerEntity) {
	Advancement _adv = ((MinecraftServer)((ServerPlayerEntity)entity).server).getAdvancementManager()
        .getAdvancement(new ResourceLocation("seasons_psyimagar:deleted_mod_element"));
    AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
    if (!_ap.isDone()) {
        Iterator _iterator = _ap.getRemaningCriteria().iterator();
        while(_iterator.hasNext()) {
            String _criterion = (String)_iterator.next();
            ((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
        }
    }
}}
	}

}
