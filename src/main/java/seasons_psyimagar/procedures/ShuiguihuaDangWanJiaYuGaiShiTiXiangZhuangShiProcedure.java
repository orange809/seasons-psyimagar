package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ShuiguihuaDangWanJiaYuGaiShiTiXiangZhuangShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure ShuiguihuaDangWanJiaYuGaiShiTiXiangZhuangShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure ShuiguihuaDangWanJiaYuGaiShiTiXiangZhuangShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure ShuiguihuaDangWanJiaYuGaiShiTiXiangZhuangShi!");
				return;
			}
			if(dependencies.get("sourceentity") == null) {
				if(!dependencies.containsKey("sourceentity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ShuiguihuaDangWanJiaYuGaiShiTiXiangZhuangShi!");
				return;
			}

				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				Entity sourceentity = (Entity) dependencies.get("sourceentity");


		if (!(((sourceentity instanceof LivingEntity)?((LivingEntity)sourceentity).getItemStackFromSlot(EquipmentSlotType.HEAD):ItemStack.EMPTY).getItem() == LingguangkuijiaItem.helmet)||!((sourceentity instanceof PlayerEntity)?((PlayerEntity)sourceentity).abilities.isCreativeMode:false)) {{
	Entity _ent = sourceentity;
    _ent.setPositionAndUpdate((Math.floor(x)+0.5),y,(Math.floor(z)+0.5));
    if (_ent instanceof ServerPlayerEntity) {
    	((ServerPlayerEntity) _ent).connection.setPlayerLocation((Math.floor(x)+0.5), y, (Math.floor(z)+0.5), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
    }
}}
	}

}
