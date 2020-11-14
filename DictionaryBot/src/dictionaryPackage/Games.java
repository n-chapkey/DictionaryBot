package dictionaryPackage;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Games {
Dictionary newDict = new Dictionary();

	/*
	 * Fill in the blank game
	 * Input: 3 Strings
	 * Output: void
	 */

	public static void main(String[] args) {
		//Create Word Objects
		Word word1 = new Word("dog");
		Word word2 = new Word("cat");
		Word word3 = new Word("house");
		Word word4 = new Word("donut");
		Word word5 = new Word("coffee");
		Word word6 = new Word("bird");

		// Create ArrayList
		Dictionary allWords = new Dictionary();

		// Add all of our words
		allWords.appendWord(word1);
		allWords.appendWord(word2);
		allWords.appendWord(word3);
		allWords.appendWord(word4);
		allWords.appendWord(word5);
		allWords.appendWord(word6);

		/*
		for(Word w : allWords) {
			System.out.println(w.getName());
		}
		 */


	}


public ArrayList<String> fillInTheBlank(Dictionary temp_1, GuildMessageReceivedEvent event) {

	ArrayList<Word> dic_temp = temp_1.getList();
	ArrayList<Word> dic = new ArrayList<Word>();

	for(int i = 0; i < dic_temp.size(); i ++) {
		dic.add(dic_temp.get(i));
	}

	EmbedBuilder commandsMenu = new EmbedBuilder();
	commandsMenu.setColor(0x66d8ff);

	String options = "";

	for(int i = 0; i < dic.size(); i++) {
		options += dic.get(i).getWord() + ", ";

	}
	ArrayList<String> answer = new ArrayList<String>();

	String choices = "";
	int count = dic.size();
	for(int i = 0; i < count; i++) {
		Word temp = dic.remove((int)(Math.random() * (count - i)));
		answer.add(temp.getWord());
		int temp2 = i+1;
		choices += temp2 + ". " + temp.getSentence().replace(temp.getWord(), "__________") + "\n";
	}

	choices += "\nThe options: " + options + "\n";
	commandsMenu.setDescription(choices);
	event.getChannel().sendMessage(commandsMenu.build()).queue();

	return answer;

	} // end method

	/*menu for the fillintheblank game*/
	public static void printfillInTheBlankMenu(GuildMessageReceivedEvent event) {
		EmbedBuilder fitbMenu = new EmbedBuilder();
		fitbMenu.setColor(0x66d8ff);
		fitbMenu.setTitle("Fill in the blank menu");
		fitbMenu.setDescription("Please select one of the following: \n**"
				                  + "[1] : Play Game \n"
				                  + "[2] : Exit \n");;
		event.getChannel().sendMessage(fitbMenu.build()).queue();
	}

	public void matching(GuildMessageReceivedEvent event,String[] arguments, Dictionary allWords) {
			printfillmatching();
			Scanner myAnswer = new Scanner(System.in);
			//Random rand = new Random();
			Dictionary temp = allWords;
			int sizes = temp.size();
			ArrayList<Word> choices = new ArrayList<Word>();
			for(int i = 0; i <= sizes; i++) {
				Word question = temp.get((int)Math.random() * (sizes - 1));
				choices.set(i, question);
			}

			for(int i = 0; i <= choices.size(); i++) {
				System.out.println(choices.get(i).getDefinition() + "\n");
			}


			/*Random rand = new Random();
			Word answer = allWords.get(rand.nextInt(allWords.size()));
			Word wrongchoice1 = allWords.get(rand.nextInt(allWords.size()));
			while(wrongchoice1.equals(answer)) {
				wrongchoice1 = allWords.get(rand.nextInt(allWords.size()));
			}
			Word wrongchoice2 = allWords.get(rand.nextInt(allWords.size()));
			while(wrongchoice2.equals(answer) || wrongchoice2.equals(wrongchoice1)) {
				wrongchoice2 = allWords.get(rand.nextInt(allWords.size()));
			}
			System.out.println("What word fits with this definition?\n" + answer.getDefinition() + "\n");
			String[] choices = {answer.getWordName(), wrongchoice1.getWordName(), wrongchoice2.getWordName()};
			int correct = rand.nextInt(3);
			if(correct == 0) {
				System.out.println("A. " + choices[0] + "\n" + "B. " + choices[1] + "\n" + "C. " + choices[2] + "\n");
			}else if(correct == 1) {
				System.out.println("A. " + choices[1] + "\n" + "B. " + choices[0] + "\n" + "C. " + choices[2] + "\n");
			}else if(correct == 2){
				System.out.println("A. " + choices[1] + "\n" + "B. " + choices[2] + "\n" + "C. " + choices[0] + "\n");
			}
			String thechoice = myAnswer.nextLine();
			if(thechoice.equals(answer.getWordName())){
				System.out.println("Good job! Hope you didn't cheat!\n");
			}else{
				System.out.println("Too bad. The correct answer was " + answer.getWordName() + ". You need to study harder.\n");
			}*/

			System.out.println("Thanks for playing!\n");

	}

	public static void printfillmatching() {
		System.out.println("Welcome to matching! Here are the rules.\n");
		System.out.println("We will give you a definition, and you have to figure out the word that matches it.\n");
		System.out.println("Do you want to play?\n");
		System.out.println("[1] Yes\n");
		System.out.println("[2] No\n");
		System.out.println("We will give you three choices. Type out the word from the three choices that you think is correct.\n");
		System.out.println("Get ready to play!\n");
		/*System.out.println("[1] Yes\n");
		System.out.println("[2] No\n");*/
	}
}
