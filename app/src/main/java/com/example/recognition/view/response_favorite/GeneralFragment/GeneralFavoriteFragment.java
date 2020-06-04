package com.example.recognition.view.response_favorite.GeneralFragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.application.App;
import com.example.recognition.viewmodel.favorites.GeneralFavoriteViewModel;
import com.example.recognition.viewmodel.favorites.ImageFavoriteViewModel;

public class GeneralFavoriteFragment extends BaseGeneralFragment {

    private ImageFavoriteViewModel imageViewModel;
    private GeneralFavoriteViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(GeneralFavoriteViewModel.class);
        imageViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String image) {
                viewModel.getFavorite(image).observe(getViewLifecycleOwner(), GeneralFavoriteFragment.this);
            }
        });
    }
}
