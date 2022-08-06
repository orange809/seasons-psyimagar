package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class Shuidao3GengXinYouXiKeProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure Shuidao3GengXinYouXiKe!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure Shuidao3GengXinYouXiKe!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure Shuidao3GengXinYouXiKe!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure Shuidao3GengXinYouXiKe!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


		if (!((world.getBlockState(new BlockPos(x,y+1,z))).getBlock() == Shuidao4Block.block&&(world.getBlockState(new BlockPos(x+1,y,z))).getBlock() == Blocks.WATER&&(world.getBlockState(new BlockPos(x-1,y,z))).getBlock() == Blocks.WATER&&(world.getBlockState(new BlockPos(x,y,z+1))).getBlock() == Blocks.WATER&&(world.getBlockState(new BlockPos(x,y,z-1))).getBlock() == Blocks.WATER&&(world.getBlockState(new BlockPos(x,y-1,z))).getBlock() == NituBlock.block)) {if(world instanceof World) {
    Block.spawnDrops(world.getBlockState(
        new BlockPos(x,y,z)), (World) world, new BlockPos(x,y,z));

    world.destroyBlock(new BlockPos(x,y,z), false);
}}
	}

}
