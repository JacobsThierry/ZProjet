package Objet_base;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;

public class MultiCercle extends Objet_de_base{

	

	private ArrayList<Cercle> arr;
	
	

	public MultiCercle(Point2D pOrigine, ArrayList<Cercle> arr) {
		super(pOrigine);
		this.arr = arr;
	}
	
	public MultiCercle(Point2D pOrigine) {
		super(pOrigine);
		this.arr = new ArrayList<Cercle>();
	}
	
	public MultiCercle(Cercle el) {
		super(el.getPOrigine().dupliquer());
		this.arr = new ArrayList<Cercle>();
		arr.add(el);
	}

	@Override
	public void deplacer(Vecteur2D v) {
		
		for(int i = 0; i < this.arr.size();i++) {
			arr.get(i).deplacer(v);
		}
		
	}
	
	public void add(Cercle e) {
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
	public MultiCercle dupliquer() {
		ArrayList<Cercle> arr = new ArrayList<Cercle>();  
		for(int i = 0 ; i < this.arr.size(); i++) {
			arr.add(this.arr.get(i).dupliquer());
		}
		return new MultiCercle(this.getPOrigine().dupliquer(), arr);
	}

	@Override
	public Objet_Geometrique appliquerVecteur(Vecteur2D v) {
		
		MultiCercle arra = this.dupliquer();
		arra.deplacer(v);
		return arra;
	}

	@Override
	public DefaultMutableTreeNode getNode() {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Multi-Cercle");
		node.add(this.getPOrigine().getNode("Po"));
		
		for(int i=0; i< this.arr.size(); i++) {
			node.add(arr.get(i).getNode("Cercle " + (i+1)));
		}
		return node;
		
	}

	public ArrayList<Cercle> getArr() {
		return arr;
	}

	public void setArr(ArrayList<Cercle> arr) {
		this.arr = arr;
	}

	@Override
	public void afficher(Graphics g) {
		for(int i = 0; i < this.arr.size(); i++) {
			this.arr.get(i).afficher(g);
		}
		
	}
	public String toString(){
		String segm="";
		for(int i=0;i<arr.size();i++){
			segm=segm+arr.get(i).toString2();
		}
		return "11 "+this.getPOrigine().toString2()+this.getArr().size()+" "+segm;
		
	}
}
