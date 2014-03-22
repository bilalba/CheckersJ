package jingla.lala.checkers;


public class CheckersPosition {
	int row;
	int col;
	public CheckersPosition(String tr) {
	    row = position_parse(tr).row;
	    col = position_parse(tr).col;
	}
	public CheckersPosition(int p) {
		int r = p/8;
		int c= p % 8;
		row = r;
		col = c;
	}
	public CheckersPosition() {
		row = -1;
		col = -1;
	}
	public CheckersPosition position_parse(String b) {
    col = b.charAt(0)-'A';
    row = 8 - (b.charAt(1)-'0');
    return this;
    }
}
