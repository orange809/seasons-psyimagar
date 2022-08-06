package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class AixinzhijianDangShiTiBeiGongJuJiZhongShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("sourceentity") == null) {
				if(!dependencies.containsKey("sourceentity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency sourceentity for procedure AixinzhijianDangShiTiBeiGongJuJiZhongShi!");
				return;
			}

				Entity sourceentity = (Entity) dependencies.get("sourceentity");


		if (Math.random()<0.28) {if(sourceentity instanceof LivingEntity)((LivingEntity)sourceentity).setHealth((float)(((sourceentity instanceof LivingEntity)?((LivingEntity)sourceentity).getHealth():-1)+2));}
	}

}
