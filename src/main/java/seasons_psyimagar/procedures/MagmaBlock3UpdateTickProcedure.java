package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class MagmaBlock3UpdateTickProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure MagmaBlock3UpdateTick!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure MagmaBlock3UpdateTick!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure MagmaBlock3UpdateTick!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure MagmaBlock3UpdateTick!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


		if ((world.getBlockState(new BlockPos(x+1,y,z))).getBlock() == Blocks.LAVA&&(world.getBlockState(new BlockPos(x-1,y,z))).getBlock() == Blocks.LAVA&&(world.getBlockState(new BlockPos(x,y,z+1))).getBlock() == Blocks.LAVA&&(world.getBlockState(new BlockPos(x,y,z-1))).getBlock() == Blocks.LAVA) {world.setBlockState(new BlockPos(x,y,z), Blocks.LAVA.getDefaultState(),3);}else{if(!world.isRemote()) {
	BlockPos _bp = new BlockPos(x,y,z);
	TileEntity _tileEntity=world.getTileEntity(_bp);
	BlockState _bs = world.getBlockState(_bp);
	if(_tileEntity!=null)
		_tileEntity.getTileData().putDouble("softBasaltMeltTime", (new Object(){
	public double getValue(IWorld world, BlockPos pos, String tag) {
		TileEntity tileEntity=world.getTileEntity(pos);
		if(tileEntity != null) return tileEntity.getTileData().getDouble(tag);
		return -1;
	}
}.getValue(world, new BlockPos(x,y,z), "softBasaltMeltTime")+1));

	if(world instanceof World)
		((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
}}if (new Object(){
	public double getValue(IWorld world, BlockPos pos, String tag) {
		TileEntity tileEntity=world.getTileEntity(pos);
		if(tileEntity != null) return tileEntity.getTileData().getDouble(tag);
		return -1;
	}
}.getValue(world, new BlockPos(x,y,z), "softBasaltMeltTime")==10&&Math.random()<0.5) {world.setBlockState(new BlockPos(x,y,z), Blocks.LAVA.getDefaultState(),3);}else if (new Object(){
	public double getValue(IWorld world, BlockPos pos, String tag) {
		TileEntity tileEntity=world.getTileEntity(pos);
		if(tileEntity != null) return tileEntity.getTileData().getDouble(tag);
		return -1;
	}
}.getValue(world, new BlockPos(x,y,z), "softBasaltMeltTime")==20) {world.setBlockState(new BlockPos(x,y,z), Blocks.LAVA.getDefaultState(),3);}
	}

}
