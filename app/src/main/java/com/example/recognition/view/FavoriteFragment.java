package com.example.recognition.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.recognition.R;
import com.example.recognition.application.App;
import com.example.recognition.types.response.ColorResponseType;
import com.example.recognition.types.response.DemographicResponseType;
import com.example.recognition.types.response.GeneralResponseType;
import com.example.recognition.viewmodel.favorites.FavoriteViewModel;
import java.util.List;

public class FavoriteFragment extends Fragment {
    private View view;
    private FavoriteViewModel favoriteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
        favoriteViewModel = new ViewModelProvider(this, ((App) getActivity().getApplication())
                .getViewModelFactory()).get(FavoriteViewModel.class);
        return view;
    }
    private void onChangedGeneralFavorites(List<GeneralResponseType> response ) {

    }
    private void onChangedDemographicFavorites(List<DemographicResponseType> response) {

    }
    private void onChangedColorFavorites(List<ColorResponseType> response) {

    }
}
