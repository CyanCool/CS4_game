import java.util.*;
public class wordRunner
{
	public static void main(String[] args)
	{
		Word test = new Word();
		Letter a = new Letter();
		Letter b = new Letter();
		Letter c = new Letter();
		
		test.addLetter(a);
		test.addLetter(b);
		test.addLetter(c);
		
		System.out.println(test.toString());
		System.out.println(test.getLength());
		System.out.println(test.getFontSize());
		
		test.decrementFontSize();
		System.out.println(test.getFontSize());//Should be the same
	}
}
