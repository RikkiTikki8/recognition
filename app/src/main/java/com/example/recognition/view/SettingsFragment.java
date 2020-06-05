package com.example.recognition.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.recognition.R;
import com.example.recognition.application.App;
import com.example.recognition.types.SettingsType;
import com.example.recognition.viewmodel.SettingsViewModel;

public class SettingsFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private View view;
    private TextView textView;
    private SeekBar seekBar;
    private SettingsViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        viewModel = new ViewModelProvider(this, ((App)getActivity().getApplication())
                .getViewModelFactory()).get(SettingsViewModel.class);

        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        textView = (TextView) view.findViewById(R.id.settings_number);
        viewModel.getSettings().observe(getViewLifecycleOwner(), new Observer<SettingsType>() {
            @Override
            public void onChanged(SettingsType settingsType) {
                textView.setText(String.valueOf(settingsType.getThreshold()));
                seekBar.setProgress(settingsType.getThreshold());
            }
        });
        return view;
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        int threshold = seekBar.getProgress();
        textView.setText(String.valueOf(threshold));
        viewModel.setThreshold(threshold);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }


}
