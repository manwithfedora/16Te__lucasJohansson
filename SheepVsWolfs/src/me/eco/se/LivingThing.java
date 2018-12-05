package me.eco.se;

import java.awt.Point;
import javax.swing.ImageIcon;

public abstract class LivingThing implements Entity {
	
	protected Point position;
	protected Pasture pasture;
	
	   public int newDirection(){
		  	return (int) (Math.floor(Math.random() + Math.floor(3)) - 1);
	    }
	
	public int getRandom(){
		
		return (int)((Math.random())*3)-1;
	}

	public Point getPosition()
	{
		return position;
	}
	
	public void setPosition(Point newPosition)
	{
		position = newPosition;
	}
	
	
	
	abstract public void tick();
	
	abstract public String type();
	
	abstract public ImageIcon getImage();
}


