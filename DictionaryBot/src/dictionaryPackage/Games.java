package dictionaryPackage;

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
		int rand = new Random();
		Word answer = allWords.get(rand.nextInt(allWords.size()));
		System.out.println("What word fits with this definition?\n");
		System.out.println(answer.getDefinition() + "\n");
		
	}
	
	/*menu for the matching game*/
	public static void printfillmatching() {
		System.out.println("");
	}
	
	

}
