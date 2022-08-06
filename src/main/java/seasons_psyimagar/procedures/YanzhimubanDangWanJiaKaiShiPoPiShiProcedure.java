package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class YanzhimubanDangWanJiaKaiShiPoPiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure YanzhimubanDangWanJiaKaiShiPoPiShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		if (Math.random()<0.1) {entity.setFire((int)3);}
	}

}
