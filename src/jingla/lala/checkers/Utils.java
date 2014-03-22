package jingla.lala.checkers;

import java.util.Vector;

public class Utils {
	public Utils() {
	}
	Vector<String> string_split(String rtw, char t) {
	    int nom = 0;
	    Vector<String> abc= new Vector<String>(1);
	    abc.add(rtw);
	    String dz = "";
	    int i = 1;
	    for (char x : rtw.toCharArray()) {
	        if (x == t) {
	           abc.add("");
	           abc.set(nom,dz);
	           dz = "";
	           nom = nom + 1;
	        } else {
	            dz = dz + x;
	        }
	        i = i +1;
	    }
	    abc.set(nom,dz);
	    return abc;
	} 
	
	public CheckersPosition position_parse(String b) {
		CheckersPosition t = new CheckersPosition();
	    t.col = b.charAt(0)-'A';
	    t.row = 8 - (b.charAt(1)-'0');
	    return t;
	    }
	
}
