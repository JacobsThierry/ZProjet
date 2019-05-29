package Interface;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import Objet_base.Cercle;
import Objet_base.Losange;
import Objet_base.Objet_Geometrique;
import Objet_base.Objet_de_base;
import Objet_base.Rectangle;
import Objet_base.Segment;
import Objet_base.Triangle;
import P2D.Point2D;
import P2D.Vecteur2D;

public class Sourie  implements MouseListener, MouseMotionListener{

	private Cadre ca;
	private Point2D POrigin;
	private Point2D PExtremite;
	private Point2D P1;
	private Point2D P2;
	private int mode;
	private boolean test;
	private ArrayList<Objet_Geometrique> arrabouger;

	public Sourie(Cadre ca) {
		super();
		this.ca = ca;
		arrabouger = new ArrayList<Objet_Geometrique>();
		reset();
		
	}
	
	public void reset(){

		
		this.POrigin = new Point2D();
		this.PExtremite = new Point2D();
		this.mode = 0;
		this.P1 = new Point2D();
		this.P2 = new Point2D();
		arrabouger.clear();
		ca.cleanPreview();
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		
		}
		
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent m) {
		int x = m.getX();
		int y = m.getY();
		arrabouger = new ArrayList<Objet_Geometrique>();
				
		if(m.getY() >= ca.getPanbtn().getHeight() * 1.3) {
		
		if(ca.getMode()==0) {
			this.reset();
			ca.cleanPreview();
			this.POrigin = new Point2D(m.getX(), m.getY());
			for(int i=0;i<ca.getArr().size();i++) {
				if(ca.getArr().get(i).isIn(new Point2D(x, y))) {
					this.arrabouger.add(ca.getArr().get(i));
					ca.getPreview().add(ca.getArr().get(i).dupliquer());
					
				}
				
			
			}
			}
			if(ca.getMode() == 5 || ca.getMode() == 8) { //on pose des points a la main si c'est un triangle ou un quadrilatère
				if(this.mode == 0) {
					this.POrigin = new Point2D(m.getX(), m.getY());
					this.PExtremite = new Point2D(m.getX(), m.getY());
					this.mode = 1;}
				else if(this.mode == 1) {
					ca.getArr().add(ca.getPreview().get(0));
					this.mode = 0;
					this.POrigin = new Point2D(m.getX(), m.getY());
					this.PExtremite = new Point2D(m.getX(), m.getY());
					
					
				}

			}
			
			if(ca.getMode()==2) {
				ca.getArr().add(ca.getPreview().get(0));
			}
			
			if(ca.getMode() == 3) {
				if(this.mode == 0) {
					this.POrigin = new Point2D(m.getX(), m.getY());
					this.mode++;
				}
				else if(this.mode == 1) {
					this.PExtremite = new Point2D(m.getX(), m.getY());
					this.mode++;
				}
				else if(this.mode == 2) {
					ca.getArr().add((ca.getPreview().get(0)));
					this.reset();
				}
			}
			
			if(ca.getMode() == 1 || ca.getMode() == 6) { // si on fais un quadrilatère ou un triangle, on affiche un segment quand on a 2 points, un triangle quand on en a 3
				if(this.mode == 0) {
					this.POrigin = new Point2D(m.getX(), m.getY());
					this.mode = 1;
					
				}
				else if(this.mode == 1) {
					this.PExtremite = new Point2D(m.getX(), m.getY());
					this.mode = 2;
					
				}
				else if(this.mode == 2) {
					this.P1 = new Point2D(m.getX(), m.getY());
					this.mode = 3;
					if(ca.getMode() == 6) {
						ca.getArr().add(ca.getPreview().get(0));
						this.reset();
					}
				}
				else if(this.mode == 3) {
					
					
					ca.getArr().add(ca.getPreview().get(0));
					this.reset();
					
				}
				
				
			}
			if(ca.getMode()==14) {
				ca.getArr().add(ca.getPreview().get(0));
			}
		
		ca.repaint();
		
	}
	}
	@Override
	public void mouseReleased(MouseEvent m) {
		
		if(ca.getMode()==0) {
			for(int i=0;i < this.arrabouger.size() ; i++) {
				this.arrabouger.get(i).deplacer(new Vecteur2D(this.POrigin, new Point2D(m.getX(), m.getY())));
			}			
			ca.cleanPreview();
			ca.repaint();
			
			
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		Objet_Geometrique az;
		if(ca.getMode()==0) {
			
			for(int i = 0; i< this.arrabouger.size(); i++) {
				az = this.arrabouger.get(i).dupliquer();
				az.deplacer(new Vecteur2D(this.POrigin, new Point2D(e.getX(), e.getY())));
				ca.getPreview().set(i, az);
			}
			
			
			if(! this.test) {
			ca.repaint();	  }
		}
		
		
	}

	@Override
	public void mouseMoved(MouseEvent m) {
		
		
		
		
		if((m.getY() >= ca.getPanbtn().getHeight() * 1.3) && ca.getMode() != 0 ) {
			
			
			if(ca.getMode()==1 || ca.getMode()==6) {
				if(this.mode == 1) {
					ca.getPreview().set(0,new Segment(this.POrigin, new Point2D(m.getX(), m.getY())));
			
				}
				else if(this.mode==2) {
					ca.getPreview().set(0, new Triangle(this.POrigin, this.PExtremite, new Point2D(m.getX(), m.getY())));
			
				}
				else if(this.mode==3) {
					ca.getPreview().set(0,new Rectangle(this.POrigin, this.PExtremite, new Point2D(m.getX(), m.getY()), this.P1));
			
				}
			}
			
		if(ca.getMode()==2) {
			ca.getPreview().set(0,new Rectangle(m.getX(), m.getY(), ca.getJs1().getValue(), ca.getJs2().getValue(), ca.getJs3().getValue())); //TODO le rectangle avec des clics
		}
		
		if(ca.getMode() == 3) {
			if (this.mode == 1) {
				

				
				ca.getPreview().set(0,new Segment(this.POrigin, new Point2D(m.getX(), m.getY())));				
			}
			else if(this.mode==2) {
				Segment seg;
				if(this.POrigin.getY() > this.PExtremite.getY()) {
				 seg = new Segment(this.POrigin, this.PExtremite);
				}
				else {
					 seg = new Segment(this.PExtremite,this.POrigin);
				}
				
				
				
				ca.getPreview().set(0, new Losange(seg, Objet_de_base.dist(seg.getMilieux(), new Point2D(m.getX(), m.getY())) ));
			}
		}
		
		
		if(ca.getMode()==5 && this.mode == 1) {
			this.PExtremite.setX(m.getX());
			this.PExtremite.setY(m.getY());
			ca.getPreview().set(0,new Segment(this.POrigin, this.PExtremite));
			
			
		}
		
		if(ca.getMode()==8 && this.mode == 1) {
			this.PExtremite.setX(m.getX());
			this.PExtremite.setY(m.getY());
			ca.getPreview().set(0,new Cercle(new Point2D(POrigin.getX(), POrigin.getY()), (int) Objet_de_base.dist(this.POrigin, this.PExtremite)));
			
			
		}
		
		if(ca.getMode()==14) {
			ca.getPreview().set(0,new Point2D(m.getX(), m.getY()));
		}
		
		
		
		ca.repaint();
		
	}
	}
	
	
	
}
	
