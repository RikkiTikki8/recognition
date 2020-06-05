package com.example.recognition.view.response_favorite.GeneralFragment;

import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.application.App;
import com.example.recognition.types.SettingsType;
import com.example.recognition.viewmodel.favorites.GeneralFavoriteViewModel;

public class GeneralFavoriteFragment extends BaseGeneralFragment {

    private GeneralFavoriteViewModel viewModel;

    private View.OnClickListener changeFavorite = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isFavorite) {
                viewModel.removeFromFavorite();
            }
            else {
                viewModel.addToFavorite();
            }
            isFavorite = !isFavorite;
        }
    };
    @Override
    protected void init() {
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(GeneralFavoriteViewModel.class);
        viewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String image) {
                viewModel.getFavorite(image).observe(getViewLifecycleOwner(), GeneralFavoriteFragment.this);
            }
        });
        viewModel.getSettings().observe(getViewLifecycleOwner(), new Observer<SettingsType>() {
            @Override
            public void onChanged(SettingsType settingsType) {
                threshold = settingsType.getThreshold();
            }
        });
        favoriteButton.setOnClickListener(changeFavorite);
    }
}
