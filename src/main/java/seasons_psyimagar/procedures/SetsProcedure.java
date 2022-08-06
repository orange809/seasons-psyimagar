package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SetsProcedure {

	@Mod.EventBusSubscriber private static class GlobalTrigger {
	@SubscribeEvent public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if(event.phase == TickEvent.Phase.END){
			Entity entity = event.player;
			World world = entity.world;
			double i=entity.getPosX();
			double j=entity.getPosY();
			double k=entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x",i);
			dependencies.put("y",j);
			dependencies.put("z",k);
			dependencies.put("world",world);
			dependencies.put("entity",entity);
			dependencies.put("event",event);
			executeProcedure(dependencies);
		}
	}
}

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure Sets!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure Sets!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure Sets!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure Sets!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure Sets!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				Entity entity = (Entity) dependencies.get("entity");


		if ((new Object(){int check(Entity _entity){
		if(_entity instanceof LivingEntity){
		Collection<EffectInstance> effects=((LivingEntity)_entity).getActivePotionEffects();
		for(EffectInstance effect:effects){
		if(effect.getPotion()== Effects.SLOW_FALLING)
		return effect.getDuration();
		}
		}
		return 0;
		}}.check(entity)<=15||!(new Object(){boolean check(Entity _entity){
		if(_entity instanceof LivingEntity){
		Collection<EffectInstance> effects=((LivingEntity)_entity).getActivePotionEffects();
		for(EffectInstance effect:effects){
		if(effect.getPotion()== Effects.SLOW_FALLING)
		return true;
		}
		}
		return false;
		}}.check(entity)))&&world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x,y,z))) != null &&
        world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x,y,z)))
        .equals(new ResourceLocation("seasons_psyimagar:zhui_luo_tian_kong"))) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING,(int) 20,(int) 2));}if ((new Object(){int check(Entity _entity){
		if(_entity instanceof LivingEntity){
		Collection<EffectInstance> effects=((LivingEntity)_entity).getActivePotionEffects();
		for(EffectInstance effect:effects){
		if(effect.getPotion()== Effects.SPEED)
		return effect.getDuration();
		}
		}
		return 0;
		}}.check(entity)<=15||!(new Object(){boolean check(Entity _entity){
		if(_entity instanceof LivingEntity){
		Collection<EffectInstance> effects=((LivingEntity)_entity).getActivePotionEffects();
		for(EffectInstance effect:effects){
		if(effect.getPotion()== Effects.SPEED)
		return true;
		}
		}
		return false;
		}}.check(entity)))&&world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x,y,z))) != null &&
        world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x,y,z)))
        .equals(new ResourceLocation("seasons_psyimagar:zhui_luo_tian_kong"))) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.SPEED,(int) 20,(int) 2));}if (!((entity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null)
  .orElse(new SeasonsPsyimagarModVariables.PlayerVariables())).sky_tick_say>=400)) {{
  double _setval = ((entity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null)
  .orElse(new SeasonsPsyimagarModVariables.PlayerVariables())).sky_tick_say+1);
  entity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
    capability.sky_tick_say = _setval;
    capability.syncPlayerVariables(entity);
  });
}}if (entity.getPosY()>=90&&(new Object(){int check(Entity _entity){
		if(_entity instanceof LivingEntity){
		Collection<EffectInstance> effects=((LivingEntity)_entity).getActivePotionEffects();
		for(EffectInstance effect:effects){
		if(effect.getPotion()== QuhanPotionEffect.potion)
		return effect.getDuration();
		}
		}
		return 0;
		}}.check(entity)<=95||!(new Object(){boolean check(Entity _entity){
		if(_entity instanceof LivingEntity){
		Collection<EffectInstance> effects=((LivingEntity)_entity).getActivePotionEffects();
		for(EffectInstance effect:effects){
		if(effect.getPotion()== QuhanPotionEffect.potion)
		return true;
		}
		}
		return false;
		}}.check(entity)))&&world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x,y,z))) != null &&
        world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x,y,z)))
        .equals(new ResourceLocation("seasons_psyimagar:han_chao_lin"))) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(JieshuangPotionEffect.potion,(int) 100,(int) 0));if ((entity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null)
  .orElse(new SeasonsPsyimagarModVariables.PlayerVariables())).sky_tick_say>=400) {{
	Entity _ent = entity;
	if(!_ent.world.isRemote && _ent.world.getServer() != null) {
		_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource()
			.withFeedbackDisabled().withPermissionLevel(4), ("tellraw @s {\"text\":\""+""+new TranslationTextComponent("chat.wwworld.guide_sky").getString()+"\"}"));
	}
}{
  double _setval = 0;
  entity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
    capability.sky_tick_say = _setval;
    capability.syncPlayerVariables(entity);
  });
}}}
	}

}
