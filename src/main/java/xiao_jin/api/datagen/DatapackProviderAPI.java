package xiao_jin.api.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import xiao_jin.api.create.worldgen.BiomeModifiersAPI;
import xiao_jin.api.create.worldgen.ConfiguredFeaturesAPI;
import xiao_jin.api.create.worldgen.PlacedFeaturesAPI;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public abstract class DatapackProviderAPI extends DatapackBuiltinEntriesProvider {

//    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
//            .add(Registries.CONFIGURED_FEATURE, ConfiguredFeaturesAPI::bootstrap)
//            .add(Registries.PLACED_FEATURE, PlacedFeaturesAPI::bootstrap)
//            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifiersAPI::bootstrap);

    public DatapackProviderAPI(PackOutput output, CompletableFuture<RegistrySetBuilder.PatchedRegistries> registries, Set<String> modIds) {
        super(output, registries, modIds);
    }

    public DatapackProviderAPI(PackOutput output, CompletableFuture<RegistrySetBuilder.PatchedRegistries> registries, String modIds) {
        super(output, registries, Set.of(modIds));
    }

    public DatapackProviderAPI(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, RegistrySetBuilder builder, String modIds) {
        super(output, registries, builder, Set.of(modIds));
    }

    public DatapackProviderAPI(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, RegistrySetBuilder builder, Set<String> modIds) {
        super(output, registries, builder, modIds);
    }

}
