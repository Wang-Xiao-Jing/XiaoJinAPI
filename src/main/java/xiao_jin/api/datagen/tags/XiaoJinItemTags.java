package xiao_jin.api.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * 物品标签数据生成器
 */
public class XiaoJinItemTags<T> extends ItemTagsProvider {
    protected XiaoJinItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, String modId) {
        super(output, lookupProvider, blockTags, modId);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider){

    }
    public static TagKey<Item> tag(String name, String modId) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(modId, name));
    }
}
