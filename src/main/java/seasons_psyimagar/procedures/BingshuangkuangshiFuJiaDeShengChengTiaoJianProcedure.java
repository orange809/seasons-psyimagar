package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class BingshuangkuangshiFuJiaDeShengChengTiaoJianProcedure {

	

	public static boolean executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure BingshuangkuangshiFuJiaDeShengChengTiaoJian!");
				return false;
			}

				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");


		if (y>=90) {return
true;}return
false;
	}

}
