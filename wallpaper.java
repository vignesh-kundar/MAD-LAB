package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer mytimer;
    Drawable drawable;
    WallpaperManager wps;
    int next =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytimer=new Timer();
        wps=WallpaperManager.getInstance(this);
    }

    public void changewallpaper(View v)
    {
        setWallPaper();
    }

    public void setWallPaper()
    {
        mytimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(next==1)
                {
                    drawable=getResources().getDrawable(R.drawable.one);
                    next=2;
                }
                else if(next==2)
                {
                    drawable=getResources().getDrawable(R.drawable.two);
                    next=3;
                }
                else if(next==3)
                {
                    drawable=getResources().getDrawable(R.drawable.three);
                    next=4;
                }
                else if(next==4)
                {
                    drawable=getResources().getDrawable(R.drawable.four);
                    next=5;
                }
                else if(next==5)
                {
                    drawable=getResources().getDrawable(R.drawable.five);
                    next=1;
                }

                Bitmap img=((BitmapDrawable)drawable).getBitmap();

                try{
                    wps.setBitmap(img);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } , 500,  5000);
    }
}
