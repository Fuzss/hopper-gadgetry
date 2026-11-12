package fuzs.hoppergadgetry.common.world.level.block.entity;

import fuzs.puzzleslib.common.api.block.v1.entity.BlockEntityHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;

/**
 * A helper class for bypasses vanilla expecting the block state passed in the constructor to have the hopper block
 * state facing property.
 */
public abstract class NonHopperBlockEntity extends HopperBlockEntity {

    public NonHopperBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockPos, Blocks.HOPPER.defaultBlockState());
        BlockEntityHelper.init(this, blockEntityType, blockState);
    }

    @Override
    public void setBlockState(BlockState blockState) {
        this.blockState = blockState;
        this.facing = blockState.getValue(this.getFacingProperty());
    }

    protected abstract EnumProperty<Direction> getFacingProperty();
}
