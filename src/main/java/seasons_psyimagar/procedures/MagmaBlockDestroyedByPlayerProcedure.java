package seasons_psyimagar.procedures;

import net.minecraftforge.eventbus.api.Event;

public class MagmaBlockDestroyedByPlayerProcedure {

	

	public static void executeProcedure(Map<String, Object> dependencies){
			if(dependencies.get("world") == null) {
				if(!dependencies.containsKey("world"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency world for procedure MagmaBlockDestroyedByPlayer!");
				return;
			}
			if(dependencies.get("x") == null) {
				if(!dependencies.containsKey("x"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency x for procedure MagmaBlockDestroyedByPlayer!");
				return;
			}
			if(dependencies.get("y") == null) {
				if(!dependencies.containsKey("y"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency y for procedure MagmaBlockDestroyedByPlayer!");
				return;
			}
			if(dependencies.get("z") == null) {
				if(!dependencies.containsKey("z"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency z for procedure MagmaBlockDestroyedByPlayer!");
				return;
			}
			if(dependencies.get("entity") == null) {
				if(!dependencies.containsKey("entity"))
					SeasonsPsyimagarMod.LOGGER.warn("Failed to load dependency entity for procedure MagmaBlockDestroyedByPlayer!");
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


		world.destroyBlock(new BlockPos(x,y,z), false);if (!((EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, ((entity instanceof LivingEntity)?((LivingEntity)entity).getHeldItemMainhand():ItemStack.EMPTY)) != 0))) {world.setBlockState(new BlockPos(x,y,z), Blocks.LAVA.getDefaultState(),3);}
	}

}
