package mikos.fluidcans.item.custom;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;

/**
 * Fluid container holding a gem of fluid
 */
public class EmeraldCanItem extends DefaultCanItem {

  public static long CAPACITY = 8100L;

  public EmeraldCanItem(Properties properties) {
    super(properties);
    FluidStorage.ITEM.registerForItems((itemStack, context) -> new EmeraldCanFluidHandler(context), this);
  }


}
