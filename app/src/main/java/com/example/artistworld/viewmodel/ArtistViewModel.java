package com.example.artistworld.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.artistworld.data.ArtistRepository;
import com.example.artistworld.data.local.ArtistRoomDBase;
import com.example.artistworld.data.local.entity.ArtistEntity;
import com.example.artistworld.data.network.Resource;

import java.util.List;

public class ArtistViewModel extends ViewModel {

    private final LiveData<Resource<List<ArtistEntity>>> artist;
    private ArtistRepository artistRepository;

    public ArtistViewModel() {
        artistRepository = new ArtistRepository();
        artist = artistRepository.getArtist();

    }

    public LiveData<Resource<List<ArtistEntity>>> getartist() {
        return artist;
    }
}
