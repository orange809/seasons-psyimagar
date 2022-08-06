

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class HuoyanjitanBlock extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:huoyanjitan")
	public static final Block block = null;

	@ObjectHolder("seasons_psyimagar:huoyanjitan")
	public static final TileEntityType<CustomTileEntity> tileEntityType = null;

	public HuoyanjitanBlock (SeasonsPsyimagarModElements instance) {
		super(instance, 9);


		FMLJavaModLoadingContext.get().getModEventBus().register(new TileEntityRegisterHandler());

	}

	@Override public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties()
		                             .group(SeasonsPsyimagarItemGroup.tab)
		                             ).setRegistryName(block.getRegistryName()));
	}

	private static class TileEntityRegisterHandler {
		@SubscribeEvent public void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> event) {
			event.getRegistry().register(TileEntityType.Builder.create(CustomTileEntity::new, block).build(null).setRegistryName("huoyanjitan"));
		}
	}

	@Override @OnlyIn(Dist.CLIENT) public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	

	public static class CustomBlock extends
				Block
            implements IWaterLoggable
             {

        public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


		public CustomBlock() {
			super(
			Block.Properties.create(Material.ROCK)
				.sound(SoundType.STONE)
				.hardnessAndResistance(-1, 3600000)
				.setLightLevel(s -> 4)
				.notSolid()
				.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true)
				.setOpaque((bs, br, bp) -> false)
			);

            this.setDefaultState(this.stateContainer.getBaseState()
                                     .with(WATERLOGGED, false)
            );

			setRegistryName("huoyanjitan");
		}






		@Override public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return state.getFluidState().isEmpty();
		}

		@Override public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 0;
		}




            @Override
            public BlockState getStateForPlacement(BlockItemUseContext context) {
            boolean flag = context.getWorld().getFluidState(context.getPos()).getFluid() == Fluids.WATER;
                return this.getDefaultState().with(WATERLOGGED, flag);
            }
            @Override protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
                builder.add(WATERLOGGED);
            }

        @Override public FluidState getFluidState(BlockState state) {
            return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
        }

		@Override public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
			if (state.get(WATERLOGGED)) {
				world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
			}
			return  super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
		}














			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 1));
			}




		@OnlyIn(Dist.CLIENT) @Override
		public void animateTick(BlockState blockstate, World world, BlockPos pos, Random random) {
			super.animateTick(blockstate, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
if(        true
)
	for (int l = 0; l < 7; ++l) {
	    double d0 = (x + random.nextFloat());
	    double d1 = (y + random.nextFloat());
	    double d2 = (z + random.nextFloat());
	    int i1 = random.nextInt(2) * 2 - 1;
	    double d3 = (random.nextFloat() - 0.5D) * 0.5D;
	    double d4 = (random.nextFloat() - 0.5D) * 0.5D;
	    double d5 = (random.nextFloat() - 0.5D) * 0.5D;
	    world.addParticle(JitanliziParticle.particle, d0, d1, d2, d3, d4, d5);
	}
		}








			@Override public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
				TileEntity tileEntity = worldIn.getTileEntity(pos);
				return tileEntity instanceof INamedContainerProvider ? (INamedContainerProvider) tileEntity : null;
			}

			@Override public boolean hasTileEntity(BlockState state) {
				return true;
			}
			
			@Override public TileEntity createTileEntity(BlockState state, IBlockReader world) {
    		    return new CustomTileEntity();
    		}

		    @Override
			public boolean eventReceived(BlockState state, World world, BlockPos pos, int eventID, int eventParam) {
				super.eventReceived(state, world, pos, eventID, eventParam);
				TileEntity tileentity = world.getTileEntity(pos);
				return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
			}

			@Override public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
   			   if (state.getBlock() != newState.getBlock()) {
   			      TileEntity tileentity = world.getTileEntity(pos);
   			      if (tileentity instanceof CustomTileEntity) {
   			         InventoryHelper.dropInventoryItems(world, pos, (CustomTileEntity) tileentity);
   			         world.updateComparatorOutputLevel(pos, this);
   			      }
			
   			      super.onReplaced(state, world, pos, newState, isMoving);
   			   }
   			}

            @Override public boolean hasComparatorInputOverride(BlockState state) {
				return true;
			}

		    @Override public int getComparatorInputOverride(BlockState blockState, World world, BlockPos pos) {
				TileEntity tileentity = world.getTileEntity(pos);
				if (tileentity instanceof CustomTileEntity)
					return Container.calcRedstoneFromInventory((CustomTileEntity) tileentity);
				else
					return 0;
			}

	}

    public static class CustomTileEntity extends LockableLootTileEntity implements ISidedInventory {

		private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(0, ItemStack.EMPTY);

		protected CustomTileEntity() {
			super(tileEntityType);
		}

		@Override public void read(BlockState blockState, CompoundNBT compound) {
			super.read(blockState, compound);

			if (!this.checkLootAndRead(compound)) {
			    this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
			}

			ItemStackHelper.loadAllItems(compound, this.stacks);


   		}

   		@Override public CompoundNBT write(CompoundNBT compound) {
   		   super.write(compound);

		   if (!this.checkLootAndWrite(compound)) {
   		       ItemStackHelper.saveAllItems(compound, this.stacks);
   		   }



   		   return compound;
   		}

		@Override public SUpdateTileEntityPacket getUpdatePacket() {
			return new SUpdateTileEntityPacket(this.pos, 0, this.getUpdateTag());
		}

		@Override public CompoundNBT getUpdateTag() {
			return this.write(new CompoundNBT());
		}

		@Override public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
			this.read(this.getBlockState(), pkt.getNbtCompound());
		}

		@Override public int getSizeInventory() {
			return stacks.size();
		}

		@Override public boolean isEmpty() {
			for (ItemStack itemstack : this.stacks)
				if (!itemstack.isEmpty())
					return false;
			return true;
		}

		@Override public ITextComponent getDefaultName() {
			return new StringTextComponent("huoyanjitan");
		}

		@Override public int getInventoryStackLimit() {
			return 64;
		}

		@Override public Container createMenu(int id, PlayerInventory player) {
				return ChestContainer.createGeneric9X3(id, player, this);
		}

		@Override public ITextComponent getDisplayName() {
			return new StringTextComponent("Altar of Fire");
		}

		@Override protected NonNullList<ItemStack> getItems() {
			return this.stacks;
		}

		@Override protected void setItems(NonNullList<ItemStack> stacks) {
			this.stacks = stacks;
		}

		@Override public boolean isItemValidForSlot(int index, ItemStack stack) {
			return true;
		}

		@Override public int[] getSlotsForFace(Direction side) {
			return IntStream.range(0, this.getSizeInventory()).toArray();
		}

		@Override public boolean canInsertItem(int index, ItemStack stack, @Nullable Direction direction) {
			return this.isItemValidForSlot(index, stack);
		}

		@Override public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
			return true;
		}

		private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());



		@Override public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
			if (!this.removed && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
				return handlers[facing.ordinal()].cast();



			return super.getCapability(capability, facing);
		}

		@Override public void remove() {
			super.remove();
			for(LazyOptional<? extends IItemHandler> handler : handlers)
				handler.invalidate();
		}

	}


}
