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

	public ArrayList<String> matching(Dictionary temp_1, GuildMessageReceivedEvent event) {
        EmbedBuilder commandsMenu = new EmbedBuilder();
        commandsMenu.setColor(0x66d8ff);

        ArrayList<String> answer = new ArrayList<String>();
        ArrayList<Word> dic = temp_1.getList();

        ArrayList<String> def = new ArrayList<String>();
        ArrayList<String> word = new ArrayList<String>();

        for(int i = 0; i < dic.size(); i++) {
            def.add(dic.get(i).getDef());
            word.add(dic.get(i).getWord());

        }
        String question = "";
        String options = "Options: ";
        int count = dic.size();
        System.out.println(count);
        for(int i = 0; i < count; i++) {
            String temp_def = def.remove((int)(Math.random() * (count - i)));
            String temp_word = word.remove((int)(Math.random() * (count - i)));
            Word t = temp_1.getWord(temp_word);
            answer.add(temp_1.getWordFromDef(temp_def));
            question += (i+1) + ". " + temp_def + "\n"; 
            options += temp_word + ", ";

        }


        for(int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
        question += "\n" + options;
        commandsMenu.setDescription(question);
        event.getChannel().sendMessage(commandsMenu.build()).queue();


        return answer;
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
