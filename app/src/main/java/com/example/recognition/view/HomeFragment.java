package com.example.recognition.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.recognition.R;

public class HomeFragment extends Fragment {

    View view;

    private View.OnClickListener onButtonSendClickListener = new View.OnClickListener() {
        @SuppressLint("ResourceType")
        @Override
        public void onClick(View v) {
            Navigation.findNavController(view).navigate(R.layout.fragment_choose_image);
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        final Button bGeneral = view.findViewById(R.id.button_general);
        final Button bDemographic = view.findViewById(R.id.button_demographics);
        final Button bColor = view.findViewById(R.id.button_color);
        return view;
    }
}
