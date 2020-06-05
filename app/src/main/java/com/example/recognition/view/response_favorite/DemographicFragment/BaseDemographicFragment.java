package com.example.recognition.view.response_favorite.DemographicFragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    protected boolean isFavorite;
    protected int threshold;
    private RecyclerView rv_gender;
    private RecyclerView rv_age;
    private RecyclerView rv_multi;
    private View view;
    private ImageView imageView;
    protected Button favoriteButton;

    protected abstract void init();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_result_demographic, container, false);
        imageView = view.findViewById(R.id.dem_model_image);
        favoriteButton = view.findViewById(R.id.but_dem_add_to_favorite);
        rv_gender = view.findViewById(R.id.rv_dem_gender);
        rv_age = view.findViewById(R.id.rv_dem_age);
        rv_multi = view.findViewById(R.id.rv_dem_multicolor);
        init();
        return view;
    }

    @Override
    public void onChanged(DemographicResponse response) {
        imageView.setImageURI(Uri.parse(response.getImage()));
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        //TODO кнопки с лицами
        for (DemographicDataType.Face faces : response.getData().getFaces()){
            rv_gender.setLayoutManager(llm);
            final GenderDemographicRecyclerAdapter adapter_gender =
                    new GenderDemographicRecyclerAdapter(faces.getGendersAppearance(), threshold);
            rv_gender.setAdapter(adapter_gender);
            rv_gender.setLayoutManager(llm);
            final AgeDemographicRecyclerAdapter adapter_age =
                    new AgeDemographicRecyclerAdapter(faces.getAgesAppearance(), threshold);
            rv_age.setAdapter(adapter_age);
            rv_gender.setLayoutManager(llm);
            final MultiDemographicRecyclerAdapter adapter_multi =
                    new MultiDemographicRecyclerAdapter(faces.getMulticulturalAppearances(), threshold);
            rv_multi.setAdapter(adapter_multi);
        }
    }
}
