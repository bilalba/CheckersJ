package jingla.lala.checkers;
import java.util.Vector;


public class CheckersMove {
	Vector<CheckersSimpleMove> simple_moves =new Vector<CheckersSimpleMove>();
	public CheckersMove() {
	}
    public CheckersMove(String fg) {
    	Utils wtf = new Utils();
    	Vector<String> lma = wtf.string_split(fg, '-');
         int d = lma.size() - 1;
        for (int i = 0; i <d ; i++) {
        	CheckersSimpleMove heyy = new CheckersSimpleMove();
            heyy.start = wtf.position_parse(lma.get(i));
            heyy.end = wtf.position_parse(lma.get(i+1));
            simple_moves.add(heyy);
        }
        // COUT functioniality
//        for (auto & x : bilal.simple_moves) {
//        std::cout << x.start.row << " " << x.start.col << " to " << x.end.row;
//            std::cout << " " << x.end.col << std::endl;
//        }
      }
   }
