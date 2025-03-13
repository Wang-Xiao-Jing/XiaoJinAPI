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

/**
 * 数据生成器-模型
 *
 * @apiNote 提供方块和物品的模型生成
 */
public class XiaoJinModelProvider extends ModelProvider {
    public XiaoJinModelProvider(PackOutput output, String modId) {
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
        ModelTemplate modelTemplate = ModelTemplates.CUBE_ALL;
        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, modelTemplate.create(block, TextureMapping.cube(particleTexture), blockModels.modelOutput))));
        Item chestItem = block.asItem();
        ItemModel.Unbaked unbaked = ItemModelUtils.plainModel(modelTemplate.create(chestItem, TextureMapping.cube(particleTexture), blockModels.modelOutput));
        itemModels.itemModelOutput.accept(chestItem, unbaked);
    }

    /**
     * 创建六面相同方块模型
     */
    public static void createRegularBlockModel(BlockModelGenerators blockModels, Block block) {
        blockModels.createTrivialCube(block);
    }

    /**
     * 创建普通物品模型
     */
    public static void createRegulaItemModel(ItemModelGenerators itemModels, Item item) {
        itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
    }

    /**
     * 注册模型
     */
    @Override
    protected void registerModels(@NotNull BlockModelGenerators blockModels, @NotNull ItemModelGenerators itemModels) {
    }

}
