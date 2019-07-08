/** 
author: Yifat Yolles
The SplitWord class provides methods to split sentence without apace to
 a legal phrase.
The working assumption is that there is a dictionary with all
 the words in the language (file words).
*/  

package splitSentenceToWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class splitWord {
	public static Set<String> dictionary = new HashSet<>();
	static File file = new File("../split sentence to words/src/splitSentenceToWords/words");

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		//add all the words to the dictionary
		while (sc.hasNextLine()) {
			dictionary.add(sc.nextLine());
		}
		splitToWords("thedogatethecat");
	}

	static void splitToWords(String str) {
		findWord(str, str.length(), "");
	}

	static void findWord(String str, int len, String result) {
		for (int i = 1; i <= len; i++) {
			String candidate = str.substring(0, i);
			if (dictionary.contains(candidate)) {
				if (i == len) {
					result += candidate;
					System.out.println(result);
					return;
				}
				String leftString = str.substring(i, len);
				String tempRes = result + candidate + " ";
				findWord(leftString, len - i, tempRes);
			}
		}
	}
}
