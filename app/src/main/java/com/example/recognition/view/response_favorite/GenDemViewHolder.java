package com.example.recognition.view.response_favorite;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recognition.R;

public class GenDemViewHolder extends RecyclerView.ViewHolder {
    public static TextView name;
    public static TextView value;

    public GenDemViewHolder(View view) {
        super(view);
        name = view.findViewById(R.id.item_name);
        value = view.findViewById(R.id.item_value);
    }
}
