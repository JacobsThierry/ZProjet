package Objet_base;
import java.awt.Graphics;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;

public interface Objet_Geometrique {

	
	public void afficher(Graphics g);
	
	public void deplacer(Vecteur2D v);
	
	public boolean isIn(Point2D p); //méthode pour savoir si un point est dans une forme. utile pour déplacé
	
	public Objet_Geometrique dupliquer();
	
	public Objet_Geometrique appliquerVecteur(Vecteur2D v);

	public abstract DefaultMutableTreeNode getNode();
}
