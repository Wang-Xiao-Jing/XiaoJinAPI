package xiao_jin.api;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import java.util.Locale;

public class XiaoJinAPI {
    static final String MOD_ID = "xiao_jin_api";
    public XiaoJinAPI(IEventBus modEventBus, ModContainer modContainer) {
    }

    /**
     * <p>生成获取资源路径</p>
     * <br/>
     * 取自ironchest项目 源代码仓库：<a href="https://github.com/progwml6/ironchest">ironchest</a>
     * <br/>
     * 经过修改 源代码许可证：GPL-3.0
     *
     * @param name 资源名称
     * @param modId 模组ID
     * @return {@link ResourceLocation} 资源路径
     */
    public static ResourceLocation prefix(String name, String modId) {
        return ResourceLocation.fromNamespaceAndPath(modId, name.toLowerCase(Locale.ROOT));
    }
}
