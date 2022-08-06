package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class XiajiweiduDangWanJiaJinRuWeiDuShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure XiajiweiduDangWanJiaJinRuWeiDuShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure XiajiweiduDangWanJiaJinRuWeiDuShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure XiajiweiduDangWanJiaJinRuWeiDuShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure XiajiweiduDangWanJiaJinRuWeiDuShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				Entity entity = (Entity) dependencies.get("entity");


		{
	Entity _ent = entity;
    _ent.setPositionAndUpdate(x,(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)),z);
    if (_ent instanceof ServerPlayerEntity) {
    	((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, (world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z)), z, _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
    }
}
	}

}
