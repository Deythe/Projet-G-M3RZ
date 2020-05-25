package model;

public class Case {

	private int x, y;
	private Case parent;
	

	public Case(int x, int y, Case parent) {
		this.x = x;
		this.y = y;
		this.parent = parent;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Case getParent() {
		return parent;
	}
	
	public boolean memeCase(Case caseComparer) {
		return (this.x == caseComparer.getX() && this.y == caseComparer.getY());
	}
}
