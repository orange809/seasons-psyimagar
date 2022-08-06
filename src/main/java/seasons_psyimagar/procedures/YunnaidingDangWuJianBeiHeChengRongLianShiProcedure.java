package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class YunnaidingDangWuJianBeiHeChengRongLianShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure YunnaidingDangWuJianBeiHeChengRongLianShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if(entity instanceof PlayerEntity) {
	ItemStack _setstack = new ItemStack(Items.BUCKET);
	_setstack.setCount((int) 4);
	ItemHandlerHelper.giveItemToPlayer(((PlayerEntity)entity), _setstack);
}
	}

}
