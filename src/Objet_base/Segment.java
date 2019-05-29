package Objet_base;
import java.awt.Graphics;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;

public class Segment extends Objet_de_base{

	private Point2D p1;
	


	public Segment(Point2D pOrigine, Point2D p1) {
		super(pOrigine);
		this.p1 = p1;
	}

	public Segment(Point2D pOrigine, double angle, int longueur) {
		super(new Point2D());
		System.out.println(angle);
		if(angle < Math.PI) {
		this.setPOrigine(new Point2D( (int) (pOrigine.getX() - Math.cos(angle)* longueur/2), (int) (pOrigine.getY() + Math.sin(angle) * longueur/2 )));
		this.p1 = new Point2D( (int) (pOrigine.getX() + Math.cos(angle)* longueur/2), (int) (pOrigine.getY() - Math.sin(angle) * longueur/2 ) );
		}
		else
		{
			System.out.println("issou");
			this.setPOrigine(new Point2D( (int) (pOrigine.getX() - Math.cos(angle)* longueur/2), (int) (pOrigine.getY() + Math.sin(angle) * longueur/2 ) ));
			this.p1 = new Point2D( (int) (pOrigine.getX() + Math.cos(angle)* longueur/2), (int) (pOrigine.getY() - Math.sin(angle) * longueur/2 ));
		}
	}
	
	public Point2D getP1() {
	return p1;
}

public void setP1(Point2D p1) {
	this.p1 = p1;
}

	@Override
	public void afficher(Graphics g) {
		
		g.drawLine(this.getPOrigine().getX(), this.getPOrigine().getY(), this.getP1().getX(), this.getP1().getY());
		
	}
	
	public double getAngle() { // donne l'angle par rapport a l'axe des abscisses 
		
		double ang;
		
		
		ang = Math.acos(
				( this.p1.getX() - this.getPOrigine().getX() )
				/
				
				(Math.sqrt(
						
						( this.getP1().getX() - this.getPOrigine().getX()) * ( this.getP1().getX() - this.getPOrigine().getX())
						+ ( this.getP1().getY() - this.getPOrigine().getY()) * ( this.getP1().getY() - this.getPOrigine().getY())
						
						
						
						
						) )
				
						
								 
				
				
				);
		
		
		return ang;
		
		
	}
	
	public Point2D getMilieux() {
		return new Point2D( (this.getP1().getX() + this.getPOrigine().getX())/2, (this.getP1().getY() + this.getPOrigine().getY())/2 );
		
	}

	@Override
	public void deplacer(Vecteur2D v) {
		this.setPOrigine(this.getPOrigine().appliquerVecteur(v));
		this.setP1(this.getP1().appliquerVecteur(v));
		
	}
	
	@Override
	public boolean isIn(Point2D p) {
		int cmpt=0;
		int x = p.getX();
		int y = p.getY();
		boolean woah1 = true;
		for(int i=x;i<1920;i++) {
			
			
			
			if((Objet_de_base.dist(this.getPOrigine(),p)+Objet_de_base.dist(this.getP1(),p)==Objet_de_base.dist(this.getPOrigine(),this.getP1())) && woah1) {
				cmpt++;
				woah1 = (1==2);
				
			}
			p.setX(i);
		}
		return(cmpt == 1);
}

	@Override
	public Objet_Geometrique dupliquer() {
		return new Segment(this.getPOrigine(), this.getP1());
	}

	@Override
	public Objet_Geometrique appliquerVecteur(Vecteur2D v) {
		return new Segment(this.getPOrigine().appliquerVecteur(v), this.getP1().appliquerVecteur(v));
	}



@Override
public DefaultMutableTreeNode getNode() {
	DefaultMutableTreeNode node = new DefaultMutableTreeNode("Segment");
	node.add(this.getPOrigine().getNode("Po"));
	node.add(this.getP1().getNode("P1"));
	return node;
	
}
public DefaultMutableTreeNode getNode(String nom) {
	DefaultMutableTreeNode node = new DefaultMutableTreeNode(nom);
	node.add(this.getPOrigine().getNode("Po"));
	node.add(this.getP1().getNode("P1"));
	return node;
	
}
	

}
