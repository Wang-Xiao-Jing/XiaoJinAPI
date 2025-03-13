package xiao_jin.api.datagen.loot;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * 创建方块的战利品表
 */
public class XiaoJinBlockLootTableProvider extends BlockLootSubProvider implements LootTableSubProvider{
    public XiaoJinBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate(){

    }
//        dropSelf(CreateBlockAPI.EXAMPLE_BLOCK.getBlock());

    /**
     * 获取所有方块
     */
    protected @NotNull Iterable<Block> getKnownBlocks(DeferredRegister.Blocks deferredBlocks) {
        return deferredBlocks.getEntries().stream().map(Holder::value)::iterator;
    }
}
