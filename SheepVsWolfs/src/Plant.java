

import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;

public class Plant extends LivingThing {

	private final ImageIcon image = new ImageIcon("src/plant.gif"); 
	private Pasture pasture;
	private int tickCount =0;
	
	
    public Plant(Pasture pasture) {
	this.pasture = pasture;
    }

    public Plant(Pasture pasture, Point position) {
	this.pasture   = pasture;
	this.position  = position;
    }
	
	public void tick() {
		
		tickCount++;
		if(tickCount%3 == 0);{
			tickCount = 0;
			// skapa ny punkt
			int dx = newDirection();
			int dy = newDirection();
			
			if (getPosition().getX() + dx <pasture.getWidth()
				&& getPosition().getX() + dx >=0
				&& getPosition().getY() + dy <pasture.getHeight()
				&& getPosition().getY() + dy >= 0 ) {

			// kolla om platsen �r tom
			// skapa ny planta 
			// plantera i hagen
				
			boolean emptySpace = true;
				Collection world = pasture.getEntities();
				Iterator it = world.iterator();
				// kollar genom hela v�rlden
				
				while(it.hasNext() && emptySpace) {
					// h�mta entity
					Entity WhatIsHere = (Entity) it.next();
					//pos om upptagen
					int existingX = (int)WhatIsHere.getPosition().getX();
					int existingY = (int)WhatIsHere.getPosition().getY();
					if (existingX == this.getPosition().getX() + dx
							&& existingY == this.getPosition().getY()+ dy){
						emptySpace = false;
					}
					
				}
				if (emptySpace){
					Point newPlantPosition = new Point();
					newPlantPosition.x = (int) this.getPosition().getX()+ dx;
					newPlantPosition.y = (int) this.getPosition().getX()+ dy;
					
					Entity plant = new Plant(pasture,newPlantPosition);
					pasture.addEntity(plant);
				}
				
				
				}
		}
		
	}

	public ImageIcon getImage() {
		return image;
	}

	public String type() {
		return "Plant";
	}

}
