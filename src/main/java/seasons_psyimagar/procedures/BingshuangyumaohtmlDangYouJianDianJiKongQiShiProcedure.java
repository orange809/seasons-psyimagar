package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class BingshuangyumaohtmlDangYouJianDianJiKongQiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure BingshuangyumaohtmlDangYouJianDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure BingshuangyumaohtmlDangYouJianDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure BingshuangyumaohtmlDangYouJianDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure BingshuangyumaohtmlDangYouJianDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure BingshuangyumaohtmlDangYouJianDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("itemstack") == null) {
				if(!dependencies.containsKey("itemstack"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency itemstack for procedure BingshuangyumaohtmlDangYouJianDianJiKongQiShi!");
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

boolean found = false;ItemStack pickaxe = ItemStack.EMPTY;double sx = 0;double sy = 0;double sz = 0;double previousRecipe = 0;double EnchtSize = 0;double i = 0;double j = 0;double k = 0;double diamonds = 0;
		{
    List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(
            x - (13 / 2d), y - (13 / 2d), z - (13 / 2d),
            x + (13 / 2d), y + (13 / 2d), z + (13 / 2d)), null)
		.stream()
		.sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
			}
		}.compareDistOf(x, y, z))
        .collect(Collectors.toList());
    for(Entity entityiterator : _entfound) {
        if (!(entityiterator.getDisplayName().getString()).equals(entity.getDisplayName().getString())) {if(entityiterator instanceof LivingEntity)
	((LivingEntity)entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS,(int) 100,(int) 5));}
    }
}if (!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {{
	ItemStack _ist = itemstack;
	if(_ist.attemptDamageItem((int) 1,new Random(),null)) {
        _ist.shrink(1);
        _ist.setDamage(0);
    }
}if(entity instanceof PlayerEntity)
	((PlayerEntity)entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 600);}
	}

}
