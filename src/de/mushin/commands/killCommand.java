package de.mushin.commands;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import de.mushin.Boss;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;



public class killCommand implements ServerCommand {
	
	private long sec = 1000L;
	private long min = sec*60L;
	private long h = min*60L;
	public static String role = "";
	
	@Override
	public void performCommand(Member m, TextChannel channel, Message message) {		
					
			String[] args = message.getContentDisplay().split(" ");
				
			if(args.length == 3) {
				if(containsBoss(args[2])) {								
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					channel.sendMessage(getBoss(args[2]).toString() + " get�tet um: " + sdf.format(cal.getTime())).queue();		
					timerBoss(getBoss(args[2]), channel);
				} else {
					channel.sendMessage("`"+args[2]+" ist kein Boss`").queue();
				}
			}
			else if(args.length==4) {
			
				if(containsBoss(args[2])) {								
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					channel.sendMessage(getBoss(args[2]).toString() + " get�tet um: " + sdf.format(cal.getTime())+" auf Kanal: "+ args[3]).queue();		
					timerBoss(getBoss(args[2]),args[3], channel);
				} else {
					channel.sendMessage("`"+args[2]+" ist kein Boss`").queue();
				}
				
			}else {
				
				channel.sendMessage("`Anzahl der Argumente ist falsch, bitte geben sie den kill in folgender Form ein: Kill Boss Kanal ein`").queue();			
			}
			 message.delete().queue();						
	}
	
	public static boolean containsBoss(String bossString) {

	    for (Boss boss : Boss.values()) {
	        if (boss.name().toLowerCase().equals(bossString.toLowerCase())) {
	            return true;
	        }
	    }

	    return false;
	}
	
	public static Boss getBoss(String bossString) {

	    for (Boss boss : Boss.values()) {
	        if (boss.name().toLowerCase().equals(bossString.toLowerCase())) {
	            return boss;
	        }
	    }

	    return null;
	}

