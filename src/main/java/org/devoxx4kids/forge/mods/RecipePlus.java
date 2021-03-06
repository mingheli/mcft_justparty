package org.devoxx4kids.forge.mods;

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



import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

@Mod(modid = RecipePlus.MODID, name = RecipePlus.MODNAME, version = RecipePlus.VERSION)
public class RecipePlus
{
    public static final String MODID = "recipeplus";
    public static final String MODNAME = "Recipe+";
    public static final String VERSION = "0.0.1";

    // create custom creativetab for mod items
    //public static CreativeTabs tabRecipePlus = new RecipeCreativeTab("Recipe+");

    public final static Block blockBlueberry = new BlockBlueberry();


    public final static Item blueberry = new ItemBlueberry();

    public final static Block blockTomato = new BlockTomato();


    public final static Item tomato = new ItemTomato();

    @EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry."
    public void preInit(FMLPreInitializationEvent event)
    {

        // DEBUG
        System.out.println("preInit()");

        // register blocks
        GameRegistry.registerBlock(blockTomato, "tomatoes");

        // register items
        GameRegistry.registerItem(tomato, "tomato");
        // register blocks
        GameRegistry.registerBlock(blockBlueberry, "blueberries");

        // register items
        GameRegistry.registerItem(blueberry, "blueberry");

        // register tileentities

    }

    @EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes."
    public void load(FMLInitializationEvent event)
    {

        // DEBUG
        System.out.println("load()");

        // register custom event listeners
        //MinecraftForge.EVENT_BUS.register(new RecipeEventHandler());
        // FMLCommonHandler.instance().bus().register(new RecipeEventHandler());
    }

    @EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this."
    public void postInit(FMLPostInitializationEvent event)
    {
        // DEBUG
        System.out.println("postInit()");

        // register world types
        // WorldType RECIPE_PLUS = new WorldTypeRecipePlus(3, "worldTypeRecipePlus");
    }
}