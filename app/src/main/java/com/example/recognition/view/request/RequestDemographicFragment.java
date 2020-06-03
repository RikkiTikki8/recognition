package com.example.recognition.view.request;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.R;
import com.example.recognition.aplication.App;
import com.example.recognition.viewmodel.request_response.DemographicViewModel;

public class RequestDemographicFragment extends BaseRequestFragment {

    private DemographicViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication()).getViewModelFactory()).get(DemographicViewModel.class);
        viewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String mImage) {
                image = mImage;
            }
        });
    }


    @Override
    protected void setImage(String image) {
        viewModel.setImage(image);
    }

    @Override
    protected int getNextFragmentId() {
        return R.layout.fragment_result_demographic;
    }
}
