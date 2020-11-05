package dictionaryPackage;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Games {
	
	/*
	 * Fill in the blank game
	 * Input: 3 Strings
	 * Output: void
	 */
	public static void fillInTheBlank(ArrayList<Word> allWords) {
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
			System.out.println(answer.getWordSentence());
			
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

	
	public void matching(ArrayList<Word> allWords) {
		printfillmatching();
		Scanner myAnswer = new Scanner(System.in);

		Random rand = new Random();
		Word answer = allWords.get(rand.nextInt(allWords.size()));
		Word wrongchoice1 = allWords.get(rand.nextInt(allWords.size()));
		Word wrongchoice2 = allWords.get(rand.nextInt(allWords.size()));
		System.out.println("What word fits with this definition?\n" + answer.getWordDefinition() + "\n");
		String[] choices = {answer.getWordName(), wrongchoice1.getWordName(), wrongchoice2.getWordName()};
		System.out.println("A. " + choices[0] + "\n" + "B. " + choices[1] + "\n" + "C. " + choices[2] + "\n");
		String thechoice = myAnswer.nextLine();
		if(thechoice.equals(answer.getWordName())){
			System.out.println("Good job! Hope you didn't cheat!\n");
		}else{
			System.out.println("Too bad. The correct answer was " + answer.getWordName() + ". You need to study harder.\n");
		}
	}
	
	/*menu for the matching game*/
	public static void printfillmatching() {
		System.out.println("");
	}
	
	/* testing */
	public static void main(String[] args) {
		Dictionary dict = new Dictionary();
		
		/*For adding custom words: first write the name of the word, then the definition, then the word in a sentence.*/
		Word spinach = new Word("spinach", "spinach is a vegetable", "I don't like to eat spinach");
		Word apples = new Word("apples", "apples are bright colored fruits", "I enjoy eating apples");
		Word pizza = new Word("pizza", "pizza is not a fruit or vegetable to be honest", "Pizza is the best food");
		
		/*add words to the dictionary*/
		dict.appendWord(spinach);
		dict.appendWord(apples);
		dict.appendWord(pizza);
			
		
		fillInTheBlank(dict.allWords);
	}

}
