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

    private Boolean isFavorite;
    private Button button;
    private View view;
    private ImageView imageView;
    protected abstract void init();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_result_color, container, false);
        init();
        imageView = view.findViewById(R.id.color_model_image);
        button = view.findViewById(R.id.button_add_to_favorite);
        isFavorite = false;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFavorite = !isFavorite;
            }
        });
        return view;
    }

    @Override
    public void onChanged(ColorResponse response) {
            imageView.setImageURI(Uri.parse(response.getImage()));
            RecyclerView rv = view.findViewById(R.id.rv_col);
            rv.setLayoutManager(new LinearLayoutManager(getContext()));
            final ColorRecyclerAdapter adapter = new ColorRecyclerAdapter(response.getData().getColors());
            rv.setAdapter(adapter);
    }
}
