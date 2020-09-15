//Last edited: Julianna 9/15
import java.util.*;
import javax.swing.JFrame;

public class wordWranglerRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	
	public wordWranglerRunner()
	{
		super("wordWranglerRunner");
		setSize(WIDTH, HEIGHT);
		getContentPane().add(new wordWrangler(WIDTH, HEIGHT));
		setVisible(true);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		wordWranglerRunner one = new wordWranglerRunner();
	}
}
