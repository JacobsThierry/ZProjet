package Interface;

import java.io.File;

import java.io.PrintWriter;  
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;

import java.awt.GridLayout;

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


import Objet_base.Objet_Geometrique;
import P2D.Point2D;
import P2D.Vecteur2D;
import java.awt.Font;

public class Cadre extends JFrame{
	/**
	 * 
	 */
	File file = new File("save.txt");
	PrintWriter writer = null;
	
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
	private JButton b_delet; //15
	private JButton b_save;//16
	private JButton b_charge; //17
	private JButton b_delete; //18
	
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
	private JPanel panbtn2;
	private JPanel label1;
	
	private JLabel label;
	
	private int index;
	
	private int mode; //mode qui permet de changer la forme que l'on place. Le numÃƒÂ©ro du mode correspond au numÃƒÂ©ro des boutons au dessus

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

    Font myFont = new Font("Gobold",Font.BOLD, 30);
	
	arr = new ArrayList<Objet_Geometrique>();
	
	label = new JLabel("Mode: ");
	label.setForeground(Color.LIGHT_GRAY);
	label.setFont(myFont);
	
	label1=new JPanel();
	label1.setLayout(new BorderLayout());
	label1.setBackground(Color.GRAY);
	label1.add(label);
	
	panbtn = new JPanel();
	panbtn.setPreferredSize(new Dimension(200,150));
	panbtn.setLayout(new BorderLayout());
	panbtn.setBackground(Color.GRAY);
	
	panbtn2=new JPanel();
	panbtn2.setBackground(Color.GRAY);
	panbtn2.setLayout(new GridLayout(2,3,10,10));
		
	
	b_deplace =  new JButton("Deplacer");
	b_quadri = new JButton("Quadrilatere");
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
	this.b_delet = new JButton("Vider la zone");
	b_save=new JButton("Sauvegarder");
	b_charge = new JButton("Charger");
	b_delete= new JButton("Supprimer l'element");
		b_deplace.setToolTipText("Utilisez cette outil pour déplacer une forme. Cliquer sur une ou plusieurs forme, déplacez la souris, relevez le clic !");
	b_deplace.addActionListener(lis);
    b_deplace.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_deplace);
	b_quadri.addActionListener(lis);
	b_quadri.setToolTipText("Utilisez cette outil pour crée un quadrilatère. Cliquez 4 fois pour placer les 4 points du quadrilatère !");

    b_quadri.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_quadri);
	b_rect.addActionListener(lis);
    b_rect.setPreferredSize(new Dimension(120, 40));
    panbtn2.add(b_rect);
	b_losange.addActionListener(lis);
	b_losange.setToolTipText("Utilisez cette outil pour crée un losange. Cliquez 2 fois pour placer la première diagonale, puis recliquer pour choisir la longueur de la seconde diagonale.");

	b_losange.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_losange);
	b_quadrangle.addActionListener(lis);
	b_quadrangle.setToolTipText("Utilisez cette outil pour crée un quadrangle. Commencez par tracer un cercle, puis placez 4 points sur le cercle pour crée un quadrangle.");

	b_quadrangle.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_quadrangle);
	b_segm.addActionListener(lis);
	b_segm.setToolTipText("Utilisez cette outil pour crée un segment. Cliquer simplement aux extremités du segment.");

	b_segm.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_segm);
	b_triangle.addActionListener(lis);
	b_triangle.setToolTipText("Utilisez cette outil pour crée un triangle. CLiquer 3 fois a l'emplacement des 3 points du triangle pour le crée.");

	b_triangle.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_triangle);
	b_multiseg.addActionListener(lis);
	b_multiseg.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_multiseg);
	b_cercle.addActionListener(lis);
	b_cercle.setToolTipText("Utilisez cette outil pour crée un cercle. Cliquer en son centre, puis déplacer la souris pour choisir son rayon. Enfin, cliquer une deuxième fois pour finaliser le cercle.");

	b_cercle.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_cercle);
	b_arcdec.addActionListener(lis);
	b_arcdec.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_arcdec);
	b_elipse.addActionListener(lis);
	b_elipse.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_elipse);
	b_multicercle.addActionListener(lis);
	b_multicercle.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_multicercle);
	b_multielipse.addActionListener(lis);
	b_multielipse.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_multielipse);
	b_multirectangle.addActionListener(lis);
	b_multirectangle.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_multirectangle);
	b_poin.addActionListener(lis);
	b_poin.setToolTipText("Utilisez cette outil pour placer des points. Cliquez simplement la ou vous voulez placer un point !");

	b_poin.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(b_poin);
	b_save.addActionListener(lis);
	b_save.setBackground(Color.CYAN);
	b_charge.addActionListener(lis);
	b_charge.setBackground(Color.ORANGE);
	b_delet.setToolTipText("Supprimez toute les formes en clicant sur ce bouton !");

	b_delet.setPreferredSize(new Dimension(120, 40));
	panbtn2.add(this.b_delet);
	b_delete.addActionListener(lis);

	this.b_delet.addActionListener(lis);
	
	panbtn.add(panbtn2,BorderLayout.WEST);
	panbtn.add(label1,BorderLayout.EAST);
	
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

	
	l1 = new JLabel("Longueur", SwingConstants.CENTER);
	l2 = new JLabel("Largeur", SwingConstants.CENTER);
	l3 = new JLabel("Angle", SwingConstants.CENTER); //TODO : gerer les angles
	

	
	
	this.setLayout(new BorderLayout());
	this.add(panbtn, BorderLayout.NORTH);
	
	pantree = new JPanel();
	pantree.setPreferredSize(new Dimension(200,200));
	
	DefaultMutableTreeNode racine1 = new DefaultMutableTreeNode("Canevas");
	
	this.add(pantree, BorderLayout.EAST);
	

	monArbre1 = new JTree(racine1);
	monArbre1.setPreferredSize(new Dimension(180,9999));
	
	Scrollp = new JScrollPane(monArbre1);
	Scrollp.setPreferredSize(new Dimension(180, 9999));
	
	

	pantree.add(b_delete);
	pantree.add(b_save);
	pantree.add(b_charge);
	pantree.add(Scrollp);
	
	
	
	
	this.addMouseListener(list);
	this.addMouseMotionListener(list);
	
	
	

	
	this.addKeyListener(list);
	
	this.setSize(1400, 800);
	
	
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	

	
}



