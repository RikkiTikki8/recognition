package com.example.recognition.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.example.recognition.R;

public class MainFragment extends Fragment {
    private View view;
    public static final String MODEL_INDEX = "MODEL_INDEX";
    public static final String MODEL_NAME = "MODEL_NAME";

    public static MainFragment newInstance() {
        return new MainFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_main, container, false);

        final String[] models = mAdapter.getModels();
        LinearLayout layout = view.findViewById(R.id.main_fragment_layout);
        for (int i = 0; i < models.length; i++) {
            Button button = new Button(view.getContext());
            button.setLayoutParams(
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    )
            );
            final int modelIndex = i;
            button.setText(models[modelIndex]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, RequestFragment.newInstance())
                            .addToBackStack(RequestFragment.class.getName())
                            .commit();
                }
            });
            layout.addView(button);
        }
        return view;
    }
}
