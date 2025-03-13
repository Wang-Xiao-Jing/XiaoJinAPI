package xiao_jin.api.datagen;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;

import java.util.Optional;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

/**
 * 模型模板
 */
public class XiaoJinModels extends TexturedModel {
    public XiaoJinModels(TextureMapping mapping, ModelTemplate template) {
        super(mapping, template);
    }

    public static ModelTemplate createBlockModel(String modId, String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(fromNamespaceAndPath(modId, "block/"+name)), Optional.empty(), requiredSlots);
    }
}
