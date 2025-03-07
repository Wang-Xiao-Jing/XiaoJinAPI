package xiao_jin.api;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import xiao_jin.api.create.CreateBlock;
import xiao_jin.api.create.CreateCreationModeTab;
import xiao_jin.api.create.CreateItem;

import java.util.Locale;

@Mod(XiaoJinAPI.MOD_ID)
public class XiaoJinAPI
{
    public static final String MOD_ID = "xiao_jin_api";

    public XiaoJinAPI(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(CreateCreationModeTab::registerCapabilities);
//        modEventBus.addListener(Datagen::gatherData);

        CreateBlock.BLOCKS.register(modEventBus);
        CreateItem.ITEMS.register(modEventBus);
        CreateCreationModeTab.CREATIVE_MODE_TABS.register(modEventBus);
    }

    /**
     * <p>生成获取资源路径</p>
     * <br/>
     * 取自ironchest项目 源代码仓库：<a href="https://github.com/progwml6/ironchest">ironchest</a>
     * <br/>
     * 经过修改 源代码许可证：GPL-3.0
     * @param name 资源名称
     * @return {@link ResourceLocation} 资源路径
     * */
    public static ResourceLocation prefix(String name) {
        return prefix(name, MOD_ID);
    }

    public static ResourceLocation prefix(String name, String modId) {
        return ResourceLocation.fromNamespaceAndPath(modId, name.toLowerCase(Locale.ROOT));
    }
}
