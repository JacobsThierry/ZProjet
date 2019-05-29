package Objet_base;
import java.awt.Graphics;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
public abstract class Objet_de_base implements Objet_Geometrique{

	private Point2D POrigine;
	public Objet_de_base(Point2D pOrigine) {
		super();
		POrigine = pOrigine;
	}

	public Point2D getPOrigine() {
		return POrigine;
	}
	public void setPOrigine(Point2D pOrigine) {
		POrigine = pOrigine;
	}
	
	public static int dist(Point2D p1, Point2D p2) {
				
		return (int) ((Math.sqrt((p1.getX() -p2.getX())*(p1.getX() -p2.getX()) + (p1.getY() -p2.getY())*(p1.getY() -p2.getY()))));
		
		
	}
	
	public abstract void afficher(Graphics g);
	
	
	
	
}
