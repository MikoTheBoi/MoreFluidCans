package mikos.fluidcans;

import io.github.fabricators_of_create.porting_lib.event.client.ModelLoadCallback;
import io.github.fabricators_of_create.porting_lib.model.ModelLoaderRegistry;
import mikos.fluidcans.client.DefaultCanModel;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;

public class MoreFluidCansClient implements ClientModInitializer {

    public static void init() {
        ModelLoadCallback.EVENT.register(MoreFluidCansClient::registerModelLoaders);
    }

    @Override
    public void onInitializeClient() {
        MoreFluidCansClient.init();
    }
    static void registerModelLoaders(ResourceManager manager, BlockColors colors, ProfilerFiller profiler, int mipLevel) {
        ModelLoaderRegistry.registerLoader(MoreFluidCans.getResource("copper_can"), DefaultCanModel.LOADER);
        ModelLoaderRegistry.registerLoader(MoreFluidCans.getResource("emerald_can"), DefaultCanModel.LOADER);
        ModelLoaderRegistry.registerLoader(MoreFluidCans.getResource("brick_can"), DefaultCanModel.LOADER);
    }
}
