package Objet_base;
import java.awt.Graphics;

import javax.swing.tree.DefaultMutableTreeNode;

import P2D.Point2D;
import P2D.Vecteur2D;

public class Rectangle extends Triangle{
	private Point2D p3;

	public Rectangle(Point2D pOrigine, Point2D p1, Point2D p2, Point2D p3) {
		super(pOrigine, p1, p2);
		this.p3 = p3;
	}
	
	public Rectangle(int x, int y, int longeur, int largeur) {
		super(new Point2D(x,y),new Point2D(x+longeur, y), new Point2D(x, y+largeur));
		p3 = new Point2D(x+longeur, y+largeur);
	}
	
	public Rectangle(int x, int y, int longeur, int largeur, double angle) {
		super((new Point2D(x,y ) ), new Point2D(), new Point2D());
		
		
				
		this.setP1(new Point2D((int)(x + longeur * Math.cos(angle )) , (int) (y + longeur * Math.sin((angle))) ));
		this.setP2(new Point2D((int)(x - largeur * Math.sin(angle)) , (int) (y + largeur * Math.cos(angle))));
						p3 = new Point2D((int) (x + (largeur * (-Math.sin(angle)) + (longeur * Math.cos(angle)))),
								(int) (y + (longeur * (Math.sin((angle))) + (largeur*Math.cos((angle)))) ));
						
	}
	
	public Rectangle(Segment s1, int longueur, double angle ) {
		super(s1.getPOrigine(), s1.getP1(), new Point2D());
		
		if(s1.getPOrigine().getY() < s1.getP1().getY() ) {
			angle = -angle ; //TODO fixe le rectangle quand l'angle est supérieur a pi. Le prob, c'est que l'angle est toujours entre 0 et pi
			System.out.println("x");
		}
			
		
		
		this.setP2( (new Segment(s1.getPOrigine(), angle + (Math.PI/2), longueur*2).getP1() ) );
		p3 = ( new Segment(s1.getP1(), angle + (Math.PI/2), longueur*2 ).getP1() );
		
		
	}

	public Point2D getP3() {
		return p3;
	}

	public void setP3(Point2D p3) {
		this.p3 = p3;
	}
	@Override
	public void afficher(Graphics g) {
		g.drawLine(this.getPOrigine().getX(), this.getPOrigine().getY(), this.getP1().getX(), this.getP1().getY());
		g.drawLine(this.getPOrigine().getX(), this.getPOrigine().getY(), this.getP2().getX(), this.getP2().getY());
		g.drawLine(this.getP3().getX(), this.getP3().getY(), this.getP1().getX(), this.getP1().getY());
		g.drawLine(this.getP3().getX(), this.getP3().getY(), this.getP2().getX(), this.getP2().getY());
	}

	@Override
	public void deplacer(Vecteur2D v) {
		this.setPOrigine( this.getPOrigine().appliquerVecteur(v) );
		this.setP1(this.getP1().appliquerVecteur(v));
		this.setP2(this.getP2().appliquerVecteur(v));
		this.setP3(this.getP3().appliquerVecteur(v));
		
	}
	
	public Rectangle appliquerVecteur(Vecteur2D v) {
		return new Rectangle(this.getPOrigine().appliquerVecteur(v), this.getP1().appliquerVecteur(v), this.getP2().appliquerVecteur(v), this.getP3().appliquerVecteur(v));
	}
	
	@Override
	public boolean isIn(Point2D p) {
				int cmpt=0;
		int x = p.getX();
		int y = p.getY();
		boolean woah1 = true;
		boolean woah2 = true;
		boolean woah3 = true;
		boolean woah4 = true;
		int save=x;
		for(int i=x;i<1920;i++) {
				if((Objet_de_base.dist(this.getPOrigine(),p)+Objet_de_base.dist(this.getP1(),p)==Objet_de_base.dist(this.getPOrigine(),this.getP1())) && woah1) {
					cmpt++;
					woah1 = (1==2);
					
			}
				if((Objet_de_base.dist(this.getPOrigine(),p)+Objet_de_base.dist(this.getP2(),p)==Objet_de_base.dist(this.getPOrigine(),this.getP2())) && woah2) {
					cmpt++;
					woah2 = (1==2);
					
			}
				if((Objet_de_base.dist(this.getP1(),p)+Objet_de_base.dist(this.getP3(),p)==Objet_de_base.dist(this.getP1(),this.getP3())) && woah3) {
					cmpt++;
					woah3 = false;
					
				}
				if((Objet_de_base.dist(this.getP2(),p)+Objet_de_base.dist(this.getP3(),p)==Objet_de_base.dist(this.getP2(),this.getP3())) && woah4) {
					cmpt++;
					woah4 = false;
					
				}

				p.setX(i);
					}
	
			if(cmpt>=2) {
				p.setX(save);
				cmpt=0;
				 woah1 = true;
				 woah2 = true;
				 woah3 = true;
				 woah4 = true;
				for( int i=x;i>=0;i--) {
					
					if((Objet_de_base.dist(this.getPOrigine(),p)+Objet_de_base.dist(this.getP1(),p)==Objet_de_base.dist(this.getPOrigine(),this.getP1())) && woah1) {
						cmpt++;
						woah1 = (1==2);
						
				}
					if((Objet_de_base.dist(this.getPOrigine(),p)+Objet_de_base.dist(this.getP2(),p)==Objet_de_base.dist(this.getPOrigine(),this.getP2())) && woah2) {
						cmpt++;
						woah2 = (1==2);
						
				}
					if((Objet_de_base.dist(this.getP1(),p)+Objet_de_base.dist(this.getP3(),p)==Objet_de_base.dist(this.getP1(),this.getP3())) && woah3) {
						cmpt++;
						woah3 = false;
						
					}
					if((Objet_de_base.dist(this.getP2(),p)+Objet_de_base.dist(this.getP3(),p)==Objet_de_base.dist(this.getP2(),this.getP3())) && woah4) {
						cmpt++;
						woah4 = false;
						
					}
					p.setX(i);
				}
				
			


		}
			return(cmpt==1);
		
	}
	
	public Rectangle dupliquer() { 
		return new Rectangle(this.getPOrigine(), this.getP1(), this.getP2(), this.p3); 
		}
	

@Override
public DefaultMutableTreeNode getNode() {
	DefaultMutableTreeNode node = new DefaultMutableTreeNode("Rectangle");
	node.add(this.getPOrigine().getNode("Po"));
	node.add(this.getP1().getNode("P1"));
	node.add(this.getP2().getNode("P2"));
	node.add(this.getP3().getNode("P3"));
	return node;
	
}

@Override
public DefaultMutableTreeNode getNode(String nom) {
	DefaultMutableTreeNode node = new DefaultMutableTreeNode(nom);
	node.add(this.getPOrigine().getNode("Po"));
	node.add(this.getP1().getNode("P1"));
	node.add(this.getP2().getNode("P2"));
	node.add(this.getP3().getNode("P3"));
	return node;
	
}

@Override
public String toString() {
	return "2 "+this.getPOrigine().getX()+" "+this.getPOrigine().getY()+" "+this.getP1().getX()+" "+this.getP1().getY()+" "+this.getP2().getX()+" "+this.getP2().getY()+" "+this.p3.getX()+" "+this.p3.getY();
}



}
