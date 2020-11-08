package dictionaryPackage;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WordScraper {
	String theWord;
	String definition;
	String sentence;
	String defUrl;
	String sent_url;
	Document doc;


	public WordScraper(String input) {
		theWord = input;
		definition = "";
		sentence = "";
		defUrl = "https://www.dictionary.com/browse/";
		sent_url = "https://sentence.yourdictionary.com/";

		try{
		doc = Jsoup.connect(defUrl +""+ theWord).get();
		Document doc2 = Jsoup.connect(sent_url + theWord).get();

		Element def = doc.select("span.one-click-content").first();
		Element sent = doc2.select("p").first();

		definition = "The definition is: " + def.text();
		sentence = sent.text();
		String title = doc.title();
		System.out.println(definition);
		System.out.println(sentence);
	  }
		catch (Exception e){
			System.out.println("not a valid word");
		}

	}

	public String getDef() {
		return definition;
	}

	public String getWord() {
		return theWord;
	}

	public static void main(String[] args) throws IOException {
		Word ws = new Word("43423423432");
	}
}
