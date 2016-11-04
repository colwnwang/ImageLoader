package com.imageloader.xiongqi.com.imageloader;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016/8/3.
 */
public class DoubleCache implements ImageCache {

    private MemoryCache memoryCache;
    private DiskCache diskCache;

    public DoubleCache(){
        initDoublceCache();
    }
    private void initDoublceCache() {
        memoryCache = new MemoryCache();
        diskCache = new DiskCache();
    }
    @Override
    public Bitmap getImage(String url) {
        Bitmap image = memoryCache.getImage(url);
        if(image==null){
            return diskCache.getImage(url);
        }else{
            return image;
        }
    }
    @Override
    public void putImage(String url, Bitmap bitmap) {
         memoryCache.putImage(url,bitmap);
         diskCache.putImage(url,bitmap);
    }
}
