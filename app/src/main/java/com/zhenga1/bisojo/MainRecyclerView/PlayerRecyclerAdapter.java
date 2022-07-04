package com.zhenga1.bisojo.MainRecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestManager;
import com.zhenga1.bisojo.R;
import com.zhenga1.bisojo.models.MediaClass;

import java.util.ArrayList;

public class PlayerRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<MediaClass> mediaObjects;
    private RequestManager requestManager;


    public PlayerRecyclerAdapter(ArrayList<MediaClass> mediaObjects, RequestManager requestManager) {
        this.mediaObjects = mediaObjects;
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new com.zhenga1.bisojo.MainRecyclerView.PlayerViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_main, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((com.zhenga1.bisojo.MainRecyclerView.PlayerViewHolder)viewHolder).onBind(mediaObjects.get(i), requestManager);
    }

    @Override
    public int getItemCount() {
        return mediaObjects.size();
    }

}
