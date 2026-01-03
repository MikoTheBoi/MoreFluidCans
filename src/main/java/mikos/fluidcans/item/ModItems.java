package mikos.fluidcans.item;


import mikos.fluidcans.MoreFluidCans;
import mikos.fluidcans.item.custom.CopperCanItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;


public class ModItems {
    public static final Item COPPER_CAN = registerItem("copper_can", new CopperCanItem(new FabricItemSettings().group(CreativeModeTab.TAB_TOOLS).stacksTo(16),9000L));
    public static final Item EMERALD_CAN = registerItem("emerald_can", new CopperCanItem(new FabricItemSettings().group(CreativeModeTab.TAB_TOOLS).stacksTo(16),8100));
    public static final Item AMETHYST_CAN = registerItem("amethyst_can", new CopperCanItem(new FabricItemSettings().group(CreativeModeTab.TAB_TOOLS).stacksTo(16),20250L));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new ResourceLocation(MoreFluidCans.MOD_ID, name), item);
    }

    public static void RegisterModItems() {
    }
}
