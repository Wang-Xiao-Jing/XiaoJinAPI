package xiao_jin.api.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * @author 尽
 * @apiNote 方块标签数据生成器
 */
public abstract class BlockTagsAPI extends BlockTagsProvider {
    public BlockTagsAPI(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,String modId) {
        super(output, lookupProvider, modId);
    }

    @Override
    protected abstract void addTags(HolderLookup.@NotNull Provider provider);
    public static TagKey<Block> tag(String name, String modId) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(modId, name));
    }
}
