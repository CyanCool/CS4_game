import java.util.*;
import java.io.*;
public class Dictionary {
	
	private String[] words;
	private int[] indLetters;
	
	public Dictionary() throws FileNotFoundException {
		
		Scanner file = new Scanner(new File("words_alpha.txt"));
		int sz = 370099;
		words = new String[sz];
		for(int i=0; i<sz; i++) {
			words[i] = file.nextLine();
		}
		
		Arrays.sort(words);
		
		indLetters = new int[27];
		indLetters[0] = 0;
		int ind = 1;
		for(int i=1; i<sz; i++) {
			if(words[i].charAt(0)!=words[i-1].charAt(0)) {
				indLetters[ind] = i;
				ind++;
			}
		}
		indLetters[26] = sz;
		
	}
	
	public boolean isWord(String s) {
		
		if(s.length()<2) return false;
		
		int start = indLetters[s.charAt(0)-97];
		int end = indLetters[s.charAt(0)-97+1];
		
		for(int i=start; i<end; i++) {
			if(words[i].equals(s)) {
				return true;
			}
		}
		return false;
		
		
	}

}
