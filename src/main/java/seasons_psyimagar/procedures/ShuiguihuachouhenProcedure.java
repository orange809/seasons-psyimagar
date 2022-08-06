package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ShuiguihuachouhenProcedure {

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

	public static boolean executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure Shuiguihuachouhen!");
				return false;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if (((entity instanceof LivingEntity)?((LivingEntity)entity).getItemStackFromSlot(EquipmentSlotType.HEAD):ItemStack.EMPTY).getItem() == LingguangkuijiaItem.helmet) {return
true;}return
false;
	}

}
