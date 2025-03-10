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
import net.neoforged.neoforge.registries.DeferredRegister;
import xiao_jin.api.create.template.ModBlockBehaviour;


/**
 * @author 尽
 * @apiNote 创建方块
 */
public abstract class CreateBlockAPI{
//    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);
//    public static final ModCreateAPI EXAMPLE_BLOCK = new ModCreateAPI("example_block");

    /**
     * 生成一个用于日志类型方块的属性对象。
     * 该函数根据传入的参数配置方块的属性，包括颜色、声音、强度等。
     *
     * @param sideColor 方块的侧面颜色，当方块的轴为Y轴时使用。
     * @param topColor 方块的顶部颜色，当方块的轴不为Y轴时使用。
     * @param sound 方块的音效类型。
     * @return {@linkplain BlockBehaviour.Properties}
     */
    public static BlockBehaviour.Properties logProperties(MapColor sideColor, MapColor topColor, SoundType sound, float strength, NoteBlockInstrument instrument) {
        return ModBlockBehaviour.Properties.of()
                .mapColor(mapColor -> mapColor.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? sideColor : topColor)
                .instrument(instrument)
                .strength(strength)
                .sound(sound)
                .ignitedByLava();
    }

    /**
     * 生成一个用于日志类型方块的属性对象。
     * 该函数根据传入的参数配置方块的属性，包括颜色、声音、强度等。
     *
     * @param sideColor 方块的侧面颜色，当方块的轴为Y轴时使用。
     * @param topColor 方块的顶部颜色，当方块的轴不为Y轴时使用。
     * @param sound 方块的音效类型。
     * @param strength 方块的强度。
     * @return {@linkplain BlockBehaviour.Properties}
     */
    public static BlockBehaviour.Properties logProperties(MapColor sideColor, MapColor topColor, SoundType sound, float strength) {
        return logProperties(sideColor, topColor, sound, strength, NoteBlockInstrument.BASS);
    }

    /**
     * 生成一个用于树叶类型方块的属性对象。
     * @param sound 声音
     * @return {@linkplain BlockBehaviour.Properties}
     */
    public static BlockBehaviour.Properties leavesProperties(SoundType sound) {
        return leavesProperties(MapColor.PLANT, sound, 0.2F);
    }

    /**
     * 生成一个用于树叶类型方块的属性对象。
     *
     * @param sound 声音
     * @return {@linkplain BlockBehaviour.Properties}
     */
    public static BlockBehaviour.Properties leavesProperties(MapColor color, SoundType sound, float strength) {
        return leavesProperties(color, sound, strength, strength);
    }

    /**
     * 生成一个用于树叶类型方块的属性对象。
     *
     * @param sound 声音
     * @return {@linkplain BlockBehaviour.Properties}
     */
    public static BlockBehaviour.Properties leavesProperties(MapColor color, SoundType sound, float destroyTime, float explosionResistance) {
        return ModBlockBehaviour.Properties.of()
                .mapColor(color)
                .strength(destroyTime, explosionResistance)
                .randomTicks()
                .sound(sound)
                .noOcclusion()
                .isValidSpawn(Blocks::ocelotOrParrot)
                .isSuffocating(CreateBlockAPI::never)
                .isViewBlocking(CreateBlockAPI::never)
                .pushReaction(PushReaction.DESTROY)
                .isRedstoneConductor(CreateBlockAPI::never);
    }


    /**
     * 该函数用于判断某个方块是否满足特定条件，始终返回 false。（mojang那我问你）
     *
     * @param blockState 方块的当前状态，包含方块的属性信息。
     * @param blockGetter 用于获取方块信息的上下文对象，通常用于查询方块的状态或属性。
     * @param blockPos 方块的位置信息，用于定位具体的方块。
     * @return 始终返回 false，表示该方块不满足任何条件。
     */
    public static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }
}
