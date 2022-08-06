package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class Bingshuangfazhang2DangZiDanJiZhongFangKuaiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure Bingshuangfazhang2DangZiDanJiZhongFangKuaiShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure Bingshuangfazhang2DangZiDanJiZhongFangKuaiShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure Bingshuangfazhang2DangZiDanJiZhongFangKuaiShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure Bingshuangfazhang2DangZiDanJiZhongFangKuaiShi!");
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
    List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(
            x - (7 / 2d), y - (7 / 2d), z - (7 / 2d),
            x + (7 / 2d), y + (7 / 2d), z + (7 / 2d)), null)
		.stream()
		.sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
			}
		}.compareDistOf(x, y, z))
        .collect(Collectors.toList());
    for(Entity entityiterator : _entfound) {
        if(entityiterator instanceof LivingEntity)
	((LivingEntity)entityiterator).addPotionEffect(new EffectInstance(JieshuangPotionEffect.potion,(int) 120,(int) 2));
    }
}if ((world.getBlockState(new BlockPos(x,y,z))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x,y,z), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x+1,y,z))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x+1,y,z), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x-1,y,z))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x-1,y,z), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x,y,z+1))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x,y,z+1), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x,y,z-1))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x,y,z-1), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x+2,y,z))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x+2,y,z), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x-2,y,z))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x-2,y,z), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x,y,z+2))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x,y,z+2), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x,y,z-2))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x,y,z-2), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x+1,y,z+1))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x+1,y,z+1), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x+1,y,z-1))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x+1,y,z-1), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x-1,y,z+1))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x-1,y,z+1), Blocks.FROSTED_ICE.getDefaultState(),3);}if ((world.getBlockState(new BlockPos(x-1,y,z-1))).getBlock() == Blocks.WATER) {world.setBlockState(new BlockPos(x-1,y,z-1), Blocks.FROSTED_ICE.getDefaultState(),3);}
	}

}
