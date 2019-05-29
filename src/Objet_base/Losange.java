package Objet_base;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;

public class Losange extends Rectangle{
private Point2D p4;

public Losange(Point2D pOrigine, Point2D p1, Point2D p2, Point2D p3, Point2D p4) {
	super(pOrigine, p1, p2, p3);
	this.p4 = p4;
	//TODO faire le constructeur
}

public Losange(Segment s, int longeur) {
	super(s.getMilieux(), s.getPOrigine(), new Segment( s.getMilieux(), s.getAngle() + (Math.PI/2), longeur ).getPOrigine(), s.getP1());
	Segment s2 = new Segment( s.getMilieux(), (s.getAngle() + (Math.PI/2)), longeur );
	this.setP4( s2.getP1());
	
}


@Override
public String toString() {
	return "Losange [p4=" + p4 + "]";
}

public Point2D getP4() {
	return p4;
}

public void setP4(Point2D p4) {
	this.p4 = p4;
}

@Override
public void afficher(Graphics g) {
	
	
	
	
	g.drawLine(this.getP1().getX(), this.getP1().getY(), this.getP2().getX(), this.getP2().getY());
	
	g.drawLine(this.getP2().getX(), this.getP2().getY(), this.getP3().getX(), this.getP3().getY());
	
	g.drawLine(this.getP3().getX(), this.getP3().getY(), this.getP4().getX(), this.getP4().getY());
	
	
	g.drawLine(this.getP4().getX(), this.getP4().getY(), this.getP1().getX(), this.getP1().getY());
	
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
	DefaultMutableTreeNode node = new DefaultMutableTreeNode("Losange");
	node.add(this.getPOrigine().getNode("Po"));
	node.add(this.getP1().getNode("P1"));
	node.add(this.getP2().getNode("P2"));
	node.add(this.getP3().getNode("P3"));
	node.add(this.getP4().getNode("P4"));
	
	return node;
	
}

}
