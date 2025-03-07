package xiao_jin.api.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

import static xiao_jin.api.XiaoJinAPI.MOD_ID;

/**
 * @author 尽
 * @apiNote 语言文件生成器Zh_Cn
 */
public class DatagenLanguageProvider extends LanguageProvider {
    public DatagenLanguageProvider(PackOutput output) {
        super(output, MOD_ID, "zh_CN");
    }

    @Override
    protected void addTranslations() {
/*        add(BUILDING_BLOCKS, "XiaoJing's Mod的建筑方块");
        addItem(EXAMPLE_ITEM, "示例物品");
        addBlock(EXAMPLE_BLOCK.block, "示例方块");*/
    }

    public <R, T extends R> void add(DeferredHolder<R, T> itemGroup, String name) {
        String itemGroupName = "itemGroup." + itemGroup.getId().toString().replace(":", ".");
        add(itemGroupName, name);
    }
}
