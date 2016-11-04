package com.imageloader.xiongqi.com.imageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by Administrator on 2016/8/3.
 */
public class MemoryCache implements ImageCache {
    private LruCache<String, Bitmap> mLruCache;
    public MemoryCache(){
        initMemoryCache();
    }
    private void initMemoryCache() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        int cacheSize= (int) (maxMemory/4);
        mLruCache = new LruCache<>(cacheSize);
    }
    @Override
    public Bitmap getImage(String url) {
        Bitmap bitmap = mLruCache.get(url);
        return bitmap;
    }
    @Override
    public void putImage(String url, Bitmap bitmap) {
        mLruCache.put(url,bitmap);
    }
}
