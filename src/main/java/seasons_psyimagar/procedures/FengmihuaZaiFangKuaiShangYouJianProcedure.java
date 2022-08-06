package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class FengmihuaZaiFangKuaiShangYouJianProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure FengmihuaZaiFangKuaiShangYouJian!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure FengmihuaZaiFangKuaiShangYouJian!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure FengmihuaZaiFangKuaiShangYouJian!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure FengmihuaZaiFangKuaiShangYouJian!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure FengmihuaZaiFangKuaiShangYouJian!");
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


		if (((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {if(world instanceof World && !world.isRemote()) {
	((World) world).playSound(null, new BlockPos(x,y,z),
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.fill")),
		SoundCategory.NEUTRAL, (float) 1, (float) 1);
} else {
	((World) world).playSound(x, y, z,
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.fill")),
		SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
}if(entity instanceof PlayerEntity) {
	ItemStack _setstack = new ItemStack(Items.HONEY_BOTTLE);
	_setstack.setCount((int) 1);
	ItemHandlerHelper.giveItemToPlayer(((PlayerEntity)entity), _setstack);
}{
    BlockPos _bp = new BlockPos(x,y,z);
    BlockState _bs = HoneyFlower0Block.block.getDefaultState();

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
if (!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {if(entity instanceof LivingEntity) {
	ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE);
	_setstack.setCount((int) ((((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY)).getCount()-1));
	((LivingEntity)entity).setHeldItem(Hand.MAIN_HAND, _setstack);
	if(entity instanceof ServerPlayerEntity)
		((ServerPlayerEntity)entity).inventory.markDirty();
}}}
	}

}
