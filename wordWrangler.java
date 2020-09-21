import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.MouseInfo;

public class wordWrangler extends JPanel implements Runnable, KeyListener{
	
	private boolean[] keys; 
	
	public wordWrangler() {
		
		addKeyListener( this );   	//
		setFocusable( true );		// Do NOT DELETE these three lines
		new Thread(this).start();   //
		
	}
	
	public void paint(Graphics window) {
		
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
