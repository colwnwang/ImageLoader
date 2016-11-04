package com.imageloader.xiongqi.com.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/8/3.
 */
public class ImageLoader {
    private ImageCache mCache=new MemoryCache();
    private ExecutorService mExecutorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    /**
     * set cache style
     * @param cache
     */
    public void setCacheStyle(ImageCache cache){
        this.mCache=cache;
    }

    /**
     * load network image
     * @param url
     * @param imageview
     */
    public void displayImage(String url,ImageView imageview){
        Bitmap image = mCache.getImage(url);
        if(image==null){
            //load image from network
            loadImage(url,imageview);
        }else{
            //load image from cache
            imageview.setImageBitmap(image);
        }
    }

    /**
     *
     * @param url
     * @param imageview
     */
    private void loadImage(final String url,final ImageView imageview) {
        imageview.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    URL imageUrl = new URL(url);
                    HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
                    Bitmap bitmap = BitmapFactory.decodeStream(conn.getInputStream());
                    imageview.setImageBitmap(bitmap);
                    mCache.putImage(url,bitmap);
                    conn.disconnect();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }


}
