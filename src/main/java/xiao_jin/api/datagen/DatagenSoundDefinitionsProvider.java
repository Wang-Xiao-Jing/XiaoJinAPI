package xiao_jin.api.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import static xiao_jin.api.XiaoJinAPI.MOD_ID;

/**
 * @author 尽
 * @apiNote 音频数据生成器
 */
public class DatagenSoundDefinitionsProvider extends SoundDefinitionsProvider {
    /**
     * Creates a new instance of this data provider.
     *
     * @param output The {@linkplain PackOutput} instance provided by the data generator.
     * @param modId  The mod ID of the current mod.
     */
    protected DatagenSoundDefinitionsProvider(PackOutput output) {
        super(output, MOD_ID);
    }

    /**
     * Registers the sound definitions that should be generated via one of the {@code add} methods.
     */
    @Override
    public void registerSounds() {

    }
}
