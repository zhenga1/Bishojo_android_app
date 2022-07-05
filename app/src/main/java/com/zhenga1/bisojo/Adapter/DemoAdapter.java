package com.zhenga1.bisojo.Adapter;

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

import java.util.List;
import java.util.Random;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.DemoViewHolder>{

    List<MediaClass> mediaObjectList;
    Context context;
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

    };
    /*final String[] urls = new String[]{
            "https://drive.google.com/file/d/1-QKgZ76K3EZQlbXyY3wI57FA8k31JmrA/view?usp=sharing",
            "https://drive.google.com/file/d/1-P9HymJG5opUFYVvLZSLui19HaFlRIId/view?usp=sharing",
            "https://drive.google.com/file/d/1-P2X6yRZtgooKzV7On0nnelPoWFmOg2C/view?usp=sharing",
            "https://drive.google.com/file/d/1-9dEzoANYVRkUntv867Jsfbat0Yd3eYZ/view?usp=sharing",
            "https://drive.google.com/file/d/1-SLbZmfpnFbcmRSyu4_S1FXgARuB7d65/view?usp=sharing",
            "https://drive.google.com/file/d/1-RvmxanOnlUr9R7SbmSqxhrN1InBKh3M/view?usp=sharing",
            "https://drive.google.com/file/d/1-EIUq2umNWybJkVa3Sx7iY40-hdQUCPy/view?usp=sharing",
            "https://drive.google.com/file/d/1-E9tr1mAcZ8TDZMowAIHbLiMIjSoDiGr/view?usp=sharing",
            "https://drive.google.com/file/d/1-3-t0cS5jAL0gWqal7LeDQV3DO18fxLG/view?usp=sharing",
            "https://drive.google.com/file/d/1FPxeRAAi4Gqo8ljDJjO0PTaUDoUSo75c/view?usp=sharing",
            "https://drive.google.com/file/d/1-Gl8KmEVmb9arQyI6NnLfvfWWjP1MB87/view?usp=sharing",
            "https://drive.google.com/file/d/1-BXyaANzlGjkEFizVNh1NSdT1m1DMEBs/view?usp=sharing",
            "https://drive.google.com/file/d/1a6jBW2FA-N5J2YLhRvQdJotNUgTiKTn1/view?usp=sharing",
            "https://drive.google.com/file/d/1-1leAWA2UBukgW_N3vmeb72RjSmBFMSh/view?usp=sharing",
            "https://drive.google.com/file/d/1S53BD0wMKSKPaOXYIbY3EOUpqOQJh1n_/view?usp=sharing"
    };*/

    public DemoAdapter(List<MediaClass> mediaObjectList, Context context) {
        this.mediaObjectList = mediaObjectList;
        this.context = context;
    }

    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main,parent,false);
        ImageView imageView = view.findViewById(R.id.background_anime);
        Random random = new Random();
        int index = random.nextInt(ids.length);
        String fileurl = base+ids[index];
        Glide.with(parent.getContext())
                .asGif()
                .load(fileurl)
                .into(imageView);
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
