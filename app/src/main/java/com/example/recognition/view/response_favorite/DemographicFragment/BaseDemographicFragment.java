package com.example.recognition.view.response_favorite.DemographicFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.recognition.R;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.viewmodel.response.DemographicViewModel;

public abstract class BaseDemographicFragment extends Fragment implements Observer<DemographicResponse> {

    private View view;
    private DemographicViewModel viewModel;

    protected abstract void init();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_result_demographic, container, false);
        init();
        return view;
    }

    @Override
    public void onChanged(DemographicResponse response) {
        //TODO
    }
}
