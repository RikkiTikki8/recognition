package com.example.recognition.view.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.R;
import com.example.recognition.application.App;
import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.viewmodel.favorites.ColorFavoriteViewModel;

import java.util.List;

public class ColorFavoriteFragment extends Fragment {
    View view;
    ColorFavoriteViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fr_color_fav, container, false);
        viewModel = new ViewModelProvider(this, ((App) getActivity().getApplication())
                .getViewModelFactory()).get(ColorFavoriteViewModel.class);
        return view;
    }
    private void onChangedGeneralFavorites(List<ColorResponse> response ) {

    }
}
