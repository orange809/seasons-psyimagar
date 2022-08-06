package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class JianciboluoDangYouJianDianJiFangKuaiShiProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure JianciboluoDangYouJianDianJiFangKuaiShi!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure JianciboluoDangYouJianDianJiFangKuaiShi!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure JianciboluoDangYouJianDianJiFangKuaiShi!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure JianciboluoDangYouJianDianJiFangKuaiShi!");
				return;
			}
			if(dependencies.get("direction") == null) {
				if(!dependencies.containsKey("direction"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency direction for procedure JianciboluoDangYouJianDianJiFangKuaiShi!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure JianciboluoDangYouJianDianJiFangKuaiShi!");
				return;
			}

				IWorld world = (IWorld) dependencies.get("world");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				Direction direction = (Direction) dependencies.get("direction");
				Entity entity = (Entity) dependencies.get("entity");


		if (((world.getBlockState(new BlockPos(x,y+1,z))).getBlock() == Blocks.AIR||(world.getBlockState(new BlockPos(x,y+1,z))).getBlock() == Blocks.CAVE_AIR)&&(world.getBlockState(new BlockPos(x,y,z))).getBlock() == CaofangkuaiBlock.block&&direction == Direction.UP) {if(world instanceof World && !world.isRemote()) {
	((World) world).playSound(null, new BlockPos(x,y,z),
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.break")),
		SoundCategory.BLOCKS, (float) 1, (float) 1);
} else {
	((World) world).playSound(x, y, z,
    	(net.minecraft.util.SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grass.break")),
		SoundCategory.BLOCKS, (float) 1, (float) 1, false);
}if(entity instanceof LivingEntity){
	((LivingEntity)entity).swing(Hand.MAIN_HAND, true);
}world.setBlockState(new BlockPos(x,y+1,z), Juduboluo11Block.block.getDefaultState(),3);if (!((entity instanceof PlayerEntity)?((PlayerEntity)entity).abilities.isCreativeMode:false)) {if(entity instanceof PlayerEntity) {
    ItemStack _stktoremove = new ItemStack(JianciboluoItem.block);
    ((PlayerEntity)entity).inventory
        .func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1, ((PlayerEntity)entity).container.func_234641_j_());
}}}
	}

}
