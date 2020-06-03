package com.example.recognition.view.response;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.R;
import com.example.recognition.aplication.App;
import com.example.recognition.types.data.ColorDataType;
import com.example.recognition.types.data.DemographicDataType;
import com.example.recognition.viewmodel.request_response.DemographicViewModel;

public class DemographicResponseFragment extends Fragment implements Observer<DemographicDataType> {

    private View view;
    private DemographicViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_choose_image, container, false);
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication()).getViewModelFactory()).get(DemographicViewModel.class);
        viewModel.getData().observe(getViewLifecycleOwner(), this);
        return view;
    }

    @Override
    public void onChanged(DemographicDataType data) {
        //TODO
    }
}
