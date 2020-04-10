package com.zefir.gnaeus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Card extends Block
{
    private static final VoxelShape SHAPE_NORTH = Block.makeCuboidShape(4, 0, 1, 12, 1, 15);
    private static final VoxelShape Shape_EAST = Block.makeCuboidShape(1, 0, 4,15 ,1 , 12);
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public Card()
    {
        super(Properties.create(Material.WOOL, MaterialColor.SNOW).hardnessAndResistance(1, 0.1f).sound(SoundType.CLOTH));
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @SuppressWarnings("deprecation")
    public boolean isSolid(BlockState state)
    {
        return false;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        switch (state.get(FACING))
        {
            case WEST:
            case EAST:
                return Shape_EAST;
            default:
                return SHAPE_NORTH;
        }
    }
}
