package fuzs.hoppergadgetry.common.init;

import fuzs.hoppergadgetry.common.HopperGadgetry;
import fuzs.hoppergadgetry.common.world.entity.vehicle.MinecartChute;
import fuzs.hoppergadgetry.common.world.entity.vehicle.MinecartGratedHopper;
import fuzs.hoppergadgetry.common.world.inventory.DuctMenu;
import fuzs.hoppergadgetry.common.world.inventory.GratedHopperMenu;
import fuzs.hoppergadgetry.common.world.level.block.ChuteBlock;
import fuzs.hoppergadgetry.common.world.level.block.DuctBlock;
import fuzs.hoppergadgetry.common.world.level.block.GratedHopperBlock;
import fuzs.hoppergadgetry.common.world.level.block.entity.ChuteBlockEntity;
import fuzs.hoppergadgetry.common.world.level.block.entity.DuctBlockEntity;
import fuzs.hoppergadgetry.common.world.level.block.entity.GratedHopperBlockEntity;
import fuzs.puzzleslib.common.api.init.v3.registry.RegistryManager;
import fuzs.puzzleslib.common.api.init.v3.tags.TagFactory;
import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

public class ModRegistry {
    static final RegistryManager REGISTRIES = RegistryManager.from(HopperGadgetry.MOD_ID);
    public static final Holder.Reference<Block> CHUTE_BLOCK = REGISTRIES.registerBlock("chute",
            ChuteBlock::new,
            () -> BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
                    .noOcclusion());
    public static final Holder.Reference<Item> CHUTE_ITEM = REGISTRIES.registerBlockItem(CHUTE_BLOCK,
            () -> new Item.Properties().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS));
    public static final Holder.Reference<Block> DUCT_BLOCK = REGISTRIES.registerBlock("duct",
            DuctBlock::new,
            () -> BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
                    .noOcclusion());
    public static final Holder.Reference<Item> DUCT_ITEM = REGISTRIES.registerBlockItem(DUCT_BLOCK,
            () -> new Item.Properties().cookingFuel(ContextIntProviders.COOKING_TIME_WOOD_BLOCKS));
    public static final Holder.Reference<Block> GRATED_HOPPER_BLOCK = REGISTRIES.registerBlock("grated_hopper",
            GratedHopperBlock::new,
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.HOPPER));
    public static final Holder.Reference<Item> GRATED_HOPPER_ITEM = REGISTRIES.registerBlockItem(GRATED_HOPPER_BLOCK);
    public static final Holder.Reference<EntityType<MinecartGratedHopper>> GRATED_HOPPER_MINECART_ENTITY_TYPE = REGISTRIES.registerEntityType(
            "grated_hopper_minecart",
            () -> EntityType.Builder.<MinecartGratedHopper>of(MinecartGratedHopper::new, MobCategory.MISC)
                    .sized(0.98F, 0.7F)
                    .clientTrackingRange(8));
    public static final Holder.Reference<EntityType<MinecartChute>> CHUTE_MINECART_ENTITY_TYPE = REGISTRIES.registerEntityType(
            "chute_minecart",
            () -> EntityType.Builder.<MinecartChute>of(MinecartChute::new, MobCategory.MISC)
                    .sized(0.98F, 0.7F)
                    .clientTrackingRange(8));
    public static final Holder.Reference<Item> GRATED_HOPPER_MINECART_ITEM = REGISTRIES.registerItem(
            "grated_hopper_minecart",
            (Item.Properties properties) -> new MinecartItem(GRATED_HOPPER_MINECART_ENTITY_TYPE.value(), properties),
            () -> new Item.Properties().stacksTo(1));
    public static final Holder.Reference<Item> CHUTE_MINECART_ITEM = REGISTRIES.registerItem("chute_minecart",
            (Item.Properties properties) -> new MinecartItem(CHUTE_MINECART_ENTITY_TYPE.value(), properties),
            () -> new Item.Properties().stacksTo(1));
    public static final Holder.Reference<CreativeModeTab> CREATIVE_MODE_TAB = REGISTRIES.registerCreativeModeTab(
            DUCT_ITEM);
    public static final Holder.Reference<BlockEntityType<GratedHopperBlockEntity>> GRATED_HOPPER_BLOCK_ENTITY_TYPE = REGISTRIES.registerBlockEntityType(
            "grated_hopper",
            GratedHopperBlockEntity::new,
            GRATED_HOPPER_BLOCK);
    public static final Holder.Reference<BlockEntityType<ChuteBlockEntity>> CHUTE_BLOCK_ENTITY_TYPE = REGISTRIES.registerBlockEntityType(
            "chute",
            ChuteBlockEntity::new,
            CHUTE_BLOCK);
    public static final Holder.Reference<BlockEntityType<DuctBlockEntity>> DUCT_BLOCK_ENTITY_TYPE = REGISTRIES.registerBlockEntityType(
            "duct",
            DuctBlockEntity::new,
            DUCT_BLOCK);
    public static final Holder.Reference<MenuType<GratedHopperMenu>> GRATED_HOPPER_MENU_TYPE = REGISTRIES.registerMenuType(
            "grated_hopper",
            GratedHopperMenu::new);
    public static final Holder.Reference<MenuType<DuctMenu>> DUCT_MENU_TYPE = REGISTRIES.registerMenuType("duct",
            DuctMenu::new);

    static final TagFactory TAGS = TagFactory.make(HopperGadgetry.MOD_ID);
    public static final TagKey<Block> DUCT_INPUTS_BLOCK_TAG = TAGS.registerBlockTag("duct_inputs");

    public static void bootstrap() {
        // NO-OP
    }
}
