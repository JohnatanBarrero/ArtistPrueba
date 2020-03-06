package com.example.artistworld.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.artistworld.common.MyApp;
import com.example.artistworld.data.local.ArtistRoomDBase;
import com.example.artistworld.data.local.dao.ArtistDao;
import com.example.artistworld.data.local.entity.ArtistEntity;
import com.example.artistworld.data.network.NetworkBoundResource;
import com.example.artistworld.data.network.Resource;
import com.example.artistworld.data.remote.ApiConstans;
import com.example.artistworld.data.remote.ArtistApiService;
import com.example.artistworld.data.remote.RequestInterceptor;
import com.example.artistworld.data.remote.model.ArtistResponse;

import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArtistRepository {

    private final ArtistApiService artistApiService;
    private final ArtistDao artistDao;


    public ArtistRepository() {
        //Local > ROOM

        ArtistRoomDBase artistRoomDBase = Room.databaseBuilder(
                MyApp.getContext(),
                ArtistRoomDBase.class,
                "db_artist"
        ).build();
        artistDao = artistRoomDBase.getArtistDao();

        //RequestInterceptor: para incluir las variables adicionales como la api_key
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.addInterceptor(new RequestInterceptor());
        OkHttpClient cliente = okHttpClientBuilder.build();


        //Remote >Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstans.BASE_URL)
                .client(cliente)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        artistApiService = retrofit.create(ArtistApiService.class);
    }
        public LiveData<Resource<List<ArtistEntity>>> getArtist(){
         return new NetworkBoundResource<List<ArtistEntity>, ArtistResponse>(){


             @Override
             protected void saveCallResult(@NonNull ArtistResponse item) {
                 artistDao.saveArtist(item.getResults());
             }

             @NonNull
             @Override
             protected LiveData<List<ArtistEntity>> loadFromDb() {
               //Aqui los datos que estan en room local
                 return artistDao.loadArtist();
             }

             @NonNull
             @Override
             protected Call<ArtistResponse> createCall() {
               //obtenemos los datos del servicio
                return artistApiService.loadArtist();
             }
         }.getAsLiveData();
    }


}
