package com.example.recognition.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.recognition.R;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final Button bGeneral = view.findViewById(R.id.button_general);
        final Button bDemographic = view.findViewById(R.id.button_demographics);
        final Button bColor = view.findViewById(R.id.button_color);
        return view;
    }
}
