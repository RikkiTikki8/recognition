package com.example.recognition.view.response_favorite.DemographicFragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.aplication.App;
import com.example.recognition.viewmodel.favorites.DemographicFavoriteViewModel;
import com.example.recognition.viewmodel.favorites.ImageFavoriteViewModel;

public class DemographicFavoriteFragment extends BaseDemographicResponseFragment {

    private ImageFavoriteViewModel imageViewModel;
    private DemographicFavoriteViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(DemographicFavoriteViewModel.class);
        imageViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() { @Override
                //TODO Update(String image) { ... GeneralFavoriteViewModel.getFavorite(image).observe(this, this); }
        });
    }
}
