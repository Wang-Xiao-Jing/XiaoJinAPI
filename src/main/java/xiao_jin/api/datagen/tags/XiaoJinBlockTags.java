package xiao_jin.api.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * 方块标签数据生成器
 */
public class XiaoJinBlockTags extends BlockTagsProvider {
    public XiaoJinBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId) {
        super(output, lookupProvider, modId);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider){

    }
    public static TagKey<Block> tag(String name, String modId) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(modId, name));
    }
}
