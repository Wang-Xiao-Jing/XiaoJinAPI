package xiao_jin.api.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static xiao_jin.api.XiaoJinAPI.MOD_ID;

/**
 * @author 尽
 * @apiNote 数据生成
 */
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = MOD_ID)
public class Datagen {

    @SubscribeEvent
    private static void gatherData(GatherDataEvent.Client event) {
        DataGenerator gen = event.getGenerator(); // 获取数据生成器
        PackOutput packOutput = gen.getPackOutput(); // 获取输出路径
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider(); // 获取查找提供者
        gen.addProvider(true, new DatagenAdvancementProvider(packOutput, lookupProvider, List.of())); // 生成成就文件
        gen.addProvider(true, new DatagenLanguageProvider(packOutput)); // 生成语言文件
        gen.addProvider(true, new DatagenModelProvider(packOutput)); // 生成模型文件
        gen.addProvider(true, new DatagenParticleDescriptionProvider(packOutput)); // 生成粒子描述文件
        gen.addProvider(true, new DatagenSoundDefinitionsProvider(packOutput)); // 生成粒子定义文件
//        gen.addProvider(event.includeReports(),
//                new LootTableProvider(packOutput, Collections.emptySet(),
//                        List.of(new LootTableProvider.SubProviderEntry(DatagenBlockLootTableProvider::new, LootContextParamSets.BLOCK)),
//                        lookupProvider));
    }

    public static void data(DataGenerator gen, PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {}


}
