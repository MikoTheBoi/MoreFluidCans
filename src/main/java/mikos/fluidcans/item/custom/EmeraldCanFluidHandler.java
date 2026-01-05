package mikos.fluidcans.item.custom;

import io.github.fabricators_of_create.porting_lib.util.FluidStack;
import lombok.Getter;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.StoragePreconditions;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;


/** Capability handler instance for the brick can item */
@SuppressWarnings("UnstableApiUsage")
public class EmeraldCanFluidHandler extends CopperCanFluidHandler {

  @Getter
  private final ContainerItemContext container;

  public EmeraldCanFluidHandler(ContainerItemContext container) {
    super(container);
    this.container = container;
  }
  
  /* Tank properties */

  @Override
  public long getCapacity(FluidVariant variant) {
    return EmeraldCanItem.CAPACITY;
  }

  /** Gets the contained fluid */
  private Fluid getFluid(ItemVariant variant) {
    return EmeraldCanItem.getFluid(variant.getNbt());
  }
  

  @Override
  protected long getAmount(ItemVariant currentVariant) {
    return getFluid(currentVariant) == Fluids.EMPTY ? 0 : EmeraldCanItem.CAPACITY;
  }


  /* Interaction */

  @Override
  public long insert(FluidVariant insertedResource, long maxAmount, TransactionContext transaction) {
    StoragePreconditions.notBlankNotNegative(insertedResource, maxAmount);
    // must not be filled, must have enough
    if (maxAmount < EmeraldCanItem.CAPACITY) {
      return 0;
    }
    return super.insert(insertedResource, EmeraldCanItem.CAPACITY, transaction);
  }

  @Override
  public long extract(FluidVariant extractedResource, long maxAmount, TransactionContext transaction) {
    StoragePreconditions.notBlankNotNegative(extractedResource, maxAmount);
    // must be draining at least an ingot
    if (maxAmount < EmeraldCanItem.CAPACITY) {
      return 0;
    }

    // must have a fluid, must match what they are draining
    Fluid fluid = getFluid(container.getItemVariant());
    if (fluid == Fluids.EMPTY || fluid != extractedResource.getFluid()) {
      return 0;
    }
    return super.extract(extractedResource, EmeraldCanItem.CAPACITY, transaction);
  }

  @Override
  protected ItemVariant getUpdatedVariant(ItemVariant currentVariant, FluidVariant newResource, long newAmount) {
    return ItemVariant.of(EmeraldCanItem.setFluid(currentVariant.toStack(), new FluidStack(newResource.getFluid(), newAmount, newResource.copyNbt())));
  }
}
