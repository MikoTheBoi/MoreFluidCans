package mikos.fluidcans.item.custom;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;

/**
 * Fluid container holding a brick of fluid
 */
public class BrickCanItem extends DefaultCanItem {

  public static long CAPACITY = 20250L;

  public BrickCanItem(Properties properties) {
    super(properties);
    FluidStorage.ITEM.registerForItems((itemStack, context) -> new BrickCanFluidHandler(context), this);
  }


}
