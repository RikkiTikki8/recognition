package com.example.recognition.view.favorite;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.recognition.R;
import com.example.recognition.application.App;
import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.viewmodel.favorites.FavoriteViewModel;
import java.util.List;

public class FavoriteFragment extends Fragment {

    private View view;

    private View.OnClickListener onGeneralClickListener = new View.OnClickListener() {
        @SuppressLint("ResourceType")
        @Override
        public void onClick(View v) {
            Navigation.findNavController(view).navigate(R.id.action_FavoriteFragment_to_GeneralFavoriteFragment);
        }
    };
    private View.OnClickListener onDemographicClickListener = new View.OnClickListener() {
        @SuppressLint("ResourceType")
        @Override
        public void onClick(View v) {
            Navigation.findNavController(view).navigate(R.id.action_FavoriteFragment_to_DemographicFavoriteFragment);
        }
    };
    private View.OnClickListener onColorClickListener = new View.OnClickListener() {
        @SuppressLint("ResourceType")
        @Override
        public void onClick(View v) {
            Navigation.findNavController(view).navigate(R.id.action_FavoriteFragment_to_ColorFavoriteFragment);
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
//        favoriteViewModel = new ViewModelProvider(this, ((App) getActivity().getApplication())
//                .getViewModelFactory()).get(FavoriteViewModel.class);

        final Button bGeneral = view.findViewById(R.id.button_fav_gen);
        final Button bDemographic = view.findViewById(R.id.button_fav_dem);
        final Button bColor = view.findViewById(R.id.button_fav_color);
        bGeneral.setOnClickListener(onGeneralClickListener);
        bDemographic.setOnClickListener(onDemographicClickListener);
        bColor.setOnClickListener(onColorClickListener);

        return view;
    }
//    private void onChangedGeneralFavorites(List<GeneralResponse> response ) {
//
//    }
//    private void onChangedDemographicFavorites(List<DemographicResponse> response) {
//
//    }
//    private void onChangedColorFavorites(List<ColorResponse> response) {
//
//    }
}
