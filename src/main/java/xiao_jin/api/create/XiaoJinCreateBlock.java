package xiao_jin.api.create;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;


/**
 * @author 尽
 * @apiNote 创建方块
 */
public class XiaoJinCreateBlock {
    /**
     * 生成一个用于原木类型方块的属性对象
     * 该函数根据传入的参数配置方块的属性，包括颜色、声音、强度等
     *
     * @param sideColor 方块的侧面在地图上显示的颜色
     * @param topColor 方块的顶部在地图上显示的颜色
     * @param sound 方块的音效类型
     * @return 方块属性 {@linkplain BlockBehaviour.Properties}
     */
    public static BlockBehaviour.Properties logProperties(MapColor sideColor, MapColor topColor, SoundType sound, float strength, NoteBlockInstrument instrument) {
        return XiaoJinBlockBehaviour.Properties.of()
                .mapColor(mapColor -> mapColor.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? sideColor : topColor)
                .instrument(instrument)
                .strength(strength)
                .sound(sound)
                .ignitedByLava();
    }

    /**
     * 生成一个用于原木类型方块的属性对象
     * 该函数根据传入的参数配置方块的属性，包括颜色、声音、强度等
     *
     * @param sideColor 方块的侧面在地图上显示的颜色
     * @param topColor 方块的顶部在地图上显示的颜色
     * @param sound 方块的音效类型
     * @param strength 方块的强度
     * @return 方块属性 {@linkplain BlockBehaviour.Properties}
     */
    public static BlockBehaviour.Properties logProperties(MapColor sideColor, MapColor topColor, SoundType sound, float strength) {
        return logProperties(sideColor, topColor, sound, strength, NoteBlockInstrument.BASS);
    }

    /**
     * 生成一个用于树叶类型方块的属性对象。
     * @param sound 声音
     * @return 方块属性 {@linkplain BlockBehaviour.Properties}
     */
    public static BlockBehaviour.Properties leavesProperties(SoundType sound) {
        return leavesProperties(MapColor.PLANT, sound, 0.2F);
    }

    /**
     * 生成一个用于树叶类型方块的属性对象。
     *
     * @param sound 声音
     * @return 方块属性 {@linkplain BlockBehaviour.Properties}
     */
    public static BlockBehaviour.Properties leavesProperties(MapColor color, SoundType sound, float strength) {
        return leavesProperties(color, sound, strength, strength);
    }

    /**
     * 生成一个用于树叶类型方块的属性对象。
     *
     * @param sound 声音
     * @return 方块属性 {@linkplain BlockBehaviour.Properties}
     */
    public static BlockBehaviour.Properties leavesProperties(MapColor color, SoundType sound, float destroyTime, float explosionResistance) {
        return XiaoJinBlockBehaviour.Properties.of()
                .mapColor(color)
                .strength(destroyTime, explosionResistance)
                .randomTicks()
                .sound(sound)
                .noOcclusion()
                .isValidSpawn(Blocks::ocelotOrParrot)
                .isSuffocating(XiaoJinCreateBlock::never)
                .isViewBlocking(XiaoJinCreateBlock::never)
                .pushReaction(PushReaction.DESTROY)
                .isRedstoneConductor(XiaoJinCreateBlock::never);
    }

    public static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }
}
