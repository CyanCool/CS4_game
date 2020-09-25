//Last edited: Julianna 9/15
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.JFrame;

public class wordWranglerRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	
	public wordWranglerRunner() throws FileNotFoundException
	{
		super("wordWranglerRunner");
		setSize(WIDTH, HEIGHT);
		//prototype is temporary
		getContentPane().add(new displayText());
		setVisible(true);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		wordWranglerRunner one = new wordWranglerRunner();
	}
}
