package com.example.artistworld;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.artistworld.data.local.entity.ArtistEntity;
import com.example.artistworld.data.network.Resource;
import com.example.artistworld.viewmodel.ArtistViewModel;

import java.util.List;


public class ArtistCountryFragment extends Fragment {


    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    List<ArtistEntity> artistList;
    MyArtistCountryRecyclerViewAdapter adapter;
    ArtistViewModel artistViewModel;

    public ArtistCountryFragment() {
    }

    public static ArtistCountryFragment newInstance(int columnCount) {
        ArtistCountryFragment fragment = new ArtistCountryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        artistViewModel= ViewModelProviders.of(getActivity())
                .get(ArtistViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artistcountry_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            adapter = new MyArtistCountryRecyclerViewAdapter(
                    getActivity(),
                    artistList

            );
            recyclerView.setAdapter(adapter);

            loadartists();
        }
        return view;
    }

    private void loadartists() {
        artistViewModel.getartist().observe(getActivity(), new Observer<Resource<List<ArtistEntity>>>() {
            @Override
            public void onChanged(Resource<List<ArtistEntity>> listResource) {
                artistList= listResource.data;
                adapter.setData(artistList);
            }
        });
    }

}
