package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SZhiliaoyaoshuiijiDangShiWuBeiChiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure SZhiliaoyaoshuiijiDangShiWuBeiChiShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.REGENERATION,(int) 150,(int) 1, (false), (false)));if(entity instanceof LivingEntity){
	((LivingEntity)entity).swing(Hand.MAIN_HAND, true);
}if (!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {if(entity instanceof LivingEntity) {
	ItemStack _setstack = new ItemStack(ZhiliaoxiangnangItem.block);
	_setstack.setCount((int) ((((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY)).getCount()-1));
	((LivingEntity)entity).setHeldItem(Hand.MAIN_HAND, _setstack);
	if(entity instanceof ServerPlayerEntity)
		((ServerPlayerEntity)entity).inventory.markDirty();
}}
	}

}
