package com.example.recognition.view.response_favorite.ColorFragment;

import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.application.App;
import com.example.recognition.viewmodel.request_response.ColorViewModel;

public class ColorResponseFragment extends BaseColorFragment {

    private ColorViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(ColorViewModel.class);
        viewModel.getData().observe(getViewLifecycleOwner(), ColorResponseFragment.this);
    }
}
