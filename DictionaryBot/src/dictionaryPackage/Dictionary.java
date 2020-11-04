package dictionaryPackage;

import java.util.ArrayList;

public class Dictionary {
	
	public ArrayList<Word> allWords;
	
	public Dictionary(){
		allWords = null;
	}
	
	public void appendWord(Word addedWord) {
		allWords.add(addedWord);
	}
	
	public void deleteWordByString(String removedWord) {
		for(int i=0;i<allWords.size();i++) {
			if(allWords.get(i).getWordName() == removedWord) {
				allWords.remove(i);
				return;
			}
		}
		System.out.println("Word could not be removed");
	}
	
	public Word getWord(String name) {
		Word theWord = null;
		for(int i=0;i<allWords.size();i++) {
			if(allWords.get(i).getWordName() == name) {
				theWord = allWords.get(i);
			}
		}
		
		return theWord;
	}
}
