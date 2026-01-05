package mikos.fluidcans.item.custom;

import io.github.fabricators_of_create.porting_lib.util.FluidStack;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Fluid container holding a brick of fluid
 */
@SuppressWarnings("removal")
public class BrickCanItem extends CopperCanItem {

  public static long CAPACITY = 20250L;

  public BrickCanItem(Properties properties) {
    super(properties);
  }

  @Override
  public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
    Fluid fluid = getFluid(stack.getTag());
    if (fluid != Fluids.EMPTY) {
      CompoundTag fluidTag = getFluidTag(stack.getTag());
      MutableComponent text;
      if (fluidTag != null) {
        FluidStack displayFluid = new FluidStack(fluid, CAPACITY, fluidTag);
        text = displayFluid.getDisplayName().plainCopy();
      } else {
        text = new TranslatableComponent(fluid.getAttributes().getTranslationKey());
      }
      tooltip.add(new TranslatableComponent(this.getDescriptionId() + ".contents", text).withStyle(ChatFormatting.GRAY));
    } else {
      tooltip.add(new TranslatableComponent(this.getDescriptionId() + ".tooltip").withStyle(ChatFormatting.GRAY));
    }
  }

}
