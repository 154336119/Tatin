package com.shulaibao.frame.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lzy.imagepicker.loader.ImageLoader;
import com.shulaibao.frame.R;

import java.io.File;

import jp.wasabeef.glide.transformations.CropCircleTransformation;


/**
 * 描述：
 * Created by Lee
 * on 2016/9/19.
 */
public  class ImageLoadUtil implements ImageLoader {
    private static int mErrorDrawable;
    private static int mPlaceholderDrawable;

    public static void setErrorDrawable(int mErrorDrawable) {
        ImageLoadUtil.mErrorDrawable = mErrorDrawable;
    }

    public static void setPlaceholderDrawable(int mPlaceholderDrawable) {
        ImageLoadUtil.mPlaceholderDrawable = mPlaceholderDrawable;
    }

    /**
     * 获取error加载的图片
     * @return
     */
    private static int getErrorDrawable(){
        return mErrorDrawable;
    };

    /**
     * 占位图
     * @return
     */
    private static int getPlaceholderDrawable(){
        return mPlaceholderDrawable;
    };

    /**
     * 通用加载
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadImage(Context context, String url, ImageView imageView){
        Glide.with(context).load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error( getErrorDrawable()).placeholder(getPlaceholderDrawable()).into(imageView);
    }

    /**
     * 加载资源图片
     * @param context
     * @param res
     * @param imageView
     */
    public static void loadResImage(Context context, int res, ImageView imageView){
        Glide.with(context).load(res).error( getErrorDrawable()).placeholder(getPlaceholderDrawable()).into(imageView);
    }

    /**
     * 加载圆形图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadCircleImage(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).error( getErrorDrawable()).placeholder(getPlaceholderDrawable()).bitmapTransform(new CropCircleTransformation(context)).into(imageView);
    }

    /**
     * 加载gif
     * @param context
     * @param url
     * @param iv
     */
    public static void loadGifImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(getPlaceholderDrawable()).error(getErrorDrawable()).into(iv);
    }

    /**
     * 清空
     * @param context
     */
    public static void clear(Context context) {
        Glide.get(context).clearMemory();
    }

    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
        Glide.with(activity)                             //配置上下文
                .load(Uri.fromFile(new File(path)))   //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                .error(R.mipmap.default_image)           //设置错误图片
                .placeholder(R.mipmap.default_image)     //设置占位图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
    }

    @Override
    public void clearMemoryCache() {

    }
    /**
     * 加载文件图片
     * @param context
     * @param imageView
     */
    public static void loadFileImage(Context context, String path, ImageView imageView){
        Glide.with(context).load(new File(path)).error( getErrorDrawable()).placeholder(getPlaceholderDrawable()).into(imageView);
    }
}
