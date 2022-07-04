package com.zhenga1.bisojo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.zhenga1.bisojo.Adapter.DemoAdapter;
import com.zhenga1.bisojo.models.MediaClass;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MediaClass> mediaObjList = new ArrayList<>();
    private DemoAdapter demoAdapter;
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        /////////////////////////////////////////
        SnapHelper mSnapHelper = new PagerSnapHelper();
        mSnapHelper.attachToRecyclerView(recyclerView);
        /////////////////////////////////////////

        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));
        mediaObjList.add(new MediaClass("","","","","","","","","",""));

        demoAdapter = new DemoAdapter(mediaObjList,getApplicationContext());
        recyclerView.setAdapter(demoAdapter);
        demoAdapter.notifyDataSetChanged();
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