package com.example.artistworld.data.remote.model;

import com.example.artistworld.data.local.entity.ArtistEntity;

import java.util.List;

public class ArtistResponse {

    private List<ArtistEntity> results;
    public List<ArtistEntity> getResults(){
        return results;
    }

    public void setResults(List<ArtistEntity> results){
        this.results= results;
    }


}
