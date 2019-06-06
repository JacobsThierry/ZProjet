package Interface;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import Objet_base.Arc;
import Objet_base.Cercle;
import Objet_base.Ellipse;
import Objet_base.Losange;
import Objet_base.Multisegment;
import Objet_base.Objet_Geometrique;
import Objet_base.Objet_de_base;
import Objet_base.Rectangle;
import Objet_base.Segment;
import Objet_base.Triangle;
import P2D.Point2D;
import P2D.Vecteur2D;

public class Sourie  implements MouseListener, MouseMotionListener, KeyListener{

	private Cadre ca;
	private Point2D POrigin;
	private Point2D PExtremite;
	private Point2D P1;
	private Point2D P2;
	private boolean a=true;
	private Point2D PC;
	private int haut;
	private int larg;
	private int mode;
	private double angle;
	private boolean test;
	private boolean boo;
	private Multisegment ms;
	private Multisegment ms2;
	
	private ArrayList<Objet_Geometrique> arrabouger;

	public Sourie(Cadre ca) {
		super();
		this.ca = ca;
		arrabouger = new ArrayList<Objet_Geometrique>();
		this.mode = 0;
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
	public void mousePressed(MouseEvent m) { // a chaque clic aillant un effet, on incremente this.mode
		int x = m.getX();
		int y = m.getY();
		
		arrabouger = new ArrayList<Objet_Geometrique>();
				
		if(m.getY() >= ca.getPanbtn().getHeight() * 1.3) {
		
		if(ca.getMode()==0) {
			this.reset();
			this.POrigin = new Point2D(m.getX(), m.getY());
			for(int i=0;i<ca.getArr().size();i++) {
				if(ca.getArr().get(i).isIn(new Point2D(x, y))) {
					this.arrabouger.add(ca.getArr().get(i));
					ca.getPreview().add(ca.getArr().get(i).dupliquer());
					
				}
				
			
			}
			}
			if(ca.getMode() == 5 || ca.getMode() == 8) { //on pose des points a la main si c'est un triangle ou un quadrilatÃ¨re
				if(this.mode == 0) {
					this.POrigin = new Point2D(m.getX(), m.getY());
					this.PExtremite = new Point2D(m.getX(), m.getY());
					this.mode = 1;}
				else if(this.mode == 1) {
					ca.addforme(ca.getPreview().get(0));
					
					this.mode = 0;
					this.POrigin = new Point2D(m.getX(), m.getY());
					this.PExtremite = new Point2D(m.getX(), m.getY());
					
					
				}

			}
			
			if(ca.getMode()==2 || ca.getMode() == 10) {
				if(this.mode == 0) {
					this.POrigin = new Point2D(m.getX(), m.getY());
					this.mode++;
				}
				else if(this.mode==1) {
					this.P1 = new Point2D(m.getX(), m.getY());
					this.mode++;
				}
				else if(this.mode == 2) {
					ca.getArr().add(ca.getPreview().get(0) );
					ca.updateJTree();
					this.reset();
				}
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
					ca.addforme((ca.getPreview().get(0)));
					this.reset();
				}
			}
			if(ca.getMode()==4){
				if(this.mode == 0) {
					this.POrigin = new Point2D(m.getX(), m.getY());
					this.PC=this.POrigin;
					this.PExtremite = new Point2D(m.getX(), m.getY());
					this.mode = 1;
					}
				
				else if(this.mode == 1) {
					this.POrigin = new Point2D(m.getX(), m.getY());
					this.mode = 2;
					
				}
				else if(this.mode == 2) {
					
					if ((Objet_de_base.dist(new Point2D(m.getX(), m.getY()),this.PC)<(int) Objet_de_base.dist(this.PC, this.POrigin)+5) && (Objet_de_base.dist(new Point2D(m.getX(), m.getY()),this.PC)>(int) Objet_de_base.dist(this.PC, this.POrigin)-5)){
					this.P1 = new Point2D(m.getX(), m.getY());
					this.mode = 3;}
					
				}
				else if(this.mode == 3) {

					if ((Objet_de_base.dist(new Point2D(m.getX(), m.getY()),this.PC)<(int) Objet_de_base.dist(this.PC, this.P1)+5) && (Objet_de_base.dist(new Point2D(m.getX(), m.getY()),this.PC)>(int) Objet_de_base.dist(this.PC, this.POrigin)-5)){
					this.P2 = new Point2D(m.getX(), m.getY());
					this.mode = 4;
					}

				}
				else if(this.mode == 4) {
					
					if ((Objet_de_base.dist(new Point2D(m.getX(), m.getY()),this.PC)<(int) Objet_de_base.dist(this.PC, this.P1)+5) && (Objet_de_base.dist(new Point2D(m.getX(), m.getY()),this.PC)>(int) Objet_de_base.dist(this.PC, this.POrigin)-5)){
					ca.getArr().add(ca.getPreview().get(1));
					this.reset();}
					
				}
				else if(this.mode == 5) {
					this.PExtremite = new Point2D(m.getX(), m.getY());
					this.mode = 4;
					
				}
			}
			
			if(ca.getMode() == 7) {
				
				if(this.mode == 0) {
					this.POrigin = new Point2D(m.getX(), m.getY());
					this.mode++;
				}else if(this.mode == 1) {
					System.out.println(boo);
					if(boo) {
						if(ms.estUneExtremite(this.POrigin)) {
							ms.add(new Segment(ms.getExtremite(this.POrigin), new Point2D(m.getX(), m.getY())));
						}else {
							ms.add(new Segment((this.POrigin), ms.getExtremite(new Point2D(m.getX(), m.getY()))));
						}
					}
					else {
						ca.getArr().add(ca.getPreview().get(0));
					}
					this.reset();
					ca.updateJTree();
					}
			}


				if(ca.getMode()==9) {
						if(this.mode == 0) {
				
							this.mode++;
						}
						else if(this.mode == 1) {
							this.POrigin = new Point2D(m.getX(), m.getY());
							this.mode = 2;
							
						}
						else if(this.mode == 2) {
							ca.addforme((ca.getPreview().get(0)));
							this.reset();
						}
						
					}
				if(ca.getMode() == 1 || ca.getMode() == 6) { // si on fais un quadrilatÃ¨re ou un triangle, on affiche un segment quand on a 2 points, un triangle quand on en a 3
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
				ca.addforme(ca.getPreview().get(0));
			}
		
		ca.repaint();
		
	}}
	
