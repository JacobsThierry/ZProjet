package Objet_base;

import java.awt.Graphics;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;

public class Arc implements Objet_Geometrique {
	private Point2D P1;
	private int haut;
	private int larg;
	private double angle;

	
	public Arc(Point2D p1, int haut, int larg,double angle) {
		P1 = p1;
		this.haut = haut;
		this.larg = larg;
		this.angle=angle;
	
	}

	@Override
	public void afficher(Graphics g) {
		g.drawArc(P1.getX(), P1.getY(), this.larg, this.haut, (int) this.angle, 90);
		
	}

	@Override
	public void deplacer(Vecteur2D v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isIn(Point2D p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Objet_Geometrique dupliquer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Objet_Geometrique appliquerVecteur(Vecteur2D v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultMutableTreeNode getNode() {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Arc");
		node.add(this.getP1().getNode("P1"));
		DefaultMutableTreeNode n =   (new DefaultMutableTreeNode ("Hauteur"));
		n.add((new DefaultMutableTreeNode(this.haut)));
		node.add(n);
		DefaultMutableTreeNode n1 =   (new DefaultMutableTreeNode ("Largeur"));
		n.add((new DefaultMutableTreeNode(this.larg)));
		node.add(n1);
		DefaultMutableTreeNode n2 =   (new DefaultMutableTreeNode ("Angle"));
		n.add((new DefaultMutableTreeNode(this.angle)));
		node.add(n2);
		
		
		return node;
	}

	public Point2D getP1() {
		return P1;
	}

	public void setP1(Point2D p1) {
		P1 = p1;
	}

	public int getHaut() {
		return haut;
	}

	public void setHaut(int haut) {
		this.haut = haut;
	}

	public int getLarg() {
		return larg;
	}

	public void setLarg(int larg) {
		this.larg = larg;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	

}
