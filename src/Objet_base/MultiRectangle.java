package Objet_base;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;

public class MultiRectangle extends Objet_de_base{
	
	

	private ArrayList<Rectangle> arr;
	
	

	public MultiRectangle(Point2D pOrigine, ArrayList<Rectangle> arr) {
		super(pOrigine);
		this.arr = arr;
	}
	
	public MultiRectangle(Point2D pOrigine) {
		super(pOrigine);
		this.arr = new ArrayList<Rectangle>();
	}

	@Override
	public void deplacer(Vecteur2D v) {
		
		
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

	@Override
	public void afficher(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	

}
