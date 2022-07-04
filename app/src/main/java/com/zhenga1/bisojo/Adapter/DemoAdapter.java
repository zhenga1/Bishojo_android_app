package com.zhenga1.bisojo.Adapter;

import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhenga1.bisojo.R;
import com.zhenga1.bisojo.models.MediaClass;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder>{

    List<MediaClass> mediaObjectList;
    Context context;

    public DemoAdapter(List<MediaClass> mediaObjectList, Context context) {
        this.mediaObjectList = mediaObjectList;
        this.context = context;
    }

    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main,parent,false);
        return new DemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mediaObjectList.size();
    }

    public class DemoViewHolder extends RecyclerView.ViewHolder {
        public DemoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
