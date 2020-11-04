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
	public void fillInTheBlank(ArrayList<Word> allWords) {
		printfillInTheBlankMenu();
		/*input*/
		
	}
	
	/*menu for the fillintheblank game*/
	public static void printfillInTheBlankMenu() {
		System.out.println("");
	}
	
	public void matching(ArrayList<Word> allWords) {
		printfillmatching();
		Scanner myAnswer = new Scanner(System.in);

		Random rand = new Random();
		Word answer = allWords.get(rand.nextInt(allWords.size()));
		Word wrongchoice1 = allWords.get(rand.nextInt(allWords.size()));
		Word wrongchoice2 = allWords.get(rand.nextInt(allWords.size()));
		System.out.println("What word fits with this definition?\n" + answer.getDefinition() + "\n");
		String[] choices = {answer.getName(), wrongchoice1.getName(), wrongchoice2.getName()};
		System.out.println("A. " + choices[0] + "\n" + "B. " + choices[1] + "\n" + "C. " + choices[2] + "\n");
		String thechoice = myAnswer.nextLine();
		if(thechoice.equals(answer.getName())){
			System.out.println("Good job! Hope you didn't cheat!\n");
		}else{
			System.out.println("Too bad. The correct answer was " + answer.getName() + ". You need to study harder.\n");
		}
	}
	
	/*menu for the matching game*/
	public static void printfillmatching() {
		System.out.println("");
	}
	
	

}
