package Objet_base;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;

public class Multisegment extends Objet_de_base{
	
	private ArrayList<Segment> arr;
	
	

	public Multisegment(Point2D pOrigine, ArrayList<Segment> arr) {
		super(pOrigine);
		this.arr = arr;
	}
	
	public Multisegment(Point2D pOrigine) {
		super(pOrigine);
		this.arr = new ArrayList<Segment>();
	}

	@Override
	public void deplacer(Vecteur2D v) {
		this.getPOrigine().deplacer(v);
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
	public Multisegment dupliquer() {
		ArrayList<Segment> arra = new ArrayList<Segment>();
		for(int i =0; i< arr.size(); i++) {
			arra.add(arr.get(i).dupliquer() );
		}
		return new Multisegment(this.getPOrigine().dupliquer(),arra);
		
	}

	@Override
	public Multisegment appliquerVecteur(Vecteur2D v) {
		Multisegment arra = this.dupliquer();
		arra.deplacer(v);
		return arra;
	}
	
	@Override
	public void afficher(Graphics g) {
		for(int i=0; i<arr.size();i++) {
			arr.get(i).afficher(g);
		}
		
	}

	@Override
	public DefaultMutableTreeNode getNode() {
		// TODO Auto-generated method stub
		return null;
	}

}
