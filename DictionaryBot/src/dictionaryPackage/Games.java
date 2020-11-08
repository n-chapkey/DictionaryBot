package dictionaryPackage;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Games {
	
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
		
		/*Games game1 = new Games();
		game1.matching(allWords);*/
		
	}

	public void fillInTheBlank(GuildMessageReceivedEvent event,String[] arguments, Dictionary allWords) {
		// Stop Flag
		boolean continueFlag = true;
		
		// While True Continue Playing Game
		while(continueFlag == true) {
			printfillInTheBlankMenu();
			
			// Get User Selection (1 or 2)
			String userInput;
			Scanner k= new Scanner(System.in);
			userInput=k.nextLine();
			
			// Check not equal to 1 
			if(!userInput.equals("1")) {
				System.out.println("Thank you for playing!");
				return;
			}
			
			// The Game Continues
			
			// Create Random Class
			Random rand = new Random();
			
			// Get random element as the answer
			int answerIdx = rand.nextInt(allWords.size());
			Word answer = allWords.get(answerIdx);
			
			// Get wrong choice 1
			int wrongChoice1Idx = rand.nextInt(allWords.size());
			// check to make sure it wasn't the answerIdx
			while(wrongChoice1Idx == answerIdx) {
				wrongChoice1Idx = rand.nextInt(allWords.size());
			}
			Word wordChoice1 = allWords.get(wrongChoice1Idx);
			
			// Get wrong choice 2
			int wrongChoice2Idx = rand.nextInt(allWords.size());
			// check to make sure it wasn't the answerIdx and wordChoice1
			while(wrongChoice2Idx == answerIdx || wrongChoice2Idx == wrongChoice1Idx) {
				wrongChoice2Idx = rand.nextInt(allWords.size());
			}
			Word wordChoice2 = allWords.get(wrongChoice2Idx);
						
			// Display Game 
			int optionDisplay = rand.nextInt(3);
			System.out.println(answer.getSentence());
			
			if(optionDisplay == 0) {
				
				System.out.println("\tOption 1: " + answer.getWordName());
				System.out.println("\tOption 2: " + wordChoice1.getWordName());
				System.out.println("\tOption 3: " + wordChoice2.getWordName());
				System.out.println("\nMake your selection! 1, 2, or 3:");
				System.out.println(">");
				
				// Get user input 
				userInput=k.nextLine();
				
				if(userInput.equals("1")) {
					System.out.println("Congrats! The correct word was: " + answer.getWordName());
				} else {
					
					while (!userInput.equals("1")) {
							
						System.out.println("Incorrect! Please try again.");
						System.out.println("Make your selection! 1, 2, or 3:");
						System.out.println("> ");
						// Get user input 
						userInput=k.nextLine();
					}
					
					System.out.println("Congrats! The correct word was: " + answer.getWordName());
				} // end if statement
				
			} 
			else if (optionDisplay == 1) {
				
					System.out.println("\tOption 1: " + wordChoice2.getWordName());
					System.out.println("\tOption 2: " + wordChoice1.getWordName());
					System.out.println("\tOption 3: " + answer.getWordName());
					System.out.println("\nMake your selection! 1, 2, or 3:");
					System.out.println(">");
					
					// Get user input 
					userInput=k.nextLine();
					
					if(userInput.equals("3")) {
						System.out.println("Congrats! The correct word was: " + answer.getWordName());
					} else {
						
						while (!userInput.equals("3")) {
								
							System.out.println("Incorrect! Please try again.");
							System.out.println("Make your selection! 1, 2, or 3:");
							System.out.println("> ");
							// Get user input 
							userInput=k.nextLine();
						}
						
						System.out.println("Congrats! The correct word was: " + answer.getWordName());
					} // end if statement
			}
			else if (optionDisplay == 2) {
				
					System.out.println("\tOption 1: " + wordChoice2.getWordName());
					System.out.println("\tOption 2: " + answer.getWordName());
					System.out.println("\tOption 3: " + wordChoice1.getWordName());
					System.out.println("\nMake your selection! 1, 2, or 3:");
					System.out.println(">");
					
					// Get user input 
					userInput=k.nextLine();
					
					if(userInput.equals("2")) {
						System.out.println("Congrats! The correct word was: " + answer.getWordName());
					} else {
						
						while (!userInput.equals("2")) {
								
							System.out.println("Incorrect! Please try again.");
							System.out.println("Make your selection! 1, 2, or 3:");
							System.out.println("> ");
							// Get user input 
							userInput=k.nextLine();
						}
						
						System.out.println("Congrats! The correct word was: " + answer.getWordName());
					} // end if statement
					
			} else {
				
					System.out.println("\tOption 1: " + wordChoice2.getWordName());
					System.out.println("\tOption 2: " + wordChoice1.getWordName());
					System.out.println("\tOption 3: " + answer.getWordName());
					System.out.println("\nMake your selection! 1, 2, or 3:");
					System.out.println(">");
					
					// Get user input 
					userInput=k.nextLine();
					
					if(userInput.equals("3")) {
						System.out.println("Congrats! The correct word was: " + answer.getWordName());
					} else {
						
						while (!userInput.equals("3")) {
								
							System.out.println("Incorrect! Please try again.");
							System.out.println("Make your selection! 1, 2, or 3:");
							System.out.println("> ");
							// Get user input 
							userInput=k.nextLine();
						}
						
						System.out.println("Congrats! The correct word was: " + answer.getWordName());
					} // end if statement
					
			}
	
		}// end "game" while loop	
		
	} // end method
	
	/*menu for the fillintheblank game*/
	public static void printfillInTheBlankMenu() {
		System.out.println("\n ----------------------------------------");
		System.out.println("***Welcome to the Fill In The Blank Game***");
		System.out.println("---------------------------------------- \n");
		System.out.println("Please select one of the following:");
		System.out.println("[1] : Play Game");
		System.out.println("[2] : Exit");
		System.out.println(">");
	}

	
	public void matching(GuildMessageReceivedEvent event,String[] arguments, Dictionary allWords) {
		printfillmatching();
		
			Scanner myAnswer = new Scanner(System.in);
			//String playing = myAnswer.nextLine();
			
			
			Random rand = new Random();
			/*int amountCorrect = 0;
			ArrayList<Word> choices = new ArrayList<Word>();
			if(allWords.size() < 5) {
				Word word1 = allWords.get(rand.nextInt(allWords.size()));
				if(allWords.size() == 1) {
					choices.add(word1);
					return;
				}else {
					choices.add(word1);
					for(int i = 1; i < allWords.size(); i++) {
						Word wordNew = allWords.get(rand.nextInt(allWords.size()));
						while(wordNew.equals(choices.get(i-1))) {
							wordNew = allWords.get(rand.nextInt(allWords.size()));
						}
					}
				}
				for(int i = 0; i < choices.size(); i++) {
					System.out.println(choices.get(i).getWordName() + "\n");
				}
			}*/
			Word answer = allWords.get(rand.nextInt(allWords.size()));
			Word wrongchoice1 = allWords.get(rand.nextInt(allWords.size()));
			while(wrongchoice1.equals(answer)) {
				wrongchoice1 = allWords.get(rand.nextInt(allWords.size()));
			}
			Word wrongchoice2 = allWords.get(rand.nextInt(allWords.size()));
			while(wrongchoice2.equals(answer) || wrongchoice2.equals(wrongchoice1)) {
				wrongchoice2 = allWords.get(rand.nextInt(allWords.size()));
			}
			System.out.println("What word fits with this definition?\n" + answer.getWordDefinition() + "\n");
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
			}
			
			System.out.println("Thanks for playing!\n");
		
}
	
	/*menu for the matching game*/
	public static void printfillmatching() {
		System.out.println("Welcome to matching! Here are the rules.\n");
		System.out.println("We will give you a definition, and you have to figure out the word that matches it.\n");
		System.out.println("We will give you three choices. Type out the word from the three choices that you think is correct.\n");
		System.out.println("Get ready to play!\n");
		/*System.out.println("[1] Yes\n");
		System.out.println("[2] No\n");*/
	}
	
	}*/

}
