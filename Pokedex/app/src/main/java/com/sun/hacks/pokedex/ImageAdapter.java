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
    public Integer[] mThumbIds = getThumbIds().toArray(new Integer[0]);

    private List<Integer>  getThumbIds() {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < 809; i++) {
            temp.add(mContext.getResources().getIdentifier(getIdName(i), null, mContext.getPackageName()));
        }
        return temp;
    }

    private String getIdName(int i) {
        if (i < 10)
            return "00" + i;
        else if (i < 100)
            return "0" + i;
        else return String.valueOf(i);
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
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }

}
