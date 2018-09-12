package me.eco.se;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Dummy implements Entity {

    private final ImageIcon image = new ImageIcon("unknown.gif"); 

    protected Point position;

    protected Pasture pasture;
   
    public Dummy(Pasture pasture) {
	this.pasture = pasture;
    }

    public Dummy(Pasture pasture, Point position) {
	this.pasture   = pasture;
	this.position  = position;
    }
    
    public Point getPosition() { return position; }

    
    public void setPosition(Point newPosition) { position = newPosition; }

    
    public void tick() {
	setPosition(new Point((int)getPosition().getX()+1,(int)getPosition().getY()));
    }

    public String type() {
	return "Dummy";
    }
    
    public ImageIcon getImage() { return image; }

   
}