
import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Wolf extends Animal {

	private final ImageIcon image = new ImageIcon("src/wolf.gif");

	// S� h�r m�nga tick kommer f�ret att �verleva utan mat.
	private int maxFood = 30;
	
	// Vi beh�ver se till att f�ret f�r sin mat i b�da varianterna av konstruktor.
	public Wolf(Pasture pasture) {
		this.pasture = pasture;
		super.setFood(maxFood);
	}

	public Wolf(Pasture pasture, Point position) {
		this.pasture = pasture;
		this.position = position;
		super.setFood(maxFood);
	}
	
	// Slytten sker i superklassen, eftersom det �r samma r�relsem�nster i f�r och varg.
	public void tick() {
		
		// F�ret r�r sig och om det hamnar p� en position d�r det �r en sheepa, s� ska 
		// h�lsa �kas till 30 och sheepan f�rsvinna.
	
		// Superklassens metod move �r inte till�mpbar nu, eftersom vi beh�ver kunna hantera
		// att f�ret �ter gr�s, om det finns.
//		super.move();

		// Vi b�rjar att slumpa en ny plats f�r f�ret att g� till.
		int x = getRandom();
		int y = getRandom();
		
		// F�rst s� ska vi unders�ka om den nya koordinaten finns inom
		// spelplanen
		// f�r att kunna g� dit �ht.

		if (position.getX()+x >= 0 && position.getX()+x < pasture.getWidth() && position.getY()+y >= 0
				&& position.getY()+y < pasture.getHeight()) {

			// Kolla om det finns mat p� platsen dit f�ret g�r.
			// Om ja, s�tt h�lsa till 30 och ta bort sheep.
			boolean isFood = false;
			Collection world = pasture.getEntities();
			Iterator it = world.iterator();

			while (it.hasNext()) {
				Entity e = (Entity) it.next();
				int existingX = (int) e.getPosition().getX();
				int existingY = (int) e.getPosition().getY();

				if (existingX == this.getPosition().getX() + x
						&& existingY == this.getPosition().getY() + y
						&& e.type().equals("sheep")){
					isFood = true;
					pasture.removeEntity(e);		
				}
			}
			// Om det inte fanns mat p� nya positionen, minska food med 1 och 
			// g� till den nya positionen.
			if (isFood){ 
				// L�ser problemet (fult) att food minskas i setPosition.
				super.setFood(maxFood+1);
			}
			else if(isFood && getCurrentFood()==1)
			{
				this.setFood(2);
			}
			move(x,y);
		}
	}

	public String type() {
		return "Wolf";
	}

	public ImageIcon getImage() {
		return image;
	}
}