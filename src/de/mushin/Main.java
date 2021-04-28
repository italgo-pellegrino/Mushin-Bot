package de.mushin;


import javax.security.auth.login.LoginException;

import de.mushin.commands.CommandManager;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {

	public static Main INSTANCE;

	
	private CommandManager cmdMan;
	
	
	public static void main(String[]args) {
		
		try {
			new Main();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Main() throws LoginException, IllegalArgumentException{
		
		INSTANCE = this;		
		
		JDABuilder builder = JDABuilder.createDefault("ODIwNjAyNDAwMzU1NTE2NDI2.YE3jig.hReL96qkfgXxJnknwINeDZdN72A");
		
			
		builder.setActivity(Activity.playing("!boss help |- for Info"));
		builder.setStatus(OnlineStatus.ONLINE);
		
		
		this.cmdMan = new CommandManager();
		
		builder.addEventListeners(new CommandListener());
		
		builder.build();
		System.out.println("Bot online.");			
	
	}
	

	
	 public CommandManager getCmdMan() {
		 return cmdMan;
	 }
	
}
