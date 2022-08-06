package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class XiangguaZaiFangKuaiShangYouJianProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure XiangguaZaiFangKuaiShangYouJian!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure XiangguaZaiFangKuaiShangYouJian!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure XiangguaZaiFangKuaiShangYouJian!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure XiangguaZaiFangKuaiShangYouJian!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure XiangguaZaiFangKuaiShangYouJian!");
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


		if (((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY).getItem() == Items.BONE_MEAL) {if (new Object(){
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
}.checkGamemode(entity)) {if(entity instanceof LivingEntity) {
	ItemStack _setstack = new ItemStack(Items.BONE_MEAL);
	_setstack.setCount((int) ((((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY)).getCount()-1));
	((LivingEntity)entity).setHeldItem(Hand.MAIN_HAND, _setstack);
	if(entity instanceof ServerPlayerEntity)
		((ServerPlayerEntity)entity).inventory.markDirty();
}}if (Math.random()<0.5) {{
    BlockPos _bp = new BlockPos(x,y,z);
    BlockState _bs = Xianggua22Block.block.getDefaultState();

    BlockState _bso = world.getBlockState(_bp);

    for(Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
        Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
        if (_property != null && _bs.get(_property) != null)
            try {
            	_bs = _bs.with(_property, (Comparable) entry.getValue());
            } catch (Exception e) {}
    }


    world.setBlockState(_bp, _bs, 3);

}
}}
	}

}
