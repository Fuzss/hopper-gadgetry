package fuzs.hoppergadgetry.common.data.loot;

import fuzs.hoppergadgetry.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v3.loot.AbstractBlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.level.block.Block;

public class ModBlockLootProvider extends AbstractBlockLootSubProvider {

    public ModBlockLootProvider(LootTableSubProvider.Context context) {
        super(context);
    }

    @Override
    public void generate() {
        this.dropNameable(ModRegistry.GRATED_HOPPER_BLOCK.value());
        this.dropNameable(ModRegistry.CHUTE_BLOCK.value());
        this.dropNameable(ModRegistry.DUCT_BLOCK.value());
    }

    public void dropNameable(Block block) {
        this.add(block, this::createNameableBlockEntityTable);
    }
}
