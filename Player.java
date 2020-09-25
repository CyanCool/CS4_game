import java.io.FileNotFoundException;

public class Player {
	
	public int points;
	public int health;
	private Dictionary d;
	
	public Player() throws FileNotFoundException {
		points = 0;
		health = 100;
		d = new Dictionary();
	}
	
	public void submitWord(String s) {
		if(d.isWord(s)) {
			points += s.length()*10;
			health += s.length()*2;
		} else {
			int damage = s.length()*5;
			if(damage>45) damage=45;
			health -= damage;
		}
	}
	
	public void submitWord(String s, boolean valid) {
		if(valid) {
			points += s.length()*10;
			health += s.length()*2;
		} else {
			int damage = s.length()*5;
			if(damage>45) damage=45;
			health -= damage;
		}
	}
	
	public String toString() {
		return ("Points: " + points + "\nHealth: " + health);
		
	}
}
