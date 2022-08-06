package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class QiuzhitengwanDangFangKuaiBeiWanJiaPoPiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure QiuzhitengwanDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure QiuzhitengwanDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure QiuzhitengwanDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure QiuzhitengwanDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure QiuzhitengwanDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				Entity entity = (Entity) dependencies.get("entity");


		if (((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY).getItem() == Items.SHEARS&&!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(QiuzhitengwanBlock.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}else if (Math.random()<0.75&&!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(QiuzhitengwanBlock.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}
	}

}
