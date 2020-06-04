package com.example.recognition.view.response_favorite.DemographicFragment;

import androidx.lifecycle.ViewModelProvider;
import com.example.recognition.application.App;
import com.example.recognition.viewmodel.request_response.DemographicViewModel;

public class DemographicResponseFragment extends BaseDemographicResponseFragment {

    private DemographicViewModel viewModel;

    protected void init(){
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(DemographicViewModel.class);
        viewModel.getData().observe(getViewLifecycleOwner(), this);
    }

}
