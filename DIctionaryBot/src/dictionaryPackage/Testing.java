package Muhammad.DicBot;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Testing {

	@Test
	void testDefinitions() {
		String [] expectedDef = {"the usually round, red or yellow, edible fruit of a small tree, Malus sylvestris, of the rose family.",
				"a natural elevation of the earth's surface rising more or less abruptly to a summit, and attaining an altitude greater than that of a hill, usually greater than 2,000 feet (610 meters).",
				"the main meal of the day, eaten in the evening or at midday.",
				"having beauty; possessing qualities that give great pleasure or satisfaction to see, hear, think about, etc.; delighting the senses or mind: a beautiful dress; a beautiful speech.",
				"(used to express a greeting, answer a telephone, or attract attention.)"
		};
		
		String [] sampleWords = {"apple", "mountain", "dinner", "beautiful", "hello"};
		ArrayList<Word> words = new ArrayList<Word>();
		
		for(int i = 0; i < 5; i++) {
			words.add(new Word(sampleWords[i]));
		}
		
		for(int i = 0; i < 5; i++) {
			assertEquals(expectedDef[i], words.get(i).getDef());
		}
		
		
	}
	
	@Test void testSentences () {
		String [] expectedSent = {"Is that apple pie I smell?",
								  "The king became insane in 1454.",
								  "Dinner will be ready at six O'clock.",
								  "Look at those big gray eyes and that beautiful red hair!",
								  "Hello, can I help you with something?"
		};
		
		String [] sampleWords = {"apple", "insane", "dinner", "beautiful", "hello"};
		ArrayList<Word> words = new ArrayList<Word>();
		
		for(int i = 0; i < 5; i++) {
			words.add(new Word(sampleWords[i]));
		}
		
		for(int i = 0; i < 5; i++) {
			assertEquals(expectedSent[i].toLowerCase(), words.get(i).getSent());
		}
		
	}
	
	@Test void testWord() {
		String [] actualWords = {"apple", "mountain", "dinner", "beautiful", "hello"};
		ArrayList<Word> words = new ArrayList<Word>();
		
		for(int i = 0; i < 5; i++) {
			words.add(new Word(actualWords[i]));
		}
		
		for(int i = 0; i < 5; i++) {
			assertEquals(actualWords[i], words.get(i).getWord());
		}
	}
	
	@Test void testAppendWord() {
		Dictionary dict = new Dictionary();
		
		
		String [] sampleWords = {"apple", "insane", "dinner", "beautiful", "hello"};
		for(int i = 0; i < 5; i++) {
			dict.appendWord(new Word(sampleWords[i]));
		}
		
		assertEquals(5, dict.cap()); 
		
		for(int i = 0; i < 5; i++) {
			assertEquals(sampleWords[i], dict.getWord(sampleWords[i]).getWord());
		}
		
	}
	
	@Test void testDeleteWordByString() {
		Dictionary dict = new Dictionary();
		
		String [] sampleWords = {"apple", "insane", "dinner", "beautiful", "hello"};
		for(int i = 0; i < 5; i++) {
			dict.appendWord(new Word(sampleWords[i]));
		}
		
		dict.deleteWordByString("insane");
		
		assertEquals(4, dict.cap());
		
		assertEquals(null, dict.getWord("insane"));
	}
	
	@Test void testGetWord() {
		Dictionary dict = new Dictionary();
		
		String [] sampleWords = {"apple", "insane", "dinner", "beautiful", "hello"};
		for(int i = 0; i < 5; i++) {
			dict.appendWord(new Word(sampleWords[i]));
		}
		
		Word actualWord = dict.getWord("dinner");
		
		assertEquals("dinner", actualWord.getWord());
	}
	
	@Test void testGetWordFromDef() {
		Dictionary dict = new Dictionary();
		
		String [] sampleWords = {"apple", "insane", "dinner", "beautiful", "hello"};
		for(int i = 0; i < 5; i++) {
			dict.appendWord(new Word(sampleWords[i]));
		}
		
		String def1 = "(used to express a greeting, answer a telephone, or attract attention.)";
		String def2 = "the main meal of the day, eaten in the evening or at midday.";
		
		String actualWord1 = "hello";
		String actualWord2 = "dinner";
		
		assertEquals(actualWord1, dict.getWordFromDef(def1));
		assertEquals(actualWord2, dict.getWordFromDef(def2));
		
	}
	
	@Test void testGetAllWords() {
		String expectedStringOfWords = "1. hello -- (used to express a greeting, answer a telephone, or attract attention.)" + "\n\n" + 
									  "2. dinner -- the main meal of the day, eaten in the evening or at midday." + "\n\n" + 
									   "3. apple -- the usually round, red or yellow, edible fruit of a small tree, Malus sylvestris, of the rose family." + "\n\n";
		
		Dictionary dict = new Dictionary();
		String [] sampleWords = {"hello", "dinner", "apple"};
		
		for(int i = 0; i < 3; i++) {
			dict.appendWord(new Word(sampleWords[i]));
		}
		
		String actualWord = dict.getAllWords();
		
		assertEquals(expectedStringOfWords, actualWord);
	}
	
	
	@Test void testCap() {
		Dictionary dict = new Dictionary();
		
		String [] sampleWords = {"apple", "insane", "dinner", "beautiful", "hello"};
		
		for(int i = 0; i < 5; i++) {
			dict.appendWord(new Word(sampleWords[i]));
		}
		
		assertEquals(5, dict.cap());
	}
	
	


}
