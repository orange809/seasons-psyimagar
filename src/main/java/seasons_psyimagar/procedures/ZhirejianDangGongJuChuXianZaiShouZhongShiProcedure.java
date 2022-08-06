package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ZhirejianDangGongJuChuXianZaiShouZhongShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure ZhirejianDangGongJuChuXianZaiShouZhongShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if (((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY).getItem() == ZhirejianItem.block&&((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemOffhand():ItemStack.EMPTY).getItem() == ZhirejianItem.block) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.STRENGTH,(int) 1,(int) 0, (false), (false)));}
	}

}
