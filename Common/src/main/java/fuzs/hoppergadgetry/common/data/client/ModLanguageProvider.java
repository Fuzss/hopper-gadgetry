package fuzs.hoppergadgetry.common.data.client;

import fuzs.hoppergadgetry.common.HopperGadgetry;
import fuzs.hoppergadgetry.common.init.ModRegistry;
import fuzs.hoppergadgetry.common.world.level.block.entity.ChuteBlockEntity;
import fuzs.hoppergadgetry.common.world.level.block.entity.DuctBlockEntity;
import fuzs.hoppergadgetry.common.world.level.block.entity.GratedHopperBlockEntity;
import fuzs.puzzleslib.common.api.client.data.v3.language.AbstractLanguageProvider;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations() {
        this.add(ModRegistry.CREATIVE_MODE_TAB.value(), HopperGadgetry.MOD_NAME);
        this.add(ModRegistry.CHUTE_BLOCK.value(), "Chute");
        this.add(ModRegistry.DUCT_BLOCK.value(), "Duct");
        this.add(ModRegistry.GRATED_HOPPER_BLOCK.value(), "Grated Hopper");
        this.add(ModRegistry.GRATED_HOPPER_MINECART_ITEM.value(), "Grated Hopper Minecart");
        this.add(ModRegistry.GRATED_HOPPER_MINECART_ENTITY_TYPE.value(), "Minecart with Grated Hopper");
        this.add(ModRegistry.CHUTE_MINECART_ITEM.value(), "Chute Minecart");
        this.add(ModRegistry.CHUTE_MINECART_ENTITY_TYPE.value(), "Minecart with Chute");
        this.add(GratedHopperBlockEntity.COMPONENT_GRATED_HOPPER, "Grated Hopper");
        this.add(ChuteBlockEntity.COMPONENT_CHUTE, "Item Chute");
        this.add(DuctBlockEntity.COMPONENT_DUCT, "Item Duct");
    }
}
