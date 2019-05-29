package Interface;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listn implements ActionListener {

	private Cadre ca;



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
}
	
}
