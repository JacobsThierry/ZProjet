package Objet_base;

import java.awt.Graphics;
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
		PO.deplacer(v);
		for(int i=0;i<arr.size();i++) {
			arr.get(i).deplacer(v);
		}
		
	}

	@Override
	public boolean isIn(Point2D p) {
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i).isIn(p)) {
				return true;
			}
		}
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
	public void afficher(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
