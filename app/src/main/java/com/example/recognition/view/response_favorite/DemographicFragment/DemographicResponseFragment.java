package com.example.recognition.view.response_favorite.DemographicFragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.recognition.application.App;
import com.example.recognition.viewmodel.ImageViewModel;
import com.example.recognition.viewmodel.request_response.DemographicViewModel;

public class DemographicResponseFragment extends BaseDemographicFragment {

    private ImageViewModel imageViewModel;
    private DemographicViewModel viewModel;

    protected void init(){
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(DemographicViewModel.class);
        imageViewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(ImageViewModel.class);
        imageViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String image) {
                viewModel.getData(image).observe(getViewLifecycleOwner(), DemographicResponseFragment.this);
            }
        });
    }

}
