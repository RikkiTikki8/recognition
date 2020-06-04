package com.example.recognition.view.response_favorite.GeneralFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.example.recognition.R;
import com.example.recognition.types.data.GeneralDataType;
import com.example.recognition.types.response.GeneralResponseType;

public abstract class BaseGeneralFragment extends Fragment implements Observer<GeneralResponseType> {

    private View view;
    protected abstract void init();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_choose_image, container, false);
        init();
        return view;
    }

    @Override
    public void onChanged(GeneralResponseType response) {
        //TODO
    }
}