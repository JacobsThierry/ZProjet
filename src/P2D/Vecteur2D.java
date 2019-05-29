package P2D;

public class Vecteur2D {

	private Point2D PExtremite;
	private Point2D POrigine;
	
	
	
	public Vecteur2D( Point2D pOrigine, Point2D pExtremite) {
		super();
		PExtremite = pExtremite;
		POrigine = pOrigine;
	}
	public Point2D getPExtremite() {
		return PExtremite;
	}
	public void setPExtremite(Point2D pExtremite) {
		PExtremite = pExtremite;
	}
	public Point2D getPOrigine() {
		return POrigine;
	}
	public void setPOrigine(Point2D pOrigine) {
		POrigine = pOrigine;
	}
	
	public int getX() {
		return PExtremite.getX() - POrigine.getX();
	}
	
	public int getY() {
		return PExtremite.getY() - POrigine.getY();
	}
	
	public boolean isIn(Point2D p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
