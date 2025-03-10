package xiao_jin.api.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.client.data.models.BlockModelGenerators.createSimpleBlock;

/**
 * 数据生成器-模型
 *
 * @author 尽
 * @apiNote 提供方块和物品的模型生成
 */
public abstract class ModelProviderAPI extends ModelProvider {
    public ModelProviderAPI(PackOutput output, String modId) {
        super(output, modId);
    }

    /**
     * 创建普通模型
     * <p>完整六面模型 方块和物品
     */
    public static void createRegular(BlockModelGenerators blockModels, Block block) {
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block,
                getResourceLocation(blockModels, TexturedModel.CUBE, block)));
    }

    /**
     * 创建原木类方块模型
     */
    public static void createRotatedPillar(BlockModelGenerators blockModels, Block block) {
        blockModels.blockStateOutput.accept(BlockModelGenerators.createRotatedPillarWithHorizontalVariant(block,
                getResourceLocation(blockModels, TexturedModel.COLUMN_ALT, block),
                getResourceLocation(blockModels, TexturedModel.COLUMN_HORIZONTAL_ALT, block)
        ));
    }

    /**
     * 获取模型路径
     */
    public static ResourceLocation getResourceLocation(BlockModelGenerators blockModels, TexturedModel.Provider model, Block block) {
        return model.create(block, blockModels.modelOutput);
    }

    /**
     * 创建普通模型
     * <p>完整六面模型 方块和物品<p/>
     * 取自ironchest项目 源代码仓库：<a href="https://github.com/progwml6/ironchest">ironchest</a>
     * <br/>
     * 经过修改 源代码许可证：GPL-3.0
     *
     * @param particleTexture 纹理路径（例：XiaojinModMain.prefix("example_block")）
     */
    public static void createRegular(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block, ResourceLocation particleTexture) {
        // 模型模板
        ModelTemplate modelTemplate = ModelTemplates.CUBE_ALL;
        // 注册方块模型
        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.multiVariant(
                        block, Variant.variant().with(
                                // 变体
                                VariantProperties.MODEL,
                                modelTemplate.create(block,
                                        TextureMapping.cube(particleTexture),
                                        blockModels.modelOutput))));
        // 获取方块对应的物品
        Item chestItem = block.asItem();
        // 创建物品模型
        ItemModel.Unbaked unbaked = ItemModelUtils.plainModel(
                modelTemplate.create(chestItem,
                        // 纹理槽位
                        TextureMapping.cube(particleTexture),
                        // 模型输出路径
                        blockModels.modelOutput));
        // 注册物品模型
        itemModels.itemModelOutput.accept(chestItem, unbaked);
    }

    /**
     * 创建六面相同方块模型
     */
    public static void CreateRegularBlockModel(BlockModelGenerators blockModels, Block block) {
        blockModels.createTrivialCube(block);
    }

    /**
     * 创建普通物品模型
     */
    public static void CreateRegularItemModel(ItemModelGenerators itemModels, Item item) {
        itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
    }

    /**
     * 注册模型
     */
    @Override
    protected abstract void registerModels(@NotNull BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels);
//        CreateRegular(blockModels, EXAMPLE_BLOCK.getBlock());
//        CreateRegular(blockModels, EXAMPLE_BLOCK.getBlock());
//        CreateRegularItemModel(itemModels, EXAMPLE_ITEM.asItem());

}
