package com.example.tugassebelumlibur;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    public Context ctx;

    public Integer[] gambars = {
            R.drawable.manusia
            , R.drawable.laskar, R.drawable.anak, R.drawable.ronggeng
    };

    public ImageAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return gambars.length;
    }

    @Override
    public Object getItem(int i) {
        return gambars[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ImageView imgView = new ImageView(ctx);
        imgView.setImageResource(gambars[i]);
        imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imgView.setLayoutParams(new GridView.LayoutParams(300, 300));

        return imgView;
    }
}