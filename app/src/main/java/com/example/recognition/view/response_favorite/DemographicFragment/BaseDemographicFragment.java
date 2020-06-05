package com.example.recognition.view.response_favorite.DemographicFragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recognition.R;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.types.DemographicDataType;
import com.example.recognition.view.response_favorite.DemographicFragment.RecyclerAdapters.AgeDemographicRecyclerAdapter;
import com.example.recognition.view.response_favorite.DemographicFragment.RecyclerAdapters.GenderDemographicRecyclerAdapter;
import com.example.recognition.view.response_favorite.DemographicFragment.RecyclerAdapters.MultiDemographicRecyclerAdapter;

public abstract class BaseDemographicFragment extends Fragment implements Observer<DemographicResponse> {

    private View view;
    private ImageView imageView;

    protected abstract void init();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_result_demographic, container, false);
        init();
        imageView = view.findViewById(R.id.dem_model_image);
        return view;
    }

    @Override
    public void onChanged(DemographicResponse response) {
        imageView.setImageURI(Uri.parse(response.getImage()));
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        //TODO кнопки с лицами
        for (DemographicDataType.Face faces : response.getData().getFaces()){
            RecyclerView rv_gender = view.findViewById(R.id.rv_dem_gender);
            rv_gender.setLayoutManager(llm);
            final GenderDemographicRecyclerAdapter adapter_gender =
                    new GenderDemographicRecyclerAdapter(faces.getGendersAppearance());
            rv_gender.setAdapter(adapter_gender);
            RecyclerView rv_age = view.findViewById(R.id.rv_dem_gender);
            rv_gender.setLayoutManager(llm);
            final AgeDemographicRecyclerAdapter adapter_age =
                    new AgeDemographicRecyclerAdapter(faces.getAgesAppearance());
            rv_age.setAdapter(adapter_age);
            RecyclerView rv_multi = view.findViewById(R.id.rv_dem_gender);
            rv_gender.setLayoutManager(llm);
            final MultiDemographicRecyclerAdapter adapter_multi =
                    new MultiDemographicRecyclerAdapter(faces.getMulticulturalAppearances());
            rv_multi.setAdapter(adapter_multi);
        }
    }
}
