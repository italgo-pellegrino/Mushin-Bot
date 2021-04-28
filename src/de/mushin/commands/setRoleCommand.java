package de.mushin.commands;


import java.util.List;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;


public class setRoleCommand implements ServerCommand {

	private String roleId = "";
	

	@Override
	public void performCommand(Member m, TextChannel channel, Message message) {		
					
			String[] args = message.getContentDisplay().split(" ");
				if(args.length == 3) {
					
					List<Role> role =  message.getMentionedRoles();														
					roleId = role.get(0).getId();								
					changeRole("<@&"+roleId+">");
				}
			
			 message.delete().queue();						
	}
	
	private void changeRole(String role) {
		spawnCommand.role = role;
		killCommand.role = role;
	}

}
