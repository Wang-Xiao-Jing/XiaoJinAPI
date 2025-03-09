package xiao_jin.api.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

/**
 * @author 尽
 * @apiNote 语言文件生成器Zh_Cn
 */
public abstract class LanguageProviderAPI extends LanguageProvider {

    public LanguageProviderAPI(PackOutput output, String modId) {
        this(output, modId, "zh_CN");
    }

    public LanguageProviderAPI(PackOutput output, String modId, String locale) {
        super(output, modId, locale);
    }

    @Override
    protected abstract void addTranslations();
/*        add(BUILDING_BLOCKS, "XiaoJing's Mod的建筑方块");
        addItem(EXAMPLE_ITEM, "示例物品");
        addBlock(EXAMPLE_BLOCK.block, "示例方块");*/

    public <R, T extends R> void add(DeferredHolder<R, T> itemGroup, String name) {
        String itemGroupName = "itemGroup." + itemGroup.getId().toString().replace(":", ".");
        add(itemGroupName, name);
    }
}
