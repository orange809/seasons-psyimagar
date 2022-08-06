package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class Juduboluo3DangFangKuaiBeiWanJiaPoPiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure Juduboluo3DangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure Juduboluo3DangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure Juduboluo3DangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure Juduboluo3DangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure Juduboluo3DangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				Entity entity = (Entity) dependencies.get("entity");


		if (!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, x, y, z, new ItemStack(JianciboluoItem.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}if (!(((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY).getItem() == CaidaoItem.block)) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.POISON,(int) 40,(int) 2));}
	}

}
