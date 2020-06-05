package com.example.recognition.view.favorite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.recognition.R;
import com.example.recognition.application.App;
import com.example.recognition.model.localdata.room.entity.DemographicResponse;
import com.example.recognition.model.localdata.room.entity.GeneralResponse;
import com.example.recognition.viewmodel.favorites.GeneralFavoriteViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListGeneralFavoriteFragment extends Fragment {
    private View view;
    private GeneralFavoriteViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fr_list_fav, container, false);
        viewModel = new ViewModelProvider(getActivity(), ((App) getActivity().getApplication())
                .getViewModelFactory()).get(GeneralFavoriteViewModel.class);
        viewModel.getGeneralFavorites().observe(getViewLifecycleOwner(), new Observer<List<GeneralResponse>>() {
            @Override
            public void onChanged(List<GeneralResponse> generalResponses) {
                onChangedGeneralFavorites(generalResponses);
            }
        });
        return view;
    }
    private void onChangedGeneralFavorites(final List<GeneralResponse> response) {
        List<String> list = new ArrayList<>();
        for (GeneralResponse genResponse : response){
            list.add(genResponse.getImage());
        }
        GridView gv = view.findViewById(R.id.gridView);
        gv.setAdapter(new ImageAdapter(view.getContext(), list));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewModel.setImage(response.get(position).getImage());
                Navigation.findNavController(view).navigate(R.id.action_ListGeneralFavoriteFragment_to_GeneralResponseFavoriteFragment);
            }
        });
    }
}
