package net.valion.manyflowers.setup;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.valion.manyflowers.ManyFlowers;
import net.valion.manyflowers.block.*;

import javax.annotation.Nullable;
import java.util.List;

import static net.valion.manyflowers.ManyFlowers.MOD_ID;

public class OreFlowers {
    public static final Block DIAMOND_FLOWER = registerBlock("diamond_flower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroup.DECORATIONS);

    public static final Block COAL_FLOWER = registerBlock("coal_flower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroup.DECORATIONS);

    public static final Block IRON_FLOWER = registerBlock("iron_flower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroup.DECORATIONS);

    public static final Block GOLD_FLOWER = registerBlock("gold_flower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroup.DECORATIONS);

    public static final Block EMERALD_FLOWER = registerBlock("emerald_flower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroup.DECORATIONS);

    public static final Block COPPER_FLOWER = registerBlock("copper_flower",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 3,
                    FabricBlockSettings.copy(Blocks.DANDELION).nonOpaque()), ItemGroup.DECORATIONS);

    //Plants//
    public static final Block DIAMOND_PLANT = registerBlockWithoutBlockItem("diamond_plant",
            new DiamondPlant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision()));

    public static final Block COAL_PLANT = registerBlockWithoutBlockItem("coal_plant",
            new CoalPlant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision()));

    public static final Block IRON_PLANT = registerBlockWithoutBlockItem("iron_plant",
            new IronPlant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision()));

    public static final Block GOLD_PLANT = registerBlockWithoutBlockItem("gold_plant",
            new GoldPlant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision()));

    public static final Block EMERALD_PLANT = registerBlockWithoutBlockItem("emerald_plant",
            new EmeraldPlant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision()));

    public static final Block COPPER_PLANT = registerBlockWithoutBlockItem("copper_plant",
            new CopperPlant(FabricBlockSettings.copy(Blocks.WHEAT).nonOpaque().noCollision()));

    //Petal Blocks//
    public static final Block DIAMOND_PETAL_BLOCK = registerBlock("diamond_petal_block",
            new Block(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.AMETHYST_BLOCK)), ItemGroup.DECORATIONS);

    public static final Block COAL_PETAL_BLOCK = registerBlock("coal_petal_block",
            new Block(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.STONE)), ItemGroup.DECORATIONS);

    public static final Block IRON_PETAL_BLOCK = registerBlock("iron_petal_block",
            new Block(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.METAL)), ItemGroup.DECORATIONS);

    public static final Block GOLD_PETAL_BLOCK = registerBlock("gold_petal_block",
            new Block(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.METAL)), ItemGroup.DECORATIONS);

    public static final Block EMERALD_PETAL_BLOCK = registerBlock("emerald_petal_block",
            new Block(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.AMETHYST_BLOCK)), ItemGroup.DECORATIONS);

    public static final Block COPPER_PETAL_BLOCK = registerBlock("copper_petal_block",
            new Block(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.METAL)), ItemGroup.DECORATIONS);


    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(new TranslatableText(tooltipKey));
                    }
                });
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        ManyFlowers.LOGGER.info("Registering ModBlocks for " + MOD_ID);
    }
}
