package Interface;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;

import Objet_base.Cercle;
import Objet_base.Objet_Geometrique;
import P2D.Point2D;
import P2D.Vecteur2D;

public class Cadre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//on place les boutons
	private JButton b_deplace; //0
	private JButton b_quadri; //1
	private JButton b_rect; //2
	private JButton b_losange; //3
	private JButton b_quadrangle; //4 
	private JButton b_segm; //5
	private JButton b_triangle; //6
	private JButton b_multiseg; //7
	private JButton b_cercle; //8
	private JButton b_arcdec; //9
	private JButton b_elipse; //10
	private JButton b_multicercle; //11
	private JButton b_multielipse; //12
	private JButton b_multirectangle; //13
	private JButton b_poin; //14
	private JButton b_delet;
	
	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JSlider js1;
	private JSlider js2;
	private JSlider js3;
	
	private Sourie list;
	
	private ActionListener lis;
	
	private JPanel panbtn;
	private JPanel panslider;
	private JPanel pantree;
	
	private int index;
	
	private int mode; //mode qui permet de changer la forme que l'on place. Le num�ro du mode correspond au num�ro des boutons au dessus

	private ArrayList<Objet_Geometrique> arr;
	
	private ArrayList<Objet_Geometrique> preview;
	
	private JTree monArbre1;
	
	private JScrollPane Scrollp;
	

	
	
