
package seasons_psyimagar.potion;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)  public class ParalysisPotionEffect {

	@ObjectHolder("seasons_psyimagar:paralysis")
	public static final Effect potion = null;

	@SubscribeEvent public static void registerEffect(RegistryEvent.Register<Effect> event) {
		event.getRegistry().register(new EffectCustom());
	}

	public static class EffectCustom extends Effect {

		public EffectCustom() {
			super(EffectType.HARMFUL, -6711040);
			setRegistryName("paralysis");
		}

		@Override public String getName() {
      		return "effect.paralysis";
   		}

		@Override public boolean isBeneficial() {
        	return false;
    	}

		@Override public boolean isInstant() {
        	return false;
    	}

   	 	@Override public boolean shouldRenderInvText(EffectInstance effect) {
    	    return true;
    	}

		@Override public boolean shouldRender(EffectInstance effect) {
			return true;
		}

    	@Override public boolean shouldRenderHUD(EffectInstance effect) {
    	    return true;
    	}


		@Override public void performEffect(LivingEntity entity, int amplifier) {
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
    


        ParalysisOnPotionActiveTickProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}


		@Override public boolean isReady(int duration, int amplifier) {
			return true;
		}

	}

}
