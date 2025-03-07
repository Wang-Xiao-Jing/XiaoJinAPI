package xiao_jin.api.create.template;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Function;

import static xiao_jin.api.create.CreateBlock.BLOCKS;
import static xiao_jin.api.create.CreateItem.ITEMS;

/**
 * 便捷方块创建
 * @author 尽
 * @apiNote 提供方块和对应的物品的同时创建
 */
public class ModBlock{
    public final DeferredBlock<Block> block; // 方块
    public final DeferredItem<BlockItem> blockItem; // 方块物品

    /**
     * 创建一个方块
     * @param name 方块名称
     */
    public ModBlock(String name) {
         this(name, BlockBehaviour.Properties.of());
    }

    /**
     * 创建一个方块
     * @param name 方块名称
     */
    public ModBlock(String name, BlockBehaviour.Properties props) {
        this(name, Block::new, props);
    }

    /**
     * 创建一个方块
     * @param name 方块名称
     * @param func 方块构造函数
     */
    public <B extends Block> ModBlock(String name, Function<BlockBehaviour.Properties, ? extends B> func) {
        this(name, func, BlockBehaviour.Properties.of());
    }

    /**
     * 创建一个方块
     * @param name 方块名称
     * @param func 方块构造函数
     * @param props 方块属性
     */
    public <B extends Block> ModBlock(String name, Function<BlockBehaviour.Properties, ? extends B> func, BlockBehaviour.Properties props) {
        block = BLOCKS.register(name, key -> func.apply(props.setId(ResourceKey.create(Registries.BLOCK, key))));
        blockItem = ITEMS.registerSimpleBlockItem(name, block);
    }

    /** 获取方块 */
    public Block getBlock(){
        return block.get();
    }

    /** 获取方块物品 */
    public BlockItem getBlockItem(){
        return blockItem.get();
    }
}
