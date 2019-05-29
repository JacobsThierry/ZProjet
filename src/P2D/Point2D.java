package P2D;
import java.awt.Graphics;

import Objet_base.Objet_Geometrique;

public class Point2D implements Objet_Geometrique{

	private int x;
	private int y;
	private int longe=5;
	
	
	
	public Point2D(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Point2D() {
		this.x = 0;
		this.y = 0;
	}
	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + ", longe=" + longe + "]";
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void afficher(Graphics g) {
		g.drawLine(x-longe, y+longe, x+longe, y-longe);
		g.drawLine(x-longe, y-longe, x+longe, y+longe);
		
	}
	
	

	public void deplacer(Vecteur2D v) {
		this.setX(this.appliquerVecteur(v).getX());
		this.setY(this.appliquerVecteur(v).getY());
		
	}
	
	public Point2D appliquerVecteur(Vecteur2D v) {
		return new Point2D(x + v.getX(), y + v.getY() );
	}
	
	@Override
	public boolean isIn(Point2D p) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Objet_Geometrique dupliquer() {
		return new Point2D(this.x, this.y);
	}
	
}
