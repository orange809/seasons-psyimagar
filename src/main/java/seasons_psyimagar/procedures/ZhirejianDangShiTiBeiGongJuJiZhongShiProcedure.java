package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ZhirejianDangShiTiBeiGongJuJiZhongShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure ZhirejianDangShiTiBeiGongJuJiZhongShi!");
				return;
			}

				Entity entity = (Entity) dependencies.get("entity");


		entity.setFire((int)3);
	}

}
