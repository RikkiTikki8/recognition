package com.example.recognition.view.response_favorite.DemographicFragment;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.recognition.application.App;
import com.example.recognition.types.SettingsType;
import com.example.recognition.viewmodel.ImageViewModel;
import com.example.recognition.viewmodel.response.DemographicViewModel;

public class DemographicResponseFragment extends BaseDemographicFragment {
    private ImageViewModel imageViewModel;
    private DemographicViewModel viewModel;

    private View.OnClickListener changeFavorite = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isFavorite) {
                viewModel.removeFromFavorite();
            }
            else {
                viewModel.addToFavorite();
            }
            isFavorite = !isFavorite;
        }
    };
    protected void init(){
        viewModel = new ViewModelProvider(this, ((App)getActivity().getApplication())
                .getViewModelFactory()).get(DemographicViewModel.class);
        viewModel.getMassage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
        viewModel.getSettings().observe(getViewLifecycleOwner(), new Observer<SettingsType>() {
            @Override
            public void onChanged(SettingsType settingsType) {
                threshold = settingsType.getThreshold();
            }
        });
        favoriteButton.setOnClickListener(changeFavorite);
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
