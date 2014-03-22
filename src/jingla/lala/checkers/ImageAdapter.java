package jingla.lala.checkers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import jingla.lala.checkers.R;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private final char[] mobileValues;

	public ImageAdapter(Context context, char[] mobileOs) {
		this.context = context;
		this.mobileValues = mobileOs;
	}


	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.mobile, null);

			// set value into textview

			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);

			char mobile = mobileValues[position];

			if (mobile == 'w') {
				imageView.setImageResource(R.drawable.wi);
			} else if (mobile == 'W') {
				imageView.setImageResource(R.drawable.w);
			} else if (mobile == 'b') {
				imageView.setImageResource(R.drawable.bi);
			} else if (mobile == 'B') {
				imageView.setImageResource(R.drawable.b);
			} else {
				imageView.setImageResource(R.drawable.ci);
			}

		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}

	@Override
	public int getCount() {
		return mobileValues.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

}
