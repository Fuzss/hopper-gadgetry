package fuzs.hoppergadgetry.neoforge.client;

import fuzs.hoppergadgetry.common.HopperGadgetry;
import fuzs.hoppergadgetry.common.client.HopperGadgetryClient;
import fuzs.hoppergadgetry.common.data.client.ModLanguageProvider;
import fuzs.hoppergadgetry.common.data.client.ModModelProvider;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = HopperGadgetry.MOD_ID, dist = Dist.CLIENT)
public class HopperGadgetryNeoForgeClient {

    public HopperGadgetryNeoForgeClient() {
        ClientModConstructor.construct(HopperGadgetry.MOD_ID, HopperGadgetryClient::new);
        DataProviderBuilder.of(HopperGadgetry.MOD_ID)
                .addProvider(ModLanguageProvider::new, ModModelProvider::new);
    }
}
