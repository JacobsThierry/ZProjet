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

	public Multisegment(Segment s) {
		super(s.getPOrigine().dupliquer());
		this.arr = new ArrayList<Segment>();
		this.arr.add(s);
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
	
	public boolean estUneExtremite(Point2D p) {
		for(int i =0 ; i< arr.size();i++) {
			if(arr.get(i).getPOrigine().isIn(p) || arr.get(i).getP1().isIn(p)) {
				return true;
			}
		}
		return false;
	}	
	
public ArrayList<Segment> getArr() {
		return arr;
	}

	public void setArr(ArrayList<Segment> arr) {
		this.arr = arr;
	}

public Point2D getExtremite(Point2D p) {
	for(int i=0; i < arr.size(); i++) {
		if(arr.get(i).getPOrigine().isIn(p)) {
			return arr.get(i).getPOrigine();
		}
		if(arr.get(i).getP1().isIn(p)) {
			return arr.get(i).getP1();
		}
	}
	return new Point2D();
}
	
	@Override
	public Multisegment dupliquer() {
		ArrayList<Segment> arra = new ArrayList<Segment>();
		for(int i =0; i< arr.size(); i++) {
			arra.add(arr.get(i).dupliquer() );
		}
		return new Multisegment(this.getPOrigine().dupliquer(),arra);
		
	}
	
	public void add(Segment s) {
		arr.add(s);
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
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Multi-segment");
		node.add(this.getPOrigine().getNode("Po"));
		
		for(int i=0; i< this.arr.size(); i++) {
			node.add(arr.get(i).getNode("Segment " + (i+1) ));
		}
		return node;		
	}

	
	public DefaultMutableTreeNode getNode(String str) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(str);
		node.add(this.getPOrigine().getNode("Po"));
		
		for(int i=0; i< this.arr.size(); i++) {
			node.add(arr.get(i).getNode("Segment " + i));
		}
		return node;		
	}

}
