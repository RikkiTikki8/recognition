package com.example.recognition.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.recognition.R;
import com.example.recognition.application.App;
import com.example.recognition.viewmodel.NavModelViewModel;
import com.example.recognition.viewmodel.ImageViewModel;

import static android.app.Activity.RESULT_OK;

public class RequestFragment extends Fragment {
    private ImageViewModel imageViewModel;
    private NavModelViewModel navModelViewModel;
    private int layoutId;
    private View view;
    private String image;
    private ImageView button_choose;
    private Button button_send;
    private static final int IMAGE_SEARCH_CODE = 1001;

    private View.OnClickListener onButtonChooseClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, IMAGE_SEARCH_CODE);
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case IMAGE_SEARCH_CODE:
                if(RESULT_OK == resultCode) {
                    image = data.getData().toString();
                    imageViewModel.setImage(image);
                }
                break;
        }
    }

    private View.OnClickListener onButtonSendClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (image != null) {
                Navigation.findNavController(view).navigate(layoutId);
            }
            else {
                Toast.makeText(view.getContext(), "Choose an image", Toast.LENGTH_SHORT).show();
            }
        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_choose_image, container, false);
        imageViewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication()).getViewModelFactory()).get(ImageViewModel.class);
        imageViewModel.getImage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String mImage) {
                image = mImage;
                button_choose.setImageURI(Uri.parse(image));
            }
        });
        navModelViewModel = new ViewModelProvider(getActivity(), ((App)getActivity().getApplication()).getViewModelFactory()).get(NavModelViewModel.class);
        navModelViewModel.getModelLayout().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                layoutId = integer;
            }
        });
        button_choose = view.findViewById(R.id.button_choose_image);
        button_choose.setOnClickListener(onButtonChooseClickListener);
        button_send = view.findViewById(R.id.button_send_image);
        button_send.setOnClickListener(onButtonSendClickListener);
        return view;
    }
}
