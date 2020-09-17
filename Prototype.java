import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.MouseInfo;

public class Prototype extends JPanel implements Runnable, KeyListener{

	private boolean[] keys; 

	private char a;
	private char b;
	private char c;
	private char d;
	private String word;
	
	
	public Prototype() {

		a = (char)((int)(Math.random()*26)+97);
		b = (char)((int)(Math.random()*26)+97);
		c = (char)((int)(Math.random()*26)+97);
		d = (char)((int)(Math.random()*26)+97);
		word = "";
		keys = new boolean[5];
		
		addKeyListener( this );   	//
		setFocusable( true );		// Do NOT DELETE these three lines
		new Thread(this).start();   //
		
	}
	
	public void paint(Graphics window) {
		
		
		
		
		
		window.setColor(Color.blue);
		window.fillRect( 0,0, 800, 600);
		
		window.setFont(new Font("Verdana",Font.PLAIN,50));
		window.setColor(Color.white);
		window.drawString(word, 340, 300);
		
		window.setColor(Color.yellow);
		window.drawString(Character.toString(a), 380, 50);
		window.drawString(Character.toString(b), 380, 580);
		window.drawString(Character.toString(c), 30, 310);
		window.drawString(Character.toString(d), 730, 310);
		
		if (keys[0]) {
			word = word + a;
			a = (char)((int)(Math.random()*26)+97);
		}
		if (keys[1]) {
			word = word + b;
			b = (char)((int)(Math.random()*26)+97);
		}
		if (keys[2]) {
			word = word + c;
			c = (char)((int)(Math.random()*26)+97);
		}
		if (keys[3]) {
			word = word + d;
			d = (char)((int)(Math.random()*26)+97);
		}
		if (keys[4]) {
			word = "";
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
