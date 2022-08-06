package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SdfsdwerProcedure {

	@Mod.EventBusSubscriber private static class GlobalTrigger {
	@SubscribeEvent public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		PlayerEntity entity=event.getPlayer();
		if (event.getHand() != entity.getActiveHand()) {
			return;
		}
		double i=event.getPos().getX();
		double j=event.getPos().getY();
		double k=event.getPos().getZ();
		IWorld world=event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world" ,world);
		dependencies.put("entity" ,entity);
		dependencies.put("event",event);
		executeProcedure(dependencies);
	}
}

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure Sdfsdwer!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure Sdfsdwer!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure Sdfsdwer!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure Sdfsdwer!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure Sdfsdwer!");
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

double RandomZ = 0;double RandomX = 0;double Y = 0;double Level = 0;
		if (((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE&&entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
        RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getType() == RayTraceResult.Type.BLOCK) {if ((world.getFluidState(new BlockPos(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
        RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getX(),entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
        RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getY(),entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f), entity.getEyePosition(1f)
        .add(entity.getLook(1f).x * 5, entity.getLook(1f).y * 5, entity.getLook(1f).z * 5),
        RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.SOURCE_ONLY, entity)).getPos().getZ())).getBlockState()).getBlock() == Blocks.LAVA) {if (!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {if(entity instanceof LivingEntity) {
	ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE);
	_setstack.setCount((int) ((((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY)).getCount()-1));
	((LivingEntity)entity).setHeldItem(Hand.MAIN_HAND, _setstack);
	if(entity instanceof ServerPlayerEntity)
		((ServerPlayerEntity)entity).inventory.markDirty();
}}if(entity instanceof LivingEntity){
	((LivingEntity)entity).swing(Hand.MAIN_HAND, true);
}if(entity instanceof PlayerEntity) {
	ItemStack _setstack = new ItemStack(YanjiangpingItem.block);
	_setstack.setCount((int) 1);
	ItemHandlerHelper.giveItemToPlayer(((PlayerEntity)entity), _setstack);
}if(world instanceof World && !world.isRemote()) {
	((World) world).playSound(null, new BlockPos(x,y,z),
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.fill")),
		SoundCategory.NEUTRAL, (float) 1, (float) 1);
} else {
	((World) world).playSound(x, y, z,
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.fill")),
		SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
}}}
	}

}
