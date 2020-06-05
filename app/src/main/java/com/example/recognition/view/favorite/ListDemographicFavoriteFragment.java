package com.example.recognition.view.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.recognition.R;
import com.example.recognition.application.App;
import com.example.recognition.model.localdata.room.entity.ColorResponse;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.viewmodel.favorites.DemographicFavoriteViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListDemographicFavoriteFragment extends Fragment {

    private View view;
    private DemographicFavoriteViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fr_list_fav, container, false);
        viewModel = new ViewModelProvider(this, ((App) getActivity().getApplication())
                .getViewModelFactory()).get(DemographicFavoriteViewModel.class);
        viewModel.getDemographicFavorites().observe(getViewLifecycleOwner(), new Observer<List<DemographicResponse>>() {
            @Override
            public void onChanged(List<DemographicResponse> demographicResponses) {
                onChangedDemographicFavorites(demographicResponses);
            }
        });
        return view;
    }
    private void onChangedDemographicFavorites(final List<DemographicResponse> response ) {
        List<String> list = new ArrayList<>();
        for (DemographicResponse demResponse : response){
            list.add(demResponse.getImage());
        }
        GridView gv = view.findViewById(R.id.gridView);
        gv.setAdapter(new ImageAdapter(view.getContext(), list));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewModel.setImage(response.get(position).getImage());
                Navigation.findNavController(view).navigate(R.id.action_ListDemographicFavoriteFragment_to_DemographicResponseFavoriteFragment);
            }
        });
    }
}
