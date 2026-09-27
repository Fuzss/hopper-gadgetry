package fuzs.hoppergadgetry.neoforge;

import fuzs.hoppergadgetry.common.HopperGadgetry;
import fuzs.hoppergadgetry.common.data.loot.ModBlockLootProvider;
import fuzs.hoppergadgetry.common.data.tags.ModBlockTagsProvider;
import fuzs.hoppergadgetry.common.data.ModRecipeProvider;
import fuzs.hoppergadgetry.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import fuzs.puzzleslib.neoforge.api.init.v3.capability.NeoForgeCapabilityHelper;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.fml.common.Mod;

@Mod(HopperGadgetry.MOD_ID)
public class HopperGadgetryNeoForge {

    public HopperGadgetryNeoForge() {
        ModConstructor.construct(HopperGadgetry.MOD_ID, HopperGadgetry::new);
        registerCapabilities();
        DataProviderBuilder.of(HopperGadgetry.MOD_ID)
                .addLootProvider(ModBlockLootProvider::new, LootContextParamSets.BLOCK)
                .addRecipeProvider(ModRecipeProvider::new)
                .addProvider(ModBlockTagsProvider::new);
    }

    private static void registerCapabilities() {
        NeoForgeCapabilityHelper.registerBlockEntityContainer(ModRegistry.GRATED_HOPPER_BLOCK_ENTITY_TYPE,
                ModRegistry.DUCT_BLOCK_ENTITY_TYPE);
        NeoForgeCapabilityHelper.registerEntityContainer(ModRegistry.GRATED_HOPPER_MINECART_ENTITY_TYPE);
    }
}
