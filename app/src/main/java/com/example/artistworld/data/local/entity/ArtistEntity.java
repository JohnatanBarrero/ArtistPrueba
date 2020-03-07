
package com.example.artistworld.data.local.entity;

import android.media.Image;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Artist")
public class ArtistEntity {

    @PrimaryKey
    @SerializedName("mbid")
    @Expose
    @NonNull
    private String mbid;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("listeners")
    @Expose
    private String listeners;

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("streamable")
    @Expose
    private String streamable;
    @SerializedName("image")
    @Expose
    private List<Image> image = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ArtistEntity() {
    }

    /**
     * 
     * @param image
     * @param mbid
     * @param listeners
     * @param streamable
     * @param name
     * @param url
     */
    public ArtistEntity(String name, String listeners, String mbid, String url, String streamable, List<Image> image) {
        super();
        this.name = name;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

}
