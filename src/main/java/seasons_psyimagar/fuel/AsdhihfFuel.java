
package seasons_psyimagar.fuel;

@Mod.EventBusSubscriber public class AsdhihfFuel {

	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if(event.getItemStack().getItem() == JieganItem.block)
			event.setBurnTime(1200);
	}

}
