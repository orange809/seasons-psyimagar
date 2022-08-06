package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SdfdhtmlDangYouJianDianJiKongQiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure SdfdhtmlDangYouJianDianJiKongQiShi!");
				return;
			}
			if(dependencies.get("itemstack") == null) {
				if(!dependencies.containsKey("itemstack"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency itemstack for procedure SdfdhtmlDangYouJianDianJiKongQiShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");
				ItemStack itemstack = (ItemStack) dependencies.get("itemstack");


		if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.REGENERATION,(int) 100,(int) 2, (false), (false)));if (!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {{
	ItemStack _ist = itemstack;
	if(_ist.attemptDamageItem((int) 1,new Random(),null)) {
        _ist.shrink(1);
        _ist.setDamage(0);
    }
}if(entity instanceof PlayerEntity)
	((PlayerEntity)entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 600);}
	}

}
