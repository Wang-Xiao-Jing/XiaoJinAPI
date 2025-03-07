package xiao_jin.api.datagen;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

/**
 * @author 尽
 * @apiNote 粒子数据生成器
 */
public class DatagenParticleDescriptionProvider extends ParticleDescriptionProvider {
    /**
     * 创建数据提供程序的实例。
     *
     * @param output 数据生成器输出到的预期根目录
     */
    protected DatagenParticleDescriptionProvider(PackOutput output) {
        super(output);
    }

    /**
     * 注册由生成的粒子描述 {@link #sprite(ParticleType, ResourceLocation)}
     * 或其中之一 {@link #spriteSet(ParticleType, Iterable) sprite设置方法}.
     */
    @Override
    protected void addDescriptions() {

    }
}
