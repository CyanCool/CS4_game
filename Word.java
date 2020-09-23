import java.util.*;

public class Word 
{
	private String word;
	private int fontsize; 
	
	public Word()
	{
		word = "";
		fontsize = 50;
	}
	
	public void addLetter(Letter a)
	{
		if(word.length()<30)
		{
			word += a.getChar();
		}
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
	
	
}
