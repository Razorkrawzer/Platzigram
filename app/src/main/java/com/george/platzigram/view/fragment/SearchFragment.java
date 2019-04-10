package com.george.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.george.platzigram.R;
import com.george.platzigram.adapter.PictureAdapterRecyclerView;
import com.george.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        RecyclerView picturesRecycler = view.findViewById(R.id.searchRecycler);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);

        picturesRecycler.setLayoutManager(gridLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPicture(), R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);


        return view;
    }

    public ArrayList<Picture> buildPicture() {
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("https://www.nationalgeographic.com/content/dam/travel/2018-digital/ice-igloo-hotels/ice-igloo-hotels-borealis-basecamp.adapt.470.1.jpg", "Jorge Crespo", "4 días", "10 Me Gusta"));
        pictures.add(new Picture("https://st3.depositphotos.com/13193824/17646/i/450/depositphotos_176469852-stock-photo-ski-track-beautiful-mountains-landscape.jpg", "Jesus Vega", "8 días", "7 Me Gusta"));
        pictures.add(new Picture("https://jurassiccoast.org/wp-content/uploads/2015/06/durdle-door-500x300.jpg", "Alex Sanchez", "2 días", "4 Me Gusta"));
        return pictures;
    }

}
