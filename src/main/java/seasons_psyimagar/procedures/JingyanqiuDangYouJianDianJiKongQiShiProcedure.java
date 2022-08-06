package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class JingyanqiuDangYouJianDianJiKongQiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure JingyanqiuDangYouJianDianJiKongQiShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if(entity instanceof PlayerEntity)((PlayerEntity)entity).giveExperiencePoints((int)10);if(entity instanceof LivingEntity) {
	ItemStack _setstack = new ItemStack(JingyanqiuItem.block);
	_setstack.setCount((int) ((((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY)).getCount()-1));
	((LivingEntity)entity).setHeldItem(Hand.MAIN_HAND, _setstack);
	if(entity instanceof ServerPlayerEntity)
		((ServerPlayerEntity)entity).inventory.markDirty();
}
	}

}
