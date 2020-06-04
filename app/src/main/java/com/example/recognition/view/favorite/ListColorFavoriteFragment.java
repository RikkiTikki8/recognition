package com.example.recognition.view.favorite;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.R;
import com.example.recognition.application.App;
import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.model.remoutdata.ColorResponsePojo;
import com.example.recognition.viewmodel.favorites.ColorFavoriteViewModel;

import java.util.List;

public class ListColorFavoriteFragment extends Fragment {
    private View view;
    private ColorFavoriteViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fr_color_fav, container, false);
        viewModel = new ViewModelProvider(this, ((App) getActivity().getApplication())
                .getViewModelFactory()).get(ColorFavoriteViewModel.class);
        viewModel.getColorFavorites().observe(getViewLifecycleOwner(), new Observer<List<ColorResponse>>() {
            @Override
            public void onChanged(List<ColorResponse> colorResponses) {
                onChangedColorFavorites(colorResponses);
            }
        });
        return view;
    }
    private void onChangedColorFavorites(List<ColorResponse> response ) {
        for (int i = 0; i < response.size(); i++) {
            LinearLayout layout;
            Image image;
            if (0 == i % 2) {
                //TODO add LinearLayout
            }
            //TODO new Image
            //TODO linearLayout.add(image);
        }
    }
}
