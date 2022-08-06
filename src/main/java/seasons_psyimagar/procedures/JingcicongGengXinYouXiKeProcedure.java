package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class JingcicongGengXinYouXiKeProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure JingcicongGengXinYouXiKe!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure JingcicongGengXinYouXiKe!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure JingcicongGengXinYouXiKe!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure JingcicongGengXinYouXiKe!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


		if (!(new Object(){
	public double getValue(IWorld world, BlockPos pos, String tag) {
		TileEntity tileEntity=world.getTileEntity(pos);
		if(tileEntity != null) return tileEntity.getTileData().getDouble(tag);
		return -1;
	}
}.getValue(world, new BlockPos(x,y,z), "judu")==20)) {if(!world.isRemote()) {
	BlockPos _bp = new BlockPos(x,y,z);
	TileEntity _tileEntity=world.getTileEntity(_bp);
	BlockState _bs = world.getBlockState(_bp);
	if(_tileEntity!=null)
		_tileEntity.getTileData().putDouble("judu", (new Object(){
	public double getValue(IWorld world, BlockPos pos, String tag) {
		TileEntity tileEntity=world.getTileEntity(pos);
		if(tileEntity != null) return tileEntity.getTileData().getDouble(tag);
		return -1;
	}
}.getValue(world, new BlockPos(x,y,z), "judu")+1));

	if(world instanceof World)
		((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
}}if ((world.getBlockState(new BlockPos(x,y-1,z))).getBlock() == Blocks.AIR) {{
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
}if ((world.getBlockState(new BlockPos(x,y+1,z))).getBlock() == Blocks.AIR&&!((world.getBlockState(new BlockPos(x,y-6,z))).getBlock() == JingcicongBlock.block)) {world.setBlockState(new BlockPos(x,y+1,z), JingcicongBlock.block.getDefaultState(),3);}
	}

}
