package com.example.recognition.view.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.R;
import com.example.recognition.application.App;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.viewmodel.favorites.GeneralFavoriteViewModel;

import java.util.List;

public class GeneralFavoriteFragment extends Fragment {
    View view;
    GeneralFavoriteViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fr_gen_fav, container, false);
        viewModel = new ViewModelProvider(this, ((App) getActivity().getApplication())
                .getViewModelFactory()).get(GeneralFavoriteViewModel.class);
        return view;
    }
    private void onChangedGeneralFavorites(List<GeneralResponse> response ) {

    }
}
