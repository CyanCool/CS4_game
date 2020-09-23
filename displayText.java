import java.awt.Graphics;
import java.awt.Image;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.event.*;
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
	//private Player player;
	
	
	public displayText() 
	{

		a = new Letter();
		b = new Letter();
		c = new Letter();
		d = new Letter();
//		
		word = new Word();
		keys = new boolean[5];
		//player = new Player();
		
		addKeyListener( this );   	//
		setFocusable( true );		// Do NOT DELETE these three lines
		new Thread(this).start();   //
		
	}
	
	public void paint(Graphics window) 
	{
		window.setColor(Color.decode("#00bfff"));
		window.fillRect( 0,0, 800, 600);
		
		window.setFont(new Font("Verdana",Font.PLAIN, word.getFontSize()));
		window.setColor(Color.white);
		window.fillRect(200, 300-word.getFontSize(), 400, word.getFontSize()+5);
		window.setColor(Color.black);
		window.drawRect(200, 300-word.getFontSize(), 400, word.getFontSize()+5);
		window.drawString(word.toString(), 200, 300);
		
		
//		Image img1 = Toolkit.getDefaultToolkit().getImage("cow.png");
//		window.drawImage(img1, 290, 0, 200, 150, this);
//		window.drawImage(img1, 290, 530, 200, 150, this);
//		window.drawImage(img1, 0, 260, 200, 150, this);
//		window.drawImage(img1, 700, 260, 200, 150, this);
		
		window.setFont(new Font("Verdana",Font.PLAIN, 50));
		window.drawString(Character.toString((a.getChar())), 380, 50);
		window.drawString(Character.toString((b.getChar())), 380, 580);
		window.drawString(Character.toString((c.getChar())), 30, 310);
		window.drawString(Character.toString((d.getChar())), 730, 310);
		
		
		//window.drawString(Integer.toString(player.getPoints()),360, 150);
		
		window.setFont(new Font("Verdana",Font.ITALIC, 20));
		window.drawString("Points",360, 150);
		window.drawString("Health",360, 450);
		
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
			word = new Word();
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