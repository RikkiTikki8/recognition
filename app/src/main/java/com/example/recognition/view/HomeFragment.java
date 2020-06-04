package com.example.recognition.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.recognition.R;
import com.example.recognition.application.App;
import com.example.recognition.viewmodel.NavModelViewModel;

public class HomeFragment extends Fragment {

    View view;
    NavModelViewModel viewModel;

    private View.OnClickListener onGeneralClickListener = new View.OnClickListener() {
        @SuppressLint("ResourceType")
        @Override
        public void onClick(View v) {
            viewModel.setNavModel(R.id.action_ChooseImageFragment_to_GeneralResponseFragment);
            Navigation.findNavController(view).navigate(R.id.action_HomeFragment_to_ChooseImageFragment);
        }
    };
    private View.OnClickListener onDemographicClickListener = new View.OnClickListener() {
        @SuppressLint("ResourceType")
        @Override
        public void onClick(View v) {
            viewModel.setNavModel(R.id.action_ChooseImageFragment_to_DemographicResponseFragment);
            Navigation.findNavController(view).navigate(R.id.action_HomeFragment_to_ChooseImageFragment);
        }
    };
    private View.OnClickListener onColorClickListener = new View.OnClickListener() {
        @SuppressLint("ResourceType")
        @Override
        public void onClick(View v) {
            viewModel.setNavModel(R.id.action_ChooseImageFragment_to_ColorResponseFragment);
            Navigation.findNavController(view).navigate(R.id.action_HomeFragment_to_ChooseImageFragment);
        }
    };



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        viewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(NavModelViewModel.class);

        final Button bGeneral = view.findViewById(R.id.button_general);
        final Button bDemographic = view.findViewById(R.id.button_demographics);
        final Button bColor = view.findViewById(R.id.button_color);

        bGeneral.setOnClickListener(onGeneralClickListener);
        bDemographic.setOnClickListener(onDemographicClickListener);
        bColor.setOnClickListener(onColorClickListener);

        return view;
    }
}
