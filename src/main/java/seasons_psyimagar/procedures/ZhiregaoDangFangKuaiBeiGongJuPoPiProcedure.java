package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ZhiregaoDangFangKuaiBeiGongJuPoPiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure ZhiregaoDangFangKuaiBeiGongJuPoPi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure ZhiregaoDangFangKuaiBeiGongJuPoPi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure ZhiregaoDangFangKuaiBeiGongJuPoPi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure ZhiregaoDangFangKuaiBeiGongJuPoPi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


		if ((world.getBlockState(new BlockPos(x,y,z))).getBlock() == Blocks.IRON_ORE) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.IRON_ORE));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}if ((world.getBlockState(new BlockPos(x,y,z))).getBlock() == Blocks.GOLD_ORE) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.GOLD_ORE));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}if ((world.getBlockState(new BlockPos(x,y,z))).getBlock() == Blocks.DIAMOND_ORE) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.DIAMOND));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}if ((world.getBlockState(new BlockPos(x,y,z))).getBlock() == Blocks.LAPIS_ORE) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.COAL));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}if ((world.getBlockState(new BlockPos(x,y,z))).getBlock() == Blocks.EMERALD_ORE) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(Items.EMERALD));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}if ((world.getBlockState(new BlockPos(x,y,z))).getBlock() == ShengmingkuangshiBlock.block) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(ShengmingkuangshiBlock.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}if ((world.getBlockState(new BlockPos(x,y,z))).getBlock() == BingshuangkuangshiBlock.block) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(BingshuangkuangshiBlock.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}if ((world.getBlockState(new BlockPos(x,y,z))).getBlock() == ZhirekuangshiBlock.block) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(ZhirekuangshiBlock.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}
	}

}
