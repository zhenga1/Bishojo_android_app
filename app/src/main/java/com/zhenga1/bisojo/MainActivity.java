package com.zhenga1.bisojo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.zhenga1.bisojo.Video.ActualAdapter;
import com.zhenga1.bisojo.models.MediaClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MediaClass> mediaObjList = new ArrayList<>();
    //private DemoAdapter demoAdapter;
    private final int INIT_POPULATION = 20;
    private LinearLayoutManager linearLayoutManager;
    private ActualAdapter actualAdapter;
    private boolean isLoading = false;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWindow();
    }
    private void initWindow(){
        int sdk = Build.VERSION.SDK_INT;
        if(sdk>=19 && sdk <=21){
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,true);
        }if (sdk>=19){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }if (sdk>=21){
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        /////////////////////////////////////////
        SnapHelper mSnapHelper = new PagerSnapHelper();
        mSnapHelper.attachToRecyclerView(recyclerView);
        /////////////////////////////////////////
        populate();
        initAdapter();
        initScrollListener();
        //demoAdapter = new DemoAdapter(mediaObjList,getApplicationContext());
        //recyclerView.setAdapter(demoAdapter);
        //demoAdapter.notifyDataSetChanged();

    }

    private void initScrollListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(!isLoading){
                    if(linearLayoutManager!=null &&
                            linearLayoutManager.findLastCompletelyVisibleItemPosition()==
                                    mediaObjList.size()-1){
                        loadMore();
                        isLoading=true;
                    }
                }
            }
        });
    }

    private void loadMore() {
        mediaObjList.add(null);
        actualAdapter.notifyItemInserted(mediaObjList.size() - 1);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mediaObjList.remove(mediaObjList.size()-1);
                int scrollPosition = mediaObjList.size();
                actualAdapter.notifyItemRemoved(scrollPosition);
                int currentSize = scrollPosition;

                //Load at least 10 more options
                int nextlimit = currentSize+10;

                while(currentSize<=nextlimit){
                    mediaObjList.add(new MediaClass("","","","","","","","","",""));
                    currentSize++;
                }
                actualAdapter.notifyDataSetChanged();
                isLoading=false;


            }
        },2000);
    }

    private void populate(){
        for(int i=0;i<INIT_POPULATION;i++)
        {
            mediaObjList.add(new MediaClass("","","","","","","","","",""));
        }
    }
    private void initAdapter(){
        actualAdapter = new ActualAdapter(mediaObjList,getApplicationContext());
        recyclerView.setAdapter(actualAdapter);
        //actualAdapter.notifyDataSetChanged();
    }
    public static void setWindowFlag(@NonNull Activity activity,final int bits, boolean on){
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();

        if(on){
            winParams.flags |= bits;
        }else{
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}