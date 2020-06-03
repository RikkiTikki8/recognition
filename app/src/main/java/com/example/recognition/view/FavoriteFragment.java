package com.example.recognition.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.R;
import com.example.recognition.aplication.App;
import com.example.recognition.types.response.ColorResponseType;
import com.example.recognition.types.response.DemographicResponseType;
import com.example.recognition.types.response.GeneralResponseType;
import com.example.recognition.viewmodel.FavoriteViewModel;

import java.util.List;

public class FavoriteFragment extends Fragment {
    private View view;
    private FavoriteViewModel favoriteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        favoriteViewModel = new ViewModelProvider(this, ((App) getActivity().getApplication())
                .getViewModelFactory()).get(FavoriteViewModel.class);
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
        return view;
    }
    private void onChangedGeneralFavorites(List<GeneralResponseType> response ) {

    }
    private void onChangedDemographicFavorites(List<DemographicResponseType> response) {

    }
    private void onChangedColorFavorites(List<ColorResponseType> response) {

    }
}
