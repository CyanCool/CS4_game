import java.io.FileNotFoundException;
import java.util.*;

public class Word 
{
	private String word;
	private int fontsize; 
	private boolean valid;
	private Dictionary d;
	
	public Word() throws FileNotFoundException
	{
		word = "";
		fontsize = 50;
		valid = false;
		d = new Dictionary();
	}
	
	public void addLetter(Letter a)
	{
		if(word.length()<30)
		{
			word += a.getChar();
		}
		valid = d.isWord(word);
	}
	
	public void addLetter(char a) {
		if(word.length()<30)
		{
			word += a;
		}
		valid = d.isWord(word);
	}
	
	public void removeLetter() {
		if(word.length()>0) {
			word = word.substring(0,word.length()-1);
		}
		valid = d.isWord(word);
	}
	
	public int getLength()
	{
		return word.length();
	}
	public void decrementFontSize()
	{
		if(word.length()*fontsize > 700)
		{
			double joe = (Math.ceil(700/word.length()));
			if(joe%2 != 0)
			{
				fontsize = (int)(joe-1);
			}
			else
			{
				fontsize = (int)(joe);
			}
		}
	}
	public int getFontSize()
	{
		return fontsize;
	}
	public String toString()
	{
		return word;
	}
	public boolean isValid()
	{
		return valid;
	}
	
	
}
