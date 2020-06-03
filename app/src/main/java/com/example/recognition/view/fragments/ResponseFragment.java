package com.example.recognition.view.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.recognition.R;
import com.example.recognition.model.types.Data;

import java.util.List;

public class ResponseFragment extends BaseFragment {
    private int mDataIndex;
    public static ResponseFragment newInstance() {
        return new ResponseFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_result, container, false);
        init();
        mDataIndex = 0;
        Bundle bundle = getArguments();
        int modelIndex = bundle.getInt(RequestFragment.INDEX_KEY);
        String imageUri = bundle.getString(RequestFragment.IMAGE_KEY);
        ImageView mImageView = mView.findViewById(R.id.result_image);
        mImageView.setImageURI(Uri.parse(imageUri));
        mAdapter.getRequestEvent().addListener(new Action<Data>() {
            @Override
            public void onEventFired(Data... args) {
                printConcepts(args);
            }
        });
        mAdapter.startRequest(imageUri, modelIndex);
        return mView;
    }
    private void printConcepts(Data[] request) {
        List<Data.Field> fields = request[mDataIndex].getConcepts();
        StringBuilder conceptOfImage = new StringBuilder();
        for (Data.Field field : fields) {
            conceptOfImage.append(field.getName()).append(": ").append(field.getValue()).append("\n");
        }
        TextView textView = new TextView(mView.getContext());
        textView.setText(conceptOfImage.toString());
        textView.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                )
        );
        LinearLayout layout = mView.findViewById(R.id.concept_box);
        layout.addView(textView);
    }
}
