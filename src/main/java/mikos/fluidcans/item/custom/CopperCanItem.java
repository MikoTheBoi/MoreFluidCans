package mikos.fluidcans.item.custom;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;

/**
 * Fluid container holding a custom amount of fluid
 */
public class CopperCanItem extends DefaultCanItem {

  public static long CAPACITY = 9000L;

  public CopperCanItem(Properties properties) {
    super(properties);
    FluidStorage.ITEM.registerForItems((itemStack, context) -> new CopperCanFluidHandler(context), this);
  }
}
