package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class JiancicongMobplayerCollidesWithPlantProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure JiancicongMobplayerCollidesWithPlant!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure JiancicongMobplayerCollidesWithPlant!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure JiancicongMobplayerCollidesWithPlant!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure JiancicongMobplayerCollidesWithPlant!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure JiancicongMobplayerCollidesWithPlant!");
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


		if (!(entity instanceof VineEntity.CustomEntity||entity instanceof VineFlowerEntity.CustomEntity||entity instanceof VineQueenEntity.CustomEntity||entity instanceof ExplosiveVineEntity.CustomEntity||entity instanceof FlowerSpiritEntity.CustomEntity)) {entity.setMotionMultiplier(Blocks.AIR.getDefaultState(), new Vector3d(0.25D, (double)0.05F, 0.25D));if (new Object(){
	public double getValue(IWorld world, BlockPos pos, String tag) {
		TileEntity tileEntity=world.getTileEntity(pos);
		if(tileEntity != null) return tileEntity.getTileData().getDouble(tag);
		return -1;
	}
}.getValue(world, new BlockPos(x,y,z), "judu")==20) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.POISON,(int) 40,(int) 2));if(!world.isRemote()) {
	BlockPos _bp = new BlockPos(x,y,z);
	TileEntity _tileEntity=world.getTileEntity(_bp);
	BlockState _bs = world.getBlockState(_bp);
	if(_tileEntity!=null)
		_tileEntity.getTileData().putDouble("judu", 0);

	if(world instanceof World)
		((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
}}}
	}

}
