package com.example.artistworld.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.artistworld.data.local.dao.ArtistDao;

import com.example.artistworld.data.local.entity.ArtistEntity;

@Database(entities = {ArtistEntity.class},version = 1,exportSchema = false)

public abstract class ArtistRoomDBase extends RoomDatabase {

    public abstract ArtistDao getArtistDao();

}