	public void timerBoss(Boss boss, String s, TextChannel channel) {	
		//821273876058341456
		TimerTask task = new TimerTask() {
	        public void run() {
	        	if(boss!= Boss.Byung && boss!= Boss.Chung && boss != Boss.Steingolem && boss != Boss.SchluchtLycan && boss != Boss.Einzelkämpfer && boss != Boss.Akgol && boss != Boss.Minpae && boss != Boss.Phantom) {
	        		channel.sendMessage(role+" "+boss.toString() + " spawnt in 5 Minuten auf Kanal: "+ s).queue();	
	        	}else {
	        		switch (boss) {
	        		 case Byung: channel.sendMessage(role+" "+Boss.Chung.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
	        	    	break;
	        		 case Chung: channel.sendMessage(role+" "+Boss.Steingolem.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
	        	    	break; 
	        		 case Steingolem: channel.sendMessage(role+" "+Boss.SchluchtLycan.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
	        	    	break; 
	        		 case SchluchtLycan: channel.sendMessage(role+" "+Boss.Einzelkämpfer.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
	        	    	break; 
	        		 case Einzelkämpfer: channel.sendMessage(role+" "+Boss.Akgol.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
	        	    	break;
	        		 case Akgol: channel.sendMessage(role+" "+Boss.Byung.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
	        	    	break; 
	        		 case Minpae: channel.sendMessage(role+" "+Boss.Phantom.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
	        	    	break; 
	        		 case Phantom: channel.sendMessage(role+" "+Boss.Minpae.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
	        	    	break; 
	        			default:
	        				break;
	        		}	        			        			        		
	        	}
	        		
	        }
	    };
	    Timer timer = new Timer("Timer");
	    
	    long delay = 0;
	   delay= bossDelay(boss,delay);
	    
	    timer.schedule(task, delay);
	}
	
public void timerBoss(Boss boss, TextChannel channel) {	
		
		
		//821273876058341456
		TimerTask task = new TimerTask() {
	        public void run() {
	        	if(boss!= Boss.Byung && boss!= Boss.Chung && boss != Boss.Steingolem && boss != Boss.SchluchtLycan && boss != Boss.Einzelkämpfer && boss != Boss.Akgol && boss != Boss.Minpae && boss != Boss.Phantom) {
	        		channel.sendMessage("<@&821002727165263902>"+" "+boss.toString() + " spawnt in 5 Minuten.").queue();	
	        	}else {
	        		switch (boss) {
	        		 case Byung: channel.sendMessage("<@&821002727165263902>"+" "+Boss.Chung.toString() + " spawnt in 10 Minuten.").queue(); 
	        	    	break;
	        		 case Chung: channel.sendMessage("<@&821002727165263902>"+" "+Boss.Steingolem.toString() + " spawnt in 10 Minuten.").queue(); 
	        	    	break; 
	        		 case Steingolem: channel.sendMessage("<@&821002727165263902>"+" "+Boss.SchluchtLycan.toString() + " spawnt in 10 Minuten.").queue(); 
	        	    	break; 
	        		 case SchluchtLycan: channel.sendMessage("<@&821002727165263902>"+" "+Boss.Einzelkämpfer.toString() + " spawnt in 10 Minuten.").queue(); 
	        	    	break; 
	        		 case Einzelkämpfer: channel.sendMessage("<@&821002727165263902>"+" "+Boss.Akgol.toString() + " spawnt in 10 Minuten.").queue(); 
	        	    	break;
	        		 case Akgol: channel.sendMessage("<@&821002727165263902>"+" "+Boss.Byung.toString() + " spawnt in 10 Minuten.").queue(); 
	        	    	break; 
	        		 case Minpae: channel.sendMessage("<@&821002727165263902>"+" "+Boss.Phantom.toString() + " spawnt in 10 Minuten.").queue(); 
	        	    	break; 
	        		 case Phantom: channel.sendMessage("<@&821002727165263902>"+" "+Boss.Minpae.toString() + " spawnt in 10 Minuten.").queue(); 
	        	    	break; 
	        			default:
	        				break;
	        		}	        			        			        		
	        	}
	        		
	        }
	    };
	    Timer timer = new Timer("Timer");
	    
	    long delay = 0;
	   delay = bossDelay(boss,delay);
	    
	    timer.schedule(task, delay);
	    
	}
	
	private long bossDelay(Boss boss, long delay) {			    
	    switch(boss) {
	    case Chacha: return delay = 3*h-5*min; 
	   
	    case Derang: return delay = 3*h-5*min; 
    	
	    case Deva: return delay = 1*h-5*min; 	
    	
	    case Eberlin: return delay = 2*h-5*min; 
    	
	    case Gollak: return delay = 2*h-5*min; 
    
	    case Grimhorn: return delay = 1*h-5*min; 
    
	    case Klingenzahn: return delay = 4*h-5*min; 
    	
	    case Kneifi: return delay = 1*h-5*min; 
    
	    case Lycan: return delay = 2*h-5*min; 
    
	    case Sajifi: return  delay = 3*h-5*min; 
    	
	    case Sanha: return delay = 2*h-5*min; 
    
	    case Schwarzfuss: return delay = 3*h-5*min; 
    	
	    case Sindon: return delay = 3*h-5*min; 
    
	    case Uta: return delay = 3*h-5*min; 
    	
	    case Yagolta: return delay = 1*h-5*min; 
    
	    case Byung: return delay = 4*h-10*min; 
    	
	    case Chung: return delay = 4*h-10*min; 
    
	    case Steingolem: return delay = 4*h-10*min; 
    	
	    case SchluchtLycan: return delay = 4*h-10*min; 
    	
	    case Einzelkämpfer: return delay = 4*h-10*min; 
    	
	    case Akgol: return delay = 4*h-10*min; 
    	
	    case Minpae: return delay = 4*h-10*min; 
    	
	    case Phantom: return delay = 4*h-10*min; 
    	
    	
		default: return 0;
			
	    }
	}
	
}