public Cadre() {	
	super("cadre");
	this.preview = new ArrayList<Objet_Geometrique>();
	
	lis = new listn(this);	
	list = new Sourie(this);
	mode=0;
	
	arr = new ArrayList<Objet_Geometrique>();
	
	
	
	
	panbtn = new JPanel();
	panbtn.setPreferredSize(new Dimension(200,170));
	panbtn.setBackground(Color.MAGENTA);
	panbtn.setLayout(new FlowLayout());
	
	
	
	b_deplace =  new JButton("Deplacer une forme");
	b_quadri = new JButton("Quadrilat�re");
	b_rect = new JButton("Rectangle");
	b_losange = new JButton("Losange");
	b_quadrangle = new JButton("Quadrangle");
	b_segm = new JButton("Segment");
	b_triangle= new JButton("Triangle");
	b_multiseg= new JButton("Multisegment");
	b_cercle= new JButton("Cercle");
	b_arcdec= new JButton("Arc de cercle");
	b_elipse= new JButton("Elipse");
	b_multicercle= new JButton("Multicercle");
	b_multielipse= new JButton("Multielipse");
	b_multirectangle= new JButton("Multirectangle");
	b_poin = new JButton("Point");
	this.b_delet = new JButton("Supprimer");
	
	b_deplace.setToolTipText("Utilisez cette outil pour d�placer une forme. Cliquer sur une ou plusieurs forme, d�placez la souris, relevez le clic !");
	b_deplace.addActionListener(lis);
	panbtn.add(b_deplace);
	b_quadri.addActionListener(lis);
	b_quadri.setToolTipText("Utilisez cette outil pour cr�e un quadrilat�re. Cliquez 4 fois pour placer les 4 points du quadrilat�re !");
	panbtn.add(b_quadri);
	b_rect.addActionListener(lis);
	panbtn.add(b_rect);
	b_losange.addActionListener(lis);
	b_losange.setToolTipText("Utilisez cette outil pour cr�e un losange. Cliquez 2 fois pour placer la premi�re diagonale, puis recliquer pour choisir la longueur de la seconde diagonale.");
	panbtn.add(b_losange);
	b_quadrangle.setToolTipText("Utilisez cette outil pour cr�e un quadrangle. Commencez par tracer un cercle, puis placez 4 points sur le cercle pour cr�e un quadrangle.");
	b_quadrangle.addActionListener(lis);
	panbtn.add(b_quadrangle);
	b_segm.setToolTipText("Utilisez cette outil pour cr�e un segment. Cliquer simplement aux extremit�s du segment.");
	b_segm.addActionListener(lis);
	panbtn.add(b_segm);
	b_triangle.setToolTipText("Utilisez cette outil pour cr�e un triangle. CLiquer 3 fois a l'emplacement des 3 points du triangle pour le cr�e.");
	b_triangle.addActionListener(lis);
	panbtn.add(b_triangle);
	b_multiseg.addActionListener(lis);
	panbtn.add(b_multiseg);
	b_cercle.addActionListener(lis);
	b_cercle.setToolTipText("Utilisez cette outil pour cr�e un cercle. Cliquer en son centre, puis d�placer la souris pour choisir son rayon. Enfin, cliquer une deuxi�me fois pour finaliser le cercle.");
	panbtn.add(b_cercle);
	b_arcdec.addActionListener(lis);
	panbtn.add(b_arcdec);
	b_elipse.addActionListener(lis);
	panbtn.add(b_elipse);
	b_multicercle.addActionListener(lis);
	panbtn.add(b_multicercle);
	b_multielipse.addActionListener(lis);
	panbtn.add(b_multielipse);
	b_multirectangle.addActionListener(lis);
	panbtn.add(b_multirectangle);
	b_poin.setToolTipText("Utilisez cette outil pour placer des points. Cliquez simplement la ou vous voulez placer un point !");
	b_poin.addActionListener(lis);
	panbtn.add(b_poin);
	b_delet.setToolTipText("Supprimez toute les formes en clicant sur ce bouton !");
	panbtn.add(this.b_delet);
	this.b_delet.addActionListener(lis);
	
	
	
	Hashtable<Integer, JLabel> tablelabel = new Hashtable<Integer, JLabel>();
	tablelabel.put(new Integer(1), new JLabel("1"));
	
	for(int i=10;i<=100;i+=10) {
		tablelabel.put(new Integer(i), new JLabel(new Integer(i).toString()));
	}
	
	Hashtable<Integer, JLabel> tablelabel2 = new Hashtable<Integer, JLabel>();
	
	for(int i=0;i<=360;i+=60) {
		tablelabel2.put(new Integer(i), new JLabel(new Integer(i).toString()));
	}
	
	
	js1 = new JSlider(JSlider.HORIZONTAL ,1, 100, 15);
	js1.setPaintTicks(true);
	js1.setLabelTable(tablelabel);
	js1.setMajorTickSpacing(5);
	js1.setPaintLabels(true);
	
	js2 = new JSlider(JSlider.HORIZONTAL ,1, 100, 15);
	js2.setPaintTicks(true);
	js2.setLabelTable(tablelabel);
	js2.setMajorTickSpacing(5);
	js2.setPaintLabels(true);
	
	js3 = new JSlider(JSlider.HORIZONTAL ,0, 360, 15);
	js3.setPaintTicks(true);
	js3.setLabelTable(tablelabel2);
	js3.setMajorTickSpacing(15);
	js3.setPaintLabels(true);
	
	panslider = new JPanel();
	panslider.setLayout(new GridLayout(0,3));
	
	l1 = new JLabel("Longueur", SwingConstants.CENTER);
	l2 = new JLabel("Largeur", SwingConstants.CENTER);
	l3 = new JLabel("Angle", SwingConstants.CENTER); //TODO : gerer les angles
	
	panslider.add(l1);
	panslider.add(l2);
	panslider.add(l3);
	panslider.add(js1);
	panslider.add(js2);
	panslider.add(js3);
	
	panbtn.add(panslider);
	
	
	this.setLayout(new BorderLayout());
	this.add(panbtn, BorderLayout.NORTH);
	
	pantree = new JPanel();
	pantree.setPreferredSize(new Dimension(200,200));
	
	DefaultMutableTreeNode racine1 = new DefaultMutableTreeNode("Canevas");
	
	this.add(pantree, BorderLayout.EAST);
	

	monArbre1 = new JTree(racine1);
	monArbre1.setPreferredSize(new Dimension(180,9999));
	
	Scrollp = new JScrollPane(monArbre1);
	
	
	pantree.add(Scrollp);
	
	
	
	
	this.addMouseListener(list);
	this.addMouseMotionListener(list);
	
	
	

	

	
	this.setSize(800, 600);
	
	
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	

	
}


public void updateJTree() {
	
	

		this.pantree.remove(Scrollp);

	
	DefaultMutableTreeNode racine1 = new DefaultMutableTreeNode("Canevas");
	
	
	for(int i =0; i< arr.size(); i++) {
		racine1.add(arr.get(i).getNode());
	}

	monArbre1 = new JTree(racine1);
	monArbre1.setPreferredSize(new Dimension(pantree.getWidth()- 20,pantree.getHeight()));
	
	for(int i=0; i< monArbre1.getRowCount();i++) {
		monArbre1.expandRow(i);
	}
	
	Scrollp = new JScrollPane(monArbre1);
	
	pantree.add(Scrollp);
	
		
	
	
}



public JButton getB_delet() {
	return b_delet;
}






public void setB_delet(JButton b_delet) {
	this.b_delet = b_delet;
}






public JLabel getL3() {
	return l3;
}

public void addforme(Objet_Geometrique o1) {
	this.arr.add(o1);
	this.updateJTree();
}




public void setL3(JLabel l3) {
	this.l3 = l3;
}






public JSlider getJs3() {
	return js3;
}






public void setJs3(JSlider js3) {
	this.js3 = js3;
}






public JLabel getL1() {
	return l1;
}




public void setL1(JLabel l1) {
	this.l1 = l1;
}




