package xiao_jin.api.create.template;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import org.jetbrains.annotations.NotNull;

/**
 * 自定义的特殊模型渲染器，用于渲染特定的物品模型。
 * @apiNote 该类实现了 NoDataSpecialModelRenderer 接口，用于渲染不需要额外数据的物品模型。
 */
public abstract class ModSpecialModelRendererAPI implements NoDataSpecialModelRenderer {

    /**
     * 渲染物品模型
     *
     * @param displayContext 显示上下文
     * @param poseStack      姿态堆栈
     * @param bufferSource   多缓冲源
     * @param packedLight    打包的光照值
     * @param packedOverlay  打包的叠加值
     * @param hasFoilType    是否有光泽效果
     */
    @Override
    public abstract void render(@NotNull ItemDisplayContext displayContext, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay, boolean hasFoilType);
}
