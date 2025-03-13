package xiao_jin.api.create;

import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/**
 * 创建创造模式物品栏
 */
public class XiaoJinCreateCreationModeTab extends CreativeModeTabs {

    public static DeferredRegister<CreativeModeTab> getCreativeModeTabs(ResourceKey<Registry<CreativeModeTab>> registryKey, String modId) {
        return DeferredRegister.create(registryKey, modId);
    }

    /**
     * 创造模式物品栏名称标识符
     *
     * @param name 名称
     */
    public static MutableComponent title(String name, String modId) {
        return Component.translatable("itemGroup." + modId + "." + name);
    }

    /**
     * 创建一个创造模式物品栏
     *
     * @param name                  命名空间
     * @param withTabsBefore        父物品栏
     * @param icon                  图标
     * @param displayItemsGenerator 显示物品
     * @return 延迟注册器
     */
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> register(
            String name,
            ResourceKey<CreativeModeTab> withTabsBefore,
            Supplier<ItemStack> icon,
            CreativeModeTab.DisplayItemsGenerator displayItemsGenerator, DeferredRegister<CreativeModeTab> creativeModeTabs) {
        return creativeModeTabs.register(name, () -> CreativeModeTab.builder()
                .title(title(name, creativeModeTabs.getNamespace()))
                .withTabsBefore(withTabsBefore)
                .icon(icon)
                .displayItems(displayItemsGenerator)
                .build());
    }

    /**
     * 创建一个创造模式物品栏
     *
     * @param name           命名空间
     * @param withTabsBefore 父物品栏
     * @param icon           图标
     * @return 延迟注册器
     */
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> register(
            String name,
            ResourceKey<CreativeModeTab> withTabsBefore,
            Supplier<ItemStack> icon, DeferredRegister<CreativeModeTab> creativeModeTabs) {
        return register(name, withTabsBefore, icon, (parameters, output) -> {}, creativeModeTabs);
    }
}
