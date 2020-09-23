import java.util.*;

public class Letter
{
	private int size;
	private char identity;
	
	public Letter()
	{
		size = 10;
		
		int[] freq = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
		int tot = 0;
		for(int i=0; i<freq.length; i++) {
			tot += freq[i];
		}
		int r = (int)(Math.random()*tot)+1;
		int i=0;
		while(r>0) {
			r -= freq[i];
			i++;
		}
		identity = (char)(i+96);
	}
	public void changeSize()
	{
		size -= 5;
	}
	public char getChar()
	{
		return identity;
	}
}
