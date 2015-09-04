package org.devoxx4kids.forge.mods;


import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class BlockBreakMessage {
	@SubscribeEvent
	public void sendMessage(BreakEvent event) {
		event.getPlayer().addChatMessage(
				new ChatComponentText(EnumChatFormatting.GOLD
						+ "You broke a block!"));
	}
}