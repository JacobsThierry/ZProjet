package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import Objet_base.Cercle;
import Objet_base.Ellipse;
import Objet_base.Losange;
import Objet_base.MultiCercle;
import Objet_base.MultiEllipse;
import Objet_base.MultiRectangle;
import Objet_base.Multisegment;
import Objet_base.Quadrangle;
import Objet_base.Rectangle;
import Objet_base.Segment;
import Objet_base.Triangle;
import P2D.Point2D;


public class listn  extends JComponent implements ActionListener {
	
	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
	private Cadre ca;
	String filename;
	private JTextField dir = new JTextField();
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
			ca.updateJTree();
		}
		
		if(source == ca.getB_deplace() ) {
			ca.setMode(0);
			ca.getLabel().setText("Mode: DÃ©placer");
		}
		
		if(source == ca.getB_quadri()) {
			ca.setMode(1);
			ca.getLabel().setText("Mode: QuadrilatÃ¨re");
		}
		
		if(source== ca.getB_rect()) {
			
			ca.setMode(2);
			ca.getLabel().setText("Mode: Rectangle");
		}
		
		if(source == ca.getB_losange()) {
			ca.setMode(3);
			ca.getLabel().setText("Mode: Losange");
		}
		
		if(source==ca.getB_quadrangle()) {
			ca.setMode(4);
			ca.getLabel().setText("Mode: Quadrangle");
		}
		

		
		if(source == ca.getB_segm()) {
			ca.setMode(5);
			ca.getLabel().setText("Mode: Segment");
		}
		
		if(source== ca.getB_triangle()) {
			ca.setMode(6);
			ca.getLabel().setText("Mode: Triangle");
		}
		if(source == ca.getB_multiseg()) {
			ca.setMode(7);
			ca.getLabel().setText("Mode: Multisegment");
			
		}
		if(source == ca.getB_cercle()) {
			ca.setMode(8);
			ca.getLabel().setText("Mode: Cercle");
		}
		if(source==ca.getB_arcdec()) {
			ca.setMode(9);
			ca.getLabel().setText("Mode: Arc");
		}
		if(source==ca.getB_elipse()) {
			ca.setMode(10);
			ca.getLabel().setText("Mode: Elipse");
		}
		if(source == ca.getB_multicercle()) {
			ca.setMode(11);
			ca.getLabel().setText("Mode: MultiCercle");
		}
		if(source == ca.getB_multielipse()) {
			ca.setMode(12);
			ca.getLabel().setText("Mode: MultiElipse");
		}
		
		if(source == ca.getB_multirectangle()) {
			ca.setMode(13);
			ca.getLabel().setText("Mode: Multirectangle");
			
		}
		
		if(source==ca.getB_poin() ) {
			ca.setMode(14);
			ca.getLabel().setText("Mode: Point");
		}


		
		if(source==ca.getB_delete()) {
			ca.getLabel().setText("Mode: ");
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
		ca.getLabel().setText("Mode: ");
			JFileChooser c = new JFileChooser();
	      // Demonstrate "Save" dialog:
			 FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        ".txt",  "txt");
			 c.setFileFilter(filter);
	      int rVal = c.showSaveDialog(getParent());
	      if (rVal == JFileChooser.APPROVE_OPTION) {
	        filename = c.getSelectedFile().getAbsolutePath();
	        dir.setText(c.getCurrentDirectory().toString());
	      }
	     
	      filename=filename+".txt";
     	 File save  = new File(filename);
     	 try{
     		 save.createNewFile();
     	 }
     	 catch(IOException e1)
     	 {
     		 e1.printStackTrace();
     	 }

	        try
	        {
	            printWriter = new PrintWriter(filename);
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
		
		      
		
		if(source==ca.getB_charge()) {
			ca.getLabel().setText("Mode: ");
			ArrayList<Rectangle> arr2 = new ArrayList<Rectangle>();
			ArrayList<Segment> arr = new ArrayList<Segment>();
			ArrayList<Ellipse> arr3 = new ArrayList<Ellipse>();
			ArrayList<Cercle> arr4 = new ArrayList<Cercle>();
			 try
		        {
				 
				JFileChooser chooser = new JFileChooser();
				 FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        ".txt",  "txt");
				 chooser.setFileFilter(filter);
				    int returnVal = chooser.showOpenDialog(getParent()); 
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				       System.out.println("Fichier charge : " +
				            chooser.getSelectedFile().getName());
				    }
			 file =chooser.getSelectedFile();
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
			if(id==7){	       
		        	
		        	Point2D POrigin = new Point2D(sc.nextInt(),sc.nextInt());
		        	int v=sc.nextInt();
		        	for(int i=0;i<v;i++){
		        			arr.add(new Segment(new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt())));}
		        	 ca.getArr().add(new Multisegment(POrigin,arr));
				 }
		        
			
	        
		         if(id==8) {
		        	 ca.getArr().add(new Cercle(new Point2D(sc.nextInt(),sc.nextInt()),sc.nextInt()));
		         }
		         if(id==10) {
		        	 ca.getArr().add(new Ellipse(new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt())));
		         }
		         if(id==11){	       
			        	
			        	Point2D POrigin = new Point2D(sc.nextInt(),sc.nextInt());
			        	int v=sc.nextInt();
			        	for(int i=0;i<v;i++){
			        			arr4.add(new Cercle(new Point2D(sc.nextInt(),sc.nextInt()),sc.nextInt()));}
			        	 ca.getArr().add(new MultiCercle(POrigin,arr4));
					 }
		         
		         if(id==12){	       
			        	
			        	 Point2D POrigin = new Point2D(sc.nextInt(),sc.nextInt());
				        	int v=sc.nextInt();
				        	for(int i=0;i<v;i++){
				        			arr3.add(new Ellipse(new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt())));}
				        	 ca.getArr().add(new MultiEllipse(POrigin));
					 }
		         if(id==13){	       
			        	
		        		Point2D POrigin = new Point2D(sc.nextInt(),sc.nextInt());
			        	int v=sc.nextInt();
			        	for(int i=0;i<v;i++){
			        			arr2.add(new Rectangle(new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt())));}
			        	 ca.getArr().add(new MultiRectangle(POrigin,arr2));
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
	
