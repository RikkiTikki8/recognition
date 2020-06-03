package com.example.recognition.view.response_favorite.ColorFragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.aplication.App;
import com.example.recognition.viewmodel.favorites.ColorFavoriteViewModel;
import com.example.recognition.viewmodel.favorites.ImageFavoriteViewModel;
import com.example.recognition.viewmodel.request_response.ColorViewModel;

public class ColorFavoriteFragment extends BaseColorResponseFragment {

    private ImageFavoriteViewModel imageViewModel;
    private ColorFavoriteViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(ColorFavoriteViewModel.class);
        imageViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String image) {
                viewModel.getFavorite(image).observe(getViewLifecycleOwner(), this);
            }
            //TODO Update(String image) { ... GeneralFavoriteViewModel.getFavorite(image).observe(this, this); }
        });
    }
}
