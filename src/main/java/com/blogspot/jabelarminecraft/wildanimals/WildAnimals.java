/**
    Copyright (C) 2014 by jabelar

    This file is part of jabelar's Minecraft Forge modding examples; as such,
    you can redistribute it and/or modify it under the terms of the GNU
    General Public License as published by the Free Software Foundation,
    either version 3 of the License, or (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    For a copy of the GNU General Public License see <http://www.gnu.org/licenses/>.
*/

package com.blogspot.jabelarminecraft.wildanimals;

import java.io.File;

import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.config.Configuration;

import com.blogspot.jabelarminecraft.wildanimals.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = WildAnimals.MODID, 
      name = WildAnimals.MODNAME, 
      version = WildAnimals.MODVERSION,
      guiFactory = "com.blogspot.jabelarminecraft.wildanimals.gui.WildAnimalsConfigGUIFactory")
public class WildAnimals
{
    public static final String MODID = "wildanimals";
    public static final String MODNAME = "Wild Animals +";
    public static final String MODVERSION = "0.0.1";
    public static final String MODDESCRIPTION = "The wildest animals that ever inhabited Minecraft! Tigers! Snakes! Elephants! And More!";
    public static final String MODAUTHOR = "jabelar";
    public static final String MODCREDITS = "Dedicated to jnaejnae.";
    public static final String MODURL = "www.jabelarminecraft.blogspot.com";

    // use a named channel to identify packets related to this mod
    public static final String NETWORK_CHANNEL_NAME = "WildAnimals";
	public static FMLEventChannel channel;
	// networking
	public static SimpleNetworkWrapper network;

    // set up configuration properties (will be read from config file in preInit)
    public static File configFile;
    public static Configuration config;
    public static Boolean configBigCatsAreManEaters = false;
    public static Boolean configIncludeSnakes = true;
    public static Boolean configIncludeBigCats = true;
    public static Boolean configIncludeHerdAnimals = true;
    public static Boolean configIncludeBirdsOfPrey = true;

    // instantiate the mod
    @Instance(MODID)
    public static WildAnimals instance;
    
    // create custom creativetab for mod items
    //public static CreativeTabs tabWildAnimalsPlus = new WildAnimalsCreativeTab("WildAnimals+");
    
    // instantiate blocks
    //public final static Block blockTomato = new BlockTomato();

    // instantiate items
    //public final static Item tomato = new ItemTomato();
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="com.blogspot.jabelarminecraft.wildanimals.proxy.ClientProxy", serverSide="com.blogspot.jabelarminecraft.wildanimals.proxy.CommonProxy")
    public static CommonProxy proxy;
            
    @EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry."
    public void fmlLifeCycleEvent(FMLPreInitializationEvent event) 
    {   	
        // DEBUG
        System.out.println("preInit()"+event.getModMetadata().name);
        
        // hard-code mod information so don't need mcmod.info file
        event.getModMetadata().autogenerated = false ; // stops it from complaining about missing mcmod.info
        event.getModMetadata().credits = MODCREDITS;
        event.getModMetadata().authorList.add(EnumChatFormatting.RED+MODAUTHOR);
        event.getModMetadata().description = EnumChatFormatting.YELLOW+MODDESCRIPTION;
        event.getModMetadata().url = MODURL;
        
        proxy.fmlLifeCycleEvent(event);
    }

    @EventHandler
    // Do your mod setup. Build whatever data structures you care about. Register recipes."
    // Register network handlers
    public void fmlLifeCycleEvent(FMLInitializationEvent event) 
    {
    	
        // DEBUG
        System.out.println("init()");
        
        proxy.fmlLifeCycleEvent(event);
    }

	@EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this."
    public void fmlLifeCycle(FMLPostInitializationEvent event) 
	{
        // DEBUG
        System.out.println("postInit()");
        
        proxy.fmlLifeCycleEvent(event);
    }

	@EventHandler
	public void fmlLifeCycle(FMLServerAboutToStartEvent event)
	{
        // DEBUG
        System.out.println("Server about to start");
        
		proxy.fmlLifeCycleEvent(event);
	}

	@EventHandler
	// register server commands
	// refer to tutorial at http://www.minecraftforge.net/wiki/Server_Command#Mod_Implementation
	public void fmlLifeCycle(FMLServerStartingEvent event)
	{
        // DEBUG
        System.out.println("Server starting");
        
		proxy.fmlLifeCycleEvent(event);
	}

	@EventHandler
	public void fmlLifeCycle(FMLServerStartedEvent event)
	{
        // DEBUG
        System.out.println("Server started");
        
		proxy.fmlLifeCycleEvent(event);
	}

	@EventHandler
	public void fmlLifeCycle(FMLServerStoppingEvent event)
	{
        // DEBUG
        System.out.println("Server stopping");
        
		proxy.fmlLifeCycleEvent(event);
	}

	@EventHandler
	public void fmlLifeCycle(FMLServerStoppedEvent event)
	{
        // DEBUG
        System.out.println("Server stopped");
        
		proxy.fmlLifeCycleEvent(event);
	}

}