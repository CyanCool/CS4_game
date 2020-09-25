import java.awt.Graphics;
import java.awt.Image;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.MouseInfo;
import java.awt.Toolkit;

public class displayText extends JPanel implements Runnable, KeyListener{

	private boolean[] keys; 

	private Letter a;
	private Letter b;
	private Letter c;
	private Letter d;
	private Word word;
	private Player p;
	private int wordCount;
	//private Player player;
	
	
	public displayText() throws FileNotFoundException 
	{

		a = new Letter();
		b = new Letter();
		c = new Letter();
		d = new Letter();
//		
		word = new Word();
		keys = new boolean[5];
		p = new Player();
		wordCount = 0;
		
		addKeyListener( this );   	
		setFocusable( true );		
		new Thread(this).start();   
		
	}
	
	public void paint(Graphics window)
	{
		window.setColor(Color.decode("#33ff33"));
		window.fillRect( 0,0, 800, 600);
		//Image img2 = Toolkit.getDefaultToolkit().getImage("Grass.png");
		//window.drawImage(img2, 0,0,800,800,this);
		window.setFont(new Font("Verdana",Font.PLAIN, word.getFontSize()));
		window.setColor(Color.white);
		window.fillRect(195, 300-word.getFontSize(), 400, word.getFontSize()+15);
		window.setColor(Color.black);
		window.drawRect(195, 300-word.getFontSize(), 400, word.getFontSize()+15);
		if(word.isValid()) {
			window.setColor(Color.GREEN);
		}
		window.drawString(word.toString(), 200, 300);
		
		
		Image img1 = Toolkit.getDefaultToolkit().getImage("cow.png");
		window.drawImage(img1, 290, -50, 200, 150, this);
		window.drawImage(img1, 290, 475, 200, 150, this);
		window.drawImage(img1, -60, 210, 200, 150, this);
		window.drawImage(img1, 640, 210, 200, 150, this);
		
		window.setColor(Color.black);
		window.setFont(new Font("Verdana",Font.PLAIN, 50));
		window.drawString(Character.toString((a.getChar())), 380, 50);
		window.drawString(Character.toString((b.getChar())), 380, 580);
		window.drawString(Character.toString((c.getChar())), 30, 310);
		window.drawString(Character.toString((d.getChar())), 730, 310);
		
		
		//window.drawString(Integer.toString(player.getPoints()),360, 150);
		
		window.setFont(new Font("Verdana",Font.ITALIC, 20));
		window.drawString("Points "+p.points,360, 150);
		window.drawString("Health "+p.health,360, 450);
		
		if (keys[1]) 
		{
			word.addLetter(b);
			b = new Letter();
			word.decrementFontSize();			
		}
		if (keys[0]) 
		{
			word.addLetter(a);
			a = new Letter();
			word.decrementFontSize();
		}
		if (keys[3]) 
		{
			word.addLetter(d);
			d = new Letter();
			word.decrementFontSize();
		}
		if (keys[2]) 
		{
			word.addLetter(c);
			c = new Letter();
			word.decrementFontSize();
		}
		if (keys[4]) 
		{
			wordCount++;
			boolean valid = word.isValid();
			p.submitWord(word.toString(), valid);
			try {
				word = new Word();
			} catch (FileNotFoundException e) {}
			if(wordCount>=5) {
				wordCount = 0;
				a = new Letter();
				b = new Letter();
				c = new Letter();
				d = new Letter();
			}
			if(p.health<=0) {
				System.exit(0);
			}
		}
		
	
		keys[0] = false;
		keys[1] = false;
		keys[2] = false;
		keys[3] = false;
		keys[4] = false;
		
	}
	
	public void keyPressed(KeyEvent e)
	{   
		//Java KeyEvent docs
		//https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html
		
		if( e.getKeyCode()  == KeyEvent.VK_UP)
		{
			keys[0]=true;
		}
		
		if( e.getKeyCode()  == KeyEvent.VK_DOWN)
		{
			keys[1]=true;
		}
		
		if( e.getKeyCode()  == KeyEvent.VK_LEFT)
		{
			keys[2]=true;
		}
		
		if( e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[3]=true;
		}
		
		if( e.getKeyCode() == KeyEvent.VK_SPACE) 
		{
			keys[4] = true;
		}
	}
	
	// do not edit anything from this point on!!!
	public void keyTyped(KeyEvent e)
	{
		keyPressed( e );			
	}		
	public void keyReleased(KeyEvent e)
	{
	}	
	
	public void run()
	{
		try
		{
			while( true )
			{	
			   Thread.sleep( 10 );
			   repaint();
			}
		}
		catch( Exception e )
		{			
		}
	}

}