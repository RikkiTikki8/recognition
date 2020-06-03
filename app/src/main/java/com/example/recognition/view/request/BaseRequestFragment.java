package com.example.recognition.view.request;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.recognition.R;

import static android.app.Activity.RESULT_OK;

public abstract class BaseRequestFragment extends Fragment {
    protected View view;
    protected String image;
    private Button button_choose;
    private Button button_send;
    private static final int IMAGE_SEARCH_CODE = 1001;

    protected abstract void init();
    protected abstract int getNextFragmentId();
    protected abstract void setImage(String image);
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
                    setImage(image);
                }
                break;
        }
    }

    private View.OnClickListener onButtonSendClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (image != null) {
                Navigation.findNavController(view).navigate(getNextFragmentId());
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
        init();
        button_choose = view.findViewById(R.id.button_choose_image);
        button_choose.setOnClickListener(onButtonChooseClickListener);
        button_send = view.findViewById(R.id.button_send_image);
        button_send.setOnClickListener(onButtonSendClickListener);
        return view;
    }
}
