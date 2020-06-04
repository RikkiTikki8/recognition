package com.example.recognition.view.response_favorite.GeneralFragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.application.App;
import com.example.recognition.viewmodel.favorites.GeneralFavoriteViewModel;

public class GeneralFavoriteFragment extends BaseGeneralFragment {

    private GeneralFavoriteViewModel viewModel;

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
    }
}
