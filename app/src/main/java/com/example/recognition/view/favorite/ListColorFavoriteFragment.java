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
import com.example.recognition.viewmodel.favorites.ColorFavoriteViewModel;

import java.util.List;

public class ListColorFavoriteFragment extends Fragment {

    private View view;
    private ColorFavoriteViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fr_list_fav, container, false);
        viewModel = new ViewModelProvider(this, ((App) getActivity().getApplication())
                .getViewModelFactory()).get(ColorFavoriteViewModel.class);
        viewModel.getColorFavorites().observe(getViewLifecycleOwner(), new Observer<List<ColorResponse>>() {
            @Override
            public void onChanged(List<ColorResponse> colorResponses) {
                onChangedColorFavorites(colorResponses);
            }
        });
        return view;
    }
    private void onChangedColorFavorites(final List<ColorResponse> response) {
        List<String> list = null;
        for (ColorResponse colorResponse : response){
            list.add(colorResponse.getImage());
        }
        GridView gv = view.findViewById(R.id.gridView);
        gv.setAdapter(new ImageAdapter(view.getContext(), list));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewModel.setImage(response.get(position).getImage());
                Navigation.findNavController(view).navigate(R.id.action_ListColorFavoriteFragment_to_ColorResponseFavoriteFragment);
            }
        });
    }
}
