package jingla.lala.checkers;


public class CheckersPiece {
	boolean crown;
    boolean capt;
    boolean dark;
    CheckersPosition pos;
    public CheckersPiece() {
    	crown = false;
        capt = false;
        dark = false;
        pos = new CheckersPosition();
    }
    void set_position(CheckersPosition df) {
    	pos = df;
    }
    boolean piece_isnonepiece() {
        if (pos.row == -1) {
            return true;
        } else {
            return false;
        }
    }
    char piece_print() {
    	char t = ' ';
    	if (capt || piece_isnonepiece()) {
            t = '.';
        } else if (dark == false) {
            if (crown == false) {
                t = 'w';
            } else if (crown == true) {
            	t = 'W';
            }
        } else if (dark == true) {
            if (crown == false) {
            	t = 'b';
            
            } else if (crown == true) {
            	t = 'B';
            }        
        }
        return t;
    }
}