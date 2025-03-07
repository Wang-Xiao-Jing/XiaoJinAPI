package xiao_jin.api.create;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static xiao_jin.api.XiaoJinAPI.MOD_ID;

/**
 * @author 尽
 * @apiNote 创建一个创造模式物品栏
 */
public class CreateCreationModeTab extends EventHooks{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
//    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BUILDING_BLOCKS = register(
//            "building_blocks",
//            CreativeModeTabs.COMBAT,
//            () -> EXAMPLE_ITEM.get().getDefaultInstance(),
//            (parameters, output) ->{
//                    output.accept(EXAMPLE_ITEM);
//                    output.accept(EXAMPLE_BLOCK.blockItem);
//            });

    /**
     * 添加到创造模式物品栏
     */
    public static void registerCapabilities(BuildCreativeModeTabContentsEvent event)
    {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
//            event.accept(EXAMPLE_BLOCK.blockItem);
    }

    /**
     * 创造模式物品栏名称标识符
     * @param name 名称
     */
    public static MutableComponent title(String name, String modId){
        return Component.translatable("itemGroup." + modId + "." + name);
    }

    /**
     * 创建一个创造模式物品栏
     * @param name 命名空间
     * @param withTabsBefore 父物品栏
     * @param icon 图标
     * @param displayItemsGenerator 显示物品
     * @return 延迟注册器
     */
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> register(
            String name,
            ResourceKey<CreativeModeTab> withTabsBefore,
            Supplier<ItemStack> icon,
            CreativeModeTab.DisplayItemsGenerator displayItemsGenerator) {
        return CREATIVE_MODE_TABS.register(name, () -> CreativeModeTab.builder()
                .title(title(name, CREATIVE_MODE_TABS.getNamespace()))
                .withTabsBefore(withTabsBefore)
                .icon(icon)
                .displayItems(displayItemsGenerator)
                .build());
    }

    /**
     * 创建一个创造模式物品栏
     * @param name 命名空间
     * @param withTabsBefore 父物品栏
     * @param icon 图标
     * @return 延迟注册器
     */
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> register(
            String name,
            ResourceKey<CreativeModeTab> withTabsBefore,
            Supplier<ItemStack> icon) {
        return register(name, withTabsBefore, icon, (parameters, output) -> {});
    }
}
