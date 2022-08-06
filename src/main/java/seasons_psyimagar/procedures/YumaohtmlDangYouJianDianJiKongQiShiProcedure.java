package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class YumaohtmlDangYouJianDianJiKongQiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure YumaohtmlDangYouJianDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure YumaohtmlDangYouJianDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure YumaohtmlDangYouJianDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure YumaohtmlDangYouJianDianJiKongQiShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");


		if(((Entity) world.getEntitiesWithinAABB(AgeableEntity.class, new AxisAlignedBB(
            x - (10 / 2d), y - (10 / 2d), z - (10 / 2d),
            x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
) instanceof LivingEntity)
	((LivingEntity)((Entity) world.getEntitiesWithinAABB(AgeableEntity.class, new AxisAlignedBB(
            x - (10 / 2d), y - (10 / 2d), z - (10 / 2d),
            x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
    .stream()
	.sorted(new Object() {
		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
		    return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
		}
	}.compareDistOf(x, y, z))
    .findFirst().orElse(null)
)).addPotionEffect(new EffectInstance(Effects.SLOWNESS,(int) 2000,(int) 100, (false), (false)));
	}

}
