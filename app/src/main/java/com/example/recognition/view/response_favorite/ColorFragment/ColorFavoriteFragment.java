package com.example.recognition.view.response_favorite.ColorFragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.application.App;
import com.example.recognition.viewmodel.favorites.ColorFavoriteViewModel;

public class ColorFavoriteFragment extends BaseColorFragment {

    private ColorFavoriteViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(this, ((App)getActivity().getApplication())
                .getViewModelFactory()).get(ColorFavoriteViewModel.class);
        viewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String image) {
                viewModel.getFavorite(image).observe(getViewLifecycleOwner(), ColorFavoriteFragment.this);
            }
        });
    }
}
