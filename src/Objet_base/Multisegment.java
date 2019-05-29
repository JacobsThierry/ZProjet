package Objet_base;

import java.util.ArrayList;

import P2D.Point2D;
import P2D.Vecteur2D;

public class Multisegment extends Objet_de_base{
	
	private ArrayList<Segment> arr;
	private Point2D PO;
	
	

	public Multisegment(Point2D pOrigine, ArrayList<Segment> arr, Point2D pO) {
		super(pOrigine);
		this.arr = arr;
		PO = pO;
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

}
