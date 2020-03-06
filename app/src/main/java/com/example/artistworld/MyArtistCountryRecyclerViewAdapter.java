package com.example.artistworld;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.artistworld.data.local.ArtistEntity;
import com.example.artistworld.data.remote.ApiConstans;

import java.util.List;


public class MyArtistCountryRecyclerViewAdapter extends RecyclerView.Adapter<MyArtistCountryRecyclerViewAdapter.ViewHolder> {

    private final List<ArtistEntity> mValues;
    Context ctx;


    public MyArtistCountryRecyclerViewAdapter(Context context , List<ArtistEntity> items) {
        mValues = items;
      ctx=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_artistcountry, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        Glide.with(ctx)
                .load(ApiConstans.IMAGE_API_PREFIX_LARGE + holder.mItem.getImage())
                .into(holder.imageViewCover);



    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView imageViewCover;
        public ArtistEntity mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imageViewCover =  view.findViewById(R.id.image_view_cover);

        }

        @Override
        public String toString() {
            return super.toString() ;
        }
    }
}
