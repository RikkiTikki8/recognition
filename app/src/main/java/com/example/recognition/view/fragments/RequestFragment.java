package com.example.recognition.view.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.recognition.R;
import com.example.recognition.adapters.ViewAdapter;
import com.example.recognition.interfaces.IViewAdapter;

import static android.app.Activity.RESULT_OK;

public class RequestFragment extends BaseFragment {
    private int mIndex;
    private String mImageUri;
    private ImageView mImageView;
    private static final int IMAGE_SEARCH_CODE = 1001;
    public static final String IMAGE_KEY = "IMAGE_KEY";
    public static final String INDEX_KEY = "INDEX_KEY";

    public static Fragment newInstance() {
        return new RequestFragment();
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_request, container, false);
        init();
        TextView mTextView = mView.findViewById(R.id.model_description);
        mImageView = mView.findViewById(R.id.selected_image);
        Button mButton = mView.findViewById(R.id.make_request_button);
        final Bundle bundle = getArguments();
        mIndex = bundle.getInt(MainFragment.MODEL_INDEX);
        mTextView.setText("Please chose image to " + bundle.getString(MainFragment.MODEL_NAME) + " model");
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, IMAGE_SEARCH_CODE);
            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mImageUri) {
                    Bundle b = new Bundle();
                    b.putString(IMAGE_KEY, mImageUri);
                    b.putInt(INDEX_KEY, mIndex);
                    Fragment fragment = ResultFragment.newInstance();
                    fragment.setArguments(b);
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .addToBackStack(RequestFragment.class.getName())
                            .commit();
                } else {
                    Toast.makeText(mView.getContext(), "Please chose an image!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return mView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case IMAGE_SEARCH_CODE:
                if(RESULT_OK == resultCode) {
                    mImageUri = data.getData().toString();
                    mImageView.setImageURI(data.getData());
                }
                break;
        }
    }
}
