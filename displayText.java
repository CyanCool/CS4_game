import java.awt.Graphics;
import java.awt.Image;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.FileNotFoundException;

import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.MouseInfo;
import java.awt.Toolkit;

public class displayText extends JPanel implements Runnable, KeyListener{

	private boolean[] keys; 

	private Letter[] letters = new Letter[4];
	private int[] cowPosition = new int[4];
	private Word word;
	private Player p;
	private int wordCount;
	private char freeLetter;
	private int cowInterval;
	private Color background;
	//private Player player;
	
	
	public displayText() throws FileNotFoundException 
	{
		background = Color.decode("#33ff33");
		
		letters[0] = new Letter();
		letters[1] = new Letter();
		letters[2] = new Letter();
		letters[3] = new Letter();
		
		cowPosition[0] = -1;
		cowPosition[1] = -1;
		cowPosition[2] = -1;
		cowPosition[3] = -1;
		
		word = new Word();
		keys = new boolean[5];
		p = new Player();
		wordCount = 0;
		freeLetter = 'a';
		cowInterval = 50;
		
		addKeyListener( this );   	
		setFocusable( true );		
		new Thread(this).start();   
		
	}
	
	public void paint(Graphics window)
	{
		window.setColor(background);
		window.fillRect( 0,0, 800, 600);
		//Image img2 = Toolkit.getDefaultToolkit().getImage("Grass.png");
		//window.drawImage(img2, 0,0,800,800,this);
		window.setFont(new Font("Verdana",Font.PLAIN, word.getFontSize()));
		window.setColor(Color.white);
		window.fillRect(195, 300-word.getFontSize(), 400, word.getFontSize()+15);
		window.setColor(new Color(0,0,0));
		window.drawRect(195, 300-word.getFontSize(), 400, word.getFontSize()+15);
		if(word.isValid()) {
			window.setColor(new Color(175,0,0));
		}
		window.drawString(word.toString(), 200, 300);
		
		
		Image img1 = Toolkit.getDefaultToolkit().getImage("CowWalking.gif");
		//window.drawImage(img1, 290, -50, 200, 150, this);
		//window.drawImage(img1, 290, 475, 200, 150, this);
		//window.drawImage(img1, -60, 210, 200, 150, this);
		//window.drawImage(img1, 640, 210, 200, 150, this);
		
		window.setColor(new Color(0,0,0));
		window.setFont(new Font("Verdana",Font.PLAIN, 50));
		window.drawString(Character.toString((letters[0].getChar())), 380, 50);
		window.drawString(Character.toString((letters[1].getChar())), 380, 580);
		window.drawString(Character.toString((letters[2].getChar())), 30, 310);
		window.drawString(Character.toString((letters[3].getChar())), 730, 310);
		
		for(int i=0; i<4; i++) {
			if(cowPosition[i]>=0 && cowPosition[i]<cowInterval) {
				if(i==0) window.drawImage(img1, 350, (-50+(int)((((double)cowPosition[0])/cowInterval)*(180+50))), 120,90, this);
				if(i==1) window.drawImage(img1, 350, (500-(int)(((double)cowPosition[1]/cowInterval)*(580-330))), 120,90, this);
				if(i==2) window.drawImage(img1, (-150+(int)(((double)cowPosition[2]/cowInterval)*(250))), 250, 120,90, this);
				if(i==3) window.drawImage(img1, (820-(int)(((double)cowPosition[3]/cowInterval)*(820-600))), 250, 120,90, this);
				cowPosition[i]++;
			} 
		}
		
		
		//window.drawString(Integer.toString(player.getPoints()),360, 150);
		
		window.setFont(new Font("Verdana",Font.ITALIC, 20));
		window.drawString("Points "+p.points,600, 50);
		window.drawString("Health "+p.health,600, 70);
		
		for(int i=0; i<letters.length; i++) 
		{
			if(keys[i]) {
				if(letters[i].getChar()=='*') {
					word.addLetter(freeLetter);
				} else if(letters[i].getChar()=='<'){
					word.removeLetter();
				}  else {
					word.addLetter(letters[i]);
				}
				letters[i] = new Letter();
				word.decrementFontSize();
				cowPosition[i] = 0;
				background = new Color(((int)(Math.random()*100)),200+((int)(Math.random()*55)),((int)(Math.random()*100)));
			}
		}
		/*
		if (keys[2]) 
		{
			if(c.getChar()=='*') {
				word.addLetter(freeLetter);
			} else if(c.getChar()=='<'){
				word.removeLetter();
			}  else {
				word.addLetter(c);
			}
			c = new Letter();
			word.decrementFontSize();
		}
		*/
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
				letters[0] = new Letter();
				letters[1] = new Letter();
				letters[2] = new Letter();
				letters[3] = new Letter();
			}
			if(p.health<=0 || p.points>10000) {
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
		if(Character.toString(e.getKeyChar()).matches("[a-z]")) {
			freeLetter = e.getKeyChar();
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