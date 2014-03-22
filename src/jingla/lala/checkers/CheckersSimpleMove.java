package jingla.lala.checkers;


public class CheckersSimpleMove {
	CheckersPosition start;
	CheckersPosition end;
	CheckersSimpleMove () {
		start = new CheckersPosition();
		end = new CheckersPosition();
	}
	CheckersSimpleMove(String zt, String rt) {
		Utils wtf = new Utils();
	    start = wtf.position_parse(zt);
	    end = wtf.position_parse(rt);
	}
}
