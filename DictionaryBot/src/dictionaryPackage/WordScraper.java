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
	String url;
	Document doc;
	
	public WordScraper(String input) {
		theWord = input;
		definition = "";
		sentence = "";
		url = "https://www.dictionary.com/browse/";
	}
	
	public void scanWebsite() throws IOException {
		doc = Jsoup.connect(url +""+ theWord).get();
		
		Element def = doc.select("span.one-click-content").first();
		definition = "The definition is: " + def.text();
		String title = doc.title();
		System.out.println(definition);
	}
	
	public static void main(String[] args) throws IOException {
		WordScraper ws = new WordScraper("cat");
		ws.scanWebsite();
	}
}