	@Override
	public void mouseReleased(MouseEvent m) {
		
		if(ca.getMode()==0) {
			for(int i=0;i < this.arrabouger.size() ; i++) {
				this.arrabouger.get(i).deplacer(new Vecteur2D(this.POrigin, new Point2D(m.getX(), m.getY())));
			}			
			ca.cleanPreview();
			ca.updateJTree();
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
			
		if(ca.getMode()==2 || ca.getMode() == 10) {
			if(this.mode == 1) {
				ca.getPreview().set(0, new Segment(this.POrigin, new Point2D(m.getX(), m.getY())));
			}
			else if(this.mode == 2 && ca.getMode() == 2) {
				int dist = new Triangle(this.POrigin, this.P1, new Point2D(m.getX(), m.getY())).getHauteur(); //les distances et hauteur sont en valeur absolue. On cherche donc a savoir de quel côté on doit dessiné le rectangle. On crée donc 2 rectangle allant dans les 2 senses, et on garde celui dont le centre du côté est le plus proche de la sourie.
				Rectangle rect = new Rectangle(new Segment(this.POrigin, this.P1) , dist, ((new Segment(this.POrigin, this.P1).getAngle())));
				Rectangle rect2 = new Rectangle(new Segment(this.POrigin, this.P1) , -dist, ((new Segment(this.POrigin, this.P1).getAngle())));
				
				if(Objet_de_base.dist((new Segment(rect.getP3() , rect.getP2()).getMilieux()), (new Point2D(m.getX(), m.getY()))) >
				Objet_de_base.dist((new Segment(rect2.getP3() , rect2.getP2()).getMilieux() ), new Point2D(m.getX(), m.getY()))) {
					ca.getPreview().set(0,rect2);
				}else {
					ca.getPreview().set(0, rect);
				}
								
				
			}else if(this.mode == 2 && ca.getMode() == 10) {
				ca.getPreview().set(0, new Ellipse(new Segment(this.POrigin, this.P1) , (new Triangle(this.POrigin, this.P1, new Point2D(m.getX(), m.getY())) ).getHauteur(), ((new Segment(this.POrigin, this.P1).getAngle())) ));
			}
			
			
			
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
				
				
				
				ca.getPreview().set(0, new Losange(seg, Objet_de_base.dist(seg.getMilieux(), new Point2D(m.getX(), m.getY()))*2 ));

			}
			
			
		}
		
		if(ca.getMode()==4) {

			this.PExtremite.setX(m.getX());
			this.PExtremite.setY(m.getY());
			if (this.mode==1){
				ca.getPreview().set(0,new Cercle(new Point2D(POrigin.getX(), POrigin.getY()), (int) Objet_de_base.dist(this.POrigin, this.PExtremite)));
				
			
			}

			
		 if(this.mode==2) {
	
			 
			if(a){
						ca.getPreview().add(1,new Segment(this.POrigin, new Point2D(m.getX(), m.getY())));
						a=false;}
				
					ca.getPreview().set(1,new Segment(this.POrigin, new Point2D(m.getX(), m.getY())));
		
			}			
			else if(this.mode==3) {
				ca.getPreview().set(1, new Triangle(this.POrigin, this.P1, new Point2D(m.getX(), m.getY())));
		}
			else if(this.mode==4){
				ca.getPreview().set(1,new Rectangle(this.POrigin, this.P1, new Point2D(m.getX(), m.getY()), this.P2));
				
			}
			
		}
		
		
		if(ca.getMode()==5 && this.mode == 1) {
			this.PExtremite.setX(m.getX());
			this.PExtremite.setY(m.getY());
			ca.getPreview().set(0,new Segment(this.POrigin, this.PExtremite));
			
			
		}
		
		if(ca.getMode() == 7 && this.mode == 1) {
			
			boo = false;
			for(int i=0; i< ca.getArr().size();i++) {
				if(ca.getArr().get(i) instanceof Multisegment) {
					ms = (Multisegment) ca.getArr().get(i);
					if(ms.estUneExtremite(new Point2D(m.getX(), m.getY()))) {
						ms2 = ms.dupliquer();
						ms2.add(new Segment(this.POrigin, ms2.getExtremite((new Point2D(m.getX(), m.getY())))));
						ca.getPreview().set(0, ms2);
						boo = true;
						break;
					} else if( ms.estUneExtremite(this.POrigin)) {
						Multisegment ms2 = ms.dupliquer();
						ms2.add(new Segment(ms2.getExtremite(this.POrigin), (new Point2D(m.getX(), m.getY()))));

						ca.getPreview().set(0, ms2);
						boo = true;
						break;
						
						
					}
				}
			}
			if(!boo) {
				
				ca.getPreview().set(0, new Multisegment(new Segment(this.POrigin, new Point2D(m.getX(), m.getY())) ) );
			
			}
			ca.repaint();
			
			
		}
		

		
		if(ca.getMode()==8 && this.mode == 1) {
			this.PExtremite.setX(m.getX());
			this.PExtremite.setY(m.getY());
			ca.getPreview().set(0,new Cercle(new Point2D(POrigin.getX(), POrigin.getY()), (int) Objet_de_base.dist(this.POrigin, this.PExtremite)));
			
			
		}
		
		if(ca.getMode()==14) {
			ca.getPreview().set(0,new Point2D(m.getX(), m.getY()));
			
		}
		
	if(ca.getMode()==9) {
			if(this.mode==1) {
				this.haut=Math.abs(this.POrigin.getY()-m.getY());
				this.larg=Math.abs(180);
				this.angle=Math.atan2((this.POrigin.getY()-m.getY()), this.POrigin.getX()-m.getX());
				ca.getPreview().set(0, new Arc(this.POrigin,this.haut,this.larg,this.angle));
			}
		}
		
		
		ca.repaint();
		
		
	}
		ca.requestFocusInWindow();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int source = arg0.getKeyCode();
		if(source == KeyEvent.VK_ESCAPE) {
			this.reset();
			ca.repaint();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}
	
	
	
}
	
