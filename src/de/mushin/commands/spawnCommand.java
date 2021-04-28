package de.mushin.commands;

import java.util.Timer;
import java.util.TimerTask;

import de.mushin.Boss;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class spawnCommand implements ServerCommand{

	private long sec = 1000L;
	private long min = sec*60L;
	private long h = min*60L;
	public static String role = "";
	
	public void performCommand(Member m, TextChannel channel, Message message) {		
					System.out.println(role);
			String[] args = message.getContentDisplay().split(" ");		
			
			if(args.length==4) {
				if(containsBoss(args[2])) {													
					channel.sendMessage(getBoss(args[2]).toString() + " wird in : " + Integer.parseInt(args[3])+" Minuten spawnen.").queue();		
					timerBoss(getBoss(args[2]), channel,Integer.parseInt(args[3]));
				} else {
					channel.sendMessage("`"+args[2]+" ist kein Boss`").queue();
				}
			}
			else if(args.length==5) {
				if(containsBoss(args[2])) {													
					channel.sendMessage(getBoss(args[2]).toString() + " wird in : " + Integer.parseInt(args[4])+" Minuten auf Kanal: "+ args[3]+" spawnen.").queue();		
					timerBoss(getBoss(args[2]),args[3], channel,Integer.parseInt(args[4]));
				} else {
					channel.sendMessage("`"+args[2]+" ist kein Boss`").queue();
				}													
			}else {
				
				channel.sendMessage("`Anzahl der Argumente ist falsch, bitte geben sie den spawn in folgender Form ein: spawn boss Minuten ein`").queue();
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
	
	public void timerBoss(Boss boss, String s, TextChannel channel, int delay) {	
		
		long delayFive = (int) ((delay * (int)min) - 5*min);
		long delayTen = (int) ((delay * (int)min) - 10*min);
			if(delay>4) {
				 
					TimerTask task = new TimerTask() {
					
						
				        public void run() {
				        	if(delay > 4 && boss!= Boss.Byung && boss!= Boss.Chung && boss != Boss.Steingolem && boss != Boss.SchluchtLycan && boss != Boss.Einzelkämpfer && boss != Boss.Akgol && boss != Boss.Minpae && boss != Boss.Phantom) {			        					        		
				        		channel.sendMessage(role+" "+boss.toString() + " spawnt in 5 Minuten auf Kanal: "+ s).queue();	
				        	}else if(delay>9){     		
				        		switch (boss) {			        		
				        		 case Byung: channel.sendMessage(role+" "+Boss.Byung.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
				        	    	break;
				        		 case Chung: channel.sendMessage(role+" "+Boss.Chung.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        		 case Steingolem: channel.sendMessage(role+" "+Boss.Steingolem.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        		 case SchluchtLycan: channel.sendMessage(role+" "+Boss.SchluchtLycan.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        		 case Einzelkämpfer: channel.sendMessage(role+" "+Boss.Einzelkämpfer.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
				        	    	break;
				        		 case Akgol: channel.sendMessage(role+" "+Boss.Akgol.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        		 case Minpae: channel.sendMessage(role+" "+Boss.Minpae.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        		 case Phantom: channel.sendMessage(role+" "+Boss.Phantom.toString() + " spawnt in 10 Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        			default:
				        				break;
				        		}	        			        			        		
				        	}else {
				        		switch (boss) {
				        		 case Byung: channel.sendMessage(role+" "+Boss.Byung.toString() + " spawnt in "+ delay +" Minuten auf Kanal: "+ s).queue(); 
				        	    	break;
				        		 case Chung: channel.sendMessage(role+" "+Boss.Chung.toString() + " spawnt in "+ delay +" Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        		 case Steingolem: channel.sendMessage(role+" "+Boss.Steingolem.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        		 case SchluchtLycan: channel.sendMessage(role+" "+Boss.SchluchtLycan.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        		 case Einzelkämpfer: channel.sendMessage(role+" "+Boss.Einzelkämpfer.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
				        	    	break;
				        		 case Akgol: channel.sendMessage(role+" "+Boss.Akgol.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        		 case Minpae: channel.sendMessage(role+" "+Boss.Minpae.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        		 case Phantom: channel.sendMessage(role+" "+Boss.Phantom.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
				        	    	break; 
				        			default:
				        				break;
				        		}	        
				        	}
				        }
				    };
				    Timer timer = new Timer("Timer");
				    
				    if(delayFive > 0 && boss!= Boss.Byung && boss!= Boss.Chung && boss != Boss.Steingolem && boss != Boss.SchluchtLycan && boss != Boss.Einzelkämpfer && boss != Boss.Akgol&& boss != Boss.Minpae && boss != Boss.Phantom) {	
				    	System.out.println(delayFive);
					    timer.schedule(task, delayFive);
				    }else if(delayTen>0){
				    	System.out.println(delayTen);
					    timer.schedule(task, delayTen);
				    } else {
				    	System.out.println(delay);
					    timer.schedule(task, delay);
				    }
				    
				    
				    
			}else {
				TimerTask task = new TimerTask() {
			        public void run() {
			        	
			        	
			        	if(boss!= Boss.Byung && boss!= Boss.Chung && boss != Boss.Steingolem && boss != Boss.SchluchtLycan && boss != Boss.Einzelkämpfer && boss != Boss.Akgol) {
			        		
			        		System.out.println("test");
			        		channel.sendMessage(role+" "+boss.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue();	
			        	}else {		        		
			        		switch (boss) {
			        		 case Byung: channel.sendMessage(role+" "+Boss.Byung.toString() + " spawnt in "+ delay +" Minuten auf Kanal: "+ s).queue(); 
			        	    	break;
			        		 case Chung: channel.sendMessage(role+" "+Boss.Chung.toString() + " spawnt in "+ delay +" Minuten auf Kanal: "+ s).queue(); 
			        	    	break; 
			        		 case Steingolem: channel.sendMessage(role+" "+Boss.Steingolem.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
			        	    	break; 
			        		 case SchluchtLycan: channel.sendMessage(role+" "+Boss.SchluchtLycan.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
			        	    	break; 
			        		 case Einzelkämpfer: channel.sendMessage(role+" "+Boss.Einzelkämpfer.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
			        	    	break;
			        		 case Akgol: channel.sendMessage(role+" "+Boss.Akgol.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
			        	    	break; 
			        		 case Minpae: channel.sendMessage(role+" "+Boss.Minpae.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
			        	    	break; 
			        		 case Phantom: channel.sendMessage(role+" "+Boss.Phantom.toString() + " spawnt in "+delay+" Minuten auf Kanal: "+ s).queue(); 
			        	    	break; 
			        			default:
			        				break;
			        		}	        			        			        		
			        	}		
			        }
			    };
			    Timer timer = new Timer("Timer");
			    
			    
			    timer.schedule(task, delay);
			}
	}
	
			public void timerBoss(Boss boss, TextChannel channel, int delay) {	
				
				long delayFive = (int) ((delay * (int)min) - 5*min);
				long delayTen = (int) ((delay * (int)min) - 10*min);
					if(delay>4) {
						 
							TimerTask task = new TimerTask() {
							
								
						        public void run() {
						        	if(delay > 4 && boss!= Boss.Byung && boss!= Boss.Chung && boss != Boss.Steingolem && boss != Boss.SchluchtLycan && boss != Boss.Einzelkämpfer && boss != Boss.Akgol && boss != Boss.Minpae && boss != Boss.Phantom) {			        					        		
						        		channel.sendMessage(role+" "+boss.toString() + " spawnt in 5 Minuten.").queue();	
						        	}else if(delay>9){     		
						        		switch (boss) {			        		
						        		 case Byung: channel.sendMessage(role+" "+Boss.Byung.toString() + " spawnt in 10 Minuten.").queue(); 
						        	    	break;
						        		 case Chung: channel.sendMessage(role+" "+Boss.Chung.toString() + " spawnt in 10 Minuten.").queue(); 
						        	    	break; 
						        		 case Steingolem: channel.sendMessage(role+" "+Boss.Steingolem.toString() + " spawnt in 10 Minuten.").queue(); 
						        	    	break; 
						        		 case SchluchtLycan: channel.sendMessage(role+" "+Boss.SchluchtLycan.toString() + " spawnt in 10 Minuten.").queue(); 
						        	    	break; 
						        		 case Einzelkämpfer: channel.sendMessage(role+" "+Boss.Einzelkämpfer.toString() + " spawnt in 10 Minuten.").queue(); 
						        	    	break;
						        		 case Akgol: channel.sendMessage(role+" "+Boss.Akgol.toString() + " spawnt in 10 Minuten.").queue(); 
						        	    	break; 
						        		 case Minpae: channel.sendMessage(role+" "+Boss.Minpae.toString() + " spawnt in 10 Minuten.").queue(); 
						        	    	break; 
						        		 case Phantom: channel.sendMessage(role+" "+Boss.Phantom.toString() + " spawnt in 10 Minuten.").queue(); 
						        	    	break; 
						        			default:
						        				break;
						        		}	        			        			        		
						        	}else {
						        		switch (boss) {
						        		 case Byung: channel.sendMessage(role+" "+Boss.Byung.toString() + " spawnt in "+ delay +" Minuten.").queue(); 
						        	    	break;
						        		 case Chung: channel.sendMessage(role+" "+Boss.Chung.toString() + " spawnt in "+ delay +" Minuten.").queue(); 
						        	    	break; 
						        		 case Steingolem: channel.sendMessage(role+" "+Boss.Steingolem.toString() + " spawnt in "+delay+" Minuten .").queue(); 
						        	    	break; 
						        		 case SchluchtLycan: channel.sendMessage(role+" "+Boss.SchluchtLycan.toString() + " spawnt in "+delay+" Minuten.").queue(); 
						        	    	break; 
						        		 case Einzelkämpfer: channel.sendMessage(role+" "+Boss.Einzelkämpfer.toString() + " spawnt in "+delay+" Minuten.").queue(); 
						        	    	break;
						        		 case Akgol: channel.sendMessage(role+" "+Boss.Akgol.toString() + " spawnt in "+delay+" Minuten.").queue(); 
						        	    	break; 
						        		 case Minpae: channel.sendMessage(role+" "+Boss.Minpae.toString() + " spawnt in "+delay+" Minuten.").queue(); 
						        	    	break; 
						        		 case Phantom: channel.sendMessage(role+" "+Boss.Phantom.toString() + " spawnt in "+delay+" Minuten.").queue(); 
						        	    	break; 
						        			default:
						        				break;
						        		}	        
						        	}
						        }
						    };
						    Timer timer = new Timer("Timer");
						    
						    if(delayFive > 0 && boss!= Boss.Byung && boss!= Boss.Chung && boss != Boss.Steingolem && boss != Boss.SchluchtLycan && boss != Boss.Einzelkämpfer && boss != Boss.Akgol&& boss != Boss.Minpae && boss != Boss.Phantom) {	
						    	System.out.println(delayFive);
							    timer.schedule(task, delayFive);
						    }else if(delayTen>0){
						    	System.out.println(delayTen);
							    timer.schedule(task, delayTen);
						    } else {
						    	System.out.println(delay);
							    timer.schedule(task, delay);
						    }
						    
						    
						    
					}else {
						TimerTask task = new TimerTask() {
					        public void run() {
					        	
					        	
					        	if(boss!= Boss.Byung && boss!= Boss.Chung && boss != Boss.Steingolem && boss != Boss.SchluchtLycan && boss != Boss.Einzelkämpfer && boss != Boss.Akgol) {
					        							        		
					        		channel.sendMessage(role+" "+boss.toString() + " spawnt in "+delay+" Minuten.").queue();	
					        	}else {		        		
					        		switch (boss) {
					        		 case Byung: channel.sendMessage(role+" "+Boss.Byung.toString() + " spawnt in "+ delay +" Minuten.").queue(); 
					        	    	break;
					        		 case Chung: channel.sendMessage(role+" "+Boss.Chung.toString() + " spawnt in "+ delay +" Minuten.").queue(); 
					        	    	break; 
					        		 case Steingolem: channel.sendMessage(role+" "+Boss.Steingolem.toString() + " spawnt in "+delay+" Minuten.").queue(); 
					        	    	break; 
					        		 case SchluchtLycan: channel.sendMessage(role+" "+Boss.SchluchtLycan.toString() + " spawnt in "+delay+" Minuten.").queue(); 
					        	    	break; 
					        		 case Einzelkämpfer: channel.sendMessage(role+" "+Boss.Einzelkämpfer.toString() + " spawnt in "+delay+" Minuten.").queue(); 
					        	    	break;
					        		 case Akgol: channel.sendMessage(role+" "+Boss.Akgol.toString() + " spawnt in "+delay+" Minuten.").queue(); 
					        	    	break; 
					        		 case Minpae: channel.sendMessage(role+" "+Boss.Minpae.toString() + " spawnt in "+delay+" Minuten.").queue(); 
					        	    	break; 
					        		 case Phantom: channel.sendMessage(role+" "+Boss.Phantom.toString() + " spawnt in "+delay+" Minuten.").queue(); 
					        	    	break; 
					        			default:
					        				break;
					        		}	        			        			        		
					        	}		
					        }
					    };
					    Timer timer = new Timer("Timer");
					    
					    
					    timer.schedule(task, delay);
					}
			
			
		}
	
}
