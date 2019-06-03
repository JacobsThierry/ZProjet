package Objet_base;



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;


public class Ellipse extends Rectangle {
	private Point2D P4;
	private double angle;

	
	public Ellipse(Point2D pOrigine, Point2D p1, Point2D p2, Point2D p3, Point2D p4,int angle) {
		super(pOrigine, p1, p2, p3);
		this.P4 = p4;
		this.angle=angle;
	}

	public Ellipse(Segment s, int longeur, double angle) {
		super(s.getMilieux(), s.getPOrigine(), new Segment( s.getMilieux(), s.getAngle() + (Math.PI/2), longeur ).getPOrigine(), s.getP1());
		Segment s2 = new Segment( s.getMilieux(), (s.getAngle() + (Math.PI/2)), longeur );
		this.setP4( s2.getP1());
		this.angle=angle;
	}





@Override
public void afficher(Graphics g) {
	AffineTransform old = ((Graphics2D) g).getTransform();
	 ((Graphics2D) g).rotate(this.angle,this.getPOrigine().getX()+Math.abs(Objet_de_base.dist(this.getP2(),this.getP4()))/2,this.getPOrigine().getY()+Objet_de_base.dist(this.getPOrigine(), this.getP3())/2);
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
	// TODO Auto-generated method stub
	
}

@Override
public boolean isIn(Point2D p) {
	// TODO Auto-generated method stub
	return false;
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
	n.add((new DefaultMutableTreeNode(this.angle)));
	node.add(n);
	return node;
}

public String toString() {
	return "10 "+this.getPOrigine().getX()+" "+this.getPOrigine().getY()+" "+this.getP1().getX()+" "+this.getP1().getY()+" "+this.getP2().getX()+" "+this.getP2().getY()+" "+this.getP3().getX()+" "+this.getP3().getY()+" "+this.P4.getX()+" "+this.P4.getY()+" "+this.angle;

}
}
