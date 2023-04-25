package de.mushin;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String message = event.getMessage().getContentDisplay();
		
		if(event.isFromType(ChannelType.TEXT)) {
			TextChannel channel = event.getTextChannel();
			
			if(message.startsWith("!boss") || message.startsWith("!Boss") || message.startsWith("!BOSS")   ) {
				
				String[] args = message.substring(5).split(" ");
				
				if(args.length > 0) {
					
					if(Main.INSTANCE.getCmdMan().perform(args[1], event.getMember(), channel, event.getMessage()) == false) {
						channel.sendMessage("`Unbekanntes Commando`").queue();
					}					
				}
			}
		}
	}
}
