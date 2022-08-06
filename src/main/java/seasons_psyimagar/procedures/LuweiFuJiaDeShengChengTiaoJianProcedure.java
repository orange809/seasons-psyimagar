package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class LuweiFuJiaDeShengChengTiaoJianProcedure {

	

	public static boolean executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure LuweiFuJiaDeShengChengTiaoJian!");
				return false;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure LuweiFuJiaDeShengChengTiaoJian!");
				return false;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure LuweiFuJiaDeShengChengTiaoJian!");
				return false;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure LuweiFuJiaDeShengChengTiaoJian!");
				return false;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


		if ((world.getBlockState(new BlockPos(x+1,y-2,z))).getBlock() == Blocks.WATER||(world.getBlockState(new BlockPos(x-1,y-2,z))).getBlock() == Blocks.WATER||(world.getBlockState(new BlockPos(x,y-2,z+1))).getBlock() == Blocks.WATER||(world.getBlockState(new BlockPos(x,y-2,z-1))).getBlock() == Blocks.WATER||(world.getBlockState(new BlockPos(x+2,y-2,z))).getBlock() == Blocks.WATER||(world.getBlockState(new BlockPos(x-2,y-2,z))).getBlock() == Blocks.WATER||(world.getBlockState(new BlockPos(x,y-2,z+2))).getBlock() == Blocks.WATER||(world.getBlockState(new BlockPos(x,y-2,z-2))).getBlock() == Blocks.WATER) {return
true;}return
false;
	}

}
