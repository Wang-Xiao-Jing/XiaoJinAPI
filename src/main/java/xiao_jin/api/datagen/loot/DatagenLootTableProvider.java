package xiao_jin.api.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * @author 尽
 * @apiNote 战利品表数据生成器
 */
public class DatagenLootTableProvider extends LootTableProvider {
    public DatagenLootTableProvider(PackOutput output, List<SubProviderEntry> subProviders, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Set.of(), subProviders, registries);
    }
}
