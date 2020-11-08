package dictionaryPackage;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

	Dictionary newDict = new Dictionary();
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");


		if(args[0].equalsIgnoreCase(Main.prefix + "commands")) {
			getCommands(event, args);
		}
		else if(args[0].equalsIgnoreCase(Main.prefix + "define")) {
			define(event, args);
		}
		else if(args[0].equalsIgnoreCase(Main.prefix + "getAllWords")) {
			allWords(event, args);
		}

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

	public void define(GuildMessageReceivedEvent event,String[] arguments) {
		if(arguments[0].equalsIgnoreCase(Main.prefix + "define") ) {
		EmbedBuilder definitionMenu = new EmbedBuilder();
		definitionMenu.setColor(0x66d8ff);
		Word temp = new Word(arguments[1]);
		newDict.appendWord(temp);
		definitionMenu.setDescription(temp.getDef());
		event.getChannel().sendMessage(definitionMenu.build()).queue();}
	}

	public void allWords(GuildMessageReceivedEvent event,String[] arguments) {
		String result = newDict.getAllWords();
		EmbedBuilder commandsMenu = new EmbedBuilder();
		commandsMenu.setColor(0x66d8ff);
		commandsMenu.setDescription(result);
		event.getChannel().sendMessage(commandsMenu.build()).queue();
	}

	/*code for parsing ~blank command*/

	public void blank(GuildMessageReceivedEvent event,String[] arguments, Dictionary newDict) {
		
	}
	/*code for parsing ~matching command*/
	public void matching(GuildMessageReceivedEvent event,String[] arguments) {
		
	}

   public void deleteAllWords () {

   }

   public void deleteAWord () {

   }
}
