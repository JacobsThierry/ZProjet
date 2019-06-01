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
		// TODO Auto-generated method stub
		return null;
	}

}
