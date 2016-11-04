package com.imageloader.xiongqi.com.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;

/**
 * Created by Administrator on 2016/8/3.
 */
public class DiskCache implements ImageCache {

    private LruCache<String, Bitmap> mLruCache;

    public DiskCache(){
        initDiskCache();
    }

    private void initDiskCache() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        int cacheSize= (int) (maxMemory/4);
        mLruCache = new LruCache<>(cacheSize);
    }

    @Override
    public Bitmap getImage(String url) {
        return mLruCache.get(url);
    }

    @Override
    public void putImage(String url, Bitmap bitmap) {
         mLruCache.put(url,bitmap);
    }
}
