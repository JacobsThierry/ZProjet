package Objet_base;
import java.awt.Graphics;

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
	// TODO Auto-generated method stub
	
}

@Override
public boolean isIn(Point2D p) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public Objet_Geometrique dupliquer() {
	return new Cercle(this.getPOrigine(), this.rayon);
}


@Override
public Objet_Geometrique appliquerVecteur(Vecteur2D v) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public DefaultMutableTreeNode getNode() {
	DefaultMutableTreeNode node = new DefaultMutableTreeNode("Cercle");
	node.add(this.getPOrigine().getNode("Po"));
	node.add(new DefaultMutableTreeNode("rayon =" + this.rayon));
	return node;
	
}

}
