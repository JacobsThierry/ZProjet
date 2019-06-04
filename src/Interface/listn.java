package Interface;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import Objet_base.Cercle;
import Objet_base.Losange;
import Objet_base.Quadrangle;
import Objet_base.Rectangle;
import Objet_base.Segment;
import Objet_base.Triangle;
import P2D.Point2D;
import javafx.scene.shape.Ellipse;


public class listn implements ActionListener {
	
	private Cadre ca;
	File file = new File("save.txt");

    PrintWriter printWriter = null;


	public listn(Cadre c) {
		super();
		this.ca = c;
	}

	public Cadre getC() {
		return ca;
	}

	public void setC(Cadre c) {
		this.ca = c;
	}

	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		this.ca.getList().reset();
		if (source == ca.getB_delet()) {
			ca.getArr().clear();
			ca.repaint();
		}
		
		if(source == ca.getB_deplace() ) {
			ca.setMode(0);
		}
		
		if(source == ca.getB_quadri()) {
			ca.setMode(1);
		}
		
		if(source== ca.getB_rect()) {
			
			ca.setMode(2);
		}
		
		if(source==ca.getB_quadrangle()) {
			ca.setMode(4);
		}
		
		if(source == ca.getB_losange()) {
			ca.setMode(3);
		}
		
		if(source == ca.getB_segm()) {
			ca.setMode(5);
		}
		
		if(source== ca.getB_triangle()) {
			ca.setMode(6);
		}
		if(source == ca.getB_cercle()) {
			ca.setMode(8);
		}
		
		if(source==ca.getB_poin() ) {
			ca.setMode(14);
		}
		if(source==ca.getB_arcdec()) {
			ca.setMode(9);
		}
		if(source==ca.getB_elipse()) {
			ca.setMode(10);
		}
		
		if(source==ca.getB_delete()) {
			DefaultTreeModel model=(DefaultTreeModel) ca.getMonArbre1().getModel();
			TreePath[] paths= ca.getMonArbre1().getSelectionPaths();
		      if (paths != null) {
                  for (TreePath path : paths) {
                      DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                      DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) ca.getMonArbre1().getModel().getRoot();
                      if(node.getParent()==node.getRoot()) {
                    	  int id = ca.getMonArbre1().getModel().getIndexOfChild(node1, node);
                    		ca.getArr().remove(id);
                    		model.removeNodeFromParent(node);
                
                      ca.repaint();
                  }
              }
          }
		}
		if(source==ca.getB_save()) {
		

	        try
	        {
	            printWriter = new PrintWriter(file);
	           for(int i=0;i<ca.getArr().size();i++) {
	        	   printWriter.println(ca.getArr().get(i));
	           }
	        }
	        catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            if ( printWriter != null ) 
	            {
	                printWriter.close();
	            }
	        }
		
		
		}
		if(source==ca.getB_delete()) {
			DefaultTreeModel model=(DefaultTreeModel) ca.getMonArbre1().getModel();
			TreePath[] paths= ca.getMonArbre1().getSelectionPaths();
		      if (paths != null) {
                  for (TreePath path : paths) {
                      DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                      DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) ca.getMonArbre1().getModel().getRoot();
                      if(node.getParent()==node.getRoot()) {
                    	  int id = ca.getMonArbre1().getModel().getIndexOfChild(node1, node);
                    		ca.getArr().remove(id);
                    		model.removeNodeFromParent(node);
                
                      ca.repaint();
                  }
              }
		      }
		}
		if(source==ca.getB_charge()) {
			System.out.println("defef");
			 try
		        {
				 Scanner sc=new Scanner(file);
				 while(sc.hasNextInt()) {
		         int id = sc.nextInt();
		    
		         if(id==2) {		        	 
		        	 ca.getArr().add(new Rectangle(new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt())));
		         }
		         if(id==3) {
		        	 ca.getArr().add(new Losange(new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt())));
		         }
		         if(id==4) {
		        	 ca.getArr().add(new Quadrangle(new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),sc.nextInt()));
		         }
		         if(id==5) {
		        	 ca.getArr().add(new Segment(new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt())));
		         }
		         if(id==6) {
		        	 ca.getArr().add(new Triangle(new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt())) );
		         }
		         if(id==8) {
		        	 ca.getArr().add(new Cercle(new Point2D(sc.nextInt(),sc.nextInt()),sc.nextInt()));
		         }
		         if(id==10) {
		        	 //ca.getArr().add(new Ellipse(new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),sc.nextInt()));
		         }
		         if(id==14) {
		        	 ca.getArr().add(new Point2D(sc.nextInt(),sc.nextInt()));
		         }
		        }
				 }
			 catch (FileNotFoundException e)
		        {
		            e.printStackTrace();
		        }
		        finally
		        {
		            if ( printWriter != null ) 
		            {
		                printWriter.close();
		            }
		        }
			 ca.repaint();
			 ca.updateJTree();
			

	
}
	}
	



		}
	

