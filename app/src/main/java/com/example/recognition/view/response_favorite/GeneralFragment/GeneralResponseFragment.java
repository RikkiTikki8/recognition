package com.example.recognition.view.response_favorite.GeneralFragment;

import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.recognition.application.App;
import com.example.recognition.viewmodel.ImageViewModel;
import com.example.recognition.viewmodel.response.GeneralViewModel;

public class GeneralResponseFragment extends BaseGeneralFragment {
    private ImageViewModel imageViewModel;
    private GeneralViewModel viewModel;

    @Override
    protected void init() {
        viewModel = new ViewModelProvider(this, ((App)getActivity().getApplication())
                .getViewModelFactory()).get(GeneralViewModel.class);
        viewModel.getMassage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
        imageViewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication())
                .getViewModelFactory()).get(ImageViewModel.class);
        imageViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String image) {
                viewModel.getData(image).observe(getViewLifecycleOwner(), GeneralResponseFragment.this);
            }
        });
    }
}
