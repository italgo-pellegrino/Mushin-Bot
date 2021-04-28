package de.mushin.commands;

import java.util.concurrent.ConcurrentHashMap;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;


public class CommandManager {

	public ConcurrentHashMap<String, ServerCommand> commands;
	
	public CommandManager() {
		this.commands = new ConcurrentHashMap<>();
		
		this.commands.put("kill", new killCommand());
		this.commands.put("spawn", new spawnCommand());
		this.commands.put("help", new helpCommand());
		this.commands.put("role", new setRoleCommand());
		this.commands.put("contact", new contactCommand());
	}
	
	public boolean perform(String command, Member member, TextChannel channel, Message message) {
		
		ServerCommand cmd;
		if((cmd = this.commands.get(command.toLowerCase())) != null) {
			cmd.performCommand(member, channel, message);
			return true;
		}
		
		
		return false;
	}
}
