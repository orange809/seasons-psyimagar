package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class JingyanjianDangShiTiBeiGongJuJiZhongShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure JingyanjianDangShiTiBeiGongJuJiZhongShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure JingyanjianDangShiTiBeiGongJuJiZhongShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure JingyanjianDangShiTiBeiGongJuJiZhongShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure JingyanjianDangShiTiBeiGongJuJiZhongShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


		if (Math.random()<0.9) {if (world instanceof World && !world.isRemote()) {
	((World) world).addEntity(new ExperienceOrbEntity(((World) world), (x+0.5), (y+0.5), (z+0.5),(int)4));
}}if (Math.random()<0.7) {if (world instanceof World && !world.isRemote()) {
	((World) world).addEntity(new ExperienceOrbEntity(((World) world), (x+0.5), (y+0.5), (z+0.5),(int)4));
}}if (Math.random()<0.6) {if (world instanceof World && !world.isRemote()) {
	((World) world).addEntity(new ExperienceOrbEntity(((World) world), (x+0.5), (y+0.5), (z+0.5),(int)4));
}}
	}

}
