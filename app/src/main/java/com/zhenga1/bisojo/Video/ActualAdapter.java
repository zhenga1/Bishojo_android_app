package com.zhenga1.bisojo.Video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zhenga1.bisojo.R;
import com.zhenga1.bisojo.models.MediaClass;

import java.util.ArrayList;
import java.util.Random;

public class ActualAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<MediaClass> mediaObjectList;
    final int VIEW_TYPE_ITEM = 1, VIEW_TYPE_LOADING=0;
    Context context;
    public View parent, imgview;
    final String base = "https://drive.google.com/uc?id=";
    final String[] ids = new String[]{
            "1-QKgZ76K3EZQlbXyY3wI57FA8k31JmrA",
            "1-P9HymJG5opUFYVvLZSLui19HaFlRIId",
            "1-P2X6yRZtgooKzV7On0nnelPoWFmOg2C",
            "1-9dEzoANYVRkUntv867Jsfbat0Yd3eYZ",
            "1-SLbZmfpnFbcmRSyu4_S1FXgARuB7d65",
            "1-RvmxanOnlUr9R7SbmSqxhrN1InBKh3M",
            "1-EIUq2umNWybJkVa3Sx7iY40-hdQUCPy",
            "1-E9tr1mAcZ8TDZMowAIHbLiMIjSoDiGr",
            "1-3-t0cS5jAL0gWqal7LeDQV3DO18fxLG",
            "1FPxeRAAi4Gqo8ljDJjO0PTaUDoUSo75c",
            "1-Gl8KmEVmb9arQyI6NnLfvfWWjP1MB87",
            "1-BXyaANzlGjkEFizVNh1NSdT1m1DMEBs",
            "1a6jBW2FA-N5J2YLhRvQdJotNUgTiKTn1",
            "1-1leAWA2UBukgW_N3vmeb72RjSmBFMSh",
            "1S53BD0wMKSKPaOXYIbY3EOUpqOQJh1n"
    };
    final int[] links = new int[]{
            R.raw.animation1,
            R.raw.animation2,
            R.raw.animation3,
            R.raw.animation4,
            R.raw.animation5,
            R.raw.animation6,
            R.raw.animation7,
            R.raw.animation8,
            R.raw.animation9,
            R.raw.animation10,
            R.raw.animation11,
            R.raw.animation12,
            R.raw.animation13,
            R.raw.animation14,
            R.raw.animation15

    };

    public ActualAdapter(ArrayList<MediaClass> mediaObjectList, Context context) {
        this.mediaObjectList = mediaObjectList;
        this.context = context;
        this.parent = new View(context);
        this.imgview = new View(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.parent = parent;
        if(viewType==VIEW_TYPE_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main,parent,false);
            return new ItemViewHolder(view);
        }else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_loading,parent,false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemViewHolder){
            populateItemRows((ItemViewHolder) holder,position);
        } else if (holder instanceof LoadingViewHolder){
            showLoadingView((LoadingViewHolder) holder, position);
        }
    }
    private void showLoadingView(LoadingViewHolder holder, int position){
        //DO something idk
        ImageView imageView = holder.loadingImgView;
        Glide.with(context)
                .asGif()
                .load(R.raw.loading)//links[index]
                .into(imageView);

    }
    private void populateItemRows(ItemViewHolder itemViewHolder,int position){
        ImageView imageView = itemViewHolder.imageView;
        //Random random = new Random();
        //int index = random.nextInt(ids.length);
        //String fileurl = base+ids[index];
        Random random = new Random();
        int index = random.nextInt(links.length);
        Glide.with(context)
                .asGif()
                .load(links[index])//links[index]
                .into(imageView);

    }

    @Override
    public int getItemViewType(int position){
        //SO basically if configured already, this will return View Type loading, if not then
        //it will return view type item
        return mediaObjectList.get(position)==null?VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }
    @Override
    public int getItemCount() {
        return mediaObjectList==null?0 : mediaObjectList.size();
    }
    public class LoadingViewHolder extends RecyclerView.ViewHolder{
        public ImageView loadingImgView;
        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            loadingImgView = itemView.findViewById(R.id.loading);
        }
    }
    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.background_anime);
        }
    }
}
