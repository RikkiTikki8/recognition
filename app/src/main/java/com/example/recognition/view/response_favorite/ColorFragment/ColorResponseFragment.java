package com.example.recognition.view.response_favorite.ColorFragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.aplication.App;
import com.example.recognition.types.data.ColorDataType;
import com.example.recognition.viewmodel.request_response.ColorViewModel;

public class ColorResponseFragment extends BaseColorResponseFragment implements Observer<ColorDataType> {

    private ColorViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(ColorViewModel.class);
        viewModel.getData().observe(getViewLifecycleOwner(), this);
    }

    @Override
    public void onChanged(ColorDataType colorDataType) {
        super.onChanged(colorDataType);
    }
}
