package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class DaixuedekuangshiduiDangFangKuaiBeiWanJiaPoPiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure DaixuedekuangshiduiDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure DaixuedekuangshiduiDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure DaixuedekuangshiduiDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure DaixuedekuangshiduiDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure DaixuedekuangshiduiDangFangKuaiBeiWanJiaPoPiShi!");
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


		if (!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {{
  double _setval = ((entity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null)
  .orElse(new SeasonsPsyimagarModVariables.PlayerVariables())).daixuedekuangshidui10+1);
  entity.getCapability(SeasonsPsyimagarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
    capability.daixuedekuangshidui10 = _setval;
    capability.syncPlayerVariables(entity);
  });
}if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.COBBLESTONE));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}if (Math.random()<0.001) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.NETHERITE_INGOT));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}}else if (Math.random()<0.01) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.DIAMOND));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}}else if (Math.random()<0.05) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.GOLD_INGOT));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}}else if (Math.random()<0.15) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_INGOT));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}}else if (Math.random()<0.3) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_NUGGET));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_NUGGET));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_NUGGET));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}}else if (Math.random()<0.4) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.GOLD_NUGGET));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.GOLD_NUGGET));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}}else if (Math.random()<0.5) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_NUGGET));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_NUGGET));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}}else if (Math.random()<0.7) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(MeitanliItem.block));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(MeitanliItem.block));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}}else if (Math.random()<0.8) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.COBBLESTONE));
	entityToSpawn.setPickupDelay((int)5);
	world.addEntity(entityToSpawn);
}}}
	}

}
