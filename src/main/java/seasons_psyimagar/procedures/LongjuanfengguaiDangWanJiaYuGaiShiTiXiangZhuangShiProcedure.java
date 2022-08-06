package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class LongjuanfengguaiDangWanJiaYuGaiShiTiXiangZhuangShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure LongjuanfengguaiDangWanJiaYuGaiShiTiXiangZhuangShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure LongjuanfengguaiDangWanJiaYuGaiShiTiXiangZhuangShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure LongjuanfengguaiDangWanJiaYuGaiShiTiXiangZhuangShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure LongjuanfengguaiDangWanJiaYuGaiShiTiXiangZhuangShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");

double distance = 0;
		world.addParticle(LongjuanfengguailiziParticle.particle, (x+1), y, z, 0, 1, 0);world.addParticle(LongjuanfengguailiziParticle.particle, (x-1), y, z, 0, 1, 0);world.addParticle(LongjuanfengguailiziParticle.particle, x, y, (z+1), 0, 1, 0);world.addParticle(LongjuanfengguailiziParticle.particle, x, y, (z-1), 0, 1, 0);world.addParticle(LongjuanfengguailiziParticle.particle, (x+1), y, (z+1), 0, 1, 0);world.addParticle(LongjuanfengguailiziParticle.particle, (x+1), y, (z-1), 0, 1, 0);world.addParticle(LongjuanfengguailiziParticle.particle, (x-1), y, (z+1), 0, 1, 0);world.addParticle(LongjuanfengguailiziParticle.particle, (x-1), y, (z-1), 0, 1, 0);world.addParticle(LongjuanfengguailiziParticle.particle, x, y, z, 0, 1, 0);
	}

}
