package jingla.lala.checkers;


import jingla.lala.checkers.ImageAdapter;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends Activity {
	
	boolean flag = true;
	GridView gridView;
	 CheckersBoard hr = new CheckersBoard();
	String dv = hr.board_print();
	char[] ary = dv.toCharArray();
	char[] MOBILE_OS = ary;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println(dv);

		gridView = (GridView) findViewById(R.id.gridView1);
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int wid = size.x;
		int hei = size.y;
		int yt = 0;
		if (wid<hei) {
			yt = wid;
		} else {
			yt = hei;
		}

		gridView.setLayoutParams(new LinearLayout.LayoutParams(yt, yt));
//		sidView.setLayoutParams(new LinearLayout.LayoutParams(yt/8, yt/8));

		final MainActivity h = this;
		gridView.setAdapter(new ImageAdapter(this, MOBILE_OS));
		
		
		final CheckersMove ht = new CheckersMove();
		final CheckersSimpleMove zf = new CheckersSimpleMove();

			gridView.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent, View v,
						int position, long id) {
					if (flag) {
					
						
								flag = false;
//									CheckersMove ht = new CheckersMove();
									CheckersPosition one = new CheckersPosition(position);
//									CheckersSimpleMove zf = new CheckersSimpleMove();
									zf.start = one;
									CheckersPiece ghj = hr.board_get_piece_at(one.row, one.col);
									if (ghj.pos.row == -1) {
										flag = true;
										Toast.makeText(getApplicationContext(), "Please select a piece.",
												   Toast.LENGTH_LONG).show();
									}
						
						} else {
						flag = true;
						CheckersPosition two = new CheckersPosition(position);
						zf.end = two;
						ht.simple_moves.add(zf);
						// MOVE
						int t= hr.move(ht);
						// WARNINGS.
						
						if (t == 1) {
						Toast.makeText(getApplicationContext(), "Game has already been won.",
								   Toast.LENGTH_LONG).show();
						} else if (t == 2) {
							Toast.makeText(getApplicationContext(), "Invalid Move. Not your turn.",
									   Toast.LENGTH_LONG).show();
						} else if (t == 3) {
							Toast.makeText(getApplicationContext(), "Please select a valid piece.",
									   Toast.LENGTH_LONG).show();
						} else if (t == 4) {
							Toast.makeText(getApplicationContext(), "You cannot move onto another piece.",
									   Toast.LENGTH_LONG).show();
						} else if (t == 5) {
							Toast.makeText(getApplicationContext(), "You can't take double steps.",
									   Toast.LENGTH_LONG).show();
						} else if (t == 6) {
							Toast.makeText(getApplicationContext(), "You can only move diagonally.",
									   Toast.LENGTH_LONG).show();
						}
						// NEW BOARD BEING SET UP.
						String dv = hr.board_print();
						System.out.println(dv);
						char[] ary = dv.toCharArray();
						MOBILE_OS = ary;
						gridView.setAdapter(new ImageAdapter(h , MOBILE_OS));
						ht.simple_moves.removeAllElements();
						
					}
		}
			
		});
//	}
	}
};