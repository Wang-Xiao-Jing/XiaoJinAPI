package xiao_jin.api.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

import static xiao_jin.api.XiaoJinAPI.MOD_ID;

/**
 * @author 尽
 * @apiNote 方块标签数据生成器
 */
public class DatageBlockTags extends TagsProvider<Block> {
    protected DatageBlockTags(PackOutput output, ResourceKey<? extends Registry<Block>> registryKey, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, registryKey, lookupProvider, CompletableFuture.completedFuture(TagLookup.empty()), MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
