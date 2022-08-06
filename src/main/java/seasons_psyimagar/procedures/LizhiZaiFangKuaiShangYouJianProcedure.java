package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class LizhiZaiFangKuaiShangYouJianProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure LizhiZaiFangKuaiShangYouJian!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure LizhiZaiFangKuaiShangYouJian!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure LizhiZaiFangKuaiShangYouJian!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure LizhiZaiFangKuaiShangYouJian!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


		{
    BlockPos _bp = new BlockPos(x,y,z);
    BlockState _bs = Blocks.AIR.getDefaultState();

    BlockState _bso = world.getBlockState(_bp);

    for(Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
        Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
        if (_property != null && _bs.get(_property) != null)
            try {
            	_bs = _bs.with(_property, (Comparable) entry.getValue());
            } catch (Exception e) {}
    }


    world.setBlockState(_bp, _bs, 3);

}
if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(LizhishifoodItem.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}
	}

}
