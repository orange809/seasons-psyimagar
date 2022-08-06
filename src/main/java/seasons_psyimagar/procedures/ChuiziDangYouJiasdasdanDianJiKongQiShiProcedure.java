package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ChuiziDangYouJiasdasdanDianJiKongQiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure ChuiziDangYouJiasdasdanDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure ChuiziDangYouJiasdasdanDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure ChuiziDangYouJiasdasdanDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure ChuiziDangYouJiasdasdanDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure ChuiziDangYouJiasdasdanDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("itemstack") == null) {
				if(!dependencies.containsKey("itemstack"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency itemstack for procedure ChuiziDangYouJiasdasdanDianJiKongQiShi!");
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
				ItemStack itemstack = (ItemStack) dependencies.get("itemstack");


		{
    List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(
            x - (9 / 2d), y - (9 / 2d), z - (9 / 2d),
            x + (9 / 2d), y + (9 / 2d), z + (9 / 2d)), null)
		.stream()
		.sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
			}
		}.compareDistOf(x, y, z))
        .collect(Collectors.toList());
    for(Entity entityiterator : _entfound) {
        if (!(entityiterator.getDisplayName().getString()).equals(entity.getDisplayName().getString())) {entityiterator.setMotion(0,1.5,0);}
    }
}if (!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {if(entity instanceof PlayerEntity)
	((PlayerEntity)entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 500);}
	}

}
