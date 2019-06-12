package Objet_base;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.text.DecimalFormat;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;


public class Ellipse extends Rectangle {
	private Point2D P4;
	

	
	public Ellipse(Point2D pOrigine, Point2D p1, Point2D p2, Point2D p3, Point2D p4) {
		super(pOrigine, p1, p2, p3);
		this.P4 = p4;
	}

	public Ellipse(Segment s, int longeur) {
		super(s.getMilieux(), s.getPOrigine(), new Segment( s.getMilieux(), s.getAngle(), longeur ).getPOrigine(), s.getP1());
		Segment s2 = new Segment( s.getMilieux(), (s.getAngle()), longeur);
		this.setP4( s2.getP1());
	}





@Override
public void afficher(Graphics g) {
	AffineTransform old = ((Graphics2D) g).getTransform();
	 ((Graphics2D) g).rotate(((new Segment(this.getP1(), this.getP3()).getAngle()) ), this.getPOrigine().getX(), this.getPOrigine().getY() );
	g.drawOval(this.getP1().getX(),this.getP1().getY(),Math.abs(Objet_de_base.dist(this.getP2(),this.getP4())),Objet_de_base.dist(this.getPOrigine(), this.getP3()));
	((Graphics2D) g).setTransform(old);
	
}








public Point2D getP4() {
		return P4;
	}




	public void setP4(Point2D p4) {
		P4 = p4;
	}


@Override
public void deplacer(Vecteur2D v) {
	this.setPOrigine(this.getPOrigine().appliquerVecteur(v));
	this.setP1(this.getP1().appliquerVecteur(v));
	this.setP2(this.getP2().appliquerVecteur(v));
	this.setP3(this.getP3().appliquerVecteur(v));
	this.setP4(this.getP4().appliquerVecteur(v));
	
}

@Override
public boolean isIn(Point2D p) {
	Rectangle r = new Rectangle(this.getP1(), this.getP2(), this.getP3(), this.getP4());

	return r.isIn(p);
	
}

public Ellipse dupliquer() {
	return new Ellipse(this.getPOrigine().dupliquer(), this.getP1().dupliquer(),
			this.getP2().dupliquer(), this.getP3().dupliquer(), this.getP4().dupliquer());
}


@Override
public DefaultMutableTreeNode getNode() {
	DefaultMutableTreeNode node = new DefaultMutableTreeNode("Ellipse");
	node.add(this.getPOrigine().getNode("Po"));
	node.add(this.getP1().getNode("P1"));
	node.add(this.getP2().getNode("P2"));
	node.add(this.getP3().getNode("P3"));
	node.add(this.getP4().getNode("P3"));
	DefaultMutableTreeNode n =   (new DefaultMutableTreeNode ("Angle"));
	
	node.add(n);
	return node;
}

public String toString() {
	DecimalFormat df = new java.text.DecimalFormat("0.##");
	return "10 "+this.getPOrigine().getX()+" "+this.getPOrigine().getY()+" "+this.getP1().getX()+" "+this.getP1().getY()+" "+this.getP2().getX()+" "+this.getP2().getY()+" "+this.getP3().getX()+" "+this.getP3().getY()+" "+this.P4.getX()+" "+this.P4.getY()+" ";

}
public String toString2() {
	DecimalFormat df = new java.text.DecimalFormat("0.##");
	return this.getPOrigine().getX()+" "+this.getPOrigine().getY()+" "+this.getP1().getX()+" "+this.getP1().getY()+" "+this.getP2().getX()+" "+this.getP2().getY()+" "+this.getP3().getX()+" "+this.getP3().getY()+" "+this.P4.getX()+" "+this.P4.getY()+" ";

}
}
