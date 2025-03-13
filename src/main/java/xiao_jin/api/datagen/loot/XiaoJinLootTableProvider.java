package xiao_jin.api.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

/**
 * 战利品表数据生成器
 */
public class XiaoJinLootTableProvider extends LootTableProvider implements LootTableSubProvider {
    public XiaoJinLootTableProvider(PackOutput output, List<SubProviderEntry> subProviders, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Set.of(), subProviders, registries);
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {

    }
}
