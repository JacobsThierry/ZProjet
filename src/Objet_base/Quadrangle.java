package Objet_base;
import java.awt.Graphics;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;

public class Quadrangle extends Losange{

private int rayon;

public Quadrangle(Point2D pOrigine, Point2D p1, Point2D p2, Point2D p3, Point2D p4, int rayon) {
	super(pOrigine, p1, p2, p3, p4);
	this.rayon = rayon;
}

public int getRayon() {
	return rayon;
}

public void setRayon(int rayon) {
	this.rayon = rayon;
}

@Override
public void afficher(Graphics g) {
	// TODO Auto-generated method stub
	
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
public DefaultMutableTreeNode getNode() {
	DefaultMutableTreeNode node = new DefaultMutableTreeNode("Quadrangle");
	node.add(this.getPOrigine().getNode("Po"));
	node.add(this.getP1().getNode("P1"));
	node.add(this.getP2().getNode("P2"));
	node.add(this.getP3().getNode("P3"));
	node.add(this.getP4().getNode("P4"));
	node.add(new DefaultMutableTreeNode("rayon =" + this.rayon));
	return node;
	
}

}
