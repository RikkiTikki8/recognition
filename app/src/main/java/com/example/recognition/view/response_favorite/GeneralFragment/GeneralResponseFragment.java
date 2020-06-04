package com.example.recognition.view.response_favorite.GeneralFragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.recognition.application.App;
import com.example.recognition.viewmodel.response.GeneralViewModel;

public class GeneralResponseFragment extends BaseGeneralFragment {

    private GeneralViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(GeneralViewModel.class);
        viewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String image) {
                viewModel.getData(image).observe(getViewLifecycleOwner(), GeneralResponseFragment.this);
            }
        });
    }
}
