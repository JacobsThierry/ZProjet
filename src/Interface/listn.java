package Interface;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import Objet_base.Rectangle;
import Objet_base.Objet_Geometrique;
import P2D.Point2D;


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

	@Override
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
		if(source==ca.getB_charge()) {
			 try
		        {
				 Scanner sc=new Scanner(file);
		         int id = sc.nextInt();
		         if(id==2) {
		        	 
		        	 ca.getArr().add(new Rectangle(new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt()),new Point2D(sc.nextInt(),sc.nextInt())));
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
	

