
package seasons_psyimagar.particle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD) public class XuehuaParticle {

	public static final BasicParticleType particle = new BasicParticleType(false);

	@SubscribeEvent public static void registerParticleType(RegistryEvent.Register<ParticleType<?>> event) {
		event.getRegistry().register(particle.setRegistryName("xuehua"));
	}

	@OnlyIn(Dist.CLIENT) @SubscribeEvent public static void registerParticle(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(particle, CustomParticleFactory::new);
	}

	@OnlyIn(Dist.CLIENT) private static class CustomParticle extends SpriteTexturedParticle {

		private final IAnimatedSprite spriteSet;

		protected CustomParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
			super(world, x, y, z);
			this.spriteSet = spriteSet;

			this.setSize((float) 0.3, (float) 0.3);
			this.particleScale *= (float) 2;

			this.maxAge = (int) Math.max(1, 15 + (this.rand.nextInt(10) - 5));

			this.particleGravity = (float) 10;
			this.canCollide = true;

			this.motionX = vx * 1;
			this.motionY = vy * 1;
			this.motionZ = vz * 1;


			this.selectSpriteWithAge(spriteSet);
		}

   		@Override public int getBrightnessForRender(float partialTick) {
			return 15728880;
   		}

		@Override public IParticleRenderType getRenderType() {
			return IParticleRenderType.PARTICLE_SHEET_LIT;
		}

		@Override public void tick() {
			super.tick();


			if(!this.isExpired) {
				this.setSprite(this.spriteSet.get((this.age / 1) % 2 + 1, 2));
			}

		}

	}

	@OnlyIn(Dist.CLIENT) private static class CustomParticleFactory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public CustomParticleFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new CustomParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

}
