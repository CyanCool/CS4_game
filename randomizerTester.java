import java.util.*;
import java.io.*;

public class randomizerTester {

	public void run() throws FileNotFoundException {

		Scanner file = new Scanner(System.in);
		Randomizer r = new Randomizer();
		
		for(int i=0; i<100; i++) {
			System.out.println(r.randomChar());
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		randomizerTester t = new randomizerTester();
		t.run();
	}

}