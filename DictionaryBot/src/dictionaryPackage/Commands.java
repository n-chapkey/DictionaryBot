package dictionaryPackage;

import java.util.ArrayList;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

	Dictionary newDict = new Dictionary();
	ArrayList<String> blankAnswers;

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
		else if(args[0].equalsIgnoreCase(Main.prefix + "blank") || args[0].equalsIgnoreCase(Main.prefix + "answerBlank:")) {
			blank(event, args);
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
					+ " **~matching** for matching game \n"
					+ " **~getAllWords** for displaying all words in the dictionary.");
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

	public void blank(GuildMessageReceivedEvent event,String[] arguments) {
		if(arguments[0].equalsIgnoreCase(Main.prefix + "blank")) {
		Games new_game = new Games();
		blankAnswers = new_game.fillInTheBlank(newDict, event);
		}
		else if(arguments[0].equalsIgnoreCase(Main.prefix + "answerBlank:")){
			//blankUserAnswer = false;
			EmbedBuilder commandsMenu = new EmbedBuilder();
			commandsMenu.setColor(0x66d8ff);
			String retUser = "";
			boolean allTrue = true;
			for(int i = 0; i < blankAnswers.size(); i++) {
				if(!(arguments[i+1].equals(blankAnswers.get(i)))) {
					allTrue = false;
					int n = i+1;
					retUser += "You got number " + n + " wrong! It was supposed to be \"" + blankAnswers.get(i) + "\"\n";
				}
			}
			if(allTrue) {
				commandsMenu.setDescription("Congratulations! You got all of them right");
			}
			else {
				commandsMenu.setDescription(retUser);
			}
			event.getChannel().sendMessage(commandsMenu.build()).queue();
		}
	}
	/*code for parsing ~matching command*/
	public void matching(GuildMessageReceivedEvent event,String[] arguments, Dictionary newDict) {

	}

   public void deleteAllWords () {

   }

   public void deleteAWord () {

   }
}
