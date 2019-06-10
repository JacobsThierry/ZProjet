package Objet_base;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;

public class MultiEllipse extends Objet_de_base{

	

	private ArrayList<Ellipse> arr;
	
	

	public MultiEllipse(Point2D pOrigine, ArrayList<Ellipse> arr) {
		super(pOrigine);
		this.arr = arr;
	}
	
	public MultiEllipse(Point2D pOrigine) {
		super(pOrigine);
		this.arr = new ArrayList<Ellipse>();
	}
	
	public MultiEllipse(Ellipse el) {
		super(el.getPOrigine().dupliquer());
		this.arr = new ArrayList<Ellipse>();
		arr.add(el);
	}

	@Override
	public void deplacer(Vecteur2D v) {
		
		for(int i = 0; i < this.arr.size();i++) {
			arr.get(i).deplacer(v);
		}
		
	}
	
	public void add(Ellipse e) {
		this.arr.add(e);
	}

	@Override
	public boolean isIn(Point2D p) {
		for(int i = 0; i < this.arr.size();i++) {
			if(this.arr.get(i).isIn(p)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public MultiEllipse dupliquer() {
		ArrayList<Ellipse> arr = new ArrayList<Ellipse>();  
		for(int i = 0 ; i < this.arr.size(); i++) {
			arr.add(this.arr.get(i).dupliquer());
		}
		return new MultiEllipse(this.getPOrigine().dupliquer(), arr);
	}

	@Override
	public Objet_Geometrique appliquerVecteur(Vecteur2D v) {
		
		MultiEllipse arra = this.dupliquer();
		arra.deplacer(v);
		return arra;
	}

	@Override
	public DefaultMutableTreeNode getNode() {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Multi-Ellipse");
		node.add(this.getPOrigine().getNode("Po"));
		
		for(int i=0; i< this.arr.size(); i++) {
			node.add(arr.get(i).getNode("Ellipse " + (i+1)));
		}
		return node;
		
	}

	public ArrayList<Ellipse> getArr() {
		return arr;
	}

	public void setArr(ArrayList<Ellipse> arr) {
		this.arr = arr;
	}

	@Override
	public void afficher(Graphics g) {
		for(int i = 0; i < this.arr.size(); i++) {
			this.arr.get(i).afficher(g);
		}
		
	}

}
