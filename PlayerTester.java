import java.util.*;
import java.io.*;

public class PlayerTester {

	public void run() throws FileNotFoundException {

		Scanner file = new Scanner(System.in);
		Player p = new Player();
		String s = file.nextLine();
		
		p.submitWord(s);
		System.out.println(p);
		

	}

	public static void main(String[] args) throws FileNotFoundException {
		PlayerTester t = new PlayerTester();
		t.run();
	}

}