public JButton getB_delete() {
	return b_delete;
}


public void setB_delete(JButton b_delete) {
	this.b_delete = b_delete;
}


public JButton getB_charge() {
	return b_charge;
}


public void setB_charge(JButton b_charge) {
	this.b_charge = b_charge;
}


public JButton getB_save() {
	return b_save;
}


public void setB_save(JButton b_save) {
	this.b_save = b_save;
}


public void updateJTree() {
	
	

		this.pantree.remove(Scrollp);

	
	DefaultMutableTreeNode racine1 = new DefaultMutableTreeNode("Canevas");
	
	
	for(int i =0; i< arr.size(); i++) {
		racine1.add(arr.get(i).getNode());
	}

	monArbre1 = new JTree(racine1);
	
	
	for(int i=0; i< monArbre1.getRowCount();i++) {
		monArbre1.expandRow(i);
	}
	
	Scrollp = new JScrollPane(monArbre1);
	Scrollp.setPreferredSize(new Dimension(180, this.getHeight() - this.getPanbtn().getHeight() - 50));
	
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


public File getFile() {
	return file;
}


public void setFile(File file) {
	this.file = file;
}


public PrintWriter getWriter() {
	return writer;
}


public void setWriter(PrintWriter writer) {
	this.writer = writer;
}


public JPanel getPantree() {
	return pantree;
}


public void setPantree(JPanel pantree) {
	this.pantree = pantree;
}


public JTree getMonArbre1() {
	return monArbre1;
}


public void setMonArbre1(JTree monArbre1) {
	this.monArbre1 = monArbre1;
}


public JScrollPane getScrollp() {
	return Scrollp;
}


public void setScrollp(JScrollPane scrollp) {
	Scrollp = scrollp;
}

public JLabel getLabel() {
	return label;
}



public void setLabel(JLabel label) {
	this.label = label;
}






}
