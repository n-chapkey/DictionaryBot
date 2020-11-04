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
	String sent_url;
	Document doc;

	public WordScraper(String input) {
		theWord = input;
		definition = "";
		sentence = "";
		url = "https://www.dictionary.com/browse/";
		sent_url = "https://sentence.yourdictionary.com/";
	}

	public void scanWebsite() throws IOException {
		doc = Jsoup.connect(url +""+ theWord).get();
		Document doc2 = Jsoup.connect(sent_url + theWord).get();

		Element def = doc.select("span.one-click-content").first();
		Element sent = doc2.select("p").first();

		definition = "The definition is: " + def.text();
		sentence = sent.text();
		String title = doc.title();
		System.out.println(definition);
		System.out.println(sentence);
	}

	public static void main(String[] args) throws IOException {
		WordScraper ws = new WordScraper("cat");
		ws.scanWebsite();
	}
}
