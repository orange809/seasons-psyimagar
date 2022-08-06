package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class VineQueenDangShiTiShouShangShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure VineQueenDangShiTiShouShangShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure VineQueenDangShiTiShouShangShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure VineQueenDangShiTiShouShangShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure VineQueenDangShiTiShouShangShi!");
				return;
			}
			if(dependencies.get("sourceentity") == null) {
				if(!dependencies.containsKey("sourceentity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency sourceentity for procedure VineQueenDangShiTiShouShangShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				Entity sourceentity = (Entity) dependencies.get("sourceentity");


		if (((Entity) world.getEntitiesWithinAABB(VineEntity.CustomEntity.class, new AxisAlignedBB(
            x - (3 / 2d), y - (3 / 2d), z - (3 / 2d),
            x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
) != null) {    sourceentity.attackEntityFrom(DamageSource.GENERIC,(float)5);
}
	}

}
