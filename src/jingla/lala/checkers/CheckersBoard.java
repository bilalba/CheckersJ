package jingla.lala.checkers;

import java.util.Vector;

public class CheckersBoard {
	Vector<CheckersPiece> light_pieces = new Vector <CheckersPiece>(12);
	Vector<CheckersPiece> dark_pieces = new Vector <CheckersPiece>(12);
	CheckersPiece none_piece;
	boolean mover = false; // white move first... lol
	void set_none_piece() {
		none_piece = new CheckersPiece();
		none_piece.pos.row = -1;
		none_piece.pos.col = -1;
	}
	public CheckersBoard() {
		set_none_piece();
		int rowdem = 0;
	    int cowdem = 1;
	    int i = 0;
	    for (i = 0; i<12; i++) {
			   light_pieces.add(i,new CheckersPiece());
			   dark_pieces.add(i,new CheckersPiece());
		   }
	   i = 0;
	    for (CheckersPiece dv : light_pieces) {
	    	
	        dv.dark = false;
	        dv.pos.row = rowdem;
	        dv.pos.col = cowdem;
	        cowdem = cowdem + 2;
	        if (cowdem >= 8) {
	            if (rowdem  == 0) {
	                cowdem = cowdem - 2;
	            } 
	            rowdem = rowdem + 1;
	            cowdem = cowdem - 7;
	        }
	        light_pieces.set(i,dv);
	        i = i + 1;
	// std::cout << "(" << dv.pos.row << "," << dv.pos.col << ")" << std::endl;
	    }
	    rowdem = 7;
	    cowdem = 0;
	    int l = 0;
	    for (CheckersPiece ev : dark_pieces) {
	    	
	        ev.dark = true;
	        ev.pos.row = rowdem;
	        ev.pos.col = cowdem;
	        cowdem = cowdem + 2;
	        if (cowdem >= 8) {
	            if (rowdem == 6) {
	                cowdem = cowdem -2;
	            }
	            rowdem = rowdem - 1;
	            cowdem = cowdem - 7;
	        }
	        dark_pieces.set(l,ev);
	        l = l + 1;
	        }
	    }
	public CheckersBoard(String zz, String yy) {
			for (int i = 0; i<12; i++) {
				light_pieces.add(i,new CheckersPiece());
				dark_pieces.add(i,new CheckersPiece());
			}
			Utils frr = new Utils();
		    Vector<String> uv = frr.string_split(zz, ',');
		    Vector<String> uc = frr.string_split(yy, ',');
		       set_none_piece();
		       int i = 0;
		    for (CheckersPiece dv : dark_pieces) {
		        dv.dark =true;
		        dv = none_piece;
		        dark_pieces.set(i,dv);
		        i = i + 1;
		    }
		    i = 0;
		        for (CheckersPiece dv : light_pieces) {
		        	dv.dark =true;
			        dv = none_piece;
			        light_pieces.set(i,dv);
			        i = i + 1;
		        }
		    i = 0;
		    for (String df : uv) {
		    	CheckersPiece dv = new CheckersPiece();
		        CheckersPosition cd = frr.position_parse(df);
		        dv.pos =cd;
		        dv.dark = true;
		        dark_pieces.set(i,dv);
		        i = i + 1;
		    } 
		    i = 0;
		    for (String df : uc) {
		    	CheckersPiece dv = new CheckersPiece();
		    	CheckersPosition cd = frr.position_parse(df);
		    	dv.pos =cd;
		        dv.dark = false;
		        light_pieces.set(i,dv);
		        i = i + 1;
		    } 
		}		
	void simple_move(CheckersSimpleMove er) {
		int i = 0;
	    for (CheckersPiece dv : light_pieces) {
	        if (dv.pos.row == er.start.row && dv.pos.col == er.start.col) {
	            dv.pos.row = er.end.row;
	            dv.pos.col = er.end.col;
	        }
	        light_pieces.set(i,dv);
	        i = i + 1;
	    }
	    int d = 0;
	    for (CheckersPiece dv : dark_pieces) {
	    	
	        if (dv.pos.row == er.start.row && dv.pos.col == er.start.col) {
	        	dv.pos.row = er.end.row;
	            dv.pos.col = er.end.col;
	        }
	        dark_pieces.set(d,dv);
	        d = d + 1;
	    }
	}
	int move(CheckersMove ds) {
		if (validate(ds) == 0) {
			if (mover) {
				mover = false;
			} else {
				mover = true;
			}
	    for (CheckersSimpleMove x : ds.simple_moves) {
	        simple_move(x);
	        int i = 0;
	        for (CheckersPiece dv : light_pieces) {
//	            std::cout << dv.get_position().get_row() << " ";
	        if (dv.pos.row == 7) {            
	            dv.crown = true;
	        }
	        light_pieces.set(i,dv);
	        i = i + 1;
	    }
	        i = 0;
	    for (CheckersPiece dv : dark_pieces) {
	        if (dv.pos.row == 0) {
	            dv.crown = true;
	        }
	        dark_pieces.set(i,dv);
	        i = i + 1;
	    }
	        
	        int rowdif = x.start.row - x.end.row;
	        int coldif = x.start.col - x.end.col;
	        if ((rowdif == 2 || rowdif == -2) && (coldif == 2 || coldif == -2)) {
	            int newrow =x.start.row + x.end.row;
	            newrow = newrow/2;
	            int newcol =x.start.col + x.end.col;
	            newcol = newcol/2;
	            i = 0;
	            for (CheckersPiece dv : light_pieces) {
	        if (dv.pos.row == newrow && dv.pos.col == newcol) {
	            dv = none_piece;
	        }
	        light_pieces.set(i,dv);
	        i = i + 1;
	    }
	            i = 0;
	    for (CheckersPiece dv : dark_pieces) {
	    	if (dv.pos.row == newrow && dv.pos.col == newcol) {
	            dv = none_piece;
	        }
	        dark_pieces.set(i,dv);
	        i = i + 1;
	        }
	    }
	        }
	    return 0;
		} else {
			return validate(ds);
		}
	}
	String board_print() {
		String dr = "";
	    for (int g = 0; g <8 ; g++) {
	        for (int i = 0; i <8 ; i++) {
	         CheckersPiece trr = board_get_piece_at(g, i);
	         dr = dr + trr.piece_print();
	         if (i <= 6) {
	            // std::cout << " ";
	         }
	        }
//	       dr = dr + "\n";   was adding line break here.
	    }
	    return dr;
	  }
	CheckersPiece board_get_piece_at(int row, int col) {
		    for (CheckersPiece dv : light_pieces) {
		        if (dv.pos.row == row && dv.pos.col == col) {
		            return dv;
		        }  
		    }
		    for (CheckersPiece dv : dark_pieces) {
		        if (dv.pos.row == row && dv.pos.col == col) {
		            return dv;
		        }   
		    }
		        return none_piece;
		} 
	int winner() {
	    int di = 0;
	    int  li = 0;
	    int x;
	    for (CheckersPiece dv : light_pieces) {
	        if (dv.capt || dv.piece_isnonepiece()) {
	                li = li + 1;
	            }
	    }
	    for (CheckersPiece dv : dark_pieces) {
	        if (dv.capt || dv.piece_isnonepiece()) {
	                di = di + 1;
	            }
	    }
	    if (li == 12) {
	        x = 1;
	    } else if (di == 12) {
	        x = 2;
	    } else {
	        x = 0;
	    }
	    return x;
	}
	int validate(CheckersMove ht) {
	    int midd = 0;
	    int newrow = 0;
	    int newcol = 0;
	    int rty = 0;
	    if (winner() == 0) {
	        CheckersPosition fg = ht.simple_moves.get(0).start;
	        CheckersPosition dr = ht.simple_moves.get(0).end;
	        CheckersPiece dv =board_get_piece_at(fg.row, fg.col);
	        CheckersPiece en =board_get_piece_at(dr.row, dr.col);
	        /// CODE TO JUMP TWO
	            int rowdif = fg.row - dr.row;
	            int coldif = fg.col - dr.col;
	            if ((rowdif == 2 || rowdif == -2) &&
	            (coldif == 2 || coldif == -2)) {
	            newrow =fg.row + dr.row;
	            newrow = newrow/2;
	            newcol =fg.col + dr.col;
	            newcol = newcol/2;
	            midd = 1;
	            }
	            ///// ---------------
	            if (dv.dark) {   
	                if ((rowdif == 1 || ((rowdif == 1 || rowdif == -1) && dv.crown)) && (coldif == 1 || coldif == -1)) {
	            rty = 1;
	        }
	                if ((rowdif == -2 || ((rowdif == 2 || rowdif == -2) && dv.crown)) && (coldif == 2 || coldif == -2)) {
	    	            rty = 1;
	    	        }
	            if (mover == false) {
	                return 2;
	            	}
	            if (midd == 1) {
	                CheckersPiece mid =board_get_piece_at(newrow, newcol);
	                if (mid.dark || mid.pos.row == -1) {
	                	return 5;
	            	} else {
	            		if (rowdif == 2) {
	            		rty = 1;
	            		}
	            	}
	            }
	        }
	        if (dv.dark == false) {
	        	if ((rowdif == -1 || ((rowdif == 1 || rowdif == -1) && dv.crown)) && (coldif == 1 || coldif == -1)) {
	            rty = 1;
	        }
	        if ((rowdif == 2 || ((rowdif == 2 || rowdif == -2) && dv.crown)) && (coldif == 2 || coldif == -2)) {
	            rty = 1;
	        }
	            if (mover == true) {
	                return 2;
	            }
	            if (midd == 1) {
	                CheckersPiece mid =board_get_piece_at(newrow, newcol);
	            if (mid.dark == false || mid.pos.row == -1) {
	            return 5;
	            } else {
	            	if (rowdif == -2) {
	            		rty = 1;
	            		}
            	}
	            }
	        }
	        
	        if (dv.pos.row == -1) {
	     return 3;
	     }
	     if (en.pos.row != -1) {
	            return 4;
	        }
	        
	        // 6 CONDITION
	        if (rty == 0) {
	            return 6;
	        }
	        
	        
	    } else {
	        return 1;
	    }
	    return 0;
	}
	
}
