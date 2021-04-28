package de.mushin.commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class helpCommand implements ServerCommand {

	public void performCommand(Member m, TextChannel channel, Message message) {		
		
		String[] args = message.getContentDisplay().split(" ");
		
		if(args.length == 3) {
			if(args[2].equalsIgnoreCase("bosslist") || args[2].equalsIgnoreCase("bossliste")) {
				channel.sendMessage("**Ascheweiten**: Deva, Kneifi, Grimhorn, Yagolta\r\n" + 
						"**Mondwasser-Ebenen**:  Lycan, Eberlin, Gollak , Sajifi , Sanha\r\n" + 
						"**Silberfrost-Berge**:   Derang, Klingenzahn, Chacha, Sindon, Uta, Schwarzfuß\r\n" + 
						"**Vergessenes Tal**: Byung, Chung, Steingolem, SchluchtLycan, Einzelkämpfer, Akgol\r\n" + 
						"**Ruinen der Verbitterung**: Minpae, Phantom").queue();
			}
		}
		else {
				channel.sendMessage("Killeintragen:  **!Boss kill Bossname (Optional:Kanalnummer)**\r\n" +
						"Spawneintragen:  **!Boss spawn Bossname (Optional: Kanalnummer) Spawnzeit(in Min)**\r\n"+						
						"Liste aller Bosse bekommen:  **!Boss help Bossliste**\r\n"+
						"Rolle auswählen die Benachrichtigt werden soll:  **!Boss role @Rolle**\r\n"+
						"Kontaktmöglichkeiten: **!Boss contact**"
						).queue();
					
			}
		
		
		message.delete().queue();						
}
}
