package com.example.artistworld.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.artistworld.data.local.entity.ArtistEntity;

import java.util.List;

public interface ArtistDao {

    @Query("SELECT * FROM artist")
    public abstract LiveData<List<ArtistEntity>> loadArtist() ;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void saveArtist(List<ArtistEntity> artistEntityList);

}
