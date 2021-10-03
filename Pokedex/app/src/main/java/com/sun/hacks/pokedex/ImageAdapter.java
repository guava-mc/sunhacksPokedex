package com.sun.hacks.pokedex;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds =
                    {R.drawable.a001, R.drawable.a002,
                    R.drawable.a003, R.drawable.a004,
                    R.drawable.a005, R.drawable.a006,
                    R.drawable.a007, R.drawable.a008,
                    R.drawable.a009, R.drawable.a010,
                    R.drawable.a011, R.drawable.a012,
                    R.drawable.a013, R.drawable.a014,
                    R.drawable.a015, R.drawable.a016,
                    R.drawable.a017, R.drawable.a018,
                    R.drawable.a019, R.drawable.a020,
                    R.drawable.a021, R.drawable.a022,
                    R.drawable.a023, R.drawable.a024,
                    R.drawable.a025, R.drawable.a026,
                    R.drawable.a027, R.drawable.a028,
                    R.drawable.a029, R.drawable.a030,
                            R.drawable.a031, R.drawable.a032,
                            R.drawable.a033, R.drawable.a034,
                            R.drawable.a035, R.drawable.a036, };

//    private List<Integer>  getThumbIds() {
//        List<Integer> temp = new ArrayList<>();
//        for(int i = 0; i < 809; i++) {
//            temp.add(mContext.getResources().getIdentifier(getIdName(i), null, mContext.getPackageName()));
//        }
//        return temp;
//    }

    private String getIdName(int i) {
        if (i < 10)
            return "a00" + i;
        else if (i < 100)
            return "a0" + i;
        else return "a" + i;
    }

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(170, 170));
        return imageView;
    }

}
