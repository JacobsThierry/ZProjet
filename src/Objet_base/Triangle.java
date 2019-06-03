package Objet_base;
import java.awt.Graphics;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;


public class Triangle extends Segment{
	private Point2D p2;

	public Triangle(Point2D pOrigine, Point2D p1, Point2D p2) {
		super(pOrigine, p1);
		this.p2 = p2;
	}
	
	public Triangle(int x, int y, int hauteur) { //TODO faire en sorte de faire de meilleur triangles
		super(new Point2D(x,y), new Point2D(0,0));
		this.setP1(new Point2D(x-hauteur,y));
		p2 = new Point2D(x-hauteur,y+hauteur);
		
	}
	

	public Point2D getP2() {
		return p2;
	}

	public void setP2(Point2D p2) {
		this.p2 = p2;
	}
	
	@Override
	public void afficher(Graphics g) {
		g.drawLine(this.getPOrigine().getX(), this.getPOrigine().getY(), this.getP1().getX(), this.getP1().getY());
		g.drawLine(this.getPOrigine().getX(), this.getPOrigine().getY(), this.getP2().getX(), this.getP2().getY());
		g.drawLine(this.getP2().getX(), this.getP2().getY(), this.getP1().getX(), this.getP1().getY());
	}

	@Override
		public String toString() {
		return "6 "+this.getPOrigine().getX()+" "+this.getPOrigine().getY()+" "+this.getP1().getX()+" "+this.getP1().getY()+" "+this.getP2().getX()+" "+this.getP2().getY();
	}


	@Override
	public void deplacer(Vecteur2D v) {
		this.setPOrigine(this.getPOrigine().appliquerVecteur(v));
		this.setP1(this.getP1().appliquerVecteur(v));
		this.setP2(this.getP2().appliquerVecteur(v));
		
	}
	
	@Override
	public boolean isIn(Point2D p) {
		int cmpt=0;
		int x = p.getX();
		int y = p.getY();
		boolean woah1 = true;
		boolean woah2 = true;
		boolean woah3 = true;
		for(int i=x;i<1920;i++) {
			
			
			
			if((Objet_de_base.dist(this.getPOrigine(),p)+Objet_de_base.dist(this.getP1(),p)==Objet_de_base.dist(this.getPOrigine(),this.getP1())) && woah1) {
				cmpt++;
				woah1 = (1==2);
				
		}
			if((Objet_de_base.dist(this.getPOrigine(),p)+Objet_de_base.dist(this.getP2(),p)==Objet_de_base.dist(this.getPOrigine(),this.getP2())) && woah2) {
				cmpt++;
				woah2 = (1==2);
				
		}
			if((Objet_de_base.dist(this.getP1(),p)+Objet_de_base.dist(this.getP2(),p)==Objet_de_base.dist(this.getP1(),this.getP2())) && woah3) {
				cmpt++;
				woah3 = false;
				
			}
			p.setX(i);
			
		


	}
		
		return(cmpt == 1);
	}
	
	public Triangle dupliquer() {
		return new Triangle(this.getPOrigine(), this.getP1(), this.p2);
	}
	public Objet_Geometrique applquerVecteur(Vecteur2D v) {
		return new Triangle(this.getPOrigine().appliquerVecteur(v), this.getP1().appliquerVecteur(v), this.p2.appliquerVecteur(v));
	}
	
	@Override
	public DefaultMutableTreeNode getNode() {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("triangle");
		node.add(this.getPOrigine().getNode("Po"));
		node.add(this.getP1().getNode("P1"));
		node.add(this.getP2().getNode("P2"));
		return node;
		
	}
	
	
	public DefaultMutableTreeNode getNode(String nom) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(nom);
		node.add(this.getPOrigine().getNode("Po"));
		node.add(this.getP1().getNode("P1"));
		node.add(this.getP2().getNode("P2"));
		return node;
		
	}
	
	public int getHauteur() {
		return (int) Math.sqrt(
				(Objet_de_base.dist(this.getPOrigine(), this.getP2()))*(Objet_de_base.dist(this.getPOrigine(), this.getP2())) 
				- (
						(Objet_de_base.dist(this.getPOrigine(), this.getP1())*(Objet_de_base.dist(this.getPOrigine(), this.getP1())) - Objet_de_base.dist(this.getP1(), this.getP2())*Objet_de_base.dist(this.getP1(), this.getP2()) + Objet_de_base.dist(this.getPOrigine(), this.getP2())*Objet_de_base.dist(this.getPOrigine(), this.getP2()))
						/ (2 * Objet_de_base.dist(this.getPOrigine(), this.getP1()))
						) * (
								(Objet_de_base.dist(this.getPOrigine(), this.getP1())*(Objet_de_base.dist(this.getPOrigine(), this.getP1())) - Objet_de_base.dist(this.getP1(), this.getP2())*Objet_de_base.dist(this.getP1(), this.getP2()) + Objet_de_base.dist(this.getPOrigine(), this.getP2())*Objet_de_base.dist(this.getPOrigine(), this.getP2()))
								/ (2 * Objet_de_base.dist(this.getPOrigine(), this.getP1()))
								)
				
				);
	}
	
}
