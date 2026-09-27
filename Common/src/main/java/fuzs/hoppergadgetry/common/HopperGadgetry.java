package fuzs.hoppergadgetry.common;

import fuzs.hoppergadgetry.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HopperGadgetry implements ModConstructor {
    public static final String MOD_ID = "hoppergadgetry";
    public static final String MOD_NAME = "Hopper Gadgetry";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onConstructMod() {
        ModRegistry.bootstrap();
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
