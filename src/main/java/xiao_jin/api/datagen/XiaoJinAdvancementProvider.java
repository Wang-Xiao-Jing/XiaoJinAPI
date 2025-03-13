package xiao_jin.api.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 进度数据生成器
 */
public class XiaoJinAdvancementProvider extends AdvancementProvider {
    public XiaoJinAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, List<AdvancementSubProvider> subProviders) {
        super(output, registries, subProviders);
    }
}
