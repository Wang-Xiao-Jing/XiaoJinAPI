package xiao_jin.api.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * 数据包生成提供者
 */
public class XiaoJinDatapackProvider extends DatapackBuiltinEntriesProvider {

    public XiaoJinDatapackProvider(PackOutput output, CompletableFuture<RegistrySetBuilder.PatchedRegistries> registries, Set<String> modIds) {
        super(output, registries, modIds);
    }

    public XiaoJinDatapackProvider(PackOutput output, CompletableFuture<RegistrySetBuilder.PatchedRegistries> registries, String modIds) {
        super(output, registries, Set.of(modIds));
    }

    public XiaoJinDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, RegistrySetBuilder builder, String modIds) {
        super(output, registries, builder, Set.of(modIds));
    }

    public XiaoJinDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, RegistrySetBuilder builder, Set<String> modIds) {
        super(output, registries, builder, modIds);
    }

}
