package xiao_jin.api.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

/**
 * 语言文件生成器Zh_Cn
 */
public class XiaoJinLanguageProvider extends LanguageProvider {

    public XiaoJinLanguageProvider(PackOutput output, String modId) {
        this(output, modId, "zh_CN");
    }

    public XiaoJinLanguageProvider(PackOutput output, String modId, String locale) {
        super(output, modId, locale);
    }

    /**
     * 添加语言
     * */
    @Override
    protected void addTranslations(){

    }

    /**
     * 添加创造模式物品栏
     * @param itemGroup 创造模式物品栏
     * @param name 翻译后的名字
     */
    public <R, T extends R> void add(DeferredHolder<R, T> itemGroup, String name) {
        String itemGroupName = "itemGroup." + itemGroup.getId().toString().replace(":", ".");
        add(itemGroupName, name);
    }
}
