package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class ChuanSongMenDangShiTiZaiFangKuaiZhongPengZhuangShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure ChuanSongMenDangShiTiZaiFangKuaiZhongPengZhuangShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure ChuanSongMenDangShiTiZaiFangKuaiZhongPengZhuangShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				Entity entity = (Entity) dependencies.get("entity");


		if ((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == 	(World.OVERWORLD)
) {{
	Entity _ent = entity;
	if(!_ent.world.isRemote&&_ent instanceof ServerPlayerEntity) {
			RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
				new ResourceLocation("seasons_psyimagar:sijishijie"));

		ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
		if (nextWorld != null) {
			((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
			((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY()+1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
			((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
			for(EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
				((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
			}
			((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
		}
	}
}
}if ((world instanceof World ? (((World) world).getDimensionKey()) : World.OVERWORLD) == 	(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("seasons_psyimagar:sijishijie")))
) {{
	Entity _ent = entity;
	if(!_ent.world.isRemote&&_ent instanceof ServerPlayerEntity) {
			RegistryKey<World> destinationType = World.OVERWORLD;

		ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
		if (nextWorld != null) {
			((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
			((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY()+1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
			((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
			for(EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
				((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
			}
			((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
		}
	}
}
}
	}

}
