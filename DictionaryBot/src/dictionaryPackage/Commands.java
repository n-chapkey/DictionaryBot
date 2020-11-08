package dictionaryPackage;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		getCommands(event, args);
		
	}
	
	/*prints all commands supported*/
	public void getCommands(GuildMessageReceivedEvent event,String[] arguments) {
		
		if(arguments[0].equalsIgnoreCase(Main.prefix + "commands")) {
			EmbedBuilder commandsMenu = new EmbedBuilder();
			commandsMenu.setColor(0x66d8ff);
			commandsMenu.setTitle("Commands Menu");
			commandsMenu.setDescription("**The commands are: \n**"
					+ " **~define**  for defining words. \n"
					+ " **~blank** for fill in the blank game \n"
					+ " **~matching** for matching game");
			event.getChannel().sendMessage(commandsMenu.build()).queue();
			 
		}
	}
	
	/*code for parsing ~blank command*/
	public void blank(GuildMessageReceivedEvent event,String[] arguments) {
		
	}
	/*code for parsing ~matching command*/
	public void matching(GuildMessageReceivedEvent event,String[] arguments) {
		
	}
   
   public void deleteAllWords () {
      
   }
	
   public void deleteAWord () {
      
   }
}
