

package seasons_psyimagar.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvent;

@SeasonsPsyimagarModElements.ModElement.Tag
public class MagmaBlock3Block extends SeasonsPsyimagarModElements.ModElement {

	@ObjectHolder("seasons_psyimagar:magma_block_3")
	public static final Block block = null;

	@ObjectHolder("seasons_psyimagar:magma_block_3")
	public static final TileEntityType<CustomTileEntity> tileEntityType = null;

	public MagmaBlock3Block (SeasonsPsyimagarModElements instance) {
		super(instance, 665);


		FMLJavaModLoadingContext.get().getModEventBus().register(new TileEntityRegisterHandler());

	}

	@Override public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties()
		                             .group(null)
		                             ).setRegistryName(block.getRegistryName()));
	}

	private static class TileEntityRegisterHandler {
		@SubscribeEvent public void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> event) {
			event.getRegistry().register(TileEntityType.Builder.create(CustomTileEntity::new, block).build(null).setRegistryName("magma_block_3"));
		}
	}



	public static class CustomBlock extends
				Block
 {



		public CustomBlock() {
			super(
			Block.Properties.create(Material.ROCK)
				.sound(SoundType.GROUND)
				.hardnessAndResistance(1f, 10f)
				.setLightLevel(s -> 0)
			);


			setRegistryName("magma_block_3");
		}







		@Override public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}











		@Override public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
        	return new ItemStack(Blocks.MAGMA_BLOCK);
    	}








			@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

				List<ItemStack> dropsOriginal = super.getDrops(state, builder);
				if(!dropsOriginal.isEmpty())
					return dropsOriginal;
				return Collections.singletonList(new ItemStack(this, 0));
			}

		@Override public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
			super.onBlockAdded(blockstate, world, pos, oldState, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			world.getPendingBlockTicks().scheduleTick(pos, this, 1);
    


        MagmaBlockAddedProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
		}


		@Override public void tick
				(BlockState blockstate, ServerWorld world, BlockPos pos, Random random) {
			super.tick(blockstate, world, pos, random);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

    


        MagmaBlock3UpdateTickProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;

			world.getPendingBlockTicks().scheduleTick(pos, this, 1);
		}


		@Override
		public boolean removedByPlayer(BlockState blockstate, World world, BlockPos pos, PlayerEntity entity, boolean willHarvest, FluidState fluid) {
			boolean retval = super.removedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
    


        MagmaBlockDestroyedByPlayerProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("world", world),new AbstractMap.SimpleEntry<>("x", x),new AbstractMap.SimpleEntry<>("y", y),new AbstractMap.SimpleEntry<>("z", z),new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
			return retval;
		}




		@Override public void onEntityWalk(World world, BlockPos pos, Entity entity) {
			super.onEntityWalk(world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			BlockState blockstate = world.getBlockState(pos);
    


        MagmaBlock1DangShiTiZaiFangKuaiShangXingZouShiProcedure.executeProcedure(Stream.of(
        new AbstractMap.SimpleEntry<>("entity", entity)
        ).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))
;
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
			return new StringTextComponent("magma_block_3");
		}

		@Override public int getInventoryStackLimit() {
			return 64;
		}

		@Override public Container createMenu(int id, PlayerInventory player) {
				return ChestContainer.createGeneric9X3(id, player, this);
		}

		@Override public ITextComponent getDisplayName() {
			return new StringTextComponent("Magma Block");
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
