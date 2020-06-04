package com.example.recognition.view.response_favorite.DemographicFragment.RecyclerAdapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recognition.R;
import com.example.recognition.types.DemographicDataType;
import com.example.recognition.view.response_favorite.GenDemViewHolder;

public class MultiDemographicRecyclerAdapter extends RecyclerView.Adapter<GenDemViewHolder>{

    DemographicDataType.Face.MulticulturalAppearance[] data;
    GenDemViewHolder holder;

    public MultiDemographicRecyclerAdapter(DemographicDataType.Face.MulticulturalAppearance[] data){
        this.data = data;
    }

    @NonNull
    @Override
    public GenDemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_param_list, parent, false);
        return new GenDemViewHolder(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull GenDemViewHolder holder, int i) {
        this.holder = holder;
        GenDemViewHolder.name.setText(data[i].getName());
        GenDemViewHolder.value.setText(String.format("%.3f", data[i].getValue()));
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}