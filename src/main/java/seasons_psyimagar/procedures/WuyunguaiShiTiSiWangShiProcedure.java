package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class WuyunguaiShiTiSiWangShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure WuyunguaiShiTiSiWangShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure WuyunguaiShiTiSiWangShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure WuyunguaiShiTiSiWangShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure WuyunguaiShiTiSiWangShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


		if(world instanceof ServerWorld) {
	LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
    _ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x,y,z)));
    _ent.setEffectOnly(true);
    ((World) world).addEntity(_ent);
}if (Math.random()<0.3) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, (x+0.5), (y+0.5), (z+0.5), new ItemStack(WuyunsuipianItem.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}if (Math.random()<0.5) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, (x+0.5), (y+0.5), (z+0.5), new ItemStack(WuyunsuipianItem.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}if (Math.random()<0.7) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, (x+0.5), (y+0.5), (z+0.5), new ItemStack(WuyunsuipianItem.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}
	}

}
