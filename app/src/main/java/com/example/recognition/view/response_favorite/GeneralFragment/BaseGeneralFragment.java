package com.example.recognition.view.response_favorite.GeneralFragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recognition.R;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.view.response_favorite.ColorFragment.ColorRecyclerAdapter;

public abstract class BaseGeneralFragment extends Fragment implements Observer<GeneralResponse> {
    protected boolean isFavorite;
    protected int threshold;
    private View view;
    private ImageView imageView;
    protected Button favoriteButton;

    protected abstract void init();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_result_general, container, false);
        imageView = view.findViewById(R.id.gen_model_image);
        favoriteButton = view.findViewById(R.id.but_gen_add_to_favorite);
        init();
        return view;
    }

    @Override
    public void onChanged(GeneralResponse response) {
        imageView.setImageURI(Uri.parse(response.getImage()));
        RecyclerView rv = view.findViewById(R.id.rv_gen);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        final GeneralRecyclerAdapter adapter = new GeneralRecyclerAdapter(response.getData().getProperties(), threshold);
        rv.setAdapter(adapter);
    }
}