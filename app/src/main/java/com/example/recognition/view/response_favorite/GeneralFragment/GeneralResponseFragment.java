package com.example.recognition.view.response_favorite.GeneralFragment;

import androidx.lifecycle.ViewModelProvider;
import com.example.recognition.application.App;
import com.example.recognition.viewmodel.request_response.GeneralViewModel;

public class GeneralResponseFragment extends BaseGeneralResponseFragment {

    private GeneralViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(GeneralViewModel.class);
        viewModel.getData().observe(getViewLifecycleOwner(), this);
    }
}
