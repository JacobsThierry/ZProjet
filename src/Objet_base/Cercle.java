package Objet_base;
import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;

public class Cercle extends Objet_de_base{
private int rayon;

public Cercle(Point2D pOrigine, int rayon) {
	super(pOrigine);
	this.rayon = rayon;
}

public void afficher(Graphics g) {
    g.drawOval(this.getPOrigine().getX()-this.getRayon(), this.getPOrigine().getY()-this.getRayon(), this.getRayon() * 2, this.getRayon() * 2);


}


public int getRayon() {
	return rayon;
}

public void setRayon(int rayon) {
	this.rayon = rayon;
}



@Override
public void deplacer(Vecteur2D v) {
	this.setPOrigine(this.getPOrigine().appliquerVecteur(v));
	
}

@Override
public boolean isIn(Point2D p) {
	if( Objet_de_base.dist(this.getPOrigine(), p) < rayon ) return true;
	return false;
}


@Override
public Cercle dupliquer() {
	return new Cercle(this.getPOrigine(), this.rayon);
}


@Override
public Cercle appliquerVecteur(Vecteur2D v) {
	return new Cercle(this.getPOrigine().appliquerVecteur(v), this.rayon);
}

@Override
public DefaultMutableTreeNode getNode() {
	DefaultMutableTreeNode node = new DefaultMutableTreeNode("Cercle");
	node.add(this.getPOrigine().getNode("Po"));
	node.add(new DefaultMutableTreeNode("rayon =" + this.rayon));
	return node;
	
}

public DefaultMutableTreeNode getNode(String nom) {
	DefaultMutableTreeNode node = new DefaultMutableTreeNode(nom);
	node.add(this.getPOrigine().getNode("Po"));
	node.add(new DefaultMutableTreeNode("rayon =" + this.rayon));
	return node;
	
}
	public String toString(){
		
	return "8 "+this.getPOrigine().getX()+" "+this.getPOrigine().getY()+" "+this.getRayon();
}
	public String toString2(){
		return this.getPOrigine().getX()+" "+this.getPOrigine().getY()+" "+this.getRayon()+" ";
	}

}
