package com.example.recognition.view.response_favorite.DemographicFragment;

import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.application.App;
import com.example.recognition.viewmodel.favorites.DemographicFavoriteViewModel;

public class DemographicFavoriteFragment extends BaseDemographicFragment {

    private DemographicFavoriteViewModel viewModel;

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
                .getViewModelFactory()).get(DemographicFavoriteViewModel.class);
        viewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String image) {
                viewModel.getFavorite(image).observe(getViewLifecycleOwner(), DemographicFavoriteFragment.this);
            }
        });
        favoriteButton.setOnClickListener(changeFavorite);
    }
}
