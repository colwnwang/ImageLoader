package com.imageloader.xiongqi.com.imageloader;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016/8/3.
 */
public interface ImageCache {
     Bitmap getImage(String url);
     void putImage(String url,Bitmap bitmap);
}
