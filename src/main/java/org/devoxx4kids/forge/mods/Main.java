package org.devoxx4kids.forge.mods;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;


@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	public static final String MODID = "MyMods";
	public static final String VERSION = "2.0";
     @Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
        EnderBlock enderBlock = new EnderBlock();
        enderBlock.setBlockName(MODID + ":" + "enderBlock");
        enderBlock.setBlockTextureName(MODID + ":" + "enderBlock");
        GameRegistry.registerBlock(enderBlock, "enderBlock");
        Item blasterRifle = new ItemBlasterRifle();
        blasterRifle.setUnlocalizedName(MODID + ":" + "blasterRifle");
        blasterRifle.setTextureName(MODID + ":" + "blasterRifle");
        GameRegistry.registerItem(blasterRifle, "Blaster Rifle");
    }


}
