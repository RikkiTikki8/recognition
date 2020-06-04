package com.example.recognition.view.response_favorite.ColorFragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.application.App;
import com.example.recognition.viewmodel.ImageViewModel;
import com.example.recognition.viewmodel.request_response.ColorViewModel;

public class ColorResponseFragment extends BaseColorFragment {

    private ImageViewModel imageViewModel;
    private ColorViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(ColorViewModel.class);
        imageViewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(ImageViewModel.class);
        imageViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String image) {
                viewModel.getData(image).observe(getViewLifecycleOwner(), ColorResponseFragment.this);
            }
        });
    }
}