public JSlider getJs1() {
	return js1;
}

public int getJs1val() {
	return js1.getValue();
}


public void setJs1(JSlider js1) {
	this.js1 = js1;
}




public JLabel getL2() {
	return l2;
}




public void setL2(JLabel l2) {
	this.l2 = l2;
}




public JSlider getJs2() {
	return js2;
}

public int getJs2val() {
	return js2.getValue();
}


public void setJs2(JSlider js2) {
	this.js2 = js2;
}




public Sourie getList() {
	return list;
}




public void setList(Sourie list) {
	this.list = list;
}




public JPanel getPanslider() {
	return panslider;
}




public void setPanslider(JPanel panslider) {
	this.panslider = panslider;
}




public void paint(Graphics g) {
	super.paintComponents(g);
	g.setColor(Color.GRAY);
	int i;
	
	
	for(i=0 ; i<this.preview.size(); i++) {
		if(this.preview.get(i) != null) {
			this.preview.get(i).afficher(g);			
		}
	}
	
	g.setColor(Color.black);
	
	for(i=0; i<arr.size();i++) {
		arr.get(i).afficher(g);
	}
	
	
}






public ArrayList<Objet_Geometrique> getPreview() {
	return preview;
}






public void setPreview(ArrayList<Objet_Geometrique> preview) {
	this.preview = preview;
}

public void cleanPreview() {
	this.preview.clear();
	this.preview.add(new Point2D());
}

public void deplacerPreview(Vecteur2D v) {
	for(int i =0; i< this.preview.size(); i++) {
		this.preview.get(i).deplacer(v);
	}
}



public JButton getB_deplace() {
	return b_deplace;
}




public void setB_deplace(JButton b_deplace) {
	this.b_deplace = b_deplace;
}




public JButton getB_quadri() {
	return b_quadri;
}




public void setB_quadri(JButton b_quadri) {
	this.b_quadri = b_quadri;
}




public JButton getB_rect() {
	return b_rect;
}




public void setB_rect(JButton b_rect) {
	this.b_rect = b_rect;
}




public JButton getB_losange() {
	return b_losange;
}




public void setB_losange(JButton b_losange) {
	this.b_losange = b_losange;
}




public JButton getB_quadrangle() {
	return b_quadrangle;
}




public void setB_quadrangle(JButton b_quadrangle) {
	this.b_quadrangle = b_quadrangle;
}




public JButton getB_segm() {
	return b_segm;
}




public void setB_segm(JButton b_segm) {
	this.b_segm = b_segm;
}




public JButton getB_triangle() {
	return b_triangle;
}




public void setB_triangle(JButton b_triangle) {
	this.b_triangle = b_triangle;
}




public JButton getB_multiseg() {
	return b_multiseg;
}




public void setB_multiseg(JButton b_multiseg) {
	this.b_multiseg = b_multiseg;
}




public JButton getB_cercle() {
	return b_cercle;
}




public void setB_cercle(JButton b_cercle) {
	this.b_cercle = b_cercle;
}




public JButton getB_arcdec() {
	return b_arcdec;
}




public void setB_arcdec(JButton b_arcdec) {
	this.b_arcdec = b_arcdec;
}




public JButton getB_elipse() {
	return b_elipse;
}




public void setB_elipse(JButton b_elipse) {
	this.b_elipse = b_elipse;
}




public JButton getB_multicercle() {
	return b_multicercle;
}




public void setB_multicercle(JButton b_multicercle) {
	this.b_multicercle = b_multicercle;
}




public JButton getB_multielipse() {
	return b_multielipse;
}




public void setB_multielipse(JButton b_multielipse) {
	this.b_multielipse = b_multielipse;
}




public JButton getB_multirectangle() {
	return b_multirectangle;
}




public void setB_multirectangle(JButton b_multirectangle) {
	this.b_multirectangle = b_multirectangle;
}




public JButton getB_poin() {
	return b_poin;
}




public void setB_poin(JButton b_poin) {
	this.b_poin = b_poin;
}




public ActionListener getLis() {
	return lis;
}




public void setLis(ActionListener lis) {
	this.lis = lis;
}




public JPanel getPanbtn() {
	return panbtn;
}




public void setPanbtn(JPanel panbtn) {
	this.panbtn = panbtn;
}




public int getIndex() {
	return index;
}




public void setIndex(int index) {
	this.index = index;
}




public int getMode() {
	return mode;
}




public void setMode(int mode) {
	this.mode = mode;
}




public ArrayList<Objet_Geometrique> getArr() {
	return arr;
}




public void setArr(ArrayList<Objet_Geometrique> arr) {
	this.arr = arr;
}




public static long getSerialversionuid() {
	return serialVersionUID;
}










}
