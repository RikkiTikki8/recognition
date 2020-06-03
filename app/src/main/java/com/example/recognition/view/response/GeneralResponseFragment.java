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
import com.example.recognition.types.data.GeneralDataType;
import com.example.recognition.viewmodel.request_response.GeneralViewModel;

public class GeneralResponseFragment extends Fragment implements Observer<GeneralDataType> {

    private View view;
    private GeneralViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_choose_image, container, false);
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication()).getViewModelFactory()).get(GeneralViewModel.class);
        viewModel.getData().observe(getViewLifecycleOwner(), this);
        return view;
    }

    @Override
    public void onChanged(GeneralDataType data) {
        //TODO
    }

}
