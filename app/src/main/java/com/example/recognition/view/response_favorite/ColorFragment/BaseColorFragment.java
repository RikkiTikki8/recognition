package com.example.recognition.view.response_favorite.ColorFragment;

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
import com.example.recognition.model.localdata.room.entity.ColorResponse;

public abstract class BaseColorFragment extends Fragment implements Observer<ColorResponse>  {
    protected boolean isFavorite;
    protected int threshold;
    private RecyclerView rv;
    protected Button favoriteButton;
    private View view;
    private ImageView imageView;

    protected abstract void init();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_result_color, container, false);
        imageView = view.findViewById(R.id.color_model_image);
        favoriteButton = view.findViewById(R.id.but_col_add_to_favorite);
        init();
        return view;
    }

    @Override
    public void onChanged(ColorResponse response) {
            imageView.setImageURI(Uri.parse(response.getImage()));
            rv = view.findViewById(R.id.rv_col);
            rv.setLayoutManager(new LinearLayoutManager(getContext()));
            final ColorRecyclerAdapter adapter = new ColorRecyclerAdapter(response.getData().getColors(), threshold);
            rv.setAdapter(adapter);
    }
}
