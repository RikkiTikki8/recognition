package com.example.recognition.view.response_favorite.DemographicFragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.application.App;
import com.example.recognition.viewmodel.favorites.DemographicFavoriteViewModel;
import com.example.recognition.viewmodel.ImageViewModel;

public class DemographicFavoriteFragment extends BaseDemographicFragment {

    private ImageViewModel imageViewModel;
    private DemographicFavoriteViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(DemographicFavoriteViewModel.class);
        imageViewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(ImageViewModel.class);
        imageViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String image) {
                viewModel.getFavorite(image).observe(getViewLifecycleOwner(), DemographicFavoriteFragment.this);
            }
        });
    }
}
