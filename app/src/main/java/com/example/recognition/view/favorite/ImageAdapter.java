package com.example.recognition.view.favorite;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    List<String> data;

    public ImageAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv = new ImageView(context);
        iv.setImageURI(Uri.parse(data.get(position)));
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setLayoutParams(new GridView.LayoutParams(450,450));
        return iv;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
