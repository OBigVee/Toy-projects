/*
 * 
 *this program encodes English-language phrases into pig Latin. 
 *Pig Latin is a form of coded language. There are many different ways to form pig Latin phrases.
 *this application used the following algorithm:
 *Tokenize the phrase into words.
 *To translate each English word into a pig Latin word, place the first
 *letter of the English word at the end of the word and add the letters “ay.” Thus, the word “jump”
 *becomes “umpjay,” the word “the” becomes “hetay,” and the word “computer” becomes “omputercay.” 
 *Blanks between words remain as blanks. 
 *Method printLatinWord display each word. Each token is passed to method printLatinWord 
 *to print the pig Latin word.
 * 
 * 
 * */
package files;
import java.util.Scanner;

public class PigLatin {
	//private String  name;
	public static String phrase;
	public static String[] tokens;
	
	public PigLatin() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter your sentence here and press enter :: ");
		phrase = scanner.nextLine();
		tokens  = phrase.split(" ");	
	}	
	public static void  printLatinWord() {
		for (String token: tokens) {
			String raw = " ";
			for(int i=0; i<token.length();++i) {
				if (i == 0)continue;
				else 
					raw += token.charAt(i);
			}
			String newToken = raw+token.charAt(0)+"ay";	
			System.out.println(newToken);
		} 
	}
	
}

