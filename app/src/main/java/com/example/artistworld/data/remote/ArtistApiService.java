package com.example.artistworld.data.remote;

import com.example.artistworld.data.remote.model.ArtistResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArtistApiService {

    @GET("?method=geo.gettopartists")
    Call<ArtistResponse> loadArtist();
}
