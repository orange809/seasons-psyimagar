package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class SongshuyeDangFangKuaiBeiWanJiaPoPiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure SongshuyeDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure SongshuyeDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure SongshuyeDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure SongshuyeDangFangKuaiBeiWanJiaPoPiShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure SongshuyeDangFangKuaiBeiWanJiaPoPiShi!");
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


		if (((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY).getItem() == Items.SHEARS&&(new Object(){
	public boolean checkGamemode(Entity _ent){
		if(_ent instanceof ServerPlayerEntity) {
			return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
		} else if(_ent instanceof PlayerEntity && _ent.world.isRemote()) {
			NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection().getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
			return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
		}
		return false;
	}
}.checkGamemode(entity)||new Object(){
	public boolean checkGamemode(Entity _ent){
		if(_ent instanceof ServerPlayerEntity) {
			return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.ADVENTURE;
		} else if(_ent instanceof PlayerEntity && _ent.world.isRemote()) {
			NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection().getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
			return _npi != null && _npi.getGameType() == GameType.ADVENTURE;
		}
		return false;
	}
}.checkGamemode(entity))) {if(world instanceof World && !world.isRemote()) {
	ItemEntity entityToSpawn=new ItemEntity((World) world, (x+0.5), (y+0.5), (z+0.5), new ItemStack(SongshuyeBlock.block));
	entityToSpawn.setPickupDelay((int)10);
	world.addEntity(entityToSpawn);
}}
	}

}
