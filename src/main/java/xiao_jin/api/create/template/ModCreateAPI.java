package xiao_jin.api.create.template;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

/**
 * 便捷方块创建
 *
 * @author 尽
 * @apiNote 提供方块和对应的物品的同时创建
 */
public class ModCreateAPI {
    public final DeferredBlock<Block> block; // 方块
    public final DeferredItem<BlockItem> blockItem; // 方块物品

    /**
     * 创建一个方块物品
     *
     * @param name 方块名称
     * @param block 方块
     * @param deferredItems 物品注册器
     * @return 注册的方块物品
     */
    public static DeferredItem<BlockItem> createBlockItem(String name, DeferredBlock<Block> block, DeferredRegister.Items deferredItems) {
        return deferredItems.registerSimpleBlockItem(name, block);
    }

    /**
     * 创建一个方块物品
     *
     * @param name 方块名称
     * @param block 方块
     * @param itemFunc 方块物品构造函数
     * @param deferredItems 物品注册器
     * @return 注册的方块物品
     */
    public static DeferredItem<BlockItem> createBlockItem(String name, DeferredBlock<Block> block, Function<Block, ? extends BlockItem> itemFunc,
                                                   DeferredRegister.Items deferredItems) {
        return deferredItems.register(name, () -> itemFunc.apply(block.get()));
    }

    /**
     * 创建一个方块
     *
     * @param name 方块名称
     * @param props 方块属性 {@linkplain BlockBehaviour.Properties}
     * @param deferredBlocks 方块注册器
     * @return 注册的方块
     */
    public static DeferredBlock<Block> createBlock(String name, BlockBehaviour.Properties props, DeferredRegister.Blocks deferredBlocks) {
        return createBlock(name, Block::new, props, deferredBlocks);
    }

    /**
     * 创建一个方块
     *
     * @param name 方块名称
     * @param func 方块构造函数
     * @param deferredBlocks 方块注册器
     * @return 注册的方块
     */
    public static DeferredBlock<Block> createBlock(String name, Function<BlockBehaviour.Properties, ? extends Block> func,
                                                   DeferredRegister.Blocks deferredBlocks) {
        return createBlock(name, func, BlockBehaviour.Properties.of(), deferredBlocks);
    }

    /**
     * 创建一个方块
     *
     * @param name 方块名称
     * @param func 方块构造函数
     * @param props 方块属性 {@linkplain BlockBehaviour.Properties}
     * @param deferredBlocks 方块注册器
     * @return 注册的方块
     */
    public static DeferredBlock<Block> createBlock(String name, Function<BlockBehaviour.Properties, ? extends Block> func, BlockBehaviour.Properties props,
                                                   DeferredRegister.Blocks deferredBlocks) {
        return deferredBlocks.register(name, key -> func.apply(props.setId(ResourceKey.create(Registries.BLOCK, key))));
    }

    /**
     * 构造函数，用于创建方块和对应的方块物品
     *
     * @param name 方块名称
     * @param func 方块构造函数
     * @param props 方块属性 {@linkplain BlockBehaviour.Properties}
     * @param itemFunc 方块物品构造函数
     * @param deferredBlocks 方块注册器
     * @param deferredItems 物品注册器
     */
    public ModCreateAPI(String name,
                        Function<BlockBehaviour.Properties, ? extends Block> func, BlockBehaviour.Properties props,
                        Function<Block, ? extends BlockItem> itemFunc,
                        DeferredRegister.Blocks deferredBlocks,
                        DeferredRegister.Items deferredItems) {
        this.block = createBlock(name, func, props, deferredBlocks);
        this.blockItem = createBlockItem(name, block, itemFunc, deferredItems);
    }

    /**
     * 构造函数，用于创建方块和对应的方块物品
     *
     * @param name 方块名称
     * @param func 方块构造函数
     * @param props 方块属性 {@linkplain BlockBehaviour.Properties}
     * @param deferredBlocks 方块注册器
     * @param deferredItems 物品注册器
     */
    public ModCreateAPI(String name,
                        Function<BlockBehaviour.Properties, ? extends Block> func, BlockBehaviour.Properties props,
                        DeferredRegister.Blocks deferredBlocks,
                        DeferredRegister.Items deferredItems) {
        this.block = createBlock(name, func, props, deferredBlocks);
        this.blockItem = createBlockItem(name, block, deferredItems);
    }

    /**
     * 获取方块
     *
     * @return 注册的方块
     */
    public Block block() {
        return block.get();
    }

    /**
     * 获取方块物品
     *
     * @return 注册的方块物品
     */
    public BlockItem item() {
        return blockItem.get();
    }
}
