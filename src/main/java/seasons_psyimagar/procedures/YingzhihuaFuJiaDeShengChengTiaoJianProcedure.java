package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class YingzhihuaFuJiaDeShengChengTiaoJianProcedure {

	

	public static boolean executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure YingzhihuaFuJiaDeShengChengTiaoJian!");
				return false;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure YingzhihuaFuJiaDeShengChengTiaoJian!");
				return false;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure YingzhihuaFuJiaDeShengChengTiaoJian!");
				return false;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure YingzhihuaFuJiaDeShengChengTiaoJian!");
				return false;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


		if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x,y,z))) != null &&
        world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x,y,z)))
        .equals(new ResourceLocation("seasons_psyimagar:ying_hua_yuan"))) {return
true;}else if (Math.random()<0.05) {return
true;}return
false;
	}

}
