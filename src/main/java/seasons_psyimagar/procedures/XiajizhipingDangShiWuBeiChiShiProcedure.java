package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class XiajizhipingDangShiWuBeiChiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure XiajizhipingDangShiWuBeiChiShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure XiajizhipingDangShiWuBeiChiShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				Entity entity = (Entity) dependencies.get("entity");


		if ((entity.world.getDimensionKey()) == 	(World.OVERWORLD)
) {if(entity instanceof LivingEntity)
	((LivingEntity)entity).addPotionEffect(new EffectInstance(Effects.NAUSEA,(int) 200,(int) 4, (false), (false)));new Object() {

    private int ticks = 0;
    private float waitTicks;
    private IWorld world;

    public void start(IWorld world, int waitTicks) {
		this.waitTicks = waitTicks;
		MinecraftForge.EVENT_BUS.register(this);
		this.world = world;
	}

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.ticks += 1;
            if (this.ticks >= this.waitTicks)
                run();
        }
    }

    private void run() {
        {
	Entity _ent = entity;
	if(!_ent.world.isRemote&&_ent instanceof ServerPlayerEntity) {
			RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
				new ResourceLocation("seasons_psyimagar:deleted_mod_element"));

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

        MinecraftForge.EVENT_BUS.unregister(this);
    }

}.start(world, (int) 100);
}
	}

}
