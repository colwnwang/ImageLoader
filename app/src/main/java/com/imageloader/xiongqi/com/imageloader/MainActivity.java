package com.imageloader.xiongqi.com.imageloader;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mIvImage;
    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIvImage = (ImageView) findViewById(R.id.iv_imageloader);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String url="http://192.168.0.245/tomcat.png";
        if(imageLoader==null){
            imageLoader = new ImageLoader();
            imageLoader.setCacheStyle(new MemoryCache());
        }
        imageLoader.displayImage(url, mIvImage);
    }
}
