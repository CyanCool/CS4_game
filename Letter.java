import java.util.*;

public class Letter
{
	private int size;
	private char identity;
	private int powerUp;
	
	public Letter()
	{
		size = 10;
		
		int[] freq = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
		int tot = 0;
		for(int i=0; i<freq.length; i++) {
			tot += freq[i];
		}
		int r = ((int)(Math.random()*tot))+1;
		int j=0;
		while(r>0) {
			r -= freq[j];
			j++;
		}
		identity = (char)(j+96);
		
		int[] powerups = {12,1,1};
		tot = 0;
		for(int i=0; i<powerups.length; i++) {
			tot += powerups[i];
		}
		r = ((int)(Math.random()*tot))+1;
		j=-1;
		while(r>0) {
			j++;
			r -= powerups[j];
		}
		powerUp = j;
	}
	public char getChar()
	{
		if(powerUp==1) {
			identity='*';
		} else if (powerUp==2) {
			identity='<';
		}
		return identity;
	}
}
