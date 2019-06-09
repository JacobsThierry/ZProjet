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
	
	public MultiRectangle(Rectangle rect) {
		super(rect.getPOrigine().dupliquer());
		this.arr = new ArrayList<Rectangle>();
		arr.add(rect);
	}

	@Override
	public void deplacer(Vecteur2D v) {
		this.getPOrigine().deplacer(v);
		for(int i = 0; i < this.arr.size();i++) {
			arr.get(i).deplacer(v);
		}
		
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
	public MultiRectangle dupliquer() {
		ArrayList<Rectangle> arr = new ArrayList<Rectangle>();  
		for(int i = 0 ; i < this.arr.size(); i++) {
			arr.add(this.arr.get(i).dupliquer());
		}
		return new MultiRectangle(this.getPOrigine().dupliquer(), arr);
	}

	@Override
	public Objet_Geometrique appliquerVecteur(Vecteur2D v) {
		
		MultiRectangle arra = this.dupliquer();
		arra.deplacer(v);
		return arra;
	}

	@Override
	public DefaultMutableTreeNode getNode() {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Multi-Rectangle");
		node.add(this.getPOrigine().getNode("Po"));
		
		for(int i=0; i< this.arr.size(); i++) {
			node.add(arr.get(i).getNode("Rectangle " + (i+1)));
		}
		return node;
		
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
		return "7 "+this.getPOrigine().toString2()+this.getArr().size()+" "+segm;
		
	}
	
	

}
