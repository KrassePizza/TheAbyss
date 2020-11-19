package com.krassepizza.abyss;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krassepizza.abyss.init.BiomeInit;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod("abyss")
@Mod.EventBusSubscriber(modid = Abyss.MOD_ID, bus = Bus.MOD)
public class Abyss
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "abyss";
    public static Abyss instance;

    public Abyss() 
    {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        ////REIHENFOLGE WICHTIG//// ITEM/BLOCK/TILEENTITY/ETC
        //ItemInitNew.ITEMS.register(modEventBus);
        //BlockInitNew.BLOCKS.register(modEventBus);
        BiomeInit.BIOMES.register(modEventBus);
        
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    /*@SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) 
    {
    	final IForgeRegistry<Item> registry = event.getRegistry();
    	
    	BlockInitNew.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
    		final Item.Properties properties = new Item.Properties().group(ItemGroup.BUILDING_BLOCKS);
    		final BlockItem blockItem = new BlockItem(block, properties);
    		blockItem.setRegistryName(block.getRegistryName());
    		registry.register(blockItem);
    	});
    	Block laughing_obsidian = BlockInitNew.LAUGHING_OBSIDIAN.get();
    	
    	LOGGER.debug("Registered BlockItems");
    }*/ //////// VERBUGT ODER SO, KONNTE KEINEN BLOCK BEI AbyssIgniter.java FINDEN

    /*@SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event)
    {
    	BiomeInit.registerBiomes();
    }*/
    
    private void setup(final FMLCommonSetupEvent event)
    {
        
    }

    private void doClientStuff(final FMLClientSetupEvent event) 
    {
        
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
    	
    }
}
