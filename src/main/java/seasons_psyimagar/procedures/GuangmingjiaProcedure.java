package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class GuangmingjiaProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure Guangmingjia!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if (((entity instanceof LivingEntity)?((LivingEntity)entity).getItemStackFromSlot(EquipmentSlotType.CHEST):ItemStack.EMPTY).getItem() == GuangmingtoukuiItem.body) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION,(int) 1,(int) 1, (false), (false)));}
	}

}
