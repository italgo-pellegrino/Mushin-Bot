package de.mushin.commands;

import java.util.List;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

public class contactCommand implements ServerCommand{

	@Override
	public void performCommand(Member m, TextChannel channel, Message message) {		
					
			String[] args = message.getContentDisplay().split(" ");
			channel.sendMessage("Für fragen bin ich gerne wie folgt zu erreichen:\r\n" +
					"**Email: italgo.bot@web.de**\r\n" +
					"**Discord: italgo#1324**\r\n\r\n" +
					"Sollte euch der Bot gefallen würde ich mich über eine kleine Spende freuen: **PayPal: italgo@web.de**"
			).queue();
			
			 message.delete().queue();						
	}
	
	
}
