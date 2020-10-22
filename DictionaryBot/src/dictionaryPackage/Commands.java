package dictionaryPackage;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		/*How to parse commands ->
		 * if(args[0].equalsIgnoreCase(Main.prefix + "test")) {
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Cool beans.").queue();
		}*/
		
		/*method to see all commands*/
		
	}
	
	/*prints all commands supported*/
	public void getCommands() {
		
	}
	
	/*code for parsing ~blank command*/
	public void blank() {
		
	}
	/*code for parsing ~matching command*/
	public void matching() {
		
	}
   
   public void deleteAllWords () {
      
   }
	
   public void deleteAWord () {
      
   }
}
