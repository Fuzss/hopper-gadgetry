package fuzs.hoppergadgetry.common.data.tags;

import fuzs.hoppergadgetry.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;
import fuzs.puzzleslib.common.api.data.v3.tags.AbstractTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemIds;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

public class ModBlockTagsProvider extends AbstractTagsProvider<Block> {

    public ModBlockTagsProvider(DataProviderContext context) {
        super(Registries.BLOCK, context);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModRegistry.GRATED_HOPPER_BLOCK);
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModRegistry.CHUTE_BLOCK, ModRegistry.DUCT_BLOCK);
        this.tag(ModRegistry.DUCT_INPUTS_BLOCK_TAG)
                .add(BlockItemIds.HOPPER.block())
                .add(ModRegistry.DUCT_BLOCK, ModRegistry.GRATED_HOPPER_BLOCK, ModRegistry.CHUTE_BLOCK);
    }
}
