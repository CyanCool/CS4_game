import java.util.*;
import java.io.*;

public class DictionaryTester {

	public void run() throws FileNotFoundException {

		Scanner file = new Scanner(System.in);
		Dictionary d = new Dictionary();
		
		String s = file.nextLine();
		System.out.println(d.isWord(s));

	}

	public static void main(String[] args) throws FileNotFoundException {
		DictionaryTester t = new DictionaryTester();
		t.run();
	}

